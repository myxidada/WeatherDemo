package com.zhangyu.demo.WeatherDemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhangyu.demo.WeatherDemo.R;

import java.util.ArrayList;

/**
 * Created by zhangyu on 2016-09-05.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<String> list;

    public RecyclerAdapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popoupwindow_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, final int position) {
        holder.tx_pop.setText(list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(position);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lllistener.ooonItemClick(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tx_pop;
        public ViewHolder(View itemView) {
            super(itemView);
            tx_pop= (TextView) itemView.findViewById(R.id.tx_pooupwindow_item);
        }
    }

    /**
     *对Recycler的item做监听事件
     * */
    public interface onItemClickListener {
        void onItemClick(int position);
    }

    private onItemClickListener listener;

    public void setOnItemClickListener(onItemClickListener listener) {
        this.listener = listener;
    }
    /**
     * 用回调把城市名字传输过去
     * */

    public interface ooonItemClickListener {
        void ooonItemClick(String cityName);
    }

    private ooonItemClickListener lllistener;

    public void sssetOnItemClickListener(ooonItemClickListener lllistener) {
        this.lllistener = lllistener;
    }


}
