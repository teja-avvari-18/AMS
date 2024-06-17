import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AmsApplication
{
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin9860";

    private static final String USER_USERNAME = "user45";
    private static final String USER_PASSWORD = "user45623";

    static List<User> users = new ArrayList<>();
    static List<Carrier> carriers = new ArrayList<>();
    static List<Flight> flights = new ArrayList<>();
    static List<FlightSchedule> flightSchedules = new ArrayList<>();
    static List<FlightBooking> flightBookings = new ArrayList<>();


    public static void main(String[] args)
    {
        flights.add(new Flight(2,"Chennai","Mumbai",5000,150,200,50));
        flights.add(new Flight(3,"Chennai","Delhi",5000,150,200,50));
        flights.add(new Flight(3,"Mumbai","Delhi",5000,150,200,50));
        flights.add(new Flight(2,"Chennai","Mumbai",5000,150,200,50));
        flights.add(new Flight(2,"Mumbai","Delhi",5000,150,200,50));
        flights.add(new Flight(3,"Chennai","Delhi",5000,150,200,50));





        users.add(new User("Teja","raj@4698",7794096189L,"teja@gmail.com","Near Post Office","Bukkaraya Samudram","Anantapur","Andhra Pradesh","India",515701L,LocalDate.of(2001,07,18),"Gold"));
        users.add(new User("Ajith","ajith@892",9559092849L,"ajith42@gmail.com","Tapovanam","Bellary Bypass Road","Anantapur","Andhra Pradesh","India",5150002L,LocalDate.of(2001,12,22),"Silver"));
        users.add(new User("Mahesh","mahesh@11",9843239999L,"mahesh23@gmail.com","Near Old SBI","Mandapalli","Mancherial","Telangana","India",300231L,LocalDate.of(2002,06,18),"Platinum"));



        carriers.add(new Carrier("Vistara",10,20,30,30,5,10,20,5,10,15));
        carriers.add(new Carrier("Indigo",5,10,15,20,2,5,10,5,10,20));
        carriers.add(new Carrier("Air India",1,2,3,5,1,2,3,5,6,7));

        flightBookings.add(new FlightBooking(1,1,5,"Economy",LocalDate.of(2024,06,30),"Booked",30000));
        flightBookings.add(new FlightBooking(2,2,1,"Business",LocalDate.of(2024,07,30),"Booked",5000));
        flightBookings.add(new FlightBooking(2,3,4,"Economy",LocalDate.of(2024,07,30),"Cancelled",20000));
        flightBookings.add(new FlightBooking(1,2,2,"Executive",LocalDate.of(2024,06,22),"Cancelled",10000));
        flightBookings.add(new FlightBooking(2,2,4,"Economy",LocalDate.of(2024,07,30),"Cancelled",20000));
        flightBookings.add(new FlightBooking(2,2,4,"Economy",LocalDate.of(2024,07,30),"Cancelled",20000));
        flightBookings.add(new FlightBooking(6,3,1,"Business",LocalDate.of(2024,07,30),"Booked",5000));

        flightSchedules.add(new FlightSchedule(1,2,LocalDate.of(2024,07,30),100,100,100));
        flightSchedules.add(new FlightSchedule(2,1,LocalDate.of(2024,06,22),200,200,20));



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

    public static void adminSignIn()
    {
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


    public static void userSignIn()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("User Sign In");
        System.out.println("Enter your username");
        String username = sc.nextLine();
        System.out.println("Enter your password");
        String password = sc.nextLine();

        if(!(username.equals(USER_USERNAME)) && !(password.equals(USER_PASSWORD)))
        {
            System.out.println("User Sign In success");
            displayUserMenu(1);
            System.out.println("\n");
        }
        else
        {
            System.out.println("Invalid username or password. Sign in failed. Please check your credentials.");
        }
    }


    public static void displayAdminMenu(Scanner sc)
    {
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
        } while (choice!=5);
    }


    public static void displayUserMenu(int userId)
    {
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




    public static void userRegistration()
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

        User user = new User(userName,password,phone,emailId,address1,address2,city,state,country,zipCode,dateofBirth);


        users.add(user);

        System.out.println("\n");
        System.out.println("Customer Registered Successfully");

    }

    public static void addCarrierDetails()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Add Carrier Details");


        System.out.println("Enter carrier Name");
        String carrierName = sc.nextLine();

        System.out.println("Enter Discount Percentage For Thirty Days Advance Booking");
        int discountPercentageThirtyDaysAdvanceBooking = sc.nextInt();

        System.out.println("Enter Discount Percentage For Sixty Days Advance Booking");
        int discountPercentageSixtyDaysAdvanceBooking = sc.nextInt();

        System.out.println("Enter Discount Percentage For Ninety Days Advance Booking");
        int discountPercentageNinetyDaysAdvanceBooking = sc.nextInt();

        System.out.println("Enter Bulk Booking Discount");
        int bulkBookingDiscount = sc.nextInt();

        System.out.println("Enter Refund Percentage For Ticket Cancellation 2 Days Before Travel Date");
        int refundPercentageForTicketCancellation2DaysBeforeTravelDate = sc.nextInt();

        System.out.println("Enter Refund Percentage For Ticket Cancellation 10 Days Before Travel Date");
        int refundPercentageForTicketCancellation10DaysBeforeTravelDate = sc.nextInt();

        System.out.println("Enter Refund Percentage For Ticket Cancellation 20 Days or More Before Travel Date");
        int refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate = sc.nextInt();

        System.out.println("Enter Silver User Discount");
        int silverUserDiscount = sc.nextInt();

        System.out.println("Enter Gold User Discount");
        int goldUserDiscount = sc.nextInt();

        System.out.println("Enter Platinum User Discount");
        int platinumUserDiscount = sc.nextInt();

        Carrier carrier = new Carrier(carrierName,discountPercentageThirtyDaysAdvanceBooking,discountPercentageSixtyDaysAdvanceBooking,discountPercentageNinetyDaysAdvanceBooking,bulkBookingDiscount,refundPercentageForTicketCancellation2DaysBeforeTravelDate,refundPercentageForTicketCancellation10DaysBeforeTravelDate,refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate,silverUserDiscount,goldUserDiscount,platinumUserDiscount);

        if (carrier.getCarrierName() == null ||
                carrier.getDiscountPercentageThirtyDaysAdvanceBooking() < 0 ||
                carrier.getDiscountPercentageSixtyDaysAdvanceBooking() < 0 ||
                carrier.getDiscountPercentageNinetyDaysAdvanceBooking() < 0 ||
                carrier.getBulkBookingDiscount() < 0 ||
                carrier.getRefundPercentageForTicketCancellation2DaysBeforeTravelDate() < 0 ||
                carrier.getRefundPercentageForTicketCancellation10DaysBeforeTravelDate() < 0 ||
                carrier.getRefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate() < 0 ||
                carrier.getSilverUserDiscount() < 0 ||
                carrier.getGoldUserDiscount() < 0 ||
                carrier.getPlatinumUserDiscount() < 0)
        {
            System.out.println("Encountered issue while saving carrier information. Please Check the data and try again");
        }

        else
        {
            carriers.add(carrier);
            System.out.println("Carrier Information Saved Successfully in the System.");
        }

    }

    public static void addFlightDetails()
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
            flights.add(flight);
            System.out.println("Flight information saved successfully in the system");
            System.out.println(flight);
        }

    }

    public static void viewAllFlights()
    {
        if(flights.isEmpty())
        {
            System.out.println("No flights are present");
        }

        else
        {
            for(Flight flight:flights)
            {
                System.out.println("Flight Id: "+flight.getFlightId());
                System.out.println("Carrier Id: "+flight.getCarrierId());
                System.out.println("Origin: "+flight.getOrigin());
                System.out.println("Destination: "+flight.getDestination());
                System.out.println("Air Fare: "+flight.getAirFare());
                System.out.println("Seat Capacity Business Class: "+flight.getSeatCapacityBusinessClass());
                System.out.println("Seat Capacity Economy Class: "+flight.getSeatCapacityEconomyClass());
                System.out.println("Seat Capacity Executive Class: "+flight.getSeatCapacityExecutiveClass());
            }
        }
    }

    public static User findUserById(int userId)
    {
        for(User user:users)
        {
            if(user.getUserId()==userId)
            {
                return user;
            }
        }

        return null;
    }

    public static void updateUser()
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

        System.out.println("User Profile updated successfully");
        System.out.println(user);

    }

    public static Carrier findCarrierById(int carrierId)
    {
        for(Carrier carrier:carriers)
        {
            if(carrier.getCarrierId()==carrierId)
            {
                return carrier;
            }
        }

        return null;
    }

    public static void viewCarrierDetails()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the carrier Id ");
        int carrierId = sc.nextInt();
        sc.nextLine();

        Carrier carrier = findCarrierById(carrierId);

        if(carrier==null)
        {
            System.out.println("Either the data is incorrect or no Carrier Information is available for the given Carrier ID "+carrierId);
            return;
        }

        System.out.println("Carrier Details");
        System.out.println("Carrier Id: "+carrier.getCarrierId());
        System.out.println("Carrier Name: "+carrier.getCarrierName());
        System.out.println("Discount Percentage Thirty Days Advance Booking: "+carrier.getDiscountPercentageThirtyDaysAdvanceBooking());
        System.out.println("Discount Percentage Sixty Days Advance Booking: "+carrier.getDiscountPercentageSixtyDaysAdvanceBooking());
        System.out.println("Discount Percentage Ninety Days Advance Booking: "+carrier.getDiscountPercentageNinetyDaysAdvanceBooking());
        System.out.println("Bulk Booking Discount: "+carrier.getBulkBookingDiscount());
        System.out.println("Refund Percentage For Ticket Cancellation 2 Days Before Travel Date: "+carrier.getRefundPercentageForTicketCancellation2DaysBeforeTravelDate());
        System.out.println("Refund Percentage For Ticket Cancellation 10 Days Before Travel Date: "+carrier.getRefundPercentageForTicketCancellation10DaysBeforeTravelDate());
        System.out.println("Refund Percentage For Ticket Cancellation 20 Days or More Before Travel Date: "+carrier.getRefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate());
        System.out.println("Silver User Discount: "+carrier.getSilverUserDiscount());
        System.out.println("Gold User Discount: "+carrier.getGoldUserDiscount());
        System.out.println("Platinum User Discount: "+carrier.getPlatinumUserDiscount());

    }

    public static void editCarrierDetails()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the carrier id ");
        int carrierId = sc.nextInt();
        sc.nextLine();

        Carrier carrier = findCarrierById(carrierId);

        if(carrier==null)
        {
            System.out.println("There is no carrier present with the carrier Id "+carrierId);
            return;
        }

        System.out.println("Edit carrier Details");

        System.out.println("Enter new carrier name (leave blank to keep current) ");
        String carrierName = sc.nextLine();

        if(!carrierName.isEmpty())
        {
            carrier.setCarrierName(carrierName);
        }

        System.out.println("Enter new carrier Discount Percentage Thirty Days Advance Booking  (leave blank to keep current)");
        String discountPercentageThirtyDaysAdvanceBooking = sc.nextLine();

        if(!discountPercentageThirtyDaysAdvanceBooking.isEmpty())
        {
            carrier.setDiscountPercentageThirtyDaysAdvanceBooking(Integer.parseInt(discountPercentageThirtyDaysAdvanceBooking));
        }

        System.out.println("Enter new carrier Discount Percentage Sixty Days Advance Booking  (leave blank to keep current)");
        String discountPercentageSixtyDaysAdvanceBooking = sc.nextLine();

        if(!discountPercentageSixtyDaysAdvanceBooking.isEmpty())
        {
            carrier.setDiscountPercentageSixtyDaysAdvanceBooking(Integer.parseInt(discountPercentageSixtyDaysAdvanceBooking));
        }

        System.out.println("Enter new carrier Discount Percentage Ninety Days Advance Booking  (leave blank to keep current)");
        String discountPercentageNinetyDaysAdvanceBooking = sc.nextLine();

        if(!discountPercentageNinetyDaysAdvanceBooking.isEmpty())
        {
            carrier.setDiscountPercentageNinetyDaysAdvanceBooking(Integer.parseInt(discountPercentageNinetyDaysAdvanceBooking));
        }

        System.out.println("Enter new Bulk Booking Discount (leave blank to keep current) ");
        String bulkBookingDiscount = sc.nextLine();

        if(!bulkBookingDiscount.isEmpty())
        {
            carrier.setBulkBookingDiscount(Integer.parseInt(bulkBookingDiscount));
        }

        System.out.println("Enter Refund Percentage For Ticket Cancellation 2 Days Before Travel Date (leave blank to keep current)");
        String refundPercentageForTicketCancellation2DaysBeforeTravelDate = sc.nextLine();

        if(!refundPercentageForTicketCancellation2DaysBeforeTravelDate.isEmpty())
        {
            carrier.setRefundPercentageForTicketCancellation2DaysBeforeTravelDate(Integer.parseInt(refundPercentageForTicketCancellation2DaysBeforeTravelDate));
        }

        System.out.println("Enter Refund Percentage For Ticket Cancellation 10 Days Before Travel Date (leave blank to keep current)");
        String refundPercentageForTicketCancellation10DaysBeforeTravelDate = sc.nextLine();

        if(!refundPercentageForTicketCancellation10DaysBeforeTravelDate.isEmpty())
        {
            carrier.setRefundPercentageForTicketCancellation10DaysBeforeTravelDate(Integer.parseInt(refundPercentageForTicketCancellation10DaysBeforeTravelDate));
        }

        System.out.println("Enter Refund Percentage For Ticket Cancellation 20 Days or More Before Travel Date (leave blank to keep current)");
        String refundPercentageForTicketCancellation20DaysorMoreBeforeTravelDate = sc.nextLine();

        if(!refundPercentageForTicketCancellation20DaysorMoreBeforeTravelDate.isEmpty())
        {
            carrier.setRefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate(Integer.parseInt(refundPercentageForTicketCancellation20DaysorMoreBeforeTravelDate));
        }

        System.out.println("Enter Silver User Discount (leave blank to keep current)");
        String silverUserDiscount = sc.nextLine();

        if(!silverUserDiscount.isEmpty())
        {
            carrier.setSilverUserDiscount(Integer.parseInt(silverUserDiscount));
        }

        System.out.println("Enter Gold User Discount (leave blank to keep current)");
        String goldUserDiscount = sc.nextLine();

        if(!goldUserDiscount.isEmpty())
        {
            carrier.setGoldUserDiscount(Integer.parseInt(goldUserDiscount));
        }

        System.out.println("Enter Platinum User Discount (leave blank to keep current)");
        String platinumUserDiscount = sc.nextLine();

        if(!platinumUserDiscount.isEmpty())
        {
            carrier.setPlatinumUserDiscount(Integer.parseInt(platinumUserDiscount));
        }

        System.out.println("Carrier Details Updated successfully");
        System.out.println(carrier);
    }


    public static void removeCarrierDetails()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the carried Id");
        int carrierId = sc.nextInt();
        sc.nextLine();

        Carrier carrier = findCarrierById(carrierId);

        if(carrier==null)
        {
            System.out.println("Either the data is incorrect or no carrier information is available for the given carrier id "+carrierId);
        }

        else {
            boolean hasMappedFlights = false;

            for(Flight flight:flights)
            {
                if(flight.getCarrierId()==carrierId)
                {
                    hasMappedFlights = true;
                    break;
                }
            }

            if(hasMappedFlights)
            {
                System.out.println("Remove all flights mapped to this carrier before deleting this carrier from the system");
            }
            else
            {
                System.out.println("Carrier information successfully removed from system");
            }
        }
    }

    public static void   calculateRefundAmountForUser()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the booking Id ");
        int bookingId = sc.nextInt();
        sc.nextLine();

        FlightBooking flightBooking = getFlightBookingDetailsById(bookingId);

        double refundAmount = 0.0;



        if(flightBooking!=null)
        {
            LocalDate currentDate = LocalDate.now();
            long daysDifference = ChronoUnit.DAYS.between(currentDate,flightBooking.getDateOfTravel());

            if(daysDifference>20)
            {
                refundAmount+=flightBooking.getBookingAmount()*0.95;
            }
            else if (daysDifference>=10)
            {
                refundAmount+=flightBooking.getBookingAmount()*0.70;
            }
            else if (daysDifference>=2)
            {
                refundAmount+= flightBooking.getBookingAmount()*0.40;
            }
            else
            {
                refundAmount += flightBooking.getBookingAmount()*0.0;
            }
        }

        System.out.printf("Refund Amount is %.2f",refundAmount);


    }


    public static FlightBooking getFlightBookingDetailsById(int bookingId)
    {
        for(FlightBooking flightBooking:flightBookings)
        {
            if(flightBooking.getBookingId()==bookingId)
            {
                return flightBooking;
            }
        }

        return null;
    }

    public static void calculateTotalRefundForCancelledFlights()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the flight Id");
        int flightId = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the travel date (yyyy-mm-dd)");
        String travelDate = sc.nextLine();
        LocalDate travellingDate = LocalDate.parse(travelDate);

        List<FlightBooking> flightBookingList = getFlightBookingDetailsByIdAndTravelDate(flightId,travellingDate);

        double totalRefund = 0.0;

        for(FlightBooking booking:flightBookingList)
        {
            if(booking.getBookingStatus().equalsIgnoreCase("Cancelled"))
            {
                totalRefund+=booking.getBookingAmount();
            }

            if (ChronoUnit.DAYS.between(LocalDate.now(),travellingDate)<=7)
            {
                totalRefund+=booking.getBookingAmount()*0.10;
            }
        }

        System.out.printf("Refund Amount is %.2f",totalRefund);
    }

    public static List<FlightBooking> getFlightBookingDetailsByIdAndTravelDate(int flightId, LocalDate travelDate) {
        List<FlightBooking> flightBookingList = new ArrayList<>();

        for (FlightBooking flightBooking : flightBookings) {
            if (flightBooking.getFlightId() == flightId && flightBooking.getDateOfTravel().equals(travelDate)) {
                flightBookingList.add(flightBooking);
            }
        }
        return flightBookingList;
    }

    public static Flight getFlightById(int flightId)
    {
        for(Flight flight:flights)
        {
            if(flight.getFlightId()==flightId)
            {
                return flight;
            }
        }

        return null;
    }

    private static User getUserById(int userId)
    {
        for(User user:users)
        {
            if(user.getUserId()==userId)
            {
                return user;
            }
        }

        return null;
    }

    public static int calculateBookingAmount(User user,int numberOfSeats,String seatCategory,int airFare,LocalDate dateOfTravel)
    {
        int ratePerSeat = 0;

        switch (seatCategory.toLowerCase())
        {
            case "economy":
                ratePerSeat = airFare;
                break;
            case "business":
                ratePerSeat = airFare*2;
                break;
            case "executive":
                ratePerSeat = airFare*5;
                break;
        }

        int totalAmount = numberOfSeats*ratePerSeat;

        long numberOfDaysBeforeTravel = ChronoUnit.DAYS.between(LocalDate.now(),dateOfTravel);

        if(numberOfDaysBeforeTravel>=90)
        {
            totalAmount *= 0.95;
        }
        else if (numberOfDaysBeforeTravel >=60)
        {
            totalAmount*=0.97;
        }
        else if (numberOfDaysBeforeTravel>=30)
        {
            totalAmount*=0.98;
        }

        if(numberOfSeats>=10)
        {
            totalAmount*=0.98;
        }

        switch (user.getUserCategory().toLowerCase())
        {
            case "silver":
                totalAmount*=0.99;
                break;
            case "gold":
                totalAmount*=0.98;
                break;
            case "platinum":
                totalAmount*=0.96;
                break;

        }

        return (int) totalAmount;
    }

    public static void bookFlight()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the user id");
        int userId = sc.nextInt();

        System.out.println("Enter the flight id");
        int flightId = sc.nextInt();

        System.out.println("Enter number of seats");
        int numberOfSeats = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the seat category");
        String seatCategory = sc.nextLine();

        System.out.println("Enter the date of travel (yyyy-mm-dd) ");
        String dateofTravelStr = sc.nextLine();
        LocalDate dateOfTravel = LocalDate.parse(dateofTravelStr);

        Flight flight = getFlightById(flightId);
        User user = getUserById(userId);

        if(flight==null)
        {
            System.out.println("No Flight is present for the given id "+flightId);
            return;
        }


        if (user == null) {
            System.out.println("User not found for the given user id");
            return;
        }

        int availableSeats = flight.getAvailableSeats(seatCategory);

        if(availableSeats<numberOfSeats)
        {
            System.out.printf("No seats available under \"%s\" category for booking. Please try searching in another seat category or search for another flight available on this route.%n", seatCategory);
            return;
        }

        int bookingAmount = calculateBookingAmount(user,numberOfSeats,seatCategory,flight.getAirFare(),dateOfTravel);

        FlightBooking booking = new FlightBooking(flightId,userId,numberOfSeats,seatCategory,dateOfTravel,"Booked",bookingAmount);
        flightBookings.add(booking);
        flight.bookSeats(seatCategory,numberOfSeats);

        System.out.printf("Booking successful! Booking ID: %d, Amount: %d%n", booking.getBookingId(), bookingAmount);
    }

    public static void viewFlightDetailsById()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the flight id");
        int flightId = sc.nextInt();

        Flight flight = getFlightById(flightId);

        if(flight==null)
        {
            System.out.println("Either the data is incorrect or no flight information is available for the given flight id "+ flightId);
        }
        else
        {
            System.out.println("Flight id: "+flight.getFlightId());
            System.out.println("Carrier id: "+flight.getCarrierId());
            System.out.println("Origin: "+flight.getOrigin());
            System.out.println("Destination: "+flight.getOrigin());
            System.out.println("AirFare: "+flight.getAirFare());
            System.out.println("Seat Capacity Business Class: "+flight.getSeatCapacityBusinessClass());
            System.out.println("Seat Capacity Economy Class: "+flight.getSeatCapacityEconomyClass());
            System.out.println("Seat Capacity Executive Class: "+flight.getSeatCapacityExecutiveClass());
        }
    }

    public static void editFlightDetails()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the flight id");
        int flightId = sc.nextInt();
        sc.nextLine();

        Flight flight = getFlightById(flightId);

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

        System.out.println("Flight Details Updated Successfully");
        System.out.println(flight);

    }

    public static void removeFlightDetails()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the flight Id");
        int flightId = sc.nextInt();
        sc.nextLine();

        Flight flight = getFlightById(flightId);

        if(flight==null)
        {
            System.out.println("Either the data is incorrect or no carrier information is available for the given flight id "+flightId);
        }

        else
        {
            boolean hasBookedFlights = false;

            for(FlightBooking flightBooking:flightBookings)
            {
                if(flightBooking.getFlightId()==flightId)
                {
                    hasBookedFlights=true;
                    break;
                }
            }

            if(hasBookedFlights)
            {
                System.out.println("Flight Information can't be removed as there are Active Booking open in the System. Please attempt to remove this flight either by cancelling all open ticket  or try after serving all open bookings");
            }
            else
            {
                System.out.println("Flight Information successfully removed from the system");
            }
        }
    }

    public static List<Flight> getFlightsBasedOnOriginDestinationAndDateofTravel(String origin,String destination,LocalDate dateofTravel)
    {
        List<Flight> flightList = new ArrayList<>();
        for(Flight flight:flights)
        {
            if(flight.getOrigin().equalsIgnoreCase(origin) && flight.getDestination().equalsIgnoreCase(destination))
            {
                boolean hasBooking = false;

                for(FlightBooking flightBooking:flightBookings)
                {
                    if(flightBooking.getDateOfTravel().isEqual(dateofTravel))
                    {
                        hasBooking=true;
                        break;
                    }
                }

                if(hasBooking=true)
                {
                    flightList.add(flight);
                }
            }
        }

        return flightList;
    }

    public static void searchFlightsBasedOnOriginDestinationAndDateofTravel()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter origin");
        String origin = sc.nextLine();

        System.out.println("Enter destination");
        String destination = sc.nextLine();

        System.out.println("Enter Date of travel(yyyy-mm-dd)");
        String dateofTravelStr = sc.nextLine();
        LocalDate dateofTravel = LocalDate.parse(dateofTravelStr);

        List<Flight> resultFlights = getFlightsBasedOnOriginDestinationAndDateofTravel(origin,destination,dateofTravel);

        if(resultFlights.isEmpty())
        {
            System.out.println("No flights are present based on the given filters");
        }

        else
        {
            for(Flight flight:resultFlights)
            {
                Carrier carrier = getCarrierById(flight.getCarrierId());
                FlightBooking flightBooking = getFlightBookingDetailsByFlightId(flight.getFlightId());
                System.out.println("Flight id: "+flight.getFlightId());
                System.out.println("Carrier name: "+carrier.getCarrierName());
                System.out.println("Origin: "+flight.getOrigin());
                System.out.println("Destination: "+flight.getDestination());
                System.out.println("Air Fare: "+flight.getAirFare());
                System.out.println("Date of Journey: "+ flightBooking.getDateOfTravel());

            }
        }
    }

    private static FlightBooking getFlightBookingDetailsByFlightId(int flightId)
    {
        for(FlightBooking flightBooking:flightBookings)
        {
            if(flightBooking.getFlightId()==flightId)
            {
                return flightBooking;
            }
        }

        return null;
    }

    private static Carrier getCarrierById(int carrierId)
    {
        for(Carrier carrier:carriers)
        {
            if(carrier.getCarrierId()==carrierId)
            {
                return carrier;
            }
        }

        return null;
    }

    public static List<FlightBooking> getFlightBookingsBasedOnUserId(int userId)
    {
        List<FlightBooking> myBookings = new ArrayList<>();
        for(FlightBooking flightBooking:flightBookings)
        {
            if(flightBooking.getUserId() == userId)
            {
                myBookings.add(flightBooking);
            }
        }

        return myBookings;
    }

    public static void viewMyBookings()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter user id ");
        int userId = sc.nextInt();
        sc.nextLine();

        List<FlightBooking> myBookings = getFlightBookingsBasedOnUserId(userId);

        if(myBookings.isEmpty())
        {
            System.out.println("You don't have any bookings yet");
        }

        else
        {
            for(FlightBooking flightBooking:myBookings)
            {
                User user = getUserById(flightBooking.getUserId());

                System.out.println("Booking Id: "+flightBooking.getBookingId());
                System.out.println("Flight Id: "+flightBooking.getFlightId());
                System.out.println("User Name: "+user.getUserName());
                System.out.println("No.of seats: "+flightBooking.getNoOfSeats());
                System.out.println("Seat Category: "+flightBooking.getSeatCategory());
                System.out.println("Date of travel: "+flightBooking.getDateOfTravel());
                System.out.println("Booking Status: "+flightBooking.getBookingStatus());
                System.out.println("Booking Amount: "+flightBooking.getBookingAmount());
            }
        }
    }

    private static void cancelBooking()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the booking Id ");
        int bookingId = sc.nextInt();
        sc.nextLine();

        FlightBooking flightBooking = getFlightBookingDetailsById(bookingId);


        double refundAmount = 0.0;

        if(flightBooking==null)
        {
            System.out.println("Booking is not present for this booking id");
            return;
        }




        if(flightBooking!=null)
        {
            LocalDate currentDate = LocalDate.now();
            long daysDifference = ChronoUnit.DAYS.between(currentDate,flightBooking.getDateOfTravel());

            if(daysDifference>20)
            {
                refundAmount+=flightBooking.getBookingAmount()*0.95;
            }
            else if (daysDifference>=10)
            {
                refundAmount+=flightBooking.getBookingAmount()*0.70;
            }
            else if (daysDifference>=2)
            {
                refundAmount+= flightBooking.getBookingAmount()*0.40;
            }
            else
            {
                refundAmount += flightBooking.getBookingAmount()*0.0;
            }
        }


        if("Cancelled".equalsIgnoreCase(flightBooking.getBookingStatus()))
        {
            System.out.println("Booking is already cancelled");
            return;
        }

        flightBooking.setBookingStatus("Cancelled");

        FlightSchedule flightSchedule = getFlightScheduleByFlightAndDate(flightBooking.getFlightId(), flightBooking.getDateOfTravel());

        if(flightSchedule!=null)
        {
            switch (flightBooking.getSeatCategory().toLowerCase())
            {
                case "business":
                    flightSchedule.decrementBusinessClassBookedCount(flightBooking.getNoOfSeats());
                    break;
                case "economy":
                    flightSchedule.decrementEconomyClassBookedCount(flightBooking.getNoOfSeats());
                    break;
                case "executive":
                    flightSchedule.decrementEconomyClassBookedCount(flightBooking.getNoOfSeats());
                    break;
            }
        }



        System.out.printf("Booking cancelled. Refund Amount is %.2f",refundAmount);
    }

    public static FlightSchedule getFlightScheduleByFlightAndDate(int flightId,LocalDate dateOfTravel)
    {
        for(FlightSchedule schedule:flightSchedules)
        {
            if(schedule.getFlightId()==flightId && schedule.getDateOfTravel().isEqual(dateOfTravel))
            {
                return schedule;
            }
        }

        return null;
    }

}


class Carrier
{
    private static int carrierIdCounter = 1;
    private int carrierId;
    private String carrierName;
    private int discountPercentageThirtyDaysAdvanceBooking;
    private int discountPercentageSixtyDaysAdvanceBooking;
    private int discountPercentageNinetyDaysAdvanceBooking;
    private int bulkBookingDiscount;
    private int refundPercentageForTicketCancellation2DaysBeforeTravelDate;
    private int refundPercentageForTicketCancellation10DaysBeforeTravelDate;
    private int refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate;
    private int silverUserDiscount;
    private int  goldUserDiscount;
    private int platinumUserDiscount;

    @Override
    public String toString() {
        return "Carrier{" +
                "carrierId=" + carrierId +
                ", carrierName='" + carrierName + '\'' +
                ", discountPercentageThirtyDaysAdvanceBooking=" + discountPercentageThirtyDaysAdvanceBooking +
                ", discountPercentageSixtyDaysAdvanceBooking=" + discountPercentageSixtyDaysAdvanceBooking +
                ", discountPercentageNinetyDaysAdvanceBooking=" + discountPercentageNinetyDaysAdvanceBooking +
                ", bulkBookingDiscount=" + bulkBookingDiscount +
                ", refundPercentageForTicketCancellation2DaysBeforeTravelDate=" + refundPercentageForTicketCancellation2DaysBeforeTravelDate +
                ", refundPercentageForTicketCancellation10DaysBeforeTravelDate=" + refundPercentageForTicketCancellation10DaysBeforeTravelDate +
                ", refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate=" + refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate +
                ", silverUserDiscount=" + silverUserDiscount +
                ", goldUserDiscount=" + goldUserDiscount +
                ", platinumUserDiscount=" + platinumUserDiscount +
                '}';
    }

    public int getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(int carrierId) {
        this.carrierId = carrierId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public int getDiscountPercentageThirtyDaysAdvanceBooking() {
        return discountPercentageThirtyDaysAdvanceBooking;
    }

    public void setDiscountPercentageThirtyDaysAdvanceBooking(int discountPercentageThirtyDaysAdvanceBooking) {
        this.discountPercentageThirtyDaysAdvanceBooking = discountPercentageThirtyDaysAdvanceBooking;
    }

    public int getDiscountPercentageSixtyDaysAdvanceBooking() {
        return discountPercentageSixtyDaysAdvanceBooking;
    }

    public void setDiscountPercentageSixtyDaysAdvanceBooking(int discountPercentageSixtyDaysAdvanceBooking) {
        this.discountPercentageSixtyDaysAdvanceBooking = discountPercentageSixtyDaysAdvanceBooking;
    }

    public int getDiscountPercentageNinetyDaysAdvanceBooking() {
        return discountPercentageNinetyDaysAdvanceBooking;
    }

    public void setDiscountPercentageNinetyDaysAdvanceBooking(int discountPercentageNinetyDaysAdvanceBooking) {
        this.discountPercentageNinetyDaysAdvanceBooking = discountPercentageNinetyDaysAdvanceBooking;
    }

    public int getBulkBookingDiscount() {
        return bulkBookingDiscount;
    }

    public void setBulkBookingDiscount(int bulkBookingDiscount) {
        this.bulkBookingDiscount = bulkBookingDiscount;
    }

    public int getRefundPercentageForTicketCancellation2DaysBeforeTravelDate() {
        return refundPercentageForTicketCancellation2DaysBeforeTravelDate;
    }

    public void setRefundPercentageForTicketCancellation2DaysBeforeTravelDate(int refundPercentageForTicketCancellation2DaysBeforeTravelDate) {
        this.refundPercentageForTicketCancellation2DaysBeforeTravelDate = refundPercentageForTicketCancellation2DaysBeforeTravelDate;
    }

    public int getRefundPercentageForTicketCancellation10DaysBeforeTravelDate() {
        return refundPercentageForTicketCancellation10DaysBeforeTravelDate;
    }

    public void setRefundPercentageForTicketCancellation10DaysBeforeTravelDate(int refundPercentageForTicketCancellation10DaysBeforeTravelDate) {
        this.refundPercentageForTicketCancellation10DaysBeforeTravelDate = refundPercentageForTicketCancellation10DaysBeforeTravelDate;
    }

    public int getRefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate() {
        return refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate;
    }

    public void setRefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate(int refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate) {
        this.refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate = refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate;
    }

    public int getSilverUserDiscount() {
        return silverUserDiscount;
    }

    public void setSilverUserDiscount(int silverUserDiscount) {
        this.silverUserDiscount = silverUserDiscount;
    }

    public int getGoldUserDiscount() {
        return goldUserDiscount;
    }

    public void setGoldUserDiscount(int goldUserDiscount) {
        this.goldUserDiscount = goldUserDiscount;
    }

    public int getPlatinumUserDiscount() {
        return platinumUserDiscount;
    }

    public void setPlatinumUserDiscount(int platinumUserDiscount) {
        this.platinumUserDiscount = platinumUserDiscount;
    }

    public Carrier(String carrierName, int discountPercentageThirtyDaysAdvanceBooking, int discountPercentageSixtyDaysAdvanceBooking, int discountPercentageNinetyDaysAdvanceBooking, int bulkBookingDiscount, int refundPercentageForTicketCancellation2DaysBeforeTravelDate, int refundPercentageForTicketCancellation10DaysBeforeTravelDate, int refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate, int silverUserDiscount, int goldUserDiscount, int platinumUserDiscount)
    {
        this.carrierId = carrierIdCounter++;
        this.carrierName = carrierName;
        this.discountPercentageThirtyDaysAdvanceBooking = discountPercentageThirtyDaysAdvanceBooking;
        this.discountPercentageSixtyDaysAdvanceBooking = discountPercentageSixtyDaysAdvanceBooking;
        this.discountPercentageNinetyDaysAdvanceBooking = discountPercentageNinetyDaysAdvanceBooking;
        this.bulkBookingDiscount = bulkBookingDiscount;
        this.refundPercentageForTicketCancellation2DaysBeforeTravelDate = refundPercentageForTicketCancellation2DaysBeforeTravelDate;
        this.refundPercentageForTicketCancellation10DaysBeforeTravelDate = refundPercentageForTicketCancellation10DaysBeforeTravelDate;
        this.refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate = refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate;
        this.silverUserDiscount = silverUserDiscount;
        this.goldUserDiscount = goldUserDiscount;
        this.platinumUserDiscount = platinumUserDiscount;
    }
}

class Flight
{
    private static  int flightIdCounter = 1;
    private int flightId;
    private int carrierId;
    private String origin;
    private String destination;
    private int airFare;
    private int seatCapacityBusinessClass;
    private int seatCapacityEconomyClass;
    private int seatCapacityExecutiveClass;

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
        this.flightId = flightIdCounter++;
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
}


class User
{
    private static int userIdCounter = 1;
    private int userId;
    private String userName;
    private String password;
    private long phone;
    private String emailId;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private long zipCode;
    private LocalDate dateofBirth;
    private String role="customer";
    private String userCategory="";

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                ", emailId='" + emailId + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode=" + zipCode +
                ", dateofBirth=" + dateofBirth +
                ", role='" + role + '\'' +
                ", userCategory='" + userCategory + '\'' +
                '}';
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }


    public User( String userName, String password, long phone, String emailId, String address1, String address2, String city, String state, String country, long zipCode, LocalDate dateofBirth) {
        this.userId = userIdCounter++;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.emailId = emailId;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.dateofBirth = dateofBirth;
        this.role = "customer";
        this.userCategory = "";
    }

    public User( String userName, String password, long phone, String emailId, String address1, String address2, String city, String state, String country, long zipCode, LocalDate dateofBirth,String userCategory) {
        this.userId = userIdCounter++;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.emailId = emailId;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.dateofBirth = dateofBirth;
        this.role = "customer";
        this.userCategory = userCategory;
    }


}


class FlightSchedule
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

    public FlightSchedule(int flightScheduleId, int flightId, LocalDate dateOfTravel, int businessClassBookedCount, int economyClassBookedCount, int executiveClassBookedCount) {
        this.flightScheduleId = flightScheduleId;
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
}


class  FlightBooking
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
}