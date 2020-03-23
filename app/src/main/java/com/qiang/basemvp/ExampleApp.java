package com.qiang.basemvp;

import android.app.Application;

import com.qiang.library.app.GlobalConfig;


public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        GlobalConfig.init(this)
                .withApiHost("http://192.168.31.80:20002/api/")
                .configure();
    }
}
