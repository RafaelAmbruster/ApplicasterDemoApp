package com.applicaster.demo.model;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Ambruster on 3/10/2017.
 * All the models that are stored in SQLite and had a long Id must extend from this
 */

public class AbstractIdentifier {

    @DatabaseField(id = true)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
