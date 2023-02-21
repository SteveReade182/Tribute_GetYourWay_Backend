package com.qa.cardatabase.data.entity;


    // import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

import java.util.Date;

public class Flight{
        public String flightNumber;
        public String departureAirport;
        public String destination;
        public int durationInMinutes;
        public Date departure;
        public Date arrival;
        public String carriers;


    public Flight() {
    }

    public Flight(String flightNumber, String departureAirport, String destination, int durationInMinutes, Date departure, Date arrival, String carriers) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.destination = destination;
        this.durationInMinutes = durationInMinutes;
        this.departure = departure;
        this.arrival = arrival;
        this.carriers = carriers;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public String getCarriers() {
        return carriers;
    }

    public void setCarriers(String carriers) {
        this.carriers = carriers;
    }
}

