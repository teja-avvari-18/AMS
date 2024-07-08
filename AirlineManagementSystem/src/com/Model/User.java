package com.Model;


import java.time.LocalDate;

public class User
{

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

    public User(String userName, String password, long phone, String emailId, String address1, String address2, String city, String state, String country, long zipCode, LocalDate dateofBirth, String userCategory) {
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
        this.userCategory = userCategory;
    }

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




}
