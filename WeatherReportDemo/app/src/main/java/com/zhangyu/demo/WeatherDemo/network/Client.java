package com.zhangyu.demo.WeatherDemo.network;

import android.media.session.MediaSession;

import com.zhangyu.demo.WeatherDemo.weatherInfo.BaseWeatherInfo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;



/**
 * Created by zhangyu on 2016-09-05.
 */
public  class Client implements WeatherApi{


    private final String BASE_URL = "http://v.juhe.cn/";

    private WeatherApi weatherApi;

    private static Client sInstance;

    public static Client getsInstance(){
        if (sInstance == null){
            sInstance = new Client();
        }
        return sInstance;
    }

    public Client() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)//打印日志
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)//基本连接
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())//转换工厂 数据的解析
                .build();
        weatherApi = retrofit.create(WeatherApi.class);
    }
    @Override
    public Call<BaseWeatherInfo> getWeatherData(@Query("format") int formatId, @Query("cityname") String city, @Query("key") String ApiKey) {
        return weatherApi.getWeatherData(formatId, city, ApiKey);
    }

}
