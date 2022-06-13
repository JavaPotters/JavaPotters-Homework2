package com.ironhack.homework_2.CRM;

import com.ironhack.homework_2.Classes.Lead;

public class Webinar {

    private String name;
    private long phoneNumber;
    private String email;
    private String companyName;

    public Lead signingUp(String name, long phoneNumber, String email, String companyName) {
        Lead lead = new Lead(name, phoneNumber, email, companyName);
        return lead;
    }
}
