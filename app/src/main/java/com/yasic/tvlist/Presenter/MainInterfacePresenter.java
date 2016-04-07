package com.yasic.tvlist.Presenter;

import android.support.v7.widget.Toolbar;

import com.yasic.tvlist.R;
import com.yasic.tvlist.View.MainInterfaceView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yasic on 2016/4/6.
 */
public class MainInterfacePresenter extends BasePresenterActivity<MainInterfaceView> {

    @Override
    protected void onBindBVI(){
        setSupportActionBar((Toolbar)BVIView.getView().findViewById(R.id.toolbar));
        BVIView.setPresenter(this);
        List<String> tabTitleList = new ArrayList<>();
        tabTitleList.add("常用");
        tabTitleList.add("全部");
        tabTitleList.add("设置");
        List<BasePresenterFragment> basePresenterFragmentList = new ArrayList<>();
        basePresenterFragmentList.add(new TVClassificationPresenter());
        basePresenterFragmentList.add(new TVClassificationPresenter());
        basePresenterFragmentList.add(new TVClassificationPresenter());
        BVIView.setViewPagerAndTablayout(tabTitleList, basePresenterFragmentList);
    }

    @Override
    protected Class getBVIClass() {
        return MainInterfaceView.class;
    }
}
