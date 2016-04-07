package com.yasic.tvlist.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.yasic.tvlist.Bean.CallbackBean;
import com.yasic.tvlist.Model.ITVModel;
import com.yasic.tvlist.Model.TVModel;
import com.yasic.tvlist.R;
import com.yasic.tvlist.View.CCTVTypeListView;

import java.util.List;

import butterknife.ButterKnife;
import im.fir.sdk.FIR;
import im.fir.sdk.VersionCheckCallback;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by ESIR on 2016/3/17.
 */
public class CCTVTypeListPresenter extends BasePresenterActivity<CCTVTypeListView>{

    private ITVModel tvModel;

    @Override
    protected void onBindBVI(){
        BVIView.initRvCCTVType(this);
        tvModel = new TVModel();
        setSupportActionBar((Toolbar)BVIView.getView().findViewById(R.id.toolbar));
        BVIView.setPresenter(this);
        setRvCCTVTypeList();
        setUpdateFunction();
        BVIView.setProgressBarVisible();
    }

    public CCTVTypeListPresenter getPresenterClass(){
        return this;
    }

    public void getCCTVShow(final int position, String tvName){
        Intent intent = new Intent(CCTVTypeListPresenter.this, CCTVShowPresenter.class);
        Bundle bundle = new Bundle();
        bundle.putInt("CCTVPOSITON",position);
        bundle.putString("TVNAME",tvName);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void setRvCCTVTypeList() {
        Observable.create(new Observable.OnSubscribe<CallbackBean<List<String>>>() {
            @Override
            public void call(Subscriber<? super CallbackBean<List<String>>> subscriber) {
                CallbackBean<List<String>> callbackBean = tvModel. getCCTVListFromNetwork();
                subscriber.onNext(callbackBean);
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<CallbackBean<List<String>>>() {
                    @Override
                    public void call(CallbackBean<List<String>> callbackBean) {
                        if (callbackBean.getCode().equals("0")) {
                            BVIView.setCCTVTypeInfo(getApplicationContext(), callbackBean.getResponse());
                        } else {
                            if (callbackBean.getErrorMessage() == null || callbackBean.getErrorMessage().equals("")) {
                                Toast.makeText(getApplicationContext(), "貌似网络出现了错误？", Toast.LENGTH_LONG).show();
                            }
                            Toast.makeText(getApplicationContext(), callbackBean.getErrorMessage(), Toast.LENGTH_LONG).show();
                        }
                        BVIView.setProgressBarGone();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.i("throwable",throwable.getMessage());
                    }
                });
    }

    private void setUpdateFunction(){
        String firToken = "14c173e14d1ac43d8f0ad682dc1dd3ab";
        FIR.checkForUpdateInFIR(firToken , new VersionCheckCallback() {
            @Override
            public void onSuccess(String versionJson) {
                Log.i("fir","check from fir.im success! " + "\n" + versionJson);
            }

            @Override
            public void onFail(Exception exception) {
                Log.i("fir", "check fir.im fail! " + "\n" + exception.getMessage());
            }

            @Override
            public void onStart() {
                //Toast.makeText(getApplicationContext(), "正在获取", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {
                //Toast.makeText(getApplicationContext(), "获取完成", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected Class<CCTVTypeListView> getBVIClass() {
        return CCTVTypeListView.class;
    }

}
