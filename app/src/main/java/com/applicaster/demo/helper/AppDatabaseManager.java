package com.applicaster.demo.helper;

import android.content.Context;

/**
 * Created by Ambruster on 3/10/2017.
 * Helper class implementing singleton for obtain instance of db
 */

public class AppDatabaseManager {

    private static AppDatabaseManager instance;

    private AppDatabaseHelper helper;

    private AppDatabaseManager(Context ctx) {
        helper = new AppDatabaseHelper(ctx);
    }

    public static void init(Context ctx) {
        if (null == instance) {
            instance = new AppDatabaseManager(ctx);
        }
    }

    public static AppDatabaseManager getInstance() {
        return instance;
    }

    public AppDatabaseHelper getHelper() {
        return helper;
    }
}
