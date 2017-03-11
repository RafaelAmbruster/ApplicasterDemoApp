package com.applicaster.demo.dao;

import android.util.Log;

import com.applicaster.demo.model.TweetResponse;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Ambruster on 3/10/2017.
 * Dao of the model class Response that is stored in SQLite
 */

public class TweetResponseDAO extends AbstractDAO<TweetResponse, Long> implements
        IOperationDAO<TweetResponse> {

    private AppDatabaseHelper helper;

    public TweetResponseDAO(AppDatabaseHelper helper) {
        this.helper = helper;
    }

    public AppDatabaseHelper getHelper() {
        return helper;
    }

    @Override
    public Class<TweetResponse> getEntityClass() {
        return TweetResponse.class;
    }

    @Override
    public Dao<TweetResponse, Long> getDao() {
        try {
            return DaoManager.createDao(getHelper().getConnectionSource(), getEntityClass());
        } catch (Exception localException) {
            Log.e(getClass().getCanonicalName(), localException.getMessage());
        }
        return null;
    }

    public void Create(TweetResponse l, int operation) {
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
    public TweetResponse Get(TweetResponse object) {
        TweetResponse TweetResponse = null;
        try {
            TweetResponse = getDao().queryForSameId(object);
        } catch (SQLException e) {
            Log.e(getClass().getCanonicalName(), e.getMessage());
        }
        return TweetResponse;
    }

    public void Delete(TweetResponse object) {
        try {
            getDao().delete(object);
        } catch (SQLException e) {
            Log.e(getClass().getCanonicalName(), e.getMessage());
        }
    }

    public void Refresh(TweetResponse object) {
        try {
            getDao().refresh(object);
        } catch (SQLException e) {
            Log.e(getClass().getCanonicalName(), e.getMessage());
        }
    }

    public void Update(TweetResponse object) {
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

    public void Create(final ArrayList<TweetResponse> list, final int operation) {
        try {
            getDao().callBatchTasks(() -> {
                for (TweetResponse ur : list) {
                    Create(ur, operation);
                }
                return null;
            });
        } catch (Exception e) {
            Log.e(getClass().getCanonicalName(), e.getMessage());
        }
    }

    public ArrayList<TweetResponse> Get() {
        ArrayList<TweetResponse> lists = null;
        try {
            lists = (ArrayList<TweetResponse>) getDao().queryBuilder().orderBy("id", false).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
    }

}