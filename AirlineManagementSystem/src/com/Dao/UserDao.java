package com.Dao;

import com.Model.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

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
                        "address1,address2,city,country,zipcode,dateofBirth,user_category)" +
                        "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

                psmt = conn.prepareStatement(sql);
                psmt.setString(1,user.getUserName());
                psmt.setString(2,user.getPassword());
                psmt.setLong(3,user.getPhone());
                psmt.setString(4,user.getEmailId());
                psmt.setString(5,user.getAddress1());
                psmt.setString(6,user.getAddress2());
                psmt.setString(7,user.getCity());
                psmt.setString(8,user.getCountry());
                psmt.setLong(9,user.getZipCode());
                psmt.setDate(10, Date.valueOf(user.getDateofBirth()));
                psmt.setString(11,user.getUserCategory());

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
}
