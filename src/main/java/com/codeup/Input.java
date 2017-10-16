package com.codeup;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RyanHarper on 10/16/17.
 */
public class Input {
    private Scanner scan;

//    public validator(Scanner scan) {
//        this.scan = scan;
//    }

    public Input() {
        this.scan = new Scanner(System.in);
    }

    public int getInt(String prompt) {

        System.out.println(prompt);
        String intInput;
        intInput = scan.nextLine();

        try {
            return Integer.valueOf(intInput);
        } catch (NumberFormatException e) {
            System.out.println("ERROR -- Input must be an integer");
            return getInt(prompt);
        }
    }

    public int getIntWithinRange(String prompt, int min, int max) {

        int intInput = getInt(prompt);

        try {
            if (intInput < min || intInput > max) {
                throw new IllegalArgumentException("ERROR -- Integer is out of range between " + min + " and " + max);
            }
        } catch (IllegalArgumentException e) { //listening for either of these exceptions.
            System.out.println(e.getMessage());
            return getIntWithinRange(prompt, min, max);
        }
        return intInput;
    }

    public double getDouble(String prompt) {

        System.out.println(prompt);
        String doubleInput;
        try {
            doubleInput = scan.nextLine();
            return Double.valueOf(doubleInput);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR -- Input must be an integer");
            return getDouble(prompt);
        }
    }


    public double getDoubleWithinRange(String prompt, double min, double max) {

        try {
            double doubleInput = getDouble(prompt);

            if (doubleInput < min || doubleInput > max) {
                throw new IllegalArgumentException("ERROR -- Integer is out of range between " + min + " and " + max);
            }
            return doubleInput;
        } catch (InputMismatchException e) {
            System.out.println("ERROR -- Input must be an integer.");
            scan.nextLine();
            return getDoubleWithinRange(prompt, min, max);
        } catch (IllegalArgumentException e) { //listening for either of these exceptions.
            System.out.println(e.getMessage());
            return getDoubleWithinRange(prompt, min, max);
        }
    }

    public void setTimeout(int milliseconds) {

        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean yesNo(String prompt){
        String userWantsToContinue;
        System.out.println(prompt);
        try {
            userWantsToContinue = scan.nextLine();
            if (!userWantsToContinue.toLowerCase().startsWith("y") && !userWantsToContinue.toLowerCase().startsWith("n")){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e ) {
            System.out.println("ERROR -- Input must be a Y/Yes or N/No");
            return yesNo(prompt);
        }

        return userWantsToContinue.trim().equalsIgnoreCase("Y") || userWantsToContinue.trim().equalsIgnoreCase("Yes");
    }

// ========== getString() isn't worth it to have in a validator  =======================================================

    public String getString(String prompt) {

        System.out.println(prompt);
        String stringInput;

        try {
            stringInput = scan.nextLine();
        } catch (IllegalArgumentException e ) {
            System.out.println("ERROR -- Input must be valid");
            scan.next();
            return getString(prompt);
        }
        return stringInput;
    }


    public String getPhoneNumber(String prompt){
        System.out.println(prompt);
        String userInput = scan.nextLine();
        Pattern pattern = Pattern.compile("^\\(?([2-9][0-8][0-9])\\)?[-.●]?([2-9][0-9]{2})[-.●]?([0-9]{4})$");
//                "^(?:(?:\\\\+?1\\\\s*(?:[.-]\\\\s*)?)?(?:\\\\(\\\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\\\s*\\\\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\\\s*(?:[.-]\\\\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\\\\s*(?:[.-]\\\\s*)?([0-9]{4})(?:\\\\s*(?:#|x\\\\.?|ext\\\\.?|extension)\\\\s*(\\\\d+))?$");
        Matcher match = pattern.matcher(userInput);
        if(match.matches()){
            return userInput;
        } else{
            System.out.println("Invalid Input Format:(xxx)xxx-xxxx");
            return getPhoneNumber(prompt);
        }
    }

    public String getSongLength(String prompt) {
        System.out.println(prompt);
        String userInput = scan.nextLine();
        Pattern pattern = Pattern.compile("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$");
        Matcher match = pattern.matcher(userInput);
        if(match.matches()){
            return userInput;
        } else{
            System.out.println("Invalid format 00:00");
            return getSongLength(prompt);
        }
    }
}
