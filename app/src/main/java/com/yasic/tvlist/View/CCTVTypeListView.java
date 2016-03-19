package com.yasic.tvlist.View;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.yasic.tvlist.Adapter.CCTVTypeListAdapter;
import com.yasic.tvlist.Presenter.CCTVTypeListPresenter;
import com.yasic.tvlist.R;

import java.util.List;

/**
 * Created by ESIR on 2016/3/18.
 */
public class CCTVTypeListView implements BaseViewInterface<CCTVTypeListPresenter>{
    private View view;
    private TextView tvTextView;
    private RecyclerView rvCCTVType;
    private CCTVTypeListPresenter cctvTypePresenter;
    private ProgressBar progressBar;

    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.activity_cctvtype,container,false);
        rvCCTVType = (RecyclerView)view.findViewById(R.id.rv_CCTVType);
        progressBar = (ProgressBar)view.findViewById(R.id.pgb_cctvTypeProgressBar);
    }

    public void setProgressBarVisible(){
        progressBar.setVisibility(View.VISIBLE);
    }

    public void setProgressBarGone(){
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setPresenter(CCTVTypeListPresenter cctvTypePresenter){
        this.cctvTypePresenter = cctvTypePresenter;
    }

    public void initRvCCTVType(Context context){
        rvCCTVType.setLayoutManager(new LinearLayoutManager(context));
        rvCCTVType.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public View getView() {
        return view;
    }


    public void setCCTVTypeInfo(Context context, final List<String> cctvTypeList){
        final CCTVTypeListAdapter cctvTypeListAdapter = new CCTVTypeListAdapter(context,cctvTypeList);
        cctvTypeListAdapter.setOnItemClickListener(new CCTVTypeListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                cctvTypePresenter.getCCTVShow(position,cctvTypeList.get(position).toString());
            }

            @Override
            public void onItemLongCick(View v, int position) {

            }
        });
        rvCCTVType.setAdapter(cctvTypeListAdapter);
    }
}
