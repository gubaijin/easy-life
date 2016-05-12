package com.easylife.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by Kevin on 2016/4/10.
 */
public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getmContext(){
        return mContext;
    }
}
