package com.applicaster.demo.view;

import android.content.Intent;
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
import com.applicaster.demo.model.TweetResponse;
import com.applicaster.demo.view.adapters.SearchItemAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by Ambruster on 3/10/2017.
 * History activity, this activity show the searches loaded from SQLite
 */

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView rv_content;
    private SearchItemAdapter adapter;
    private ArrayList<TweetResponse> tweetResponses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("History");
        Init();
    }

    /**
     * Init visual components
     */

    private void Init() {
        rv_content = (RecyclerView) findViewById(R.id.rv_content);
        rv_content.setHasFixedSize(true);
        rv_content.setItemAnimator(new DefaultItemAnimator());

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(HistoryActivity.this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_content.setLayoutManager(mLinearLayoutManager);
        SetupAdapter();

        CallData();
    }

    /**
     * Load Data from Database
     */

    private void CallData() {
        tweetResponses = new TweetResponseDAO(AppDatabaseManager.getInstance().getHelper()).Get();
        adapter.Add(tweetResponses);
        adapter.notifyDataSetChanged();
    }

    /**
     * Init the search adapter
     */

    private void SetupAdapter() {
        tweetResponses = new ArrayList<>();
        adapter = new SearchItemAdapter(HistoryActivity.this, (position, v) -> {
            TweetResponse resp = tweetResponses.get(position);
            OpenDetail(resp);
        });
        rv_content.setAdapter(adapter);
    }

    /**
     * Open tweets history activity with all the tweets stored
     */

    private void OpenDetail(TweetResponse resp) {
        Intent i = new Intent(HistoryActivity.this, HistoryTweetsActivity.class);
        Bundle b = new Bundle();
        b.putInt(HistoryTweetsActivity.OBJ_RESPONSE, resp.getId());
        i.putExtras(b);
        startActivity(i);
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
