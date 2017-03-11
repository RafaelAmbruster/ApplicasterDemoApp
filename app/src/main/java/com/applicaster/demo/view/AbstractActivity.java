package com.applicaster.demo.view;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ambruster on 3/10/2017.
 * Abstract Activity with some of the most common used helper method, not necessary all the others
 * Its not mandatory that activities extend from this, but its a good practice
 */

public abstract class AbstractActivity extends AppCompatActivity {

    public abstract void CallData();

    public abstract void Init();

    public abstract void SetupAdapter();

    public abstract void OpenDetail(Object object);

}
