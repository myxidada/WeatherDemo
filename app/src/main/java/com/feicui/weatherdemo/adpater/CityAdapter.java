package com.feicui.weatherdemo.adpater;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.feicui.weatherdemo.R;
import com.feicui.weatherdemo.entity.city.CityInfo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by yukai on 2016/9/5.
 */
public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ItemViewHolder>{
    private ArrayList<CityInfo> data;

    public CityAdapter() {
        data = new ArrayList<>();
    }

    public void addAllData(Collection<CityInfo> list){
        data.addAll(list);
        notifyDataSetChanged();
    }

    public void clear(){
        data.clear();
        notifyDataSetChanged();
    }
    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView city_id,province,city;
        public ItemViewHolder(View itemView) {
            super(itemView);
//            city_id = (TextView) itemView.findViewById(R.id.city_id);
//            province = (TextView) itemView.findViewById(R.id.city_province);
            city = (TextView) itemView.findViewById(R.id.city_name);
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_item,null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
//        holder.province.setText(data.get(position).getProvince());
//        holder.city_id.setText(data.get(position).getId());
        holder.city.setText(data.get(position).getCity());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerListener != null){
                    recyclerListener.onRecycleItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface onRecyclerListener{
        void onRecycleItemClick(int position);
    }

    private onRecyclerListener recyclerListener;

    public void setOnRecyclerItemViewListener(onRecyclerListener recyclerListener){
        this.recyclerListener = recyclerListener;
    }
}
