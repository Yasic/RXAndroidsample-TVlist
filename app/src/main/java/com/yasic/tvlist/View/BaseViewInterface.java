package com.yasic.tvlist.View;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yasic.tvlist.Presenter.BasePresenterActivity;

/**
 * Created by Yasic on 2016/3/17.
 */
public interface BaseViewInterface<T extends Activity, E extends Fragment> {
    void init(LayoutInflater inflater, ViewGroup container);
    View getView();
    void setPresenter(T t);
    void setPresenter(E e);
}
