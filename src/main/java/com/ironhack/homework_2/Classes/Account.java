package com.ironhack.homework_2.Classes;

import java.util.List;

public class Account {
    private long id;
    private Enum industry;
    private int employeeAccount;
    private String city;
    private String country;
    private List<Contact> contactList;
    private List<Opportunity> opportunityList;

    // Constructor method


    public Account(long id, Enum industry, int employeeAccount, String city, String country,
                   List<Contact> contactList, List<Opportunity> opportunityList) {
        this.id = id;
        this.industry = industry;
        this.employeeAccount = employeeAccount;
        this.city = city;
        this.country = country;
        this.contactList = contactList;
        this.opportunityList = opportunityList;
    }

    // Getters and Setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Enum getIndustry() {
        return industry;
    }

    public void setIndustry(Enum industry) {
        this.industry = industry;
    }

    public int getEmployeeAccount() {
        return employeeAccount;
    }

    public void setEmployeeAccount(int employeeAccount) {
        this.employeeAccount = employeeAccount;
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

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public void setOpportunityList(List<Opportunity> opportunityList) {
        this.opportunityList = opportunityList;
    }
}




