package com.yasic.tvlist.View;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.yasic.tvlist.Adapter.BaseAdapter;
import com.yasic.tvlist.Adapter.ViewPagerMainInterfaceAdapter;
import com.yasic.tvlist.Presenter.BasePresenterActivity;
import com.yasic.tvlist.Presenter.BasePresenterFragment;
import com.yasic.tvlist.Presenter.MainInterfacePresenter;
import com.yasic.tvlist.R;

import java.util.List;

/**
 * Created by ESIR on 2016/4/6.
 */
public class MainInterfaceView implements BaseViewInterface<MainInterfacePresenter, Fragment> {
    private View view;
    private ViewPager vpMainInterface;
    private TabLayout tlBottomBar;
    private MainInterfacePresenter mainInterfacePresenter;
    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.activity_maininterface, container, false);
        vpMainInterface = (ViewPager)view.findViewById(R.id.vp_MainInterface);
        tlBottomBar = (TabLayout)view.findViewById(R.id.tl_BottomBar);
    }

    @Override
    public View getView() {
        return view;
    }

    public void setViewPagerAndTablayout(List<String> tabTitleList, List<BasePresenterFragment> basePresenterFragmentList){
        vpMainInterface.setAdapter(new ViewPagerMainInterfaceAdapter<>(
                mainInterfacePresenter.getSupportFragmentManager(),
                tabTitleList,
                basePresenterFragmentList));
        vpMainInterface.setOffscreenPageLimit(3);
        tlBottomBar.setupWithViewPager(vpMainInterface);
        tlBottomBar.setTabMode(TabLayout.MODE_FIXED);
        mainInterfacePresenter.getSupportFragmentManager().beginTransaction().commit();
    }

    @Override
    public void setPresenter(MainInterfacePresenter mainInterfacePresenter) {
        this.mainInterfacePresenter = mainInterfacePresenter;
    }

    @Override
    public void setPresenter(Fragment fragment) {

    }
}
