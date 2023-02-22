package com.qa.cardatabase.data.entity;

public class Weather {

    private String weather;
    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Weather(double weather) {
        this.weather = String.valueOf(weather);
    }


}
