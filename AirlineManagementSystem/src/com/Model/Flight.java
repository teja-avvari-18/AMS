package com.Model;


public class Flight
{
    private int flightId;
    private int carrierId;
    private String origin;
    private String destination;
    private int airFare;
    private int seatCapacityBusinessClass;
    private int seatCapacityEconomyClass;
    private int seatCapacityExecutiveClass;

    public Flight() {

    }


    public int getAirFare() {
        return airFare;
    }

    public void setAirFare(int airFare) {
        this.airFare = airFare;
    }

    public int getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(int carrierId) {
        this.carrierId = carrierId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getSeatCapacityBusinessClass() {
        return seatCapacityBusinessClass;
    }

    public void setSeatCapacityBusinessClass(int seatCapacityBusinessClass) {
        this.seatCapacityBusinessClass = seatCapacityBusinessClass;
    }

    public int getSeatCapacityExecutiveClass() {
        return seatCapacityExecutiveClass;
    }

    public void setSeatCapacityExecutiveClass(int seatCapacityExecutiveClass) {
        this.seatCapacityExecutiveClass = seatCapacityExecutiveClass;
    }

    public int getSeatCapacityEconomyClass() {
        return seatCapacityEconomyClass;
    }

    public void setSeatCapacityEconomyClass(int seatCapacityEconomyClass) {
        this.seatCapacityEconomyClass = seatCapacityEconomyClass;
    }

    public Flight(int carrierId, String origin, String destination, int airFare, int seatCapacityBusinessClass, int seatCapacityEconomyClass, int seatCapacityExecutiveClass) {
        this.carrierId = carrierId;
        this.origin = origin;
        this.destination = destination;
        this.airFare = airFare;
        this.seatCapacityBusinessClass = seatCapacityBusinessClass;
        this.seatCapacityEconomyClass = seatCapacityEconomyClass;
        this.seatCapacityExecutiveClass = seatCapacityExecutiveClass;
    }

    public int getAvailableSeats(String seatCategory)
    {
        switch (seatCategory.toLowerCase())
        {
            case "business":
                return seatCapacityBusinessClass;
            case "economy":
                return seatCapacityEconomyClass;
            case "executive":
                return seatCapacityExecutiveClass;
            default:
                return 0;
        }
    }

    public void bookSeats(String seatCategory,int noOfSeats)
    {
        switch (seatCategory.toLowerCase()) {
            case "business":
                seatCapacityBusinessClass -= noOfSeats;
                break;
            case "economy":
                seatCapacityEconomyClass -= noOfSeats;
                break;
            case "executive":
                seatCapacityExecutiveClass -= noOfSeats;
                break;
        }
    }


    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", carrierId=" + carrierId +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", airFare=" + airFare +
                ", seatCapacityBusinessClass=" + seatCapacityBusinessClass +
                ", seatCapacityEconomyClass=" + seatCapacityEconomyClass +
                ", seatCapacityExecutiveClass=" + seatCapacityExecutiveClass +
                '}';
    }
}