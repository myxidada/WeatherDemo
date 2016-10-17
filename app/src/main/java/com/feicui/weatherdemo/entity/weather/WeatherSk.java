package com.feicui.weatherdemo.entity.weather;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yukai on 2016/9/5.
 */
public class WeatherSk {

    /**
     * temp : 21
     * wind_direction : 西风
     * wind_strength : 2级
     * humidity : 4%
     * time : 14:25
     */

    private String temp;
    @SerializedName("wind_direction")
    private String windDirection;
    @SerializedName("wind_strength")
    private String windStrength;
    private String humidity;
    private String time;

    public WeatherSk(String temp, String windDirection, String windStrength, String humidity, String time) {
        this.temp = temp;
        this.windDirection = windDirection;
        this.windStrength = windStrength;
        this.humidity = humidity;
        this.time = time;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindStrength() {
        return windStrength;
    }

    public void setWindStrength(String windStrength) {
        this.windStrength = windStrength;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
