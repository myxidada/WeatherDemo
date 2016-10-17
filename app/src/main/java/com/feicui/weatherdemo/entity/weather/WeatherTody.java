package com.feicui.weatherdemo.entity.weather;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yukai on 2016/9/5.
 */
public class WeatherTody {


    /**
     * city : 天津
     * date_y : 2014年03月21日
     * week : 星期五
     * temperature : 8℃~20℃
     * weather : 晴转霾
     * weather_id : {"fa":"00","fb":"53"}
     * wind : 西南风微风
     * dressing_index : 较冷
     * dressing_advice : 建议着大衣、呢外套加毛衣、卫衣等服装。
     * uv_index : 中等
     * comfort_index :
     * wash_index : 较适宜
     * travel_index : 适宜
     * exercise_index : 较适宜
     * drying_index :
     */
    private String city;
    @SerializedName("date_y")
    private String dateY;
    private String week;
    private String temperature;
    private String weather;
    /**
     * fa : 00
     * fb : 53
     */
    @SerializedName("weather_id")
    private WeatherIdBean weatherId;
    private String wind;
    @SerializedName("dressing_index")
    private String dressingIndex;
    @SerializedName("dressing_advice")
    private String dressingAdvice;
    @SerializedName("uv_index")
    private String uvIndex;
    @SerializedName("comfort_index")
    private String comfortIndex;
    @SerializedName("wash_index")
    private String washIndex;
    @SerializedName("travel_index")
    private String travelIndex;
    @SerializedName("exercise_index")
    private String exerciseIndex;
    @SerializedName("drying_index")
    private String dryingIndex;

    public WeatherTody(String city, String dateY, String week, String temperature, String weather, String wind, String dressingIndex, String dressingAdvice, String uvIndex, String comfortIndex, String washIndex, String travelIndex, String exerciseIndex) {
        this.city = city;
        this.dateY = dateY;
        this.week = week;
        this.temperature = temperature;
        this.weather = weather;
        this.wind = wind;
        this.dressingIndex = dressingIndex;
        this.dressingAdvice = dressingAdvice;
        this.uvIndex = uvIndex;
        this.comfortIndex = comfortIndex;
        this.washIndex = washIndex;
        this.travelIndex = travelIndex;
        this.exerciseIndex = exerciseIndex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDateY() {
        return dateY;
    }

    public void setDateY(String dateY) {
        this.dateY = dateY;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
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

    public WeatherIdBean getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(WeatherIdBean weatherId) {
        this.weatherId = weatherId;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getDressingIndex() {
        return dressingIndex;
    }

    public void setDressingIndex(String dressingIndex) {
        this.dressingIndex = dressingIndex;
    }

    public String getDressingAdvice() {
        return dressingAdvice;
    }

    public void setDressingAdvice(String dressingAdvice) {
        this.dressingAdvice = dressingAdvice;
    }

    public String getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(String uvIndex) {
        this.uvIndex = uvIndex;
    }

    public String getComfortIndex() {
        return comfortIndex;
    }

    public void setComfortIndex(String comfortIndex) {
        this.comfortIndex = comfortIndex;
    }

    public String getWashIndex() {
        return washIndex;
    }

    public void setWashIndex(String washIndex) {
        this.washIndex = washIndex;
    }

    public String getTravelIndex() {
        return travelIndex;
    }

    public void setTravelIndex(String travelIndex) {
        this.travelIndex = travelIndex;
    }

    public String getExerciseIndex() {
        return exerciseIndex;
    }

    public void setExerciseIndex(String exerciseIndex) {
        this.exerciseIndex = exerciseIndex;
    }

    public String getDryingIndex() {
        return dryingIndex;
    }

    public void setDryingIndex(String dryingIndex) {
        this.dryingIndex = dryingIndex;
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
