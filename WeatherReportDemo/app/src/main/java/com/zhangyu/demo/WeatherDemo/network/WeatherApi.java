package com.zhangyu.demo.WeatherDemo.network;

import com.zhangyu.demo.WeatherDemo.weatherInfo.BaseWeatherInfo;

import retrofit2.Call;
import retrofit2.http.Query;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by zhangyu on 2016-09-05.
 */
public interface WeatherApi {

    //    AppKey：3b3a9d1e2927f68abb26b3c6b58183d8
    @GET("weather/index")
    Call<BaseWeatherInfo> getWeatherData(@Query("format")int formatId,
                                         @Query("cityname")String city,
                                         @Query("key")String ApiKey);
}
