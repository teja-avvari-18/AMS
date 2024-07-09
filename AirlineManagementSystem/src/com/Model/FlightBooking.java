package com.Model;

import java.time.LocalDate;

public class  FlightBooking
{
    private static int bookingIdCounter = 1;
    private int bookingId;
    private int flightId;
    private int userId;
    private int noOfSeats;
    private String seatCategory;
    private LocalDate dateOfTravel;
    private String bookingStatus;
    private int bookingAmount;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(String seatCategory) {
        this.seatCategory = seatCategory;
    }

    public LocalDate getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(LocalDate dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public int getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(int bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public FlightBooking(int flightId, int userId, int noOfSeats, String seatCategory, LocalDate dateOfTravel, String bookingStatus, int bookingAmount) {
        this.bookingId = bookingIdCounter++;
        this.flightId = flightId;
        this.userId = userId;
        this.noOfSeats = noOfSeats;
        this.seatCategory = seatCategory;
        this.dateOfTravel = dateOfTravel;
        this.bookingStatus = bookingStatus;
        this.bookingAmount = bookingAmount;
    }

    public FlightBooking() {
    }
}