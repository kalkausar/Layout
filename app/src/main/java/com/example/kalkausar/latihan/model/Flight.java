package com.example.kalkausar.latihan.model;

public class Flight {
    String flightid;
    String flightName;
    String flightDeparture;
    String flightArrival;
    String flightDate;
    String flightPassenger;
    String flightPrice;

    public Flight(){

    }

    public Flight(String flightid, String flightName, String flightDeparture, String flightArrival, String flightDate, String flightPassenger, String flightPrice) {
        this.flightid = flightid;
        this.flightName = flightName;
        this.flightDeparture = flightDeparture;
        this.flightArrival = flightArrival;
        this.flightDate = flightDate;
        this.flightPassenger = flightPassenger;
        this.flightPrice = flightPrice;
    }

    public String getFlightid() {
        return flightid;
    }

    public String getFlightName() {
        return flightName;
    }

    public String getFlightDeparture() {
        return flightDeparture;
    }

    public String getFlightArrival() {
        return flightArrival;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public String getFlightPassenger() {
        return flightPassenger;
    }

    public String getFlightPrice() {
        return flightPrice;
    }
}
