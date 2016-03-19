package com.yasic.tvlist.Util;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by ESIR on 2016/3/17.
 */
public class OkhttpUtil {
    private static OkhttpUtil okhttpUtil = null;
    public OkHttpClient okHttpClient = null;
    private OkhttpUtil(){
        init();
    }

    private void init(){
        okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(10, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(10, TimeUnit.SECONDS);
    }

    public static OkhttpUtil getInstance(){
        if(okhttpUtil == null){
            synchronized (OkhttpUtil.class){
                if(okhttpUtil == null){
                    okhttpUtil = new OkhttpUtil();
                }
            }
        }
        return okhttpUtil;
    }
}
