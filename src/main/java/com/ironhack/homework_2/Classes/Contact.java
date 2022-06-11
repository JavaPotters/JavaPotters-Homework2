package com.ironhack.homework_2.Classes;

public class Contact {
    private String  name;
    private long phoneNumber;
    private String email;
    private Account companyName;

    // Constructor method

    public Contact(String name, long phoneNumber, String email, Account companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }

    // Getters and setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Account companyName) {
        this.companyName = companyName;
    }
}