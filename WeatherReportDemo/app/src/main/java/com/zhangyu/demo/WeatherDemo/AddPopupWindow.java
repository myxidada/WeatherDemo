package com.zhangyu.demo.WeatherDemo;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.zhangyu.demo.WeatherDemo.adapter.RecyclerAdapter;

import java.util.ArrayList;

/**
 * Created by zhangyu on 2016-09-05.
 */
public class AddPopupWindow extends PopupWindow {

    public ArrayList<String> list;

    public RecyclerView recycler_pop;

    public RecyclerAdapter adapter;


    public AddPopupWindow(final Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.popoupwindow, null);
        setContentView(v);
        int width = context.getResources().getDisplayMetrics().widthPixels;

        int height = context.getResources().getDisplayMetrics().heightPixels;
        setWidth(width / 4);
        setHeight(height / 3);
        recycler_pop = (RecyclerView) v.findViewById(R.id.recycler_pop);
        list = new ArrayList<String>();
        list.add("成都");
        list.add("上海");
        list.add("重庆");
        list.add("广元");
        list.add("南充");
        list.add("北京");
        list.add("广州");
        adapter = new RecyclerAdapter(list);
        recycler_pop.setLayoutManager(new LinearLayoutManager(context));
        recycler_pop.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position) {
                    case 0:
                        Toast.makeText(context, "当前城市:" + list.get(position), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        setBackgroundDrawable(new BitmapDrawable());
        setTouchable(true);
        setOutsideTouchable(true);
        update();
    }

}
