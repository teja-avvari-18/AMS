package com.Dao;

import com.Model.FlightBooking;
import com.Model.FlightSchedule;

import java.sql.*;
import java.time.LocalDate;

public class FlightScheduleDao {

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


}