package com.applicaster.demo.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Ambruster on 3/10/2017.
 */

@DatabaseTable(tableName = "TweetHistory")
public class TweetHistory {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String text;

    @DatabaseField
    private String createdAt;

    @DatabaseField
    private Integer retweetCount;

    @DatabaseField
    private Integer favoriteCount;

    @DatabaseField
    private String mediaUrl;

    @DatabaseField
    private String mediaUrlHttps;

    @DatabaseField
    private String name;

    @DatabaseField
    private String profileImageUrl;

    @DatabaseField
    private String profileImageUrlHttps;

    @DatabaseField
    private Integer followersCount;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private TweetResponse tweetResponse;

    public TweetHistory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(Integer retweetCount) {
        this.retweetCount = retweetCount;
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getMediaUrlHttps() {
        return mediaUrlHttps;
    }

    public void setMediaUrlHttps(String mediaUrlHttps) {
        this.mediaUrlHttps = mediaUrlHttps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getProfileImageUrlHttps() {
        return profileImageUrlHttps;
    }

    public void setProfileImageUrlHttps(String profileImageUrlHttps) {
        this.profileImageUrlHttps = profileImageUrlHttps;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public TweetResponse getTweetResponse() {
        return tweetResponse;
    }

    public void setTweetResponse(TweetResponse tweetResponse) {
        this.tweetResponse = tweetResponse;
    }
}
