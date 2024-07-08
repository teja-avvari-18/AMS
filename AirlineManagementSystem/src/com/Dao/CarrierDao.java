package com.Dao;

import com.Model.Carrier;

import java.sql.*;
import java.util.Scanner;

public class CarrierDao
{

    public static void addCarrierDetails() throws SQLException
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

        Carrier carrier = new Carrier(carrierName, discountPercentageThirtyDaysAdvanceBooking, discountPercentageSixtyDaysAdvanceBooking, discountPercentageNinetyDaysAdvanceBooking, bulkBookingDiscount, refundPercentageForTicketCancellation2DaysBeforeTravelDate, refundPercentageForTicketCancellation10DaysBeforeTravelDate, refundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate, silverUserDiscount, goldUserDiscount, platinumUserDiscount);

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
                carrier.getPlatinumUserDiscount() < 0) {
            System.out.println("Encountered issue while saving carrier information. Please Check the data and try again");
        }
        else
        {
            PreparedStatement psmt = null;
            Connection conn = null;
            try
            {
                conn = DatabaseConnection.getConnection();
                String sql = "INSERT INTO carrier (carrier_name, discount_percentage_thirtyDaysAdvanceBooking, discount_percentage_sixtyDaysAdvanceBooking, discount_percentage_ninteyDaysAdvanceBooking, " +
                        "bulk_booking_discount, refund_percentage_for_ticketCancellation_2DaysBeforeTravelDate, refund_percentage_for_ticketCancellation_10DaysBeforeTravelDate , refund_percentage_for_ticketCancellation_20DaysBeforeTravelDate, silver_user_discount, gold_user_discount, platinum_user_discount) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, carrier.getCarrierName());
                psmt.setInt(2, carrier.getDiscountPercentageThirtyDaysAdvanceBooking());
                psmt.setInt(3, carrier.getDiscountPercentageSixtyDaysAdvanceBooking());
                psmt.setInt(4, carrier.getDiscountPercentageNinetyDaysAdvanceBooking());
                psmt.setInt(5, carrier.getBulkBookingDiscount());
                psmt.setInt(6, carrier.getRefundPercentageForTicketCancellation2DaysBeforeTravelDate());
                psmt.setInt(7, carrier.getRefundPercentageForTicketCancellation10DaysBeforeTravelDate());
                psmt.setInt(8, carrier.getRefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate());
                psmt.setInt(9, carrier.getSilverUserDiscount());
                psmt.setInt(10, carrier.getGoldUserDiscount());
                psmt.setInt(11, carrier.getPlatinumUserDiscount());

                int rowsAffected = psmt.executeUpdate();
                if (rowsAffected > 0)
                {
                    System.out.println("Carrier Details are saved successfully.");
                }
                else
                {
                    System.out.println("Carrier Information is not saved. Please check the data and try again.");
                }
            }
            catch (SQLException | ClassNotFoundException e)
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



    public static void editCarrierDetails() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the carrier id ");
        int carrierId = sc.nextInt();
        sc.nextLine();

        Carrier carrier = findCarrierById(carrierId);

        if (carrier == null) {
            System.out.println("There is no carrier present with the carrier Id " + carrierId);
            return;
        }

        System.out.println("Edit carrier Details");

        System.out.println("Enter new carrier name (leave blank to keep current) ");
        String carrierName = sc.nextLine();

        if (!carrierName.isEmpty()) {
            carrier.setCarrierName(carrierName);
        }

        System.out.println("Enter new carrier Discount Percentage Thirty Days Advance Booking  (leave blank to keep current)");
        String discountPercentageThirtyDaysAdvanceBooking = sc.nextLine();

        if (!discountPercentageThirtyDaysAdvanceBooking.isEmpty()) {
            carrier.setDiscountPercentageThirtyDaysAdvanceBooking(Integer.parseInt(discountPercentageThirtyDaysAdvanceBooking));
        }

        System.out.println("Enter new carrier Discount Percentage Sixty Days Advance Booking  (leave blank to keep current)");
        String discountPercentageSixtyDaysAdvanceBooking = sc.nextLine();

        if (!discountPercentageSixtyDaysAdvanceBooking.isEmpty()) {
            carrier.setDiscountPercentageSixtyDaysAdvanceBooking(Integer.parseInt(discountPercentageSixtyDaysAdvanceBooking));
        }

        System.out.println("Enter new carrier Discount Percentage Ninety Days Advance Booking  (leave blank to keep current)");
        String discountPercentageNinetyDaysAdvanceBooking = sc.nextLine();

        if (!discountPercentageNinetyDaysAdvanceBooking.isEmpty()) {
            carrier.setDiscountPercentageNinetyDaysAdvanceBooking(Integer.parseInt(discountPercentageNinetyDaysAdvanceBooking));
        }

        System.out.println("Enter new Bulk Booking Discount (leave blank to keep current) ");
        String bulkBookingDiscount = sc.nextLine();

        if (!bulkBookingDiscount.isEmpty()) {
            carrier.setBulkBookingDiscount(Integer.parseInt(bulkBookingDiscount));
        }

        System.out.println("Enter Refund Percentage For Ticket Cancellation 2 Days Before Travel Date (leave blank to keep current)");
        String refundPercentageForTicketCancellation2DaysBeforeTravelDate = sc.nextLine();

        if (!refundPercentageForTicketCancellation2DaysBeforeTravelDate.isEmpty()) {
            carrier.setRefundPercentageForTicketCancellation2DaysBeforeTravelDate(Integer.parseInt(refundPercentageForTicketCancellation2DaysBeforeTravelDate));
        }

        System.out.println("Enter Refund Percentage For Ticket Cancellation 10 Days Before Travel Date (leave blank to keep current)");
        String refundPercentageForTicketCancellation10DaysBeforeTravelDate = sc.nextLine();

        if (!refundPercentageForTicketCancellation10DaysBeforeTravelDate.isEmpty()) {
            carrier.setRefundPercentageForTicketCancellation10DaysBeforeTravelDate(Integer.parseInt(refundPercentageForTicketCancellation10DaysBeforeTravelDate));
        }

        System.out.println("Enter Refund Percentage For Ticket Cancellation 20 Days or More Before Travel Date (leave blank to keep current)");
        String refundPercentageForTicketCancellation20DaysorMoreBeforeTravelDate = sc.nextLine();

        if (!refundPercentageForTicketCancellation20DaysorMoreBeforeTravelDate.isEmpty()) {
            carrier.setRefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate(Integer.parseInt(refundPercentageForTicketCancellation20DaysorMoreBeforeTravelDate));
        }

        System.out.println("Enter Silver User Discount (leave blank to keep current)");
        String silverUserDiscount = sc.nextLine();

        if (!silverUserDiscount.isEmpty()) {
            carrier.setSilverUserDiscount(Integer.parseInt(silverUserDiscount));
        }

        System.out.println("Enter Gold User Discount (leave blank to keep current)");
        String goldUserDiscount = sc.nextLine();

        if (!goldUserDiscount.isEmpty()) {
            carrier.setGoldUserDiscount(Integer.parseInt(goldUserDiscount));
        }

        System.out.println("Enter Platinum User Discount (leave blank to keep current)");
        String platinumUserDiscount = sc.nextLine();

        if (!platinumUserDiscount.isEmpty()) {
            carrier.setPlatinumUserDiscount(Integer.parseInt(platinumUserDiscount));
        }

        Connection conn = null;
        PreparedStatement psmt = null;

        try {
            conn = DatabaseConnection.getConnection();

            String query = "UPDATE carrier SET carrier_name=?,discount_percentage_thirtyDaysAdvanceBooking = ?, discount_percentage_sixtyDaysAdvanceBooking = ?, " +
                    "discount_percentage_ninetyDaysAdvanceBooking = ?, bulk_booking_discount = ?, refund_percentage_for_ticketCancellation_2DaysBeforeTravelDate = ?, " +
                    "refund_percentage_for_ticketCancellation_10DaysBeforeTravelDate = ?, " +
                    "refund_percentage_for_ticketCancellation_20DaysBeforeTravelDate = ?, silver_user_discount = ?, gold_user_discount = ?, " +
                    "platinum_user_discount = ? WHERE carrier_id = ?";
            psmt = conn.prepareStatement(query);

            psmt.setString(1, carrier.getCarrierName());
            psmt.setInt(2, carrier.getDiscountPercentageThirtyDaysAdvanceBooking());
            psmt.setInt(3, carrier.getDiscountPercentageSixtyDaysAdvanceBooking());
            psmt.setInt(4, carrier.getDiscountPercentageNinetyDaysAdvanceBooking());
            psmt.setInt(5, carrier.getBulkBookingDiscount());
            psmt.setInt(6, carrier.getRefundPercentageForTicketCancellation2DaysBeforeTravelDate());
            psmt.setInt(7, carrier.getRefundPercentageForTicketCancellation10DaysBeforeTravelDate());
            psmt.setInt(8, carrier.getRefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate());
            psmt.setInt(9, carrier.getSilverUserDiscount());
            psmt.setInt(10, carrier.getGoldUserDiscount());
            psmt.setInt(11, carrier.getPlatinumUserDiscount());
            psmt.setInt(12, carrierId);

            int result = psmt.executeUpdate();

            if (result > 0) {
                System.out.println("Carrier details are updated successfully");
            } else {
                System.out.println("Either the data is incorrect or no carrier information is available for the given carrier ID");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (psmt != null) {
                psmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }



    public static Carrier findCarrierById(int carrierId) throws SQLException
    {
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Carrier carrier = null;

        try
        {
            conn = DatabaseConnection.getConnection();
            String query = "SELECT * FROM carrier WHERE carrier_id = ?";
            psmt = conn.prepareStatement(query);
            psmt.setInt(1,carrierId);

            rs = psmt.executeQuery();

            if(rs.next())
            {
                carrier = new Carrier(rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(9),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(10),rs.getInt(11),rs.getInt(12));
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

        return carrier;

    }


    public static void getAllCarriersDetails() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try
        {
            conn = DatabaseConnection.getConnection();
            String query = "SELECT * FROM carrier";

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next())
            {
                System.out.println("Carrier Id: "+rs.getInt(1));
                System.out.println("Carrier Name: "+rs.getString(2));
                System.out.println("Discount Percentage Thirty Days AdvanceBooking: "+rs.getInt(3));
                System.out.println("Discount Percentage Sixty Days AdvanceBooking: "+rs.getInt(4));
                System.out.println("Discount Percentage Ninety Days AdvanceBooking: "+rs.getInt(5));
                System.out.println("Refund Percentage For Ticket Cancellation 2 Days Before Travel Date: "+rs.getInt(6));
                System.out.println("Refund Percentage For Ticket Cancellation 10 Days Before Travel Date: "+rs.getInt(7));
                System.out.println("Refund Percentage For Ticket Cancellation 20 or more Days Before Travel Date: "+rs.getInt(8));
                System.out.println("Bulk Booking Discount: "+rs.getInt(9));
                System.out.println("Silver User Discount: "+rs.getInt(10));
                System.out.println("Gold User Discount: "+rs.getInt(11));
                System.out.println("Platinum User Discount: "+rs.getInt(12));

            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }

        finally
        {
            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }

    }


    public static void viewCarrierDetails() throws SQLException
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the carrier Id ");
        int carrierId = sc.nextInt();
        sc.nextLine();

        try
        {
            Carrier carrier = findCarrierById(carrierId);

            if(carrier==null)
            {
                System.out.println("Either the data is incorrect or no Carrier Information is available for the given Carrier ID "+carrierId);
                return;
            }

            System.out.println("Carrier Details");
            System.out.println("Carrier Id: "+carrierId);
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
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }



}
