package com.qa.cardatabase.web;
import com.qa.cardatabase.data.entity.Weather;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import com.qa.cardatabase.service.WeatherService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class WeatherController {
    private WeatherService service;
    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/weather/{location}")
    public Weather weatherRequest(@PathVariable String location) {

        return this.service.getWeather(location);
    }
    @GetMapping("/weather")
    public Weather weatherRequestByCityName(@RequestParam String cityName) {
        return this.service.getWeather(cityName);
    }

    @GetMapping("/weather2")
    public String weatherRequestByCityName2(@RequestParam String cityName) {
        return this.service.getWeather2(cityName);
    }

}
