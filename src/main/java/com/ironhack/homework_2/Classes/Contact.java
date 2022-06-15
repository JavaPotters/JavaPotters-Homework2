package com.ironhack.homework_2.Classes;

import java.util.Objects;

public class Contact extends Lead{
    private long idContact;
    private static int idCounter= 1;

    private long generateIdContact() {

        int idContact = idCounter++;

        return idContact;
    }

    public Contact(String name, long phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
        this.idContact = generateIdContact();
    }

    public long getIdContact() {
        return idContact;
    }

    public void setIdContact(long idContact) {
        this.idContact = idContact;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Contact.idCounter = idCounter;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "idContact=" + idContact +
                ", idLead=" + idLead +
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
        Contact contact = (Contact) o;
        return idContact == contact.idContact;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContact, name, phoneNumber, email, companyName);
    }
}