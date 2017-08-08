package com.coderminion.connectionstatus;

import android.app.Application;

/**
 * Created by phoenix on 8/8/17.
 */

public class MyApplication extends Application {

    public  static MyApplication myApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        myApplication =this;
    }

    public static MyApplication getInstance()
    {
        return myApplication;
    }
}
