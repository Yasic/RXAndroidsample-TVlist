package com.yasic.tvlist.Presenter;

import android.support.annotation.IntegerRes;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.yasic.tvlist.Bean.CallbackBean;
import com.yasic.tvlist.Bean.TVShowBean;
import com.yasic.tvlist.Model.TVModel;
import com.yasic.tvlist.R;
import com.yasic.tvlist.View.CCTVShowView;
import com.yasic.tvlist.View.CCTVTypeListView;

import java.util.EmptyStackException;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by ESIR on 2016/3/19.
 */
public class CCTVShowPresenter extends BasePresenterActivity<CCTVShowView> {

    private TVModel tvModel;

    private int cctvShowPosition;

    @Override
    protected void onBindBVI(){
        setSupportActionBar((Toolbar)BVIView.getView().findViewById(R.id.toolbar));
        BVIView.initRvCCTVType(this);
        tvModel = new TVModel();
        BVIView.setProgressBarVisible();
        setTitle(getIntent().getExtras().getString("TVNAME"));
        try{
            cctvShowPosition = Integer.valueOf(getIntent().getExtras().get("CCTVPOSITON").toString());
            setRvTVShow();
        }catch (Exception e){
            Log.i("errorIngetShowList",e.getMessage());
        }
    }

    private void setRvTVShow(){
        Observable.create(new Observable.OnSubscribe<CallbackBean<List<TVShowBean>>>() {
            @Override
            public void call(Subscriber<? super CallbackBean<List<TVShowBean>>> subscriber) {
                CallbackBean<List<TVShowBean>> callbackBean = tvModel.getCCTVShowFromNetwork(cctvShowPosition);
                subscriber.onNext(callbackBean);
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<CallbackBean<List<TVShowBean>>>() {
                    @Override
                    public void call(CallbackBean<List<TVShowBean>> listCallbackBean) {
                        if (listCallbackBean.getCode().equals("0") && listCallbackBean.getResponse().size()!=0){
                            BVIView.setRvCCTVShow(getApplicationContext(),listCallbackBean.getResponse());
                            BVIView.setProgressBarGone();
                            setCurrentShow(listCallbackBean.getResponse());
                        }
                        else {
                            if (listCallbackBean.getErrorMessage()==null || listCallbackBean.getErrorMessage().equals("")){
                                Toast.makeText(getApplicationContext(),"貌似网络出现了错误？",Toast.LENGTH_LONG).show();
                            }else {
                                Toast.makeText(getApplicationContext(),listCallbackBean.getErrorMessage(),Toast.LENGTH_LONG).show();
                            }
                            try{
                                BVIView.setProgressBarGone();
                            }catch (Exception ignored){

                            }
                        }
                    }
                });
    }


    private void setCurrentShow(List<TVShowBean> tvShowBeanList){
        for(int i = 0; i < tvShowBeanList.size(); i++){
            if (tvShowBeanList.get(i).getShowName().contains("正在播放")){
                BVIView.setTvCurrentShow(tvShowBeanList.get(i));
            }
        }
    }

    @Override
    protected Class<CCTVShowView> getBVIClass() {
        return CCTVShowView.class;
    }
}
