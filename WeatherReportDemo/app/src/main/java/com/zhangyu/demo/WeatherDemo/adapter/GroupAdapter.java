package com.zhangyu.demo.WeatherDemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhangyu.demo.WeatherDemo.R;

import java.util.List;

/**
 * Created by zhangyu on 2016-09-05.
 */
public class GroupAdapter extends BaseAdapter{

    private Context context;

    private List<String> list;

    public GroupAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder  holder;
        if(view ==null){
            view=LayoutInflater.from(context).inflate(R.layout.popoupwindow_item,null);
            holder=new ViewHolder();
            view.setTag(holder);
            holder.popoupwindow_item= (TextView) view.findViewById(R.id.tx_pooupwindow_item);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        holder.popoupwindow_item.setText(list.get(i));
        return null;
    }

    static class ViewHolder{
        TextView popoupwindow_item;
    }
}
