package com.applicaster.demo.view;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Ambruster on 3/10/2017.
 * Abstract Activity with some of the most common used helper method.
 * Its not mandatory that activities extend from this, but its a good practice
 */

public abstract class AbstractActivity extends AppCompatActivity {

    public abstract void CallData();

    public abstract void Init();

    public abstract void SetupAdapter();

    public abstract void OpenDetail(Object object);

}
