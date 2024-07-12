import java.sql.SQLException;
import java.util.Scanner;

import static com.Dao.BookingDao.cancelBooking;
import static com.Dao.CarrierDao.*;
import static com.Dao.FlightDao.*;
import static com.Dao.UserDao.*;

public class AmsApplication
{
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin9860";

    private static final String USER_USERNAME = "user45";
    private static final String USER_PASSWORD = "user45623";


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Airline Management System Application");
        System.out.println("1. Admin Sign In");
        System.out.println("2. User Sign In");

        System.out.println("Please Enter your choice");
        int choice = sc.nextInt();

        switch (choice)
        {
            case 1:
                adminSignIn();
                break;
            case 2:
                userSignIn();
                break;
            default:
                System.out.println("Invalid Choice. Please enter correct choice... ");
        }
    }

    public static void adminSignIn() throws SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Admin Sign In");
        System.out.println("Enter username");
        String username = sc.nextLine();
        System.out.println("Enter password");
        String password = sc.nextLine();

        if(username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD))
        {
            System.out.println("Admin Sign In Success");
            displayAdminMenu(sc);
            System.out.println("\n");
        }
        else
        {
            System.out.println("Invalid username or password. Sign in failed. Please check your credentials.");
        }
    }


    public static void userSignIn() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("User Sign In");
        System.out.println("Enter your username");
        String username = sc.nextLine();
        System.out.println("Enter your password");
        String password = sc.nextLine();

        if(!(username.equals(USER_USERNAME)) && !(password.equals(USER_PASSWORD)))
        {
            System.out.println("User Sign In success");
            displayUserMenu();
            System.out.println("\n");
        }
        else
        {
            System.out.println("Invalid username or password. Sign in failed. Please check your credentials.");
        }
    }




    public static void displayAdminMenu(Scanner sc) throws SQLException, ClassNotFoundException {
        int choice;
        do
        {
            System.out.println("\n Admin Menu");
            System.out.println("1. Add Carrier Details");
            System.out.println("2. Edit Carrier Details");
            System.out.println("3. Remove Carrier Details");
            System.out.println("4. Refund Price Calculation for Cancelled flights");
            System.out.println("5. Exit");
            System.out.println("6. Add Flight Details");
            System.out.println("7. View All Flights Details");
            System.out.println("8. View Carrier Details");
            System.out.println("9. View Flight Details for the given id");
            System.out.println("10. Edit Flight Details");
            System.out.println("11. Remove Flight Details");


            System.out.println("Enter your choice");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    addCarrierDetails();
                    break;
                case 2:
                    editCarrierDetails();
                    break;
                case 3:
                    removeCarrierDetails();
                    break;
                case 4:
                    calculateTotalRefundForCancelledFlights();
                    break;
                case 5:
                    System.out.println("Exiting AMS... ");
                    break;
                case 6:
                    addFlightDetails();
                    break;
                case 7:
                    viewAllFlights();
                    break;
                case 8:
                    viewCarrierDetails();
                    break;
                case 9:
                    viewFlightDetailsById();
                    break;
                case 10:
                    editFlightDetails();
                    break;
                case 11:
                    removeFlightDetails();
                    break;

                default:
                    System.out.println("Invalid choice. Try again");
            }
        }while (choice!=5);
    }




    public static void displayUserMenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        int choice;

        do
        {
            System.out.println("\n User Menu");
            System.out.println("1. Customer Registration");
            System.out.println("2. Edit Customer Profile");
            System.out.println("3. Ticket Booking - Price Calculation");
            System.out.println("4. Ticket Booking - Refund Price Calculation");
            System.out.println("5. Exit");
            System.out.println("6. Search Flights");
            System.out.println("7. View Bookings");
            System.out.println("8. Cancel Booking");


            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    userRegistration();
                    break;
                case 2:
                    updateUser();
                    break;
                case 3:
                    bookFlight();
                    break;
                case 4:
                    calculateRefundAmountForUser();
                    break;
                case 5:
                    System.out.println("Exiting AMS ...........");
                    break;
                case 6:
                    searchFlightsBasedOnOriginDestinationAndDateofTravel();
                    break;
                case 7:
                    viewMyBookings();
                    break;
                case 8:
                    cancelBooking();
                    break;
                default:
                    System.out.println("Invalid choice. Try again");
            }
        } while (choice!=5);
    }

}

