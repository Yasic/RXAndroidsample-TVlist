package com.yasic.tvlist.Model;

import android.util.Log;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.yasic.tvlist.Bean.CallbackBean;
import com.yasic.tvlist.Bean.TVShowBean;
import com.yasic.tvlist.Util.OkhttpUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ESIR on 2016/3/17.
 */
public class TVModel implements ITVModel {

    @Override
    public CallbackBean<List<TVShowBean>> getCCTVShowFromNetwork(int position){
        OkhttpUtil okhttpUtil = OkhttpUtil.getInstance();
        final Request request = new Request.Builder().url("http://www.kandianshi.com/" + (position+1) + "/").build();
        try {
            List<TVShowBean> cctvShowList = new ArrayList<>();
            Response response = okhttpUtil.okHttpClient.newCall(request).execute();
            Document document = Jsoup.parse(response.body().string());
            Element titleElement = document.getElementById("zhongbu");
            Elements elements = titleElement.getElementsByClass("td_nr");
            for(int i = 0; i < elements.size(); i = i + 3){
                if (elements.get(i).id().equals("")){
                    cctvShowList.add(new TVShowBean(elements.get(i+1).text(),elements.get(i).text(),elements.get(i+2).text()));
                }else {
                    i++;
                }
            }
            CallbackBean<List<TVShowBean>> callbackBean = new CallbackBean("0","",cctvShowList);
            return callbackBean;
        } catch (Exception e) {
            CallbackBean<List<TVShowBean>> callbackBean = new CallbackBean<List<TVShowBean>>("1",e.getMessage(),null);
            return callbackBean;
        }
    }

    @Override
    public CallbackBean<List<String>> getCCTVListFromNetwork() {
        OkhttpUtil okhttpUtil = OkhttpUtil.getInstance();
        final Request request = new Request.Builder().url("http://www.kandianshi.com").build();
        try {
            List<String> cctvList = new ArrayList<>();
            Response response = okhttpUtil.okHttpClient.newCall(request).execute();
            Document document = Jsoup.parse(response.body().string());
            Element element = document.getElementById("zhongbu_kuang_zuo");
            Element element1 = element.getElementsByTag("ul").first();
            Elements elements = element1.getElementsByTag("li");
            for (int i = 0; i < elements.size(); i++){
                cctvList.add(elements.get(i).text());
            }
            CallbackBean<List<String>> callbackBean = new CallbackBean<List<String>>("0","",cctvList);
            return callbackBean;
        } catch (Exception e) {
            CallbackBean<List<String>> callbackBean = new CallbackBean<List<String>>("1",e.getMessage(),null);
            return callbackBean;
        }
    }
}
