package com.yasic.tvlist.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yasic.tvlist.R;

import java.util.List;

/**
 * Created by ESIR on 2016/3/18.
 */
public class CCTVTypeListAdapter extends BaseAdapter<CCTVTypeListAdapter.MyViewHolder,String> {

    public CCTVTypeListAdapter(Context context, List<String> objectList) {
        this.context = context;
        this.objectList = objectList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_cctvtype,parent,false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        if (onItemClickListener != null) {
            holder.liCCTVType.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(holder.liCCTVType,position);
                }
            });
        }
        holder.tvCCTVTypeName.setText(objectList.get(position));
        super.onBindViewHolder(holder, position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tvCCTVTypeName;
        private LinearLayout liCCTVType;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvCCTVTypeName = (TextView)itemView.findViewById(R.id.tv_CCTVTypeName);
            liCCTVType = (LinearLayout)itemView.findViewById(R.id.li_CCTVType);
        }
    }

}
