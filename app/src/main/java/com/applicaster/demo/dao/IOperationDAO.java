package com.applicaster.demo.dao;

import java.util.ArrayList;

/**
 * Created by Ambruster on 3/10/2017.
 * Helper interface, all dao must implements
 */

public interface IOperationDAO<T> {

    int OPERATION_INSERT = 0;
    int OPERATION_INSERT_OR_UPDATE = 1;
    int OPERATION_INSERT_IF_NOT_EXISTS = 2;

    void Create(final T object, int operation);

    void Create(final ArrayList<T> list, final int operation);

    T Get(T object);

    void Delete(T object);

    void Refresh(T object);

    void Update(T object);

    long CountOf();

    ArrayList<T> Get();

}
