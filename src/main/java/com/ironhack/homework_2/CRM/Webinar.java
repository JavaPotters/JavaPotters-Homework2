package com.ironhack.homework_2.CRM;

import com.ironhack.homework_2.Classes.Lead;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Webinar {

    public Lead signingUp() {

        List<String> name = getInputData("\nIntroduce the lead's name: ");
        Long phoneNumber = validInput("\nIntroduce the lead's phone number: ");
        List<String> emailAndCompany = getInputData("\nIntroduce the lead's email: ",
                "\nIntroduce the lead's company name: ");

        Lead lead = new Lead(name.get(0), phoneNumber , emailAndCompany.get(0), emailAndCompany.get(1));
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

    private static long validInput(String questions){
        Scanner myScanner =  new Scanner(System.in);
        long input = 0;

        while (input <= 0){
            try {System.out.println(questions);
                input = myScanner.nextInt();
            } catch (InputMismatchException ex) {
                ex.getMessage();
                System.out.println("INVALID OPTION! Please insert a valid phone number" );
                myScanner =  new Scanner(System.in);
            }
        }
        return input;
    }
}
