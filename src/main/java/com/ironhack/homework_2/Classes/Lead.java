package com.ironhack.homework_2.Classes;

public class Lead {
    private long idLead;
    private String name;
    private long phoneNumber;
    private String email;
    private String companyName;
    private static long idCounter= 1;

   private long generateIdLead(){

        long idLead = idCounter++;

        return idLead;

    }

    // Constructor method

    public Lead(String name, long phoneNumber, String email, String companyName) {
        // Create idLead
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }

    // Getters and Setters

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public long getIdLead() {
        return idLead;
    }

    public void setIdLead(long idLead) {
        this.idLead = idLead;
    }
}

