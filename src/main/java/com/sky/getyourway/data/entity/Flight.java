package com.sky.getyourway.data.entity;

public class Flight {

    private String departure;
    private String destination;
    private String date;
    private int adults;

    public Flight(String departure, String destination, String date, int adults) {
        this.departure = departure;
        this.destination = destination;
        this.date = date;
        this.adults = adults;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }


}

