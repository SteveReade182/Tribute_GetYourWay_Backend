package com.qa.cardatabase.data.entity.Flight;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Leg {
    private String id;

    @JsonProperty("origin")
    private Airport originAirport;

    @JsonProperty("destination")
    private Airport destinationAirport;

    @JsonProperty("departure")
    private LocalDateTime departureTime;

    @JsonProperty("arrival")
    private LocalDateTime arrivalTime;

    // getters and setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Airport getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(Airport originAirport) {
        this.originAirport = originAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
