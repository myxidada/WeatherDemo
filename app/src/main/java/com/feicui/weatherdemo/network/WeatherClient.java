package com.feicui.weatherdemo.network;

import com.feicui.weatherdemo.entity.city.BaseInfo;
import com.feicui.weatherdemo.entity.weather.BaseWeatherInfo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

/**
 * Created by yukai on 2016/9/5.
 */
public class WeatherClient implements WeatherApi{

    private final String BASE_URL = "http://v.juhe.cn/";
    private WeatherApi weatherApi;
    //单例
    private static WeatherClient sInstance;
    public static WeatherClient getsInstance(){
        if (sInstance == null){
            sInstance = new WeatherClient();
        }
        return sInstance;
    }

    public WeatherClient() {
        //拦截器
        //用HttpLoggingInterceptor弄出请求到的JSON字符串
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        //拦截请求体
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //链接网络时用拦截器来打印
        //Okhttp的使用方式
        OkHttpClient client = new OkHttpClient.Builder()
                //使用拦截器打印日志
                .addInterceptor(loggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                //Okhttp的基本连接
                .baseUrl(BASE_URL)
                .client(client)
                //使用Retrofit自带的转换工厂来进行数据的解析
                .addConverterFactory(GsonConverterFactory.create())
                .build();
            //用Retrofit来创建一个接口
        weatherApi = retrofit.create(WeatherApi.class);

    }

    @Override
    public Call<BaseInfo> getCityData(@Query("key") String apiKey) {
        //因为这里根据它的API文档只需要返回一个接口的apiKey值
        return weatherApi.getCityData(apiKey);
    }

    @Override
    public Call<BaseWeatherInfo> getWeatherData(@Query("format") int formatId, @Query("cityname") String city, @Query("key") String ApiKey) {
       //这里根据API的文档需要返回一个城市名字和未来七天的天气预报还有一个apiKey值
        return weatherApi.getWeatherData(formatId, city, ApiKey);
    }
}
