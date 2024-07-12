package com.Dao;

import com.Model.FlightBooking;
import com.Model.FlightSchedule;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.util.Scanner;


public class BookingDao
{

    public static FlightBooking getFlightBookingsBasedOnBookingId(int bookingId) throws SQLException {

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs;
        FlightBooking flightBooking = null;

        try
        {
            conn = DatabaseConnection.getConnection();

            String query = "SELECT * FROM flight_booking WHERE booking_id = ?";

            psmt = conn.prepareStatement(query);

            psmt.setInt(1,bookingId);

            rs = psmt.executeQuery();

            if (rs.next())
            {
                flightBooking = new FlightBooking();
                flightBooking.setBookingId(rs.getInt(1));
                flightBooking.setFlightId(rs.getInt(2));
                flightBooking.setUserId(rs.getInt(3));
                flightBooking.setNoOfSeats(rs.getInt(4));
                flightBooking.setSeatCategory(rs.getString(5));
                flightBooking.setDateOfTravel(rs.getDate(6).toLocalDate());
                flightBooking.setBookingStatus(rs.getString(7));
                flightBooking.setBookingAmount(rs.getInt(8));
            }
            else
            {
                return null;
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }

        finally
        {
            if (psmt != null)
            {
                psmt.close();
            }
            if (conn != null)
            {
                conn.close();
            }
        }

        return flightBooking;
    }


    public static void updateFlightBookingStatus(int bookingId,String status) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;

        try
        {
            conn = DatabaseConnection.getConnection();
            String query = "UPDATE flight_booking SET booking_status=? WHERE booking_id=?";
            psmt = conn.prepareStatement(query);
            psmt.setString(1,status);
            psmt.setInt(2,bookingId);

            psmt.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e)
        {
           e.printStackTrace();
        }

        finally
        {
            if (psmt != null)
            {
                psmt.close();
            }
            if (conn != null)
            {
                conn.close();
            }
        }
    }

    public static void cancelBooking() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the bookingId");
        int bookingId = sc.nextInt();
        sc.nextLine();

        FlightBooking flightBooking = getFlightBookingsBasedOnBookingId(bookingId);

        if(flightBooking == null) {
            System.out.println("Booking is not present for this booking id");
            return;
        }

        if("Cancelled".equalsIgnoreCase(flightBooking.getBookingStatus())) {
            System.out.println("Booking is already cancelled");
            return;
        }

        double refundAmount = 0.0;

        LocalDate currentDate = LocalDate.now();
        long daysOfDifference = ChronoUnit.DAYS.between(currentDate, flightBooking.getDateOfTravel());

        if(daysOfDifference > 20) {
            refundAmount += flightBooking.getBookingAmount() * 0.95;
        } else if (daysOfDifference >= 10) {
            refundAmount += flightBooking.getBookingAmount() * 0.70;
        } else if(daysOfDifference >= 2) {
            refundAmount += flightBooking.getBookingAmount() * 0.40;
        }

        flightBooking.setBookingStatus("Cancelled");
        updateFlightBookingStatus(bookingId, "Cancelled");

        FlightSchedule flightSchedule = getFlightScheduleByFlightAndDate(flightBooking.getFlightId(), flightBooking.getDateOfTravel());

        if(flightSchedule!= null) {
            updateFlightScheduleBookedCount(flightBooking.getFlightId(), flightBooking.getDateOfTravel(), flightBooking.getSeatCategory(), flightBooking.getNoOfSeats());
        }

        System.out.println("Booking cancelled successfully. Refund amount: " + refundAmount);
    }



    public static FlightSchedule getFlightScheduleByFlightAndDate(int flightId, LocalDate dateOfTravel) throws SQLException {
        FlightSchedule flightSchedule = null;

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs;


        try {
            conn = DatabaseConnection.getConnection();

            String query = "SELECT * FROM flight_schedule WHERE flight_id=? AND dateoftravel=? ";

            psmt = conn.prepareStatement(query);

            psmt.setInt(1, flightId);
            psmt.setDate(2, Date.valueOf(dateOfTravel));

            rs = psmt.executeQuery();

            if (rs.next()) {
                flightSchedule = new FlightSchedule();
                flightSchedule.setFlightScheduleId(rs.getInt(1));
                flightSchedule.setFlightId(rs.getInt(2));
                flightSchedule.setDateOfTravel(rs.getDate(3).toLocalDate());
                flightSchedule.setBusinessClassBookedCount(rs.getInt(4));
                flightSchedule.setEconomyClassBookedCount(rs.getInt(5));
                flightSchedule.setExecutiveClassBookedCount(rs.getInt(6));

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        finally
        {
            if (psmt != null)
            {
                psmt.close();
            }
            if (conn != null)
            {
                conn.close();
            }
        }

        return flightSchedule;
    }


    public static void updateFlightScheduleBookedCount(int flightId,LocalDate dateOfTravel,String seatCategory,int noOfSeats) throws SQLException {
        Connection conn = null;
        PreparedStatement psmt = null;
        String query = "";

        switch (seatCategory.toLowerCase())
        {
            case "business":
                query = "UPDATE flight_schedule SET businessclass_bookedcount= businessclass_bookedcount - ? WHERE flight_id=? AND dateoftravel=?";
                break;
            case "economy":
                query = "UPDATE flight_schedule SET economyclass_bookedcount= economyclass_bookedcount - ? WHERE flight_id=? AND dateoftravel=?";
                break;
            case "executive":
                query = "UPDATE flight_schedule SET executiveclass_bookedcount= executiveclass_bookedcount - ? WHERE flight_id=? AND dateoftravel=?";
                break;
        }

        try
        {
            conn = DatabaseConnection.getConnection();
            psmt = conn.prepareStatement(query);

            psmt.setInt(1,noOfSeats);
            psmt.setInt(2,flightId);
            psmt.setDate(3,Date.valueOf(dateOfTravel));
            psmt.executeUpdate();
        }

        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }

        finally
        {
            if (psmt != null)
            {
                psmt.close();
            }
            if (conn != null)
            {
                conn.close();
            }
        }
    }

    public static FlightBooking getFlightBookingDetailsByFlightId(int flightId) throws SQLException {

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs;
        FlightBooking flightBooking = null;

        try
        {
            conn = DatabaseConnection.getConnection();

            String query = "SELECT date_of_travel FROM flight_booking WHERE flight_id = ?";

            psmt = conn.prepareStatement(query);

            psmt.setInt(1,flightId);

            rs = psmt.executeQuery();

            if (rs.next())
            {
                flightBooking = new FlightBooking();
                flightBooking.setFlightId(flightId);
                flightBooking.setDateOfTravel(rs.getDate("date_of_travel").toLocalDate());
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }

        finally
        {
            if (psmt != null)
            {
                psmt.close();
            }
            if (conn != null)
            {
                conn.close();
            }
        }

        return flightBooking;
    }

}
