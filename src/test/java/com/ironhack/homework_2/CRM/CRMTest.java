package com.ironhack.homework_2.CRM;

import com.ironhack.homework_2.Classes.Account;
import com.ironhack.homework_2.Classes.Contact;
import com.ironhack.homework_2.Classes.Lead;
import com.ironhack.homework_2.Classes.Opportunity;
import com.ironhack.homework_2.Enumerations.IndustryEnum;
import com.ironhack.homework_2.Enumerations.ProductEnum;
import com.ironhack.homework_2.Enumerations.StatusEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CRMTest {

    private Contact contact;
    private Opportunity opportunity;
    private Lead lead1, lead2;
    private Account account;

    private CRM crm;

    @BeforeEach
    void setUp() {
        contact = new Contact("Mike", 634477559, "mike@irontruck.com",
                "Irontruck");
        opportunity = new Opportunity(ProductEnum.HYBRID, 30, contact, StatusEnum.OPEN);
        lead1 = new Lead("Mike", 634477559, "mike@irontruck.com",
                "Irontruck");
        lead2 = new Lead("Bob", 636798559, "bob@mcgee.com",
                "McGee");
        account = new Account(IndustryEnum.MANUFACTURING, 12, "Sevilla", "España",
                "Irontruck");
        crm = new CRM();
    }

    @Test
    void createContact() {
        Contact contactResult = crm.createContact(lead1);
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
        opportunityResult.setIdOpportunity(opportunity.getIdOpportunity());
        crm.addOpportunity(opportunityResult);
        assertEquals(opportunity, crm.lookUpOpportunity(opportunity.getIdOpportunity()));
    }

    @Test
    void closeOpportunity_LowerCase() {
        Opportunity opportunityResult = crm.createOpportunity(contact, ProductEnum.HYBRID, 30);
        opportunityResult.setIdOpportunity(5);
        crm.closeOpportunity("won", opportunityResult.getIdOpportunity());
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
        crm.addLead(lead1);
        int sizeListLeads = crm.getCountLeads();
        assertEquals(1, sizeListLeads);
        crm.addLead(lead2);
        sizeListLeads = crm.getCountLeads();
        assertEquals(2, sizeListLeads);
    }

    @Test
    void findLead() {
        crm.addLead(lead1);
        Lead leadResult = crm.findLead(lead1.getIdLead());
        assertEquals(lead1, leadResult);
    }


    @Test
    void trackingLeads() {
        crm.addLead(lead1);
        crm.trackingLeads();
        int sizeListLeads = crm.getCountLeads();
        assertEquals(1, sizeListLeads);

        crm.addLead(lead2);
        crm.trackingLeads();
        sizeListLeads = crm.getCountLeads();
        assertEquals(2, sizeListLeads);
    }

    @Test
    void findAccount() {
        crm.addAccount(account);
        Account accountResult = crm.findAccount(account.getCompanyName());
        assertEquals(account, accountResult);
    }

    @Test
    void createAccount() {
        Account accountResult = crm.createAccount(IndustryEnum.MANUFACTURING, 12, "Sevilla", "España",
                contact, opportunity);
        account.setIdAccount(accountResult.getIdAccount());
        assertEquals(account, accountResult);
    }
}