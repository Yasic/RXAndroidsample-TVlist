package com.yasic.tvlist.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yasic.tvlist.Presenter.BasePresenterActivity;

/**
 * Created by ESIR on 2016/3/17.
 */
public interface BaseViewInterface<T extends BasePresenterActivity> {
    void init(LayoutInflater inflater, ViewGroup container);
    View getView();
    void setPresenter(T t);
}
