package com.feicui.weatherdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.feicui.weatherdemo.adpater.RecyclerAdapter;
import com.feicui.weatherdemo.entity.weather.BaseWeatherInfo;
import com.feicui.weatherdemo.entity.weather.WeatherSk;
import com.feicui.weatherdemo.entity.weather.WeatherTody;
import com.feicui.weatherdemo.entity.weather.WeatherInfo;
import com.feicui.weatherdemo.network.WeatherClient;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MyPopupWindow.cityNameListener {
    private RecyclerView recyclerView;
    private TextView city,temp,date_y,week,
            temperature,weather,dressing_index,
            dressing_advice,wind;
    private RecyclerAdapter adapter;
    private Call<BaseWeatherInfo> call;
    private ArrayList<WeatherInfo> cityList;
    private Toolbar main_toolbar;
    private String cityName = "";
    private final String API_KEY = "3b3a9d1e2927f68abb26b3c6b58183d8";
    private MyPopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        initView();
    }

    private void initView() {
        setToolBarTitle();
        initTitleData();
        cityName = main_toolbar.getTitle().toString();
        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter();
        cityList = new ArrayList<>();
        call = WeatherClient.getsInstance().getWeatherData(2,cityName,API_KEY);
        call.enqueue(infoCallback);

        recyclerView.setAdapter(adapter);

        city = (TextView) findViewById(R.id.main_title_tv);

        city.setOnClickListener(this);

        mPopupWindow = new MyPopupWindow(MainActivity.this);
        mPopupWindow.setonPopupWindowCityNameListener(this);
    }

    /*
    * 初始化当天数据控件
    * */
    private void initTitleData() {
        temp = (TextView) findViewById(R.id.temp);
        date_y = (TextView) findViewById(R.id.date_y);
        week = (TextView) findViewById(R.id.week);
        temperature = (TextView) findViewById(R.id.temperature);
        weather = (TextView) findViewById(R.id.weather);
        dressing_index = (TextView) findViewById(R.id.dressing_index);
        dressing_advice = (TextView) findViewById(R.id.dressing_advice);
        wind = (TextView) findViewById(R.id.wind);
    }

    /*
   * 显示popupWindow
   * */
    private boolean isShowWindow;
    @Override
    public void onClick(View v) {
        if(isShowWindow == false) {
            mPopupWindow.showAsDropDown(city);
        }
        isShowWindow = !isShowWindow;
    }

    private Callback<BaseWeatherInfo> infoCallback = new Callback<BaseWeatherInfo>() {
        @Override
        public void onResponse(Call<BaseWeatherInfo> call, Response<BaseWeatherInfo> response) {
            cityList = response.body().getResult().getFuture();
            WeatherSk weatherSk = response.body().getResult().getSk();
            WeatherTody weatherTody = response.body().getResult().getToday();
            getTodayData(weatherSk, weatherTody);
            if (cityList.size() <= 0){
                showErrInfo("没有访问到数据");
                return;
            }
            adapter.clear();
            adapter.addAll(cityList);
        }

        @Override
        public void onFailure(Call<BaseWeatherInfo> call, Throwable t) {
            showErrInfo(t.getMessage());
        }
    };

    /*
    * 当天数据获取
    * */
    private void getTodayData(WeatherSk weatherSk, WeatherTody weatherTody) {
        temp.setText("今日温度:"+ weatherSk.getTemp()+"℃");
        wind.setText("风向:"+ weatherTody.getWind());
        weather.setText("今日天气:"+ weatherTody.getWeather());
        week.setText(weatherTody.getWeek());
        temperature.setText("今日温度:"+ weatherTody.getTemperature());
        dressing_advice.setText(weatherTody.getDressingAdvice());
        dressing_index.setText(weatherTody.getDressingIndex());
    }

    private void showErrInfo(String msg){
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
    }

    /*
    * 显示年月日
    * */
    private void setToolBarTitle() {
        main_toolbar = (Toolbar) findViewById(R.id.toolbar);
        main_toolbar.setTitle("北京");

        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dayData = dataFormat.format(new Date());
        main_toolbar.setSubtitle(dayData);
    }


    /*
    * 获取城市名
    * */
    @Override
    public void onCityNameListener(String city) {
        main_toolbar.setTitle(city);
        cityName = main_toolbar.getTitle().toString();
        call = WeatherClient.getsInstance().getWeatherData(2,cityName,API_KEY);
        call.enqueue(infoCallback);
    }

    private String change(String content) {
        String changedStr = null;
        try {
            byte[] convertTo = content.getBytes("UTF-8");
            changedStr = new String(convertTo, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return changedStr;
    }
}
