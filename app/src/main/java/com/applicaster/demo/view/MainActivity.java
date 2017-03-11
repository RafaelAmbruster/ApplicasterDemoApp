package com.applicaster.demo.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.applicaster.demo.R;
import com.applicaster.demo.api.IResponseObject;
import com.applicaster.demo.api.task.TwitterTask;
import com.applicaster.demo.dao.TweetHistoryDAO;
import com.applicaster.demo.helper.AppDatabaseManager;
import com.applicaster.demo.dao.IOperationDAO;
import com.applicaster.demo.dao.TweetResponseDAO;
import com.applicaster.demo.helper.PreferenceManager;
import com.applicaster.demo.model.TweetHistory;
import com.applicaster.demo.model.TweetResponse;
import com.applicaster.demo.model.Tweet;
import com.applicaster.demo.model.Tweets;
import com.applicaster.demo.view.adapters.TwitterItemAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AbstractActivity implements IResponseObject {

    private RecyclerView rv_content;
    private TwitterItemAdapter adapter;
    private ArrayList<Tweet> statuses;
    private RelativeLayout rl_progressbar;
    private String query;
    private Handler mTimerHandler;
    private Runnable mTimerRunnable;
    private static final long TIMER_DELAY = 20000l;
    private static Boolean inSearch;
    public PreferenceManager preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        preference = new PreferenceManager(this);
        if (!preference.getQuery().contains(PreferenceManager.STRING_NF)) {
            query = preference.getQuery();
        }

        Init();
        inSearch = false;
    }

    /**
     * Init visual components
     */

    @Override
    public void Init() {

        /**
         * Start the timer
         */

        setupTimer();

        rl_progressbar = (RelativeLayout) findViewById(R.id.rv_progress);
        rv_content = (RecyclerView) findViewById(R.id.rv_content);
        rv_content.setHasFixedSize(true);
        rv_content.setItemAnimator(new DefaultItemAnimator());

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(MainActivity.this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_content.setLayoutManager(mLinearLayoutManager);
        SetupAdapter();
    }

    /**
     * Init the tweet adapter
     */

    @Override
    public void SetupAdapter() {
        statuses = new ArrayList<>();
        adapter = new TwitterItemAdapter(MainActivity.this, (position, v) -> {

            /**
             *If we are going to see the tweet detail, we implement this method
             *Tweet status = statuses.get(adapter.getPosition(position));
             *OpenDetail(status);
             */

        });
        rv_content.setAdapter(adapter);
    }

    @Override
    public void OpenDetail(Object object) {

    }

    /**
     * Helper method to communicate with the API
     */

    @Override
    public void CallData() {
        preference.setQuery(query);
        statuses = new ArrayList<>();
        adapter.Clear();
        rl_progressbar.setVisibility(View.VISIBLE);
        new TwitterTask(this).Search(query);
    }

    /**
     * Helper method to order the response based on user followers
     */

    private void sortByFavoriteTweet() {
        if (statuses != null && statuses.size() > 0) {
            Collections.sort(statuses);
        }
    }

    /**
     * Create the search view
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setQueryHint("Search..");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String search) {
                if (!TextUtils.isEmpty(search)) {
                    /**
                     * Call Search
                     */
                    inSearch = true;
                    query = search;
                    callSearch();
                    /**
                     * Hide keyboard
                     */
                    searchView.clearFocus();
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }

            public void callSearch() {
                CallData();
            }

        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_saved:
                Intent intent;
                intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Receive the data from the API
     * Based on this we can draw differents views of, empty, or whatsoever.
     */

    @Override
    public void onResponse(Object object) {
        rl_progressbar.setVisibility(View.GONE);
        if (object instanceof Tweets) {
            statuses.addAll(((Tweets) object).getStatuses());
            sortByFavoriteTweet();
            adapter.Add(statuses);
            adapter.notifyDataSetChanged();

            if (inSearch)
                Persist(statuses, query);
        }
    }

    /**
     * In more complex scenario, we must handle the error
     */

    @Override
    public void onError(String message, Integer code) {
        rl_progressbar.setVisibility(View.GONE);
        Log.e("onError", code + message);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startTimer();
        invalidateOptionsMenu();
    }

    @Override
    public void onPause() {
        super.onPause();
         /*Stop the timer*/
        stopTimer();
    }

    /**
     * Helper method to start the handler
     */

    private void startTimer() {
        mTimerHandler.postDelayed(mTimerRunnable, 0);
    }

    /**
     * Helper method to initialize the handler
     */

    private void setupTimer() {
        mTimerHandler = new Handler();
        mTimerRunnable = new Runnable() {
            @Override
            public void run() {
                if (!TextUtils.isEmpty(query)) {
                    CallData();
                } else {
                    Toast.makeText(MainActivity.this, "Please add a criteria", Toast.LENGTH_SHORT).show();
                }
                mTimerHandler.postDelayed(this, TIMER_DELAY);
            }
        };
    }

    /**
     * Helper method to stop the handler
     */

    private void stopTimer() {
        mTimerHandler.removeCallbacks(mTimerRunnable);
    }

    /**
     * For persist the data, i create two entities, TweetHistory and TweetResponse with the data that will be persisted in SQLite
     */

    private void Persist(ArrayList<Tweet> statuses, String query) {
        inSearch = false;
        TweetResponse resp = new TweetResponse();
        resp.setQuery(query);

        /**
         * First we create the father (TweetResponse)
         * */

        new TweetResponseDAO(AppDatabaseManager.getInstance().getHelper()).Create(resp, IOperationDAO.OPERATION_INSERT);
        TweetHistory tweetHistory;
        ArrayList<TweetHistory> list_to_persist = new ArrayList<>();

        for (Tweet item : statuses) {
            tweetHistory = new TweetHistory();

            tweetHistory.setCreatedAt(item.getCreatedAt());
            tweetHistory.setFavoriteCount(item.getUser().getFavouritesCount());
            tweetHistory.setFollowersCount(item.getUser().getFollowersCount());

            if (item.getEntities().getMedia() != null)
                tweetHistory.setMediaUrl(item.getEntities().getMedia().get(0).getMediaUrl());

            tweetHistory.setName(item.getUser().getName());
            tweetHistory.setProfileImageUrl(item.getUser().getProfileImageUrl());
            tweetHistory.setRetweetCount(item.getRetweetCount());
            tweetHistory.setText(item.getText());
            tweetHistory.setTweetResponse(resp);
            list_to_persist.add(tweetHistory);
        }

        /**
         * Then we create all the childs
         */

        if (list_to_persist.size() > 0)
            new TweetHistoryDAO(AppDatabaseManager.getInstance().getHelper()).Create(list_to_persist, IOperationDAO.OPERATION_INSERT);

    }
}
