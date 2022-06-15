package com.ironhack.homework_2.CRM;

import com.ironhack.homework_2.Classes.Account;
import com.ironhack.homework_2.Classes.Contact;
import com.ironhack.homework_2.Classes.Lead;
import com.ironhack.homework_2.Classes.Opportunity;
import com.ironhack.homework_2.Enumerations.IndustryEnum;
import com.ironhack.homework_2.Enumerations.ProductEnum;
import com.ironhack.homework_2.Enumerations.StatusEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CRMTest {

    private Contact contact;
    private Opportunity opportunity;
    private Lead lead;
    private Account account;

    private CRM crm;

    @BeforeEach
    void setUp() {
         contact = new Contact("Mike", 634477559, "mike@irontruck.com",
                 "Irontruck");
         opportunity = new Opportunity(ProductEnum.HYBRID, 30, contact, StatusEnum.OPEN);
         lead = new Lead("Mike", 634477559, "mike@irontruck.com",
                 "Irontruck");
         account = new Account(IndustryEnum.MANUFACTURING, 12, "Sevilla", "España",
                 "Irontruck");
         crm = new CRM();
    }

    @Test
    void createContact() {
        Contact contactResult = crm.createContact(lead);
        contact.setIdContact(contactResult.getIdContact());
        assertEquals(contact, contactResult);

    }

    @Test
    void createOpportunity() {
        Opportunity opportunityResult = crm.createOpportunity(contact, ProductEnum.HYBRID, 30);
        opportunity.setIdOpportunity(opportunityResult.getIdOpportunity());
        assertEquals(opportunity, opportunityResult);
    }

    @Test
    void lookUpOpportunity() {
        Opportunity opportunityResult = crm.createOpportunity(contact, ProductEnum.HYBRID, 30);
        opportunityResult.setIdOpportunity(1);
        crm.addOpportunity(opportunityResult);
        assertEquals(opportunity, crm.lookUpOpportunity(1));
    }

    @Test
    void closeOpportunity_LowerCase() {
        Opportunity opportunityResult = crm.createOpportunity(contact, ProductEnum.HYBRID, 30);
        opportunityResult.setIdOpportunity(5);
        crm.closeOpportunity("win", opportunityResult.getIdOpportunity());
        assertEquals(StatusEnum.CLOSED_WON, opportunityResult.getStatus());
    }
    @Test
    void closeOpportunity_UpperCase() {
        Opportunity opportunityResult = crm.createOpportunity(contact, ProductEnum.HYBRID, 30);
        opportunityResult.setIdOpportunity(5);
        crm.closeOpportunity("WON", opportunityResult.getIdOpportunity());
        assertEquals(StatusEnum.CLOSED_WON, opportunityResult.getStatus());
    }
    @Test
    void closeOpportunity_UpperCase_Lost() {
        Opportunity opportunityResult = crm.createOpportunity(contact, ProductEnum.HYBRID, 30);
        opportunityResult.setIdOpportunity(3);
        crm.closeOpportunity("LOST", opportunityResult.getIdOpportunity());
        assertEquals(StatusEnum.CLOSED_LOST, opportunityResult.getStatus());
    }

    @Test
    void addLead() {


    }

    @Test
    void findLead() {
    }


    @Test
    void trackingLeads() {
    }

    @Test
    void findAccount() {
    }

    @Test
    void createAccount() {
    }
}