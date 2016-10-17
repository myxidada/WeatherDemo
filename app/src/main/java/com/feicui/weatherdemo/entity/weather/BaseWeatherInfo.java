package com.feicui.weatherdemo.entity.weather;

/**
 * Created by yukai on 2016/9/5.
 */
public class BaseWeatherInfo {
    /**
     * resultcode : 200
     * reason : 查询成功!
     * error_code : 0
     */
    private String resultcode;
    private String reason;
    private int error_code;
    private WeatherResult result;

    public WeatherResult getResult() {
        return result;
    }

    public void setResult(WeatherResult result) {
        this.result = result;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
