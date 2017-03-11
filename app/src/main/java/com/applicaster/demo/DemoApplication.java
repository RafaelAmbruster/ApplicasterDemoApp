package com.applicaster.demo;

import android.app.Application;
import android.content.Context;
import com.applicaster.demo.dao.AppDatabaseManager;

/**
 * Created by Ambruster on 3/10/2017.
 */

public class DemoApplication extends Application {

    private static DemoApplication instance;

    public DemoApplication() {
        instance = this;
    }

    public static synchronized DemoApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        AppDatabaseManager.init(getApplicationContext());

    }

    public static Context getContext() {
        return instance;
    }

}
