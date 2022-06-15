package com.ironhack.homework_2.Main;

import com.ironhack.homework_2.CRM.CRM;
import com.ironhack.homework_2.CRM.Webinar;
import com.ironhack.homework_2.Classes.Account;
import com.ironhack.homework_2.Classes.Contact;
import com.ironhack.homework_2.Classes.Lead;
import com.ironhack.homework_2.Classes.Opportunity;
import com.ironhack.homework_2.Enumerations.IndustryEnum;
import com.ironhack.homework_2.Enumerations.ProductEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Webinar webinar = new Webinar();

        //Create a Scanner to collect user input

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Starting CRM");

        // Lead leadDummy = new Lead("Mike", 6100000, "mike@test", "company X");

        CRM crm = new CRM();

        // Get input from the user

        while (true) {
            System.out.println("What do you want to do?");
            String userInput = myScanner.nextLine();
            //add some logic to here to determine what to do based on the userInput
            if(isAKeyWord(userInput)){

                int id;
                try{
                    String[] splited = userInput.split(" ");
                    String keyword = splited[0].toLowerCase();
                    switch (keyword){
                        case "convert":
                            id = Integer.parseInt(splited[1]);
                            Lead lead = crm.findLead(id);
                            Contact contact = crm.createContact(lead);

                            System.out.println("How many trucks  ");
                            int productQuantity = myScanner.nextInt();

                            // añadir validaciones
                            System.out.println("What product \n" +
                                    "1. HYBRID,\n" +
                                    "2. FLATBED,\n" +
                                    "3. BOX");

                            int productTypeInt = myScanner.nextInt();
                            ProductEnum productEnum = null;
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

                            Opportunity opportunity = crm.createOpportunity(contact, productEnum, productQuantity);

                            // añadir validaciones
                            System.out.println("What industry \n" +
                                    "1. PRODUCE\n" +
                                    "2. ECOMMERCE\n" +
                                    "3. MANUFACTURING\n" +
                                    "4. MEDICAL\n" +
                                    "5. OTHER\n" );

                            int industryTypeInt = myScanner.nextInt();
                            IndustryEnum industryEnum = null;
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

                            List<String> companyData = getInputData("How many employees does your company have?\n",
                                    "Introduce company's city\n", "Introduce company's country\n");

                            Account account = crm.createAccount(industryEnum, Integer.parseInt(companyData.get(0)),
                                    companyData.get(1), companyData.get(2), contact, opportunity);
                            crm.deleteLead(lead);
                            System.out.println("Convert done");
                            break;
                        case "lookup":
                            id = Integer.parseInt(splited[1]);
                            Opportunity opportunity1 = crm.lookUpOpportunity(id);
                            System.out.println(opportunity1);
                            break;
                        case "close-lost":
                            id = Integer.parseInt(splited[1]);
                            Opportunity opportunity2 = crm.closeOpportunity("Lost", id);
                            System.out.println("Close-lost");
                            System.out.println(opportunity2.getStatus());
                            break;
                        case "close-won":
                            id = Integer.parseInt(splited[1]);
                            Opportunity opportunity3 = crm.closeOpportunity("Won", id);
                            System.out.println("Close-won");
                            System.out.println(opportunity3.getStatus());
                            break;
                        case "show":
                            String objectType = splited[1];
                            if (objectType.equals("leads")) {
                                crm.showListLead();
                                System.out.println("List of leads");
                            } else if (objectType.equals("opportunities")) {
                                crm.showListOpportunity();
                                System.out.println("List of opportunities");
                            }
                            break;
                        case "signing-up":
                            lead = webinar.signingUp();
                            crm.addLead(lead);
                            break;
                    }
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Please insert ID");
                }

            }
        }
    }

    private static final String[] keyWords = {"convert", "lookup", "close-lost", "close-won", "show", "signing-up"};

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
