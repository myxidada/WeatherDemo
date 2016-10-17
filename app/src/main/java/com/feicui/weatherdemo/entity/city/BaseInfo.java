package com.feicui.weatherdemo.entity.city;

import com.feicui.weatherdemo.entity.city.CityInfo;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by yukai on 2016/9/5.
 */
public class BaseInfo {

    /**
     * resultcode : 200
     * reason : successed
     * error_code : 0
     */

    @SerializedName("resultcode")
    private String resultCode;
    private String reason;
    @SerializedName("error_code")
    private int errorCode;

    private ArrayList<CityInfo> result;

    public ArrayList<CityInfo> getResult() {
        return result;
    }

    public void setResult(ArrayList<CityInfo> result) {
        this.result = result;
    }

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
}
