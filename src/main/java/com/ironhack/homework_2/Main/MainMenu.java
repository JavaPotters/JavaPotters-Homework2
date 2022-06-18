package com.ironhack.homework_2.Main;

import com.ironhack.homework_2.CRM.CRM;
import com.ironhack.homework_2.Classes.Webinar;
import com.ironhack.homework_2.Classes.Account;
import com.ironhack.homework_2.Classes.Contact;
import com.ironhack.homework_2.Classes.Lead;
import com.ironhack.homework_2.Classes.Opportunity;
import com.ironhack.homework_2.Enumerations.IndustryEnum;
import com.ironhack.homework_2.Enumerations.ProductEnum;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    private static CRM crm;

    public MainMenu() {
        // Create a CRM
        crm = new CRM();
        main();
    }

    public static void main() {
        Webinar webinar = new Webinar();

        //Create a Scanner to collect user input
        Scanner myScanner = new Scanner(System.in);

        System.out.println("************* Starting CRM *************");
        System.out.println("What is your name?");
        String salesAssistName = myScanner.nextLine();
        System.out.println("Welcome to the CRM system, " + salesAssistName + ".\n" + options);

        while (true) {
            System.out.println("\nWhat do you want to do, " + salesAssistName + "?");
            String userInput = myScanner.nextLine();
            if(isAKeyWord(userInput)){
                userInput = userInput.toLowerCase();
                int id;
                try{
                    String[] splited = userInput.split(" ");
                    String keyword = splited[0].toLowerCase(); // ignore mayus, always lowerCase
                    switch (keyword){
                        case "signup":
                            Lead lead = webinar.signingUp();
                            crm.addLead(lead);
                            break;
                        case "convert":
                            convertMethod(splited);
                            break;
                        case "lookup":
                            id = Integer.parseInt(splited[1]);
                            Opportunity opportunity1 = crm.lookUpOpportunity(id);
                            System.out.println(opportunity1);
                            break;
                        case "show":
                            String objectType = splited[1];
                            if (objectType.equals("leads")) {
                                System.out.println("List of leads: ");
                                crm.showListLead();
                            } else if (objectType.equals("opportunities")) {
                                System.out.println("List of opportunities:  ");
                                crm.showListOpportunity();
                            } else{
                                System.out.println("Invalid option. Show does not have "+objectType+" option, please " +
                                        "try again. With \033[3mshow leads\033[0m or \033[3mshow opportunities\033[0m");
                                break;
                            }
                            break;
                        case "close-lost":
                            id = Integer.parseInt(splited[1]);
                            Opportunity opportunity2 = crm.closeOpportunity("Lost", id);
                            if(opportunity2!=null){
                                System.out.println("The opportunity with id " + id + " was closed-lost.");
                            }
                            break;
                        case "close-won":
                            id = Integer.parseInt(splited[1]);
                            Opportunity opportunity3 = crm.closeOpportunity("Won", id);
                            if(opportunity3!=null) {
                                System.out.println("The opportunity with id " + id + " was closed-won.");
                            }
                            break;
                        case "exit":
                            System.exit(0);
                    }
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Please insert ID");
                }

            }
            else {
                System.out.println("Invalid option, please try again.");
                System.out.println(options);
                myScanner = new Scanner(System.in);
            }
        }
    }

    // Static string with options to show for screen
    private static final String options = "You can type: \n" +
            "\033[3m- Signup:\033[0m to create a lead.\n" +
            "\033[3m- Show leads:\033[0m  to see the leads list.\n" +
            "\033[3m- Convert <leadId>:\033[0m to convert a lead into an opportunity.\n" +
            "\033[3m- Show opportunities:\033[0m to see the opportunities list.\n" +
            "\033[3m- Lookup <opportunityId>:\033[0m to find an opportunity.\n" +
            "\033[3m- Close-won <opportunityId>:\033[0m to close an opportunity that was won.\n" +
            "\033[3m- Close-lost <opportunityId>:\033[0m to close an opportunity that was lost.\n"+
            "\033[3m- Exit:\033[0m to finish the program.";

    // Key words to enter in the switch-case
    private static final String[] keyWords = {"convert", "lookup", "close-lost", "close-won", "show", "signup", "exit"};

    // valid if a string is a keyword
    public static boolean isAKeyWord(String str){
        String[] splited = str.split(" ");
        String word = splited[0].toLowerCase();
        for(String keyWord: keyWords){
            if(word.equals(keyWord)){
                return true;
            }
        }
        return false;
    }

    // read questions, and return a list of strings
    private static List<String> getInputData(String... questions) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputData = new ArrayList<>();
        for (String question : questions) {
            System.out.println(question);
            inputData.add(scanner.next());
        }
        return inputData;
    }

    // valid if the user's input is a int
    private static int validInput(String questions){
        Scanner myScanner =  new Scanner(System.in);
        int input = 0;

        while (input <= 0){
            try {System.out.println(questions);
                input = myScanner.nextInt();
            } catch (InputMismatchException ex) {
                ex.getMessage();
                System.out.println("INVALID OPTION! Please insert an int" );
                myScanner =  new Scanner(System.in);
            }
        }
        return input;
    }

    // option convert is a method because is larger
    private static void convertMethod(String[] splited){
        int id = Integer.parseInt(splited[1]);
        Lead lead = crm.findLead(id);
        Contact contact = crm.createContact(lead);

        int productQuantity = validInput("How many trucks does the lead want?");

        ProductEnum productEnum = null;
        int productTypeInt;
        //Validation productType
        do{
            productTypeInt = validInput("\nWhich of our products? \n" +
                    "1. HYBRID,\n" + "2. FLATBED,\n" + "3. BOX");
            switch (productTypeInt){
                case 1:
                    productEnum = ProductEnum.HYBRID;
                    break;
                case 2:
                    productEnum = ProductEnum.FLATBED;
                    break;
                case 3:
                    productEnum = ProductEnum.BOX;
                    break;
            }
            if(productTypeInt > 3){
                System.out.println("Invalid option, please insert an int between 1 - 3");
            }
        } while (productTypeInt > 3);

        Opportunity opportunity = crm.createOpportunity(contact, productEnum, productQuantity);

        int industryTypeInt;
        IndustryEnum industryEnum = null;
        //Validation industryType
        do{
            industryTypeInt = validInput("\nWhich industry are the products for? \n" +
                    "1. PRODUCE\n" + "2. ECOMMERCE\n" + "3. MANUFACTURING\n" + "4. MEDICAL\n" +
                    "5. OTHER");
            switch (industryTypeInt){
                case 1:
                    industryEnum = IndustryEnum.PRODUCE;
                    break;
                case 2:
                    industryEnum = IndustryEnum.ECOMMERCE;
                    break;
                case 3:
                    industryEnum = IndustryEnum.MANUFACTURING;
                    break;
                case 4:
                    industryEnum = IndustryEnum.MEDICAL;
                    break;
                case 5:
                    industryEnum = IndustryEnum.OTHER;
                    break;
            }
            if(industryTypeInt > 5){
                System.out.println("Invalid option, please insert an int between 1 - 5");
            }
        }while (industryTypeInt > 5);

        int numEmployees = validInput("\nHow many employees does the contact's company have?");
        List<String> companyData = getInputData(
                "\nIntroduce the city where the contact's company is located.",
                "\nIntroduce the country where the contact's company is located.");

        Account account = crm.createAccount(industryEnum, numEmployees,
                companyData.get(0), companyData.get(1), contact, opportunity);
        crm.deleteLead(lead);
        System.out.println("Convert done");
    }
}
