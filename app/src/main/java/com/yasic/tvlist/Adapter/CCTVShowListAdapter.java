package com.yasic.tvlist.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yasic.tvlist.Bean.TVShowBean;
import com.yasic.tvlist.R;

import java.util.List;

/**
 * Created by ESIR on 2016/3/19.
 */
public class CCTVShowListAdapter extends BaseAdapter<CCTVShowListAdapter.MyViewHolder,TVShowBean> {

    public CCTVShowListAdapter(Context context, List<TVShowBean> tvShowBeanList){
        this.context = context;
        this.objectList = tvShowBeanList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_cctvshow,parent,false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        if (onItemClickListener != null) {
            holder.liShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(holder.liShow,position);
                }
            });
        }
        holder.tvShowName.setText(objectList.get(position).getShowName());
        holder.tvShowTime.setText(objectList.get(position).getShowTime());
        holder.tvShowDuration.setText(objectList.get(position).getShowDuration());
        super.onBindViewHolder(holder, position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tvShowName;
        private TextView tvShowTime;
        private TextView tvShowDuration;
        private LinearLayout liShow;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvShowName = (TextView)itemView.findViewById(R.id.tv_ShowName);
            tvShowDuration = (TextView)itemView.findViewById(R.id.tv_ShowDuration);
            tvShowTime = (TextView)itemView.findViewById(R.id.tv_ShowTime);
            liShow = (LinearLayout) itemView.findViewById(R.id.li_Show);
        }
    }
}
