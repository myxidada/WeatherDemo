package com.zhangyu.demo.WeatherDemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhangyu.demo.WeatherDemo.R;
import com.zhangyu.demo.WeatherDemo.weatherInfo.BaseWeatherInfo;
import com.zhangyu.demo.WeatherDemo.weatherInfo.WeatherInfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/6.
 */
public class RecyclerViewAdaptr extends RecyclerView.Adapter<RecyclerViewAdaptr.TwoViwHolder>{

    private ArrayList<WeatherInfo> datas;

    public RecyclerViewAdaptr() {
        datas=new ArrayList<>();
    }

    public void addAll(ArrayList<WeatherInfo> list){
        datas.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public TwoViwHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,null);
        return new TwoViwHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdaptr.TwoViwHolder holder, int position) {
            holder.week.setText(datas.get(position).getWeek());
            holder.weather.setText(datas.get(position).getWeather());
            holder.temperature.setText(datas.get(position).getTemperature());
            holder.data.setText(datas.get(position).getData());
            holder.wind.setText(datas.get(position).getWind());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TwoViwHolder extends RecyclerView.ViewHolder{
        TextView week,weather,temperature,data,wind;
        public TwoViwHolder(View itemView) {
            super(itemView);
            week= (TextView) itemView.findViewById(R.id.week);
            weather= (TextView) itemView.findViewById(R.id.weather);
            temperature= (TextView) itemView.findViewById(R.id.temperature);
            data= (TextView) itemView.findViewById(R.id.data);
            wind= (TextView) itemView.findViewById(R.id.wind);

        }
    }

}
