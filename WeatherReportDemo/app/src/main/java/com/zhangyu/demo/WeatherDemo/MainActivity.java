package com.zhangyu.demo.WeatherDemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.zhangyu.demo.WeatherDemo.adapter.RecyclerAdapter;
import com.zhangyu.demo.WeatherDemo.adapter.RecyclerViewAdaptr;
import com.zhangyu.demo.WeatherDemo.network.Client;
import com.zhangyu.demo.WeatherDemo.weatherInfo.BaseWeatherInfo;
import com.zhangyu.demo.WeatherDemo.weatherInfo.WeatherInfo;
import com.zhangyu.demo.WeatherDemo.weatherInfo.WeatherSk;
import com.zhangyu.demo.WeatherDemo.weatherInfo.WeatherTody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView main_textView;

    private AddPopupWindow addPopupWindow;

    private final String API_KEY = "3b3a9d1e2927f68abb26b3c6b58183d8";

    private RecyclerViewAdaptr  recyclerViewAdaptr;

    private ArrayList<WeatherInfo> dataList;

    private Call<BaseWeatherInfo> call;

    private RecyclerView  main_recyclerView;

    private String cityNmae="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        SimpleDateFormat foormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = foormat.format(curDate);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("成都");
        toolbar.setSubtitle(str);

        if (cityNmae.isEmpty()){
            cityNmae = toolbar.getTitle().toString();
        }

        initi();

        Log.d("city1","============" + cityNmae);
        main_textView = (TextView) findViewById(R.id.main_textView);
        addPopupWindow = new AddPopupWindow(this);
        main_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPopupWindow.showAsDropDown(main_textView);
            }
        });
        addPopupWindow.adapter.sssetOnItemClickListener(new RecyclerAdapter.ooonItemClickListener() {
            @Override
            public void ooonItemClick(String city) {
                cityNmae = city;
                toolbar.setTitle(city);
                getCityData(city);
                addPopupWindow.dismiss();
            }
        });
    }


    private void initi() {
        main_recyclerView= (RecyclerView) findViewById(R.id.main_recyclerView);
        main_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataList=new ArrayList<>();
        recyclerViewAdaptr = new RecyclerViewAdaptr();
        getCityData(cityNmae);
        main_recyclerView.setAdapter(recyclerViewAdaptr);
    }

    /*
    * 获取城市信息
    * */
    private void getCityData(String cityNmae) {
        call= Client.getsInstance().getWeatherData(2,cityNmae,API_KEY);
        call.enqueue(infoCallback);
    }


    private Callback<BaseWeatherInfo> infoCallback = new Callback<BaseWeatherInfo>() {
        @Override
        public void onResponse(Call<BaseWeatherInfo> call, Response<BaseWeatherInfo> response) {

            dataList = response.body().getWeatherResult().getFutrue();
            recyclerViewAdaptr.addAll(dataList);

            WeatherSk weatherSk=response.body().getWeatherResult().getSk();
            WeatherTody weatherTody = response.body().getWeatherResult().getTody();
        }

        @Override
        public void onFailure(retrofit2.Call<BaseWeatherInfo> call, Throwable t) {

        }
    };
}
