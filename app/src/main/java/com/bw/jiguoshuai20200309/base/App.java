package com.bw.jiguoshuai20200309.base;

import android.app.Application;
import android.content.Context;
/**
 * 季国帅
 * 20200309
 */
public class App extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }
    public static Context getApplicon(){
        return context;
    }
}
