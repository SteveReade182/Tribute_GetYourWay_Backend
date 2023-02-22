package com.sky.getyourway.service;
import com.sky.getyourway.data.entity.Weather;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Service
public class WeatherResponseService implements WeatherService {

    public Weather getWeather(String location) {
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=c7bb8dcd62ae2dcba9ad47510c70f946");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.out.println("Error: " + responseCode);
            } else {
                Scanner sc = new Scanner(url.openStream());
                StringBuilder sb = new StringBuilder();
                while (sc.hasNext()) {
                    sb.append(sc.nextLine());
                }
                sc.close();
                String jsonString = sb.toString();
                JSONObject json = new JSONObject(jsonString);
                double temperature = json.getJSONObject("main").getDouble("temp");
                return new Weather(temperature);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}