package com.applicaster.demo.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *This POJO was generated whit http://www.jsonschema2pojo.org/
 * */

@DatabaseTable(tableName = "Tweet")
public class Tweet extends AbstractIdentifier implements Comparable<Tweet> {

    @DatabaseField
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @DatabaseField(foreign = true, canBeNull = false)
    @SerializedName("user")
    @Expose
    private User user;

    @DatabaseField
    @SerializedName("retweet_count")
    @Expose
    private Integer retweetCount;

    @DatabaseField
    @SerializedName("favorite_count")
    @Expose
    private Integer favoriteCount;

    @SerializedName("id_str")
    @Expose
    private String idStr;

    @DatabaseField
    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("truncated")
    @Expose
    private Boolean truncated;

    @SerializedName("entities")
    @Expose
    private Entities entities;

    @SerializedName("metadata")
    @Expose
    private Metadata metadata;

    @SerializedName("source")
    @Expose
    private String source;

    @SerializedName("in_reply_to_status_id")
    @Expose
    private long inReplyToStatusId;

    @SerializedName("in_reply_to_status_id_str")
    @Expose
    private long inReplyToStatusIdStr;

    @SerializedName("in_reply_to_user_id")
    @Expose
    private long inReplyToUserId;

    @SerializedName("in_reply_to_user_id_str")
    @Expose
    private String inReplyToUserIdStr;

    @SerializedName("in_reply_to_screen_name")
    @Expose
    private String inReplyToScreenName;

    @SerializedName("is_quote_status")
    @Expose
    private Boolean isQuoteStatus;

    @SerializedName("favorited")
    @Expose
    private Boolean favorited;

    @SerializedName("retweeted")
    @Expose
    private Boolean retweeted;

    @SerializedName("lang")
    @Expose
    private String lang;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getTruncated() {
        return truncated;
    }

    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
    }

    public Entities getEntities() {
        return entities;
    }

    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public long getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public void setInReplyToStatusId(long inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }

    public long getInReplyToStatusIdStr() {
        return inReplyToStatusIdStr;
    }

    public void setInReplyToStatusIdStr(long inReplyToStatusIdStr) {
        this.inReplyToStatusIdStr = inReplyToStatusIdStr;
    }

    public long getInReplyToUserId() {
        return inReplyToUserId;
    }

    public void setInReplyToUserId(Integer inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    public String getInReplyToUserIdStr() {
        return inReplyToUserIdStr;
    }

    public void setInReplyToUserIdStr(String inReplyToUserIdStr) {
        this.inReplyToUserIdStr = inReplyToUserIdStr;
    }

    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public void setInReplyToScreenName(String inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getIsQuoteStatus() {
        return isQuoteStatus;
    }

    public void setIsQuoteStatus(Boolean isQuoteStatus) {
        this.isQuoteStatus = isQuoteStatus;
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

    public Boolean getFavorited() {
        return favorited;
    }

    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    public Boolean getRetweeted() {
        return retweeted;
    }

    public void setRetweeted(Boolean retweeted) {
        this.retweeted = retweeted;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public int compareTo(@NonNull Tweet o) {
        if (this.getUser().getFollowersCount() > o.getUser().getFollowersCount()) return -1;
        else if (this.getUser().getFollowersCount() < o.getUser().getFollowersCount()) return 1;
        else return 0;
    }
}
