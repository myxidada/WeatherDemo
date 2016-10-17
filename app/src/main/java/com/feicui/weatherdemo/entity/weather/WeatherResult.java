package com.feicui.weatherdemo.entity.weather;

import java.util.ArrayList;

/**
 * Created by yukai on 2016/9/5.
 */
public class WeatherResult {

    private WeatherSk sk;

    private WeatherTody today;

    private ArrayList<WeatherInfo> future;

    public WeatherSk getSk() {
        return sk;
    }

    public WeatherResult(WeatherSk sk, WeatherTody today, ArrayList<WeatherInfo> future) {
        this.sk = sk;
        this.today = today;
        this.future = future;
    }

    public void setSk(WeatherSk sk) {
        this.sk = sk;
    }

    public WeatherTody getToday() {
        return today;
    }

    public void setToday(WeatherTody today) {
        this.today = today;
    }

    public ArrayList<WeatherInfo> getFuture() {
        return future;
    }

    public void setFuture(ArrayList<WeatherInfo> future) {
        this.future = future;
    }
}
