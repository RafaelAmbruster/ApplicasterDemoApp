
package com.applicaster.demo.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*This POJO was generated whit http://www.jsonschema2pojo.org/*/
public class Entities {

    @SerializedName("hashtags")
    @Expose
    private List<Hashtag> hashtags = null;

    @SerializedName("media")
    @Expose
    private List<Media> media = null;

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }
}
