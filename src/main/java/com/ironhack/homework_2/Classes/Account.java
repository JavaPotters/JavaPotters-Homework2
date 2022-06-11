package com.ironhack.homework_2.Classes;

import com.ironhack.homework_2.Enumerations.IndustryEnum;

import java.util.List;

public class Account {
    private long id;
    private IndustryEnum industryEnum;
    private int employeeAccount;
    private String city;
    private String country;
    private List<Contact> contactList;
    private List<Opportunity> opportunityList;

    // Constructor method


    public Account(long id, IndustryEnum industryEnum, int employeeAccount, String city, String country,
                   List<Contact> contactList, List<Opportunity> opportunityList) {
        this.id = id;
        this.industryEnum = industryEnum;
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

    public IndustryEnum getIndustry() {
        return industryEnum;
    }

    public void setIndustry(IndustryEnum industry) {
        this.industryEnum = industry;
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




