package com.Dao;

import com.Model.FlightBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
