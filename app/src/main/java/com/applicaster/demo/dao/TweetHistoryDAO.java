package com.applicaster.demo.dao;

import android.util.Log;

import com.applicaster.demo.model.TweetHistory;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Ambruster on 3/10/2017.
 */

public class TweetHistoryDAO extends AbstractDAO<TweetHistory, Long> implements
        IOperationDAO<TweetHistory> {

    private AppDatabaseHelper helper;

    public TweetHistoryDAO(AppDatabaseHelper helper) {
        this.helper = helper;
    }

    public AppDatabaseHelper getHelper() {
        return helper;
    }

    @Override
    public Class<TweetHistory> getEntityClass() {
        return TweetHistory.class;
    }

    @Override
    public Dao<TweetHistory, Long> getDao() {
        try {
            return DaoManager.createDao(getHelper().getConnectionSource(), getEntityClass());
        } catch (Exception localException) {
            Log.e(getClass().getCanonicalName(), localException.getMessage());
        }
        return null;
    }

    public void Create(TweetHistory l, int operation) {
        try {
            switch (operation) {
                case IOperationDAO.OPERATION_INSERT:
                    getDao().create(l);
                    break;
                case IOperationDAO.OPERATION_INSERT_OR_UPDATE:
                    getDao().createOrUpdate(l);
                    break;
                case IOperationDAO.OPERATION_INSERT_IF_NOT_EXISTS:
                    getDao().createIfNotExists(l);
                    break;
            }
        } catch (SQLException e) {
            Log.e(getClass().getCanonicalName(), e.getMessage());
        }
    }

    @Override
    public TweetHistory Get(TweetHistory object) {
        TweetHistory TweetHistory = null;
        try {
            TweetHistory = getDao().queryForSameId(object);
        } catch (SQLException e) {
            Log.e(getClass().getCanonicalName(), e.getMessage());
        }
        return TweetHistory;
    }

    public void Delete(TweetHistory object) {
        try {
            getDao().delete(object);
        } catch (SQLException e) {
            Log.e(getClass().getCanonicalName(), e.getMessage());
        }
    }

    public void Refresh(TweetHistory object) {
        try {
            getDao().refresh(object);
        } catch (SQLException e) {
            Log.e(getClass().getCanonicalName(), e.getMessage());
        }
    }

    public void Update(TweetHistory object) {
        try {
            getDao().update(object);
        } catch (SQLException e) {
            Log.e(getClass().getCanonicalName(), e.getMessage());
        }
    }

    public long CountOf() {
        long count = 0;
        try {
            count = getDao().countOf();
        } catch (SQLException e) {
            Log.e(getClass().getCanonicalName(), e.getMessage());
        }
        return count;
    }

    public void Create(final ArrayList<TweetHistory> list, final int operation) {
        try {
            getDao().callBatchTasks(() -> {
                for (TweetHistory ur : list) {
                    Create(ur, operation);
                }
                return null;
            });
        } catch (Exception e) {
            Log.e(getClass().getCanonicalName(), e.getMessage());
        }
    }

    public ArrayList<TweetHistory> Get() {
        ArrayList<TweetHistory> lists = null;
        try {
            lists = (ArrayList<TweetHistory>) getDao().queryBuilder().query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
    }
}