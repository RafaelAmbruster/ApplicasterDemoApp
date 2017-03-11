package com.applicaster.demo.dao;

import com.j256.ormlite.dao.Dao;

/**
 * Created by Ambruster on 3/10/2017.
 */

public abstract class AbstractDAO<T, E> {

    public abstract Class<T> getEntityClass();

    public abstract Dao<T, E> getDao();

}
