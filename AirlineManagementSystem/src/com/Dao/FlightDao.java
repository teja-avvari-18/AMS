package com.Dao;

import com.Model.Flight;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class FlightDao
{
    public static void addFlightDetails() throws SQLException
    {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the flight details");

        System.out.println("Enter the carrier Id");
        int carrierId = sc.nextInt();

        sc.nextLine();

        System.out.println("Enter the origin");
        String origin = sc.nextLine();

        System.out.println("Enter the destination");
        String destination = sc.nextLine();

        System.out.println("Enter the air fare");
        int airFare = sc.nextInt();

        System.out.println("Enter the seat capacity for business class");
        int seatCapacityBusinessClass = sc.nextInt();

        System.out.println("Enter the seat capacity for economy class");
        int seatCapacityEconomyClass = sc.nextInt();

        System.out.println("Enter the seat capacity for executive class");
        int seatCapacityExecutiveClass = sc.nextInt();

        Flight flight = new Flight(carrierId,origin,destination,airFare,seatCapacityBusinessClass,seatCapacityEconomyClass,seatCapacityExecutiveClass);

        if(flight.getOrigin()==null ||
                flight.getDestination()==null ||
                flight.getAirFare()<0 ||
                flight.getSeatCapacityBusinessClass() < 0 ||
                flight.getSeatCapacityEconomyClass() < 0 ||
                flight.getSeatCapacityExecutiveClass()<0)
        {
            System.out.println("Issue in saving the flight details. Please check the data and try again.");
        }

        else
        {
            PreparedStatement psmt = null;
            Connection conn = null;
            try
            {
                conn = DatabaseConnection.getConnection();

                String query = "INSERT INTO flight (carrier_id,origin,destination,airfare,seat_capacity_business_class,seat_capacity_economy_class,seat_capacity_executive_class) " +
                        "VALUES(?,?,?,?,?,?,?)";
                psmt = conn.prepareStatement(query);
                psmt.setInt(1,flight.getCarrierId());
                psmt.setString(2,flight.getOrigin());
                psmt.setString(3,flight.getDestination());
                psmt.setInt(4,flight.getAirFare());
                psmt.setInt(5,flight.getSeatCapacityBusinessClass());
                psmt.setInt(6,flight.getSeatCapacityEconomyClass());
                psmt.setInt(7,flight.getSeatCapacityExecutiveClass());

                int rowsAffected = psmt.executeUpdate();

                if(rowsAffected>0)
                {
                    System.out.println("Flight Details are saved successfully.");
                }
                else
                {
                    System.out.println("Issue in saving Flight Information. Please check the data and try again");
                }
            }
            catch (ClassNotFoundException | SQLException e)
            {
                e.printStackTrace();
            }
            finally
            {
                if (psmt != null) {
                    psmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            }
         }
    }

    public static void viewAllFlights() throws SQLException
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try
        {
            conn = DatabaseConnection.getConnection();
            String query = "SELECT * FROM flight";

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next())
            {
                System.out.println("Flight Id: "+rs.getInt(1));
                System.out.println("Carrier Id: "+rs.getInt(2));
                System.out.println("Origin: "+rs.getString(3));
                System.out.println("Destination: "+rs.getString(4));
                System.out.println("AirFare: "+rs.getInt(5));
                System.out.println("Seat Capacity Business Class: "+rs.getInt(6));
                System.out.println("Seat Capacity Economy Class: "+rs.getInt(7));
                System.out.println("Seat Capacity Executive Class: "+rs.getInt(8));

            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (stmt != null)
            {
                stmt.close();
            }

            if (conn != null)
            {
                conn.close();
            }
        }
    }


    public static Flight findFlightById(int flightId) throws SQLException
    {
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Flight flight = null;

        try
        {
            conn = DatabaseConnection.getConnection();
            String query = "SELECT * FROM flight WHERE flight_id = ?";
            psmt = conn.prepareStatement(query);
            psmt.setInt(1,flightId);

            rs = psmt.executeQuery();

            if(rs.next())
            {
                flight = new Flight(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));
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

        return flight;
    }

    public static void viewFlightDetailsById()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the flight Id ");
        int flightId = sc.nextInt();
        sc.nextLine();

        try
        {
            Flight flight = findFlightById(flightId);

            if(flight==null)
            {
                System.out.println("Either the data is incorrect or no Flight Information is available for the given Flight ID "+flightId);
            }

            System.out.println("Flight Details");
            System.out.println("Flight id: "+flightId);
            System.out.println("Carrier id: "+flight.getCarrierId());
            System.out.println("Origin: "+flight.getOrigin());
            System.out.println("Destination: "+flight.getOrigin());
            System.out.println("AirFare: "+flight.getAirFare());
            System.out.println("Seat Capacity Business Class: "+flight.getSeatCapacityBusinessClass());
            System.out.println("Seat Capacity Economy Class: "+flight.getSeatCapacityEconomyClass());
            System.out.println("Seat Capacity Executive Class: "+flight.getSeatCapacityExecutiveClass());
        }
        catch (SQLException e)
        {
           e.printStackTrace();
        }
    }

    public static void editFlightDetails() throws SQLException
    {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the flight id");
        int flightId = sc.nextInt();
        sc.nextLine();

        Flight flight = findFlightById(flightId);

        if(flight==null)
        {
            System.out.println("There is no flight present with the flight id "+flightId);
            return;
        }

        System.out.println("Edit flight details");

        System.out.println("Enter new carrier id (leave blank to keep current)");
        String carrierId = sc.nextLine();

        if(!carrierId.isEmpty())
        {
            flight.setCarrierId(Integer.parseInt(carrierId));
        }

        System.out.println("Enter new origin (leave blank to keep current)");
        String origin = sc.nextLine();

        if(!origin.isEmpty())
        {
            flight.setOrigin(origin);
        }

        System.out.println("Enter new destination (leave blank to keep current)");
        String destination = sc.nextLine();

        if(!destination.isEmpty())
        {
            flight.setDestination(destination);
        }

        System.out.println("Enter new air fare (leave blank to keep current)");
        String airFare = sc.nextLine();

        if(!airFare.isEmpty())
        {
            flight.setAirFare(Integer.parseInt(airFare));
        }

        System.out.println("Enter new seat capacity Business Class (leave blank to keep current)");
        String seatCapacityBusinessClass = sc.nextLine();

        if(!seatCapacityBusinessClass.isEmpty())
        {
            flight.setSeatCapacityBusinessClass(Integer.parseInt(seatCapacityBusinessClass));
        }

        System.out.println("Enter new seat capacity Economy Class (leave blank to keep current)");
        String seatCapacityEconomyClass = sc.nextLine();

        if(!seatCapacityEconomyClass.isEmpty())
        {
            flight.setSeatCapacityEconomyClass(Integer.parseInt(seatCapacityEconomyClass));
        }

        System.out.println("Enter new seat capacity Executive Class (leave blank to keep current)");
        String seatCapacityExecutiveClass = sc.nextLine();

        if(!seatCapacityExecutiveClass.isEmpty())
        {
            flight.setSeatCapacityBusinessClass(Integer.parseInt(seatCapacityBusinessClass));
        }

        Connection conn = null;
        PreparedStatement psmt = null;

        try
        {
            conn = DatabaseConnection.getConnection();

            String query = "UPDATE flight SET carrier_id=?,origin=?,destination=?," +
                    "airfare=?,seat_capacity_business_class=?,seat_capacity_economy_class=?,seat_capacity_executive_class=? WHERE flight_id=?";

            psmt = conn.prepareStatement(query);

            psmt.setInt(1,flight.getCarrierId());
            psmt.setString(2,flight.getOrigin());
            psmt.setString(3,flight.getDestination());
            psmt.setInt(4,flight.getAirFare());
            psmt.setInt(5,flight.getSeatCapacityBusinessClass());
            psmt.setInt(6,flight.getSeatCapacityEconomyClass());
            psmt.setInt(7,flight.getSeatCapacityExecutiveClass());
            psmt.setInt(8,flightId);

            int result = psmt.executeUpdate();

            if(result>0)
            {
                System.out.println("Flight Details are updated successfully");
            }

            else
            {
                System.out.println("Either the data is incorrect or no flight information is available for the given flight ID");
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

    }

    public static void removeFlightDetails() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the flight Id");
        int flightId = sc.nextInt();
        sc.nextLine();

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        try
        {
            conn = DatabaseConnection.getConnection();
            String checkFlight = "SELECT * FROM flight WHERE flight_id=?";
            psmt = conn.prepareStatement(checkFlight);
            psmt.setInt(1,flightId);
            rs = psmt.executeQuery();

            if(!rs.next())
            {
                System.out.println("Either the data is incorrect or no flight information is available for the given flight id " + flightId);
            }

            else
            {
                String bookedFlights = "SELECT * FROM flight_booking WHERE flight_id = ?";
                psmt = conn.prepareStatement(bookedFlights);
                psmt.setInt(1,flightId);
                rs = psmt.executeQuery();

                if(rs.next())
                {
                    System.out.println("Flight Information can't be removed as there are Active Booking open in the System. Please attempt to remove this flight either by cancelling all open ticket  or try after serving all open bookings");
                }

                else
                {
                    String deleteFlight = "DELETE FROM flight WHERE flight_id = ? ";
                    psmt = conn.prepareStatement(deleteFlight);
                    psmt.setInt(1,flightId);
                    psmt.executeUpdate();
                    System.out.println("Flight Information successfully removed from system");
                }
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }

        finally
        {
            if(rs!=null) rs.close();
            if(psmt!=null) psmt.close();
            if(conn!=null) conn.close();
        }
    }

    public static void calculateTotalRefundForCancelledFlights() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the flight Id");
        int flightId = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the travel date (yyyy-mm-dd)");
        String travelDate = sc.nextLine();
        LocalDate travellingDate = LocalDate.parse(travelDate);

        double totalRefund = 0.0;

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs;

        try
        {
            conn = DatabaseConnection.getConnection();

            String query = "SELECT booking_status, booking_amount FROM flight_booking WHERE flight_id=? AND date_of_travel=?";

            psmt = conn.prepareStatement(query);
            psmt.setInt(1,flightId);
            psmt.setDate(2,Date.valueOf(travellingDate));

            rs = psmt.executeQuery();

            while (rs.next())
            {
                String bookingStatus = rs.getString("booking_status");
                double bookingAmount = rs.getDouble("booking_amount");

                if("Cancelled".equalsIgnoreCase(bookingStatus))
                {
                    totalRefund += bookingAmount;
                }

                if(ChronoUnit.DAYS.between(LocalDate.now(),travellingDate) <=7)
                {
                    totalRefund += bookingAmount*0.10;
                }

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

        System.out.printf("Refund Amount is %.2f",totalRefund);

    }




}
