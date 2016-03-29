package com.yasic.tvlist.Util;

import android.app.Application;

import im.fir.sdk.FIR;

/**
 * Created by ESIR on 2016/3/29.
 */
public class MyAppication extends Application {
    @Override
    public void onCreate() {

        super.onCreate();
        FIR.init(this);
    }
}
