package com.applicaster.demo.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.applicaster.demo.model.TweetHistory;
import com.applicaster.demo.model.TweetResponse;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Ambruster on 3/10/2017.
 * Helper class for life cycle of database, eg: Database name, version etc.
 */

public class AppDatabaseHelper extends OrmLiteSqliteOpenHelper {

    public static final String DATABASE_NAME = "applicaster.db3";
    private static final int DATABASE_VERSION = 1;

    public AppDatabaseHelper(Context context) {
        super(context, "/data/data/com.applicaster.demo/databases/" + DATABASE_NAME, null,
                DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, TweetResponse.class);
            TableUtils.createTable(connectionSource, TweetHistory.class);
        } catch (SQLException e) {
            Log.e(getClass().getCanonicalName(), e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
                          int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, TweetHistory.class, true);
            TableUtils.dropTable(connectionSource, TweetResponse.class, true);

            TableUtils.createTable(connectionSource, TweetResponse.class);
            TableUtils.createTable(connectionSource, TweetHistory.class);

        } catch (SQLException e) {
            Log.e(getClass().getCanonicalName(), e.getMessage());
        }
    }

    @Override
    public void close() {
        super.close();
    }
}
