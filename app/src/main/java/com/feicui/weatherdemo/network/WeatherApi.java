package com.feicui.weatherdemo.network;

import com.feicui.weatherdemo.entity.city.BaseInfo;
import com.feicui.weatherdemo.entity.weather.BaseWeatherInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yukai on 2016/9/5.
 */
public interface WeatherApi {
    //http://v.juhe.cn/weather/index?format=2&cityname=%E8%8B%8F%E5%B7%9E&key=您申请的KEY
    //我的KEY:3b3a9d1e2927f68abb26b3c6b58183d8

    /*
    * 城市接口
    * */
    @GET("weather/citys")
    Call<BaseInfo> getCityData(@Query("key")String apiKey);




    /*
    * 未来七天的天气预报接口
    * */
    @GET("weather/index")
    Call<BaseWeatherInfo> getWeatherData(@Query("format")int formatId,
                                         @Query("cityname")String city,
                                         @Query("key")String ApiKey);
}
