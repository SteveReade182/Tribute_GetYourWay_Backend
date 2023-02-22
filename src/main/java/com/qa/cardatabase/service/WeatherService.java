package com.qa.cardatabase.service;
import com.qa.cardatabase.data.entity.Weather;
import org.json.JSONObject;

public interface WeatherService {
    Weather getWeather(String w);
    String getWeather2(String w);
}