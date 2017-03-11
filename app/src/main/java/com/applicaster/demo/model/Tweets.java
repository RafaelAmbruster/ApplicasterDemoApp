package com.applicaster.demo.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *This POJO was generated whit http://www.jsonschema2pojo.org/
 * */

public class Tweets {

    @SerializedName("statuses")
    @Expose
    private List<Tweet> statuses = null;

    public List<Tweet> getStatuses() {
        return statuses;
    }

}
