package com.ironhack.homework_2.Classes;

import java.util.Objects;

public class Lead {
    protected long idLead;
    protected String name;
    protected long phoneNumber;
    protected String email;
    protected String companyName;
    protected static long idCounter;

   private long generateIdLead(){

        long idLead = idCounter++;

        return idLead;

    }

    // Constructor method

    public Lead(String name, long phoneNumber, String email, String companyName) {
        this.idLead = generateIdLead();
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

    @Override
    public String toString() {
        return "Lead{" +
                "idLead=" + idLead +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lead lead = (Lead) o;
        return idLead == lead.idLead && phoneNumber == lead.phoneNumber && name.equals(lead.name) && email.equals(lead.email) && companyName.equals(lead.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLead, name, phoneNumber, email, companyName);
    }
}

