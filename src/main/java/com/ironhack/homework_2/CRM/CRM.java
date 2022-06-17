package com.ironhack.homework_2.CRM;

import com.ironhack.homework_2.Classes.Account;
import com.ironhack.homework_2.Classes.Contact;
import com.ironhack.homework_2.Classes.Lead;
import com.ironhack.homework_2.Classes.Opportunity;
import com.ironhack.homework_2.Enumerations.IndustryEnum;
import com.ironhack.homework_2.Enumerations.ProductEnum;
import com.ironhack.homework_2.Enumerations.StatusEnum;

import java.util.ArrayList;
import java.util.List;

public class CRM {
    private List<Contact> contactList;
    private List<Opportunity> opportunityList;
    private List<Account> accountList;
    private List<Lead> leadList;
    private int countLeads;

    public CRM() {
        contactList = new ArrayList<>();
        opportunityList = new ArrayList<>();
        accountList = new ArrayList<>();
        leadList = new ArrayList<>();
        countLeads = 0;
    }

    // Contact's methods -------------------------------------------------------------------

    public Contact createContact(Lead lead){
        Contact contact = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
        return contact;
    }

    // Opportunity's methods -----------------------------------------------------------------

    public Opportunity createOpportunity(Contact contact, ProductEnum productEnum, int quantity){
        Opportunity opportunity = new Opportunity(productEnum, quantity, contact, StatusEnum.OPEN);
        opportunityList.add(opportunity);
        return opportunity;
    }

    public void addOpportunity (Opportunity opportunity) {
        opportunityList.add(opportunity);
    }

    public Opportunity lookUpOpportunity(long idOpportunity){
        for (Opportunity opportunity: opportunityList){
            if(idOpportunity == opportunity.getIdOpportunity()){
                return opportunity;
            }
        }
        return null;
    }

    public Opportunity closeOpportunity(String statusOpportunity, long idOpportunity){
        Opportunity opportunity = lookUpOpportunity(idOpportunity);
        if(opportunity != null){
            if(statusOpportunity.equalsIgnoreCase("lost")){
                opportunity.setStatus(StatusEnum.CLOSED_LOST);
            } else if (statusOpportunity.equalsIgnoreCase("Won")) {
                opportunity.setStatus(StatusEnum.CLOSED_WON);
            }
        }else{
            System.out.println("The opportunity was not found");
        }
        return opportunity;
    }

    public void showListOpportunity(){

        for(Opportunity opportunity: opportunityList){
            System.out.println(opportunity);
        }
    }

    // Lead's methods --------------------------------------------------------------------

    public void addLead(Lead lead) {
        leadList.add(lead);
        countLeads++;
    }

    public Lead findLead(long id){
        for (Lead lead: leadList){
            if(id == lead.getIdLead()){
                return lead;
            }
        }
        return null;
    }
    public void showListLead(){

        for(Lead lead: leadList){
            System.out.println(lead);
        }
    }

    public void deleteLead(Lead lead){
        leadList.remove(lead);
        countLeads--;

    }
    public void trackingLeads(){
        countLeads = 0;
        for(Lead lead: leadList){
            System.out.println("The lead's ID is: " + lead.getIdLead());
            countLeads++;
        }
        System.out.println("There are " + countLeads + " leads");
    }

    public int getCountLeads() {
        return countLeads;
    }

    public void setCountLeads(int countLeads) {
        this.countLeads = countLeads;
    }

    // Account's leads ----------------------------------------------------------------------------

    public Account findAccount(String companyName){
        for (Account account: accountList){
            if(companyName.equals(account.getCompanyName())){
                return account;
            }
        }
        return null;
    }
    public Account createAccount(IndustryEnum industryEnum, int employeeCount, String city,
                                 String country, Contact contact, Opportunity opportunity){

        Account account = findAccount(contact.getCompanyName());

        if(account != null){
            account.addContact(contact);
            account.addOpportunity(opportunity);
            accountList.add(account);
            return account;
        }else {
            Account account2 = new Account(industryEnum, employeeCount, city, country, contact.getCompanyName());
            account2.addContact(contact);
            account2.addOpportunity(opportunity);
            accountList.add(account2);
            return account2;
        }

    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

}


