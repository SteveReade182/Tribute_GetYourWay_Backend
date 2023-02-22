package com.qa.cardatabase.web;

import com.qa.cardatabase.data.entity.Weather;
import com.qa.cardatabase.service.WeatherResponseService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://127.0.0.1:9090")
public class WeatherController {
    private WeatherResponseService service;
    public WeatherController(WeatherResponseService service) {
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
}
