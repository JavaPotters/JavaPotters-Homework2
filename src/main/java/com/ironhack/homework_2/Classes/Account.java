package com.ironhack.homework_2.Classes;

import com.ironhack.homework_2.Enumerations.IndustryEnum;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private long idAccount;
    private IndustryEnum industryEnum;
    private int employeeAccount;
    private String city;
    private String country;
    private List<Contact> contactList;
    private List<Opportunity> opportunityList;

    private String companyName;

    private static long idCounter= 1;

    private long generateIdAccount(){

        long idAccount = idCounter++;

        return idAccount;
    }

    public void addContact(Contact contact){
        contactList.add(contact);
    }
    public void addOpportunity(Opportunity opportunity){
        opportunityList.add(opportunity);
    }

    // Constructor method

    public Account(IndustryEnum industryEnum, int employeeAccount, String city, String country, String companyName) {
        this.industryEnum = industryEnum;
        this.employeeAccount = employeeAccount;
        this.city = city;
        this.country = country;
        this.companyName = companyName;
        this.opportunityList = new ArrayList<>();
        this.contactList = new ArrayList<>();
    }


    // Getters and Setters


    public IndustryEnum getIndustryEnum() {
        return industryEnum;
    }

    public void setIndustryEnum(IndustryEnum industryEnum) {
        this.industryEnum = industryEnum;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
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

    @Override
    public String toString() {
        return "Account{" +
                "idAccount=" + idAccount +
                ", industryEnum=" + industryEnum +
                ", employeeAccount=" + employeeAccount +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", contactList=" + contactList +
                ", opportunityList=" + opportunityList +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}




