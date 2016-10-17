package com.zhangyu.demo.WeatherDemo.weatherInfo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/9/6.
 */
public class WeatherInfo {
    /***
     *"temperature": "28℃~36℃",   今日温度
     *"weather": "晴转多云",        今日天气
     *"wind": "南风3-4级",          今日风度
     *"week": "星期一",             星期几
     *"date": "20140804"            日期
     *"weather_id": 天气唯一标识
     "fa": "00",    天气标识00：晴
     "fb": "01"     天气标识53：霾 如果fa不等于fb，说明是组合天气
     *
     * ***/
    private String temperature;
    private String weather;

    @SerializedName("weather_id")
    private WeatherId  weatherId;

    private String wind;
    private String week;
    private String data;


    public WeatherInfo(String temperature, String weather, String wind, String week, String data) {
        this.temperature = temperature;
        this.weather = weather;
        this.wind = wind;
        this.week = week;
        this.data = data;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static class WeatherId{
        private String fa;
        private String fb;

        public String getFa() {
            return fa;
        }

        public void setFa(String fa) {
            this.fa = fa;
        }

        public String getFb() {
            return fb;
        }

        public void setFb(String fb) {
            this.fb = fb;
        }
    }

    public WeatherId getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(WeatherId weatherId) {
        this.weatherId = weatherId;
    }
}
