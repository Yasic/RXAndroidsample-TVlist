package com.yasic.tvlist.View;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yasic.tvlist.Adapter.CCTVTypeListAdapter;
import com.yasic.tvlist.Presenter.BasePresenterActivity;
import com.yasic.tvlist.Presenter.BasePresenterFragment;
import com.yasic.tvlist.Presenter.TVClassificationPresenter;
import com.yasic.tvlist.R;

import java.util.List;

/**
 * Created by Yasic on 2016/4/6.
 */
public class TVClassificationView implements BaseViewInterface<Activity, TVClassificationPresenter> {
    private View view;
    private RecyclerView rvTVClassification;
    private TVClassificationPresenter tvClassificationPresenter;
    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_tvclassification, container, false);
        rvTVClassification = (RecyclerView)view.findViewById(R.id.rv_TVClassification);

    }

    public void initRvTVClassification(Context context){
        rvTVClassification.setLayoutManager(new LinearLayoutManager(context));
        rvTVClassification.setItemAnimator(new DefaultItemAnimator());
    }

    public void setRvTVClassification(Context context, List<String> tvClassificationList){
        final CCTVTypeListAdapter cctvTypeListAdapter = new CCTVTypeListAdapter(context,tvClassificationList);
        cctvTypeListAdapter.setOnItemClickListener(new CCTVTypeListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                //cctvTypePresenter.getCCTVShow(position,cctvTypeList.get(position).toString());
            }

            @Override
            public void onItemLongCick(View v, int position) {

            }
        });
        rvTVClassification.setAdapter(cctvTypeListAdapter);
    }

    @Override
    public View getView() {
        return view;
    }

    @Override
    public void setPresenter(Activity activity) {

    }

    @Override
    public void setPresenter(TVClassificationPresenter tvClassificationPresenter) {
        this.tvClassificationPresenter = tvClassificationPresenter;
    }

}
