package com.ironhack.homework_2.Classes;

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


}