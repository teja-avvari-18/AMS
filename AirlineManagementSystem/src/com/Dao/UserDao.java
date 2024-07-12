package com.Dao;

import com.Model.Carrier;
import com.Model.Flight;
import com.Model.FlightBooking;
import com.Model.User;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.Dao.BookingDao.getFlightBookingDetailsByFlightId;
import static com.Dao.BookingDao.getFlightBookingsBasedOnBookingId;
import static com.Dao.CarrierDao.findCarrierById;
import static com.Dao.FlightDao.findFlightById;

public class UserDao
{

    public static void userRegistration() throws SQLException
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the customer details for Customer Registration");


        System.out.println("Enter the user name");
        String userName = sc.nextLine();

        System.out.println("Enter the password");
        String password = sc.nextLine();

        System.out.println("Enter the phone number");
        long phone = sc.nextLong();

        sc.nextLine();

        System.out.println("Enter the email id");
        String emailId = sc.nextLine();

        System.out.println("Enter address 1");
        String address1 = sc.nextLine();

        System.out.println("Enter address 2");
        String address2 = sc.nextLine();

        System.out.println("Enter City");
        String city = sc.nextLine();

        System.out.println("Enter state");
        String state = sc.nextLine();

        System.out.println("Enter country");
        String country = sc.nextLine();

        System.out.println("Enter zipcode");
        long zipCode = sc.nextLong();

        sc.nextLine();

        System.out.println("Enter date of birth(YYYY-MM-DD)");
        String dobInput = sc.nextLine();
        LocalDate dateofBirth = LocalDate.parse(dobInput);

        System.out.println("Enter user category");
        String userCategory = sc.nextLine();


        User user = new User(userName,password,phone,emailId,address1,address2,city,state,country,zipCode,dateofBirth,userCategory);

        if(user.getUserName()==null || user.getPassword()==null
        || user.getPhone()<0 || user.getEmailId()==null || user.getAddress1()==null
        || user.getAddress2()==null || user.getCity()==null || user.getCountry()==null || user.getState()==null ||
        user.getZipCode()<0 || user.getDateofBirth()==null || user.getUserCategory()==null)
        {
            System.out.println("Encountered issue while saving user information. Please Check the data and try again");
        }
        else
        {
            PreparedStatement psmt = null;
            Connection conn = null;

            try
            {
                conn = DatabaseConnection.getConnection();
                String sql = "INSERT INTO user(user_name,password,phone,email_id," +
                        "address1,address2,city,state,country,zipcode,dateofBirth,user_category)" +
                        "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

                psmt = conn.prepareStatement(sql);
                psmt.setString(1,user.getUserName());
                psmt.setString(2,user.getPassword());
                psmt.setLong(3,user.getPhone());
                psmt.setString(4,user.getEmailId());
                psmt.setString(5,user.getAddress1());
                psmt.setString(6,user.getAddress2());
                psmt.setString(7,user.getCity());
                psmt.setString(8,user.getState());
                psmt.setString(9,user.getCountry());
                psmt.setLong(10,user.getZipCode());
                psmt.setDate(11, Date.valueOf(user.getDateofBirth()));
                psmt.setString(12,user.getUserCategory());

                int rowsAffected = psmt.executeUpdate();

                if(rowsAffected>0)
                {
                    System.out.println("User Registration done successfully");
                }
                else
                {
                    System.out.println("Issue in saving user Information. Please check the data and try again.");
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

    public static User findUserById(int userId) throws SQLException
    {
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs;
        User user = null;

        try
        {
            conn = DatabaseConnection.getConnection();
            String query = "SELECT * FROM user WHERE user_id = ?";
            psmt = conn.prepareStatement(query);
            psmt.setInt(1,userId);

            rs = psmt.executeQuery();

            if(rs.next())
            {
                user = new User(rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getLong(11), rs.getDate(12).toLocalDate(),rs.getString(13),rs.getString(14));
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

            if (psmt != null) {
                psmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }

        return user;
    }


    public static void updateUser() throws SQLException
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the user id ");
        int userId = sc.nextInt();
        sc.nextLine();

        User user = findUserById(userId);

        if(user==null)
        {
            System.out.println("There is no user present with the user id "+userId);
            return;
        }

        System.out.println("Edit User Details ");


        System.out.println("Enter new user name (leave blank to keep current) ");
        String username = sc.nextLine();

        if(!username.isEmpty())
        {
            user.setUserName(username);
        }

        System.out.println("Enter new password (leave blank to keep current) ");
        String password = sc.nextLine();

        if(!password.isEmpty())
        {
            user.setPassword(password);
        }

        System.out.println("Enter new phone number (leave blank to keep current) ");
        String phone = sc.nextLine();

        if(!phone.isEmpty())
        {
            user.setPhone(Long.parseLong(phone));
        }

        System.out.println("Enter new email id (leave blank to keep current) ");
        String emailId = sc.nextLine();

        if(!emailId.isEmpty())
        {
            user.setEmailId(emailId);
        }

        System.out.println("Enter new address1 (leave blank to keep current) ");
        String address1 = sc.nextLine();

        if(!address1.isEmpty())
        {
            user.setAddress1(address1);
        }

        System.out.println("Enter new address2 (leave blank to keep current) ");
        String address2 = sc.nextLine();

        if(!address2.isEmpty())
        {
            user.setAddress1(address2);
        }

        System.out.println("Enter new city (leave blank to keep current) ");
        String city = sc.nextLine();

        if(!city.isEmpty())
        {
            user.setCity(city);
        }

        System.out.println("Enter new state (leave blank to keep current) ");
        String state = sc.nextLine();

        if(!state.isEmpty())
        {
            user.setState(state);
        }

        System.out.println("Enter new country (leave blank to keep current) ");
        String country = sc.nextLine();

        if(!country.isEmpty())
        {
            user.setCountry(country);
        }

        System.out.println("Enter new zip code (leave blank to keep current) ");
        String zipCode = sc.nextLine();

        if(!zipCode.isEmpty())
        {
            user.setZipCode(Long.parseLong(zipCode));
        }

        System.out.println("Enter new date of birth(YYYY-MM-DD) to keep current");
        String dateofBirth = sc.nextLine();

        if(!dateofBirth.isEmpty())
        {
            user.setDateofBirth(LocalDate.parse(dateofBirth));
        }

        Connection conn = null;
        PreparedStatement psmt = null;

        try
        {
            conn = DatabaseConnection.getConnection();
            String query = "UPDATE user SET user_name=?,password=?,phone=?,email_id=?," +
                    "address1=?,address2=?,city=?,state=?,country=?,zipcode=?,dateofBirth=?,role=?,user_category=?" +
                    "WHERE user_id=?";

            psmt = conn.prepareStatement(query);
            psmt.setString(1,user.getUserName());
            psmt.setString(2,user.getPassword());
            psmt.setLong(3,user.getPhone());
            psmt.setString(4,user.getEmailId());
            psmt.setString(5,user.getAddress1());
            psmt.setString(6,user.getAddress2());
            psmt.setString(7,user.getCity());
            psmt.setString(8,user.getState());
            psmt.setString(9,user.getCountry());
            psmt.setLong(10,user.getZipCode());
            psmt.setDate(11,Date.valueOf(user.getDateofBirth()));
            psmt.setString(12,user.getRole());
            psmt.setString(13,user.getUserCategory());
            psmt.setInt(14,userId);

            int result = psmt.executeUpdate();

            if(result>0)
            {
                System.out.println("User Details are updated successfully");
            }

            else
            {
                System.out.println("Either the data is incorrect or no user information is available for the given user ID");
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


    public static void viewMyBookings() throws SQLException
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the user Id");
        int userId = sc.nextInt();
        sc.nextLine();

        List<FlightBooking> myBookings = getFlightBookingsBasedOnUserId(userId);

        if(myBookings.isEmpty())
        {
            System.out.println("The user with userId "+userId+" did not book any flights yet");
        }

        else
        {
            for(FlightBooking flightBooking:myBookings)
            {
                User user = findUserById(flightBooking.getUserId());

                System.out.println("Booking Id: "+flightBooking.getBookingId());
                System.out.println("Flight Id: "+flightBooking.getFlightId());
                System.out.println("User Name: "+user.getUserName());
                System.out.println("No. of Seats: "+flightBooking.getNoOfSeats());
                System.out.println("Seat Category: "+flightBooking.getSeatCategory());
                System.out.println("Date of travel: "+flightBooking.getDateOfTravel());
                System.out.println("Booking Status: "+flightBooking.getBookingStatus());
                System.out.println("Booking Amount: "+flightBooking.getBookingAmount());
            }
        }
    }


    public static List<FlightBooking> getFlightBookingsBasedOnUserId(int userId) throws SQLException {
        List<FlightBooking> bookings = new ArrayList<>();

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs;

        try
        {
            conn = DatabaseConnection.getConnection();

            String query = "SELECT * FROM flight_booking WHERE user_id = ?";

            psmt = conn.prepareStatement(query);

            psmt.setInt(1,userId);

            rs = psmt.executeQuery();

            while (rs.next())
            {
                FlightBooking flightBooking = new FlightBooking();
                flightBooking.setBookingId(rs.getInt(1));
                flightBooking.setFlightId(rs.getInt(2));
                flightBooking.setUserId(rs.getInt(3));
                flightBooking.setNoOfSeats(rs.getInt(4));
                flightBooking.setSeatCategory(rs.getString(5));
                flightBooking.setDateOfTravel(rs.getDate(6).toLocalDate());
                flightBooking.setBookingStatus(rs.getString(7));
                flightBooking.setBookingAmount(rs.getInt(8));
                bookings.add(flightBooking);
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

        return bookings;
    }


    public static void searchFlightsBasedOnOriginDestinationAndDateofTravel() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter origin");
        String origin = sc.nextLine();

        System.out.println("Enter destination");
        String destination = sc.nextLine();

        System.out.println("Enter Date of travel(yyyy-mm-dd)");
        String dateofTravelStr = sc.nextLine();
        LocalDate dateofTravel = LocalDate.parse(dateofTravelStr);

        List<Flight> resultFlights = getFlightsBasedonOriginDestinationAndDateofTravel(origin,destination,dateofTravel);

        if(resultFlights.isEmpty())
        {
            System.out.println("No flights are present based on the given criteria");
        }

        else
        {
            for(Flight flight:resultFlights)
            {
                Carrier carrier = findCarrierById(flight.getCarrierId());
                FlightBooking flightBooking = getFlightBookingDetailsByFlightId(flight.getFlightId());
                System.out.println("Flight Id: "+flight.getFlightId());
                System.out.println("Carrier Name: "+carrier.getCarrierName());
                System.out.println("Origin: "+flight.getOrigin());
                System.out.println("Destination: "+flight.getDestination());
                System.out.println("Air Fare:"+flight.getAirFare());
                System.out.println("Date of Journey: "+flightBooking.getDateOfTravel());
            }
        }
    }

    public static List<Flight> getFlightsBasedonOriginDestinationAndDateofTravel(String origin, String destination, LocalDate dateofTravel) throws SQLException {
        List<Flight> flightList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        try
        {
            conn = DatabaseConnection.getConnection();
            String query = "SELECT flight.flight_id,flight.carrier_id,flight.origin,flight.destination,flight.airfare,flight_booking.date_of_travel " +
                    "FROM flight " +
                    "INNER JOIN flight_booking ON flight.flight_id=flight_booking.flight_id " +
                    "WHERE flight.origin=? AND flight.destination=? AND flight_booking.date_of_travel=?";

            psmt = conn.prepareStatement(query);
            psmt.setString(1,origin);
            psmt.setString(2,destination);
            psmt.setDate(3,Date.valueOf(dateofTravel));

            rs = psmt.executeQuery();

            while (rs.next())
            {
                Flight flight = new Flight();
                flight.setFlightId(rs.getInt("flight_id"));
                flight.setCarrierId(rs.getInt("carrier_id"));
                flight.setOrigin(rs.getString("origin"));
                flight.setDestination(rs.getString("destination"));
                flight.setAirFare(rs.getInt("airfare"));

                FlightBooking flightBooking = new FlightBooking();
                flightBooking.setFlightId(rs.getInt("flight_id"));
                flightBooking.setDateOfTravel(rs.getDate("date_of_travel").toLocalDate());

                flightList.add(flight);
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

        return flightList;

    }


    public static void bookFlight() throws SQLException
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the user id");
        int userId = sc.nextInt();

        System.out.println("Enter the flight id");
        int flightId = sc.nextInt();

        System.out.println("Enter the no of seats");
        int numberOfSeats = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the seat category");
        String seatCategory = sc.nextLine();

        System.out.println("Enter the date of travel (yyyy-mm-dd)");
        String dateofTravelStr = sc.nextLine();
        LocalDate dateOfTravel = LocalDate.parse(dateofTravelStr);

        Flight flight = findFlightById(flightId);
        User user = findUserById(userId);

        if (flight == null) {
            System.out.println("No Flight is present for the given id " + flightId);
            return;
        }

        if (user == null) {
            System.out.println("User not found for the given user id");
            return;
        }

        int availableSeats = flight.getAvailableSeats(seatCategory);

        if (availableSeats < numberOfSeats) {
            System.out.printf("No seats available under \"%s\" category for booking. Please try searching in another seat category or search for another flight available on this route.%n", seatCategory);
            return;
        }

        int bookingAmount = calculateBookingAmount(user, numberOfSeats, seatCategory, flight.getAirFare(), dateOfTravel);

        try
        {
            Connection conn = DatabaseConnection.getConnection();
            String query = "INSERT INTO flight_booking(flight_id,user_id,no_of_seats,seat_category,date_of_travel,booking_status,booking_amount) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement psmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            psmt.setInt(1,flightId);
            psmt.setInt(2,userId);
            psmt.setInt(3,numberOfSeats);
            psmt.setString(4,seatCategory);
            psmt.setDate(5,Date.valueOf(dateOfTravel));
            psmt.setString(6,"Booked");
            psmt.setInt(7,bookingAmount);

            int affectedRows = psmt.executeUpdate();

            if(affectedRows>0)
            {
                try(ResultSet rs = psmt.getGeneratedKeys())
                {
                    if(rs.next())
                    {
                        int bookingId = rs.getInt(1);
                        System.out.printf("Booking successful! Booking ID: %d, Amount: %d%n", bookingId, bookingAmount);
                    }
                }
            }

            String updateFlight = "";
            switch (seatCategory.toLowerCase()) {
                case "economy":
                    updateFlight = "UPDATE flight SET seat_capacity_economy_class = seat_capacity_economy_class - ? WHERE flight_id = ?";
                    break;
                case "business":
                    updateFlight = "UPDATE flight SET seat_capacity_business_class = seat_capacity_business_class - ? WHERE flight_id = ?";
                    break;
                case "executive":
                    updateFlight = "UPDATE flight SET seat_capacity_executive_class = seat_capacity_executive_class - ? WHERE flight_id = ?";
                    break;
            }
            try
            {
                PreparedStatement updatePsmt = conn.prepareStatement(updateFlight);
                updatePsmt.setInt(1,numberOfSeats);
                updatePsmt.setInt(2,flightId);
                updatePsmt.executeUpdate();
            } catch (SQLException e) {
               e.printStackTrace();
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
    }


    public static int calculateBookingAmount(User user, int numberOfSeats, String seatCategory, int airFare, LocalDate dateOfTravel) {
        int ratePerSeat = 0;

        switch (seatCategory.toLowerCase()) {
            case "economy":
                ratePerSeat = airFare;
                break;
            case "business":
                ratePerSeat = airFare * 2;
                break;
            case "executive":
                ratePerSeat = airFare * 5;
                break;
        }

        int totalAmount = numberOfSeats * ratePerSeat;

        long numberOfDaysBeforeTravel = ChronoUnit.DAYS.between(LocalDate.now(), dateOfTravel);

        if (numberOfDaysBeforeTravel >= 90) {
            totalAmount *= 0.95;
        } else if (numberOfDaysBeforeTravel >= 60) {
            totalAmount *= 0.97;
        } else if (numberOfDaysBeforeTravel >= 30) {
            totalAmount *= 0.98;
        }

        if (numberOfSeats >= 10) {
            totalAmount *= 0.98;
        }

        switch (user.getUserCategory().toLowerCase()) {
            case "silver":
                totalAmount *= 0.99;
                break;
            case "gold":
                totalAmount *= 0.98;
                break;
            case "platinum":
                totalAmount *= 0.96;
                break;
        }

        return (int) totalAmount;
    }

    public static void calculateRefundAmountForUser() throws SQLException
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the booking Id");
        int bookingId = sc.nextInt();
        sc.nextLine();

        FlightBooking flightBooking = getFlightBookingsBasedOnBookingId(bookingId);

        double refundAmount = 0.0;


        if (flightBooking != null) {
            LocalDate currentDate = LocalDate.now();
            long daysDifference = ChronoUnit.DAYS.between(currentDate, flightBooking.getDateOfTravel());

            if (daysDifference > 20) {
                refundAmount += flightBooking.getBookingAmount() * 0.95;
            } else if (daysDifference >= 10) {
                refundAmount += flightBooking.getBookingAmount() * 0.70;
            } else if (daysDifference >= 2) {
                refundAmount += flightBooking.getBookingAmount() * 0.40;
            } else {
                refundAmount += flightBooking.getBookingAmount() * 0.0;
            }
        }

        System.out.printf("Refund Amount is %.2f", refundAmount);
    }





}
