package com.yasic.tvlist.View;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.yasic.tvlist.Adapter.BaseAdapter;
import com.yasic.tvlist.Adapter.CCTVShowListAdapter;
import com.yasic.tvlist.Bean.TVShowBean;
import com.yasic.tvlist.Presenter.CCTVShowPresenter;
import com.yasic.tvlist.Presenter.CCTVTypeListPresenter;
import com.yasic.tvlist.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by ESIR on 2016/3/19.
 */
public class CCTVShowView implements BaseViewInterface<CCTVShowPresenter,Fragment> {
    private View view;
    private CCTVShowPresenter cctvShowPresenter;
    private RecyclerView rvCCTVShow;
    private ProgressBar progressBar;
    private TextView tvCurrentShowName;
    private TextView tvCurrentShowTime;
    private TextView tvCurrentShowDuration;
    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.activity_cctvshow,container,false);
        rvCCTVShow = (RecyclerView)view.findViewById(R.id.rv_CCTVShow);
        progressBar = (ProgressBar)view.findViewById(R.id.pgb_cctvShowProgressBar);
        tvCurrentShowName = (TextView)view.findViewById(R.id.tv_CurrentShowName);
        tvCurrentShowTime = (TextView)view.findViewById(R.id.tv_CurrentShowTime);
        tvCurrentShowDuration = (TextView)view.findViewById(R.id.tv_CurrentShowDuration);
    }

    public void initRvCCTVType(Context context){
        rvCCTVShow.setLayoutManager(new LinearLayoutManager(context));
        rvCCTVShow.setItemAnimator(new DefaultItemAnimator());
    }

    public void setRvCCTVShow(Context context, List<TVShowBean> tvShowBeanList){
        CCTVShowListAdapter cctvShowListAdapter = new CCTVShowListAdapter(context, tvShowBeanList);
        rvCCTVShow.setAdapter(cctvShowListAdapter);
    }

    public void setTvCurrentShow(TVShowBean tvCurrentShow){
        tvCurrentShowName.setText(tvCurrentShow.getShowName());
        tvCurrentShowTime.setText(tvCurrentShow.getShowTime());
        tvCurrentShowDuration.setText(tvCurrentShow.getShowDuration());
    }

    @Override
    public View getView() {
        return view;
    }

    public void setProgressBarVisible(){
        progressBar.setVisibility(View.VISIBLE);
    }

    public void setProgressBarGone(){
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setPresenter(CCTVShowPresenter cctvShowPresenter) {
        this.cctvShowPresenter = cctvShowPresenter;
    }

    @Override
    public void setPresenter(Fragment fragment) {

    }
}
