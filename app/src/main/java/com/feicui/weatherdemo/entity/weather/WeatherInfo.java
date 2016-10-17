package com.feicui.weatherdemo.entity.weather;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yukai on 2016/9/5.
 */
public class WeatherInfo {

    /**
     * temperature : 27℃~35℃
     * weather : 晴转多云
     * weather_id : {"fa":"00","fb":"01"}
     * wind : 东南风3-4级
     * week : 星期三
     * date : 20140806
     */

    private String temperature;
    private String weather;
    /**
     * fa : 00
     * fb : 01
     */

    @SerializedName("weather_id")
    private WeatherIdBean weatherIdd;
    private String wind;
    private String week;
    private String date;

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

    public WeatherIdBean getWeatherIdd() {
        return weatherIdd;
    }

    public void setWeatherIdd(WeatherIdBean weatherIdd) {
        this.weatherIdd = weatherIdd;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static class WeatherIdBean {
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
}
