package com.applicaster.demo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.applicaster.demo.R;
import com.applicaster.demo.dao.AppDatabaseManager;
import com.applicaster.demo.dao.TweetResponseDAO;
import com.applicaster.demo.model.TweetHistory;
import com.applicaster.demo.model.TweetResponse;
import com.applicaster.demo.view.adapters.SearchItemAdapter;
import com.applicaster.demo.view.adapters.TwitterItemAdapter;
import com.applicaster.demo.view.adapters.TwitterItemHistoryAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.dao.ForeignCollection;

import java.util.ArrayList;

public class HistoryTweetsActivity extends AppCompatActivity {

    private RecyclerView rv_content;
    private TwitterItemHistoryAdapter adapter;
    private ArrayList<TweetHistory> tweetHistory;
    private TweetResponse tweetResponse;
    public static final String OBJ_RESPONSE = "tweetResponse";
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            if (bundle.containsKey(OBJ_RESPONSE)) {
                id = bundle.getInt(OBJ_RESPONSE);
            }
        }

        Init();
    }

    /*Init visual components*/
    private void Init() {
        rv_content = (RecyclerView) findViewById(R.id.rv_content);
        rv_content.setHasFixedSize(true);
        rv_content.setItemAnimator(new DefaultItemAnimator());

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(HistoryTweetsActivity.this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_content.setLayoutManager(mLinearLayoutManager);
        SetupAdapter();

        CallData();
    }

    private void CallData() {
        tweetResponse = new TweetResponseDAO(AppDatabaseManager.getInstance().getHelper()).Get(new TweetResponse(id));
        getSupportActionBar().setTitle("Tweets with hashtag " + tweetResponse.getQuery());
        ForeignCollection<TweetHistory> list = tweetResponse.getTweetHistory();
        adapter.Add(new ArrayList<>(list));
        adapter.notifyDataSetChanged();
    }

    /*Init the search adapter*/
    private void SetupAdapter() {
        tweetHistory = new ArrayList<>();
        adapter = new TwitterItemHistoryAdapter(HistoryTweetsActivity.this, (position, v) -> {
        });
        rv_content.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        invalidateOptionsMenu();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
