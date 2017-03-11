package com.applicaster.demo.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ambruster on 3/10/2017.
 */

/*Helper class for work with shared preferences*/
public class PreferenceManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "applicaster";
    private static final String CONSUME_INTERVAL = "interval";
    private static final String QUERY_STRING = "query";
    public static final String STRING_NF = "defaultStringIfNothingFound";

    public PreferenceManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setQuery(String query) {
        editor.putString(QUERY_STRING, query);
        editor.commit();
    }

    public String getQuery() {
        return pref.getString(QUERY_STRING, STRING_NF);
    }

    public void setInterval(int interval) {
        editor.putInt(CONSUME_INTERVAL, interval);
        editor.commit();
    }

    public int getInterval() {
        return pref.getInt(CONSUME_INTERVAL, -1);
    }

}
