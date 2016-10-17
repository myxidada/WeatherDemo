package com.zhangyu.demo.WeatherDemo.weatherInfo;

/**
 * Created by Administrator on 2016/9/6.
 */
public class BaseWeatherInfo {
    /*
     *"resultcode": "200",
     * "reason": "查询成功!",
     *     "error_code": 0
     */
    private String resultCode;
    private String reason;
    private int errorCode;
    private WeatherResult weatherResult;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public WeatherResult getWeatherResult() {
        return weatherResult;
    }

    public void setWeatherResult(WeatherResult weatherResult) {
        this.weatherResult = weatherResult;
    }
}
