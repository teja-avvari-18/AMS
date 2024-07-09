package com.Model;


import java.time.LocalDate;

public class FlightSchedule
{
    private int flightScheduleId;
    private int flightId;
    private LocalDate dateOfTravel;
    private int businessClassBookedCount;
    private int economyClassBookedCount;
    private int executiveClassBookedCount;

    public int getFlightScheduleId() {
        return flightScheduleId;
    }

    public void setFlightScheduleId(int flightScheduleId) {
        this.flightScheduleId = flightScheduleId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public LocalDate getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(LocalDate dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public int getBusinessClassBookedCount() {
        return businessClassBookedCount;
    }

    public void setBusinessClassBookedCount(int businessClassBookedCount) {
        this.businessClassBookedCount = businessClassBookedCount;
    }

    public int getEconomyClassBookedCount() {
        return economyClassBookedCount;
    }

    public void setEconomyClassBookedCount(int economyClassBookedCount) {
        this.economyClassBookedCount = economyClassBookedCount;
    }

    public int getExecutiveClassBookedCount() {
        return executiveClassBookedCount;
    }

    public void setExecutiveClassBookedCount(int executiveClassBookedCount) {
        this.executiveClassBookedCount = executiveClassBookedCount;
    }

    public void decrementBusinessClassBookedCount(int count) {
        this.businessClassBookedCount -= count;
    }

    public void decrementEconomyClassBookedCount(int count) {
        this.economyClassBookedCount -= count;
    }

    public void decrementExecutiveClassBookedCount(int count) {
        this.executiveClassBookedCount -= count;
    }

    public FlightSchedule(int flightId, LocalDate dateOfTravel, int businessClassBookedCount, int economyClassBookedCount, int executiveClassBookedCount) {
        this.flightId = flightId;
        this.dateOfTravel = dateOfTravel;
        this.businessClassBookedCount = businessClassBookedCount;
        this.economyClassBookedCount = economyClassBookedCount;
        this.executiveClassBookedCount = executiveClassBookedCount;
    }

    @Override
    public String toString() {
        return "FlightSchedule{" +
                "flightScheduleId=" + flightScheduleId +
                ", flightId=" + flightId +
                ", dateOfTravel=" + dateOfTravel +
                ", businessClassBookedCount=" + businessClassBookedCount +
                ", economyClassBookedCount=" + economyClassBookedCount +
                ", executiveClassBookedCount=" + executiveClassBookedCount +
                '}';
    }

    public FlightSchedule() {
    }
}