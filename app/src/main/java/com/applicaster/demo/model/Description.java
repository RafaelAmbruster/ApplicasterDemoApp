
package com.applicaster.demo.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
*This POJO was generated whit http://www.jsonschema2pojo.org/
 * */

public class Description {

    @SerializedName("urls")
    @Expose
    private List<Object> urls = null;

    public List<Object> getUrls() {
        return urls;
    }

    public void setUrls(List<Object> urls) {
        this.urls = urls;
    }

}
