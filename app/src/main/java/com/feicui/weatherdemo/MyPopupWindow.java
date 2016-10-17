package com.feicui.weatherdemo;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import com.feicui.weatherdemo.adpater.CityAdapter;
import com.feicui.weatherdemo.entity.city.BaseInfo;
import com.feicui.weatherdemo.entity.city.CityInfo;
import com.feicui.weatherdemo.network.WeatherClient;
import com.feicui.weatherdemo.utils.CompanyDBUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yukai on 2016/9/5.
 */
public class MyPopupWindow extends PopupWindow implements CityAdapter.onRecyclerListener {
    private RecyclerView recyclerView;
    private CityAdapter adapter;
    private Call<BaseInfo> call;
    private ArrayList<CityInfo> cityList;
    private CompanyDBUtils utils;
    private final String API_KEY = "3b3a9d1e2927f68abb26b3c6b58183d8";

    public MyPopupWindow(Context context){

        View v = LayoutInflater.from(context).inflate(R.layout.layout_popupwindow,null);
        setContentView(v);
        int width = context.getResources().getDisplayMetrics().widthPixels;
        int height = context.getResources().getDisplayMetrics().heightPixels;
        setWidth(width  / 2);
        setHeight((height * 3) / 5);
        initView(v,context);
        setBackgroundDrawable(new BitmapDrawable());
        setTouchable(true);
        setOutsideTouchable(true);
        update();

    }

    /*
    * 初始化数据
    * */
    private void initView(View v,Context context) {
        recyclerView = (RecyclerView) v.findViewById(R.id.popu_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        utils = CompanyDBUtils.getsInstance(context);//数据库初始化
        adapter = new CityAdapter();
        cityList = new ArrayList<>();
        //去重
        judgeUtilData();//判断数据加载
        recyclerView.setAdapter(adapter);
        adapter.setOnRecyclerItemViewListener(this);
    }



    /*
   * 判断数据加载
   * */
    private void judgeUtilData() {
        if (utils.getCompanyDatas().size() <= 0){
            call = WeatherClient.getsInstance().getCityData(API_KEY);
            call.enqueue(infoCallback);
            for (int i = 0; i< cityList.size();i++){
                utils.insertName(cityList.get(i));//插入数据库
            }
        }else {
            cityList = utils.getCompanyDatas();//从独据库获取
        }
    }
    private Callback<BaseInfo> infoCallback = new Callback<BaseInfo>() {
        @Override
        public void onResponse(Call<BaseInfo> call, Response<BaseInfo> response) {
            cityList = response.body().getResult();
            adapter.addAllData(cityList);
        }

        @Override
        public void onFailure(Call<BaseInfo> call, Throwable t) {
            showErrInfo(t.getMessage());
        }
    };

    private void showErrInfo(String msg){
        Log.d("err","=======" + msg);
    }


    @Override
    public void onRecycleItemClick(int position) {
        String cityName = cityList.get(position).getCity();
        if (popupWindowCityNameListener != null){
            popupWindowCityNameListener.onCityNameListener(cityName);
        }
        dismiss();
    }

    /*
    * 回调获取城市名字
    * */
    public interface cityNameListener {
        void onCityNameListener(String cityName);
    }

    private cityNameListener popupWindowCityNameListener;

    public void setonPopupWindowCityNameListener(cityNameListener popupWindowCityNameListener){
        this.popupWindowCityNameListener = popupWindowCityNameListener;
    }
}
