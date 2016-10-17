package com.zhangyu.demo.WeatherDemo.weatherInfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/6.
 */
public class WeatherResult {
        private WeatherSk sk;
        private WeatherTody tody;
        private ArrayList<WeatherInfo> futrue;

    public WeatherResult(WeatherSk sk, WeatherTody tody, ArrayList<WeatherInfo> infos) {
        this.sk = sk;
        this.tody = tody;
        this.futrue = infos;
    }

    public WeatherSk getSk() {
        return sk;
    }

    public void setSk(WeatherSk sk) {
        this.sk = sk;
    }

    public WeatherTody getTody() {
        return tody;
    }

    public void setTody(WeatherTody tody) {
        this.tody = tody;
    }

    public ArrayList<WeatherInfo> getFutrue() {
        return futrue;
    }

    public void setFutrue(ArrayList<WeatherInfo> futrue) {
        this.futrue = futrue;
    }
}
