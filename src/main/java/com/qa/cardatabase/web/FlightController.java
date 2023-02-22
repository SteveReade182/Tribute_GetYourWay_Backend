package com.qa.cardatabase.web;

import com.qa.cardatabase.data.entity.Flight;
import com.qa.cardatabase.service.FlightApiService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class FlightController {
    private final FlightApiService flightService;

    public FlightController(FlightApiService flightService) {
        this.flightService = flightService;
    }

//    @GetMapping("/flights/outbound")
//    public List<Flight> getOutboundFlights() {
//        return flightService.getOutboundFlights();
//    }

    @GetMapping("/schedules")
    public String getSchedules(){
        return flightService.getSchedules();
    }

    @GetMapping("/schedules2")
    public String getSchedules2(){
        return flightService.getSchedules2();
    }

    @GetMapping("/schedules3")
    public Flight getSchedules3(){
        return flightService.getSchedules3();
    }


}
