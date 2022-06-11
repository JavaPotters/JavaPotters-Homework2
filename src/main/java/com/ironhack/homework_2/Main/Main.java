package com.ironhack.homework_2.Main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Create a Scanner to collect user input
        Scanner myScanner = new Scanner(System.in);
        // Get input from the user
        System.out.println("Please enter your name");
        String userNameInput = myScanner.nextLine();
        System.out.println("Welcome " + userNameInput);

        // Get input from the user
        System.out.println("Please enter your age");
        String userAgeInput = myScanner.nextLine();
        // Convert the user input to a number
        int userAge = Integer.parseInt(userAgeInput);
        System.out.println("You are " + userAge + " years old.");

        // Get input from the user
        while (true) {
            System.out.println("Please enter your age");
            String userInput = myScanner.nextLine();
            //add some logic to here to determine what to do based on the userInput
        }
    }
}
