package com.feicui.weatherdemo.adpater;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.feicui.weatherdemo.R;
import com.feicui.weatherdemo.entity.weather.WeatherInfo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * temperature : 27℃~35℃
 * weather : 晴转多云
 * weather_id : {"fa":"00","fb":"01"}
 * wind : 东南风3-4级
 * week : 星期三
 * date : 20140806
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.OtherViewHolder>{

    private ArrayList<WeatherInfo> listData;

    public RecyclerAdapter() {
        listData = new ArrayList<>();
    }

    /*
* 清理数据
* */
    public void clear(){
        listData.clear();
        notifyDataSetChanged();
    }

    /*
    * 删除数据
    * */
    public void remove(int position){
        listData.remove(position);
        notifyDataSetChanged();
    }

    /*
    * 添加数据
    * */
    public void addAll(Collection<WeatherInfo> list){
        listData.addAll(list);
        notifyDataSetChanged();
    }

    /*
  * 其他内容的填充
  * */
    public class OtherViewHolder extends RecyclerView.ViewHolder{
        TextView temperature,weather,wind,week,date;
        public OtherViewHolder(View itemView) {
            super(itemView);
            temperature = (TextView) itemView.findViewById(R.id.temperature_iv);
            weather = (TextView) itemView.findViewById(R.id.weather_iv);
            wind = (TextView) itemView.findViewById(R.id.wind_iv);
            week = (TextView) itemView.findViewById(R.id.week_iv);
            date = (TextView) itemView.findViewById(R.id.date_iv);
        }
    }

    @Override
    public OtherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_recyclerview_item,null);
        return new OtherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OtherViewHolder holder, final int position) {
        holder.temperature.setText("温度:"+listData.get(position).getTemperature());
        holder.weather.setText("天气:"+listData.get(position).getWeather());
        holder.wind.setText("风向:"+listData.get(position).getWind());
        holder.week.setText(listData.get(position).getWeek());
        holder.date.setText("日期:"+listData.get(position).getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerListener != null){
                    recyclerListener.onMainRecycleItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    //=======================短按接口=============================//
    public interface onMainRecyclerListener{
        void onMainRecycleItemClick(int position);
    }

    private onMainRecyclerListener recyclerListener;

    public void setOnMainRecyclerItemViewListener(onMainRecyclerListener recyclerListener){
        this.recyclerListener = recyclerListener;
    }

}