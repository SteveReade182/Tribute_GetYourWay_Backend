package com.qa.cardatabase.web;

import com.qa.cardatabase.data.entity.Flight;
import com.qa.cardatabase.service.FlightApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightController {
    private final FlightApiService flightService;

    public FlightController(FlightApiService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flights/outbound")
    public List<Flight> getOutboundFlights() {
        return flightService.getOutboundFlights();
    }
}
