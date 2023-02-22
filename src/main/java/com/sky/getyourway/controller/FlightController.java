package com.sky.getyourway.controller;

import com.sky.getyourway.data.entity.Flight;
import com.sky.getyourway.service.FlightService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {
    private FlightService service;
    public FlightController(FlightService service){this.service = service;}
    @PostMapping("/flight")
    public String flightRequest(@RequestBody Flight flight) {

        Flight toCreate = new Flight(flight.getDeparture(), flight.getDestination(),
                flight.getDate(), flight.getAdults());
        String created = "";

        try {
            created = this.service.getFlightAsString(toCreate);
        } catch (Exception e) {

        }

        return created;
    }

}
