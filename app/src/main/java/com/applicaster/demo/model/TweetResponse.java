package com.applicaster.demo.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Ambruster on 3/10/2017.
 */

@DatabaseTable(tableName = "TweetResponse")
public class TweetResponse {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    public String query;

    @ForeignCollectionField
    private ForeignCollection<TweetHistory> tweetHistory;

    public TweetResponse() {
    }

    public TweetResponse(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public ForeignCollection<TweetHistory> getTweetHistory() {
        return tweetHistory;
    }
}
