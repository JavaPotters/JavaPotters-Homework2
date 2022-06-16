package com.ironhack.homework_2.CRM;

import com.ironhack.homework_2.Classes.Lead;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Webinar {

    private String name;
    private long phoneNumber;
    private String email;
    private String companyName;
    private List<String> leadData;

    public Lead signingUp() {
        try{leadData = getInputData("\nIntroduce the lead's name: ","\n" +
                "Introduce the lead's phone number: ", "\n" +
                "Introduce the lead's email: ", "\n" +
                "Introduce the lead's company name: ");}
        catch (NumberFormatException e) {

        }


        Lead lead = new Lead(leadData.get(0),Long.parseLong(leadData.get(1)) , leadData.get(2), leadData.get(3));
        return lead;
    }

    private static List<String> getInputData(String... questions) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputData = new ArrayList<>();
        for (String question : questions) {
            System.out.println(question);
            inputData.add(scanner.next());
        }

        return inputData;
    }
}
