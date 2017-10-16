package com.codeup;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by RyanHarper on 10/16/17.
 */
public class StringApp {

    public String reversedInPlaceCase(String userInput) {

        System.out.print(userInput + " reversed in place is: ");
        String[] stringArray = userInput.split(" ");
        for (int i = 0; i < stringArray.length; i++) {
            String reversedInPlace = new StringBuilder(stringArray[i]).reverse().toString();
            System.out.print(reversedInPlace + " ");
        }
        return userInput;
    }

    public static void main(String[] args) {

//    Create a new class with a main method that prompts the user for input and does the following
//        Tells whether or not what the user entered is a number
//        Flips the case of the string
//        Reverses the string

        Input input = new Input();

        String userInput = input.getString("Enter a sentence");

        System.out.println("You entered: " + userInput);

        boolean isANumber = StringUtils.isNumeric(userInput);

        if (isANumber) {
            System.out.println(userInput + " is a number");
        } else {
            System.out.println(userInput + " is not a number");
        }

        String swapCases = StringUtils.swapCase(userInput);
        System.out.println(userInput + " with cases swapped: " + swapCases);

        String reverseString = StringUtils.reverse(userInput);
        System.out.println((userInput + " reversed is: " + reverseString));


        System.out.print(userInput + " reversed in place is: ");
        String[] stringArray = userInput.split(" ");
        for (int i = 0; i < stringArray.length; i++) {
            String reversedInPlace = new StringBuilder(stringArray[i]).reverse().toString();
            System.out.print(reversedInPlace + " ");
        }

// ================================================== CALLING THE METHOD ===============================================

        System.out.println(" \n====================== calling the method ============================ ");
        StringApp sa = new StringApp();
        sa.reversedInPlaceCase(userInput);
    }
}



//    public boolean checkIfNumber(String userInput) {
//
//        boolean isANumber = StringUtils.isNumeric(userInput);
//        if (isANumber) {
//            System.out.println(userInput + " is a number");
//        } else {
//            System.out.println(userInput + " is not a number");
//        }
//        return isANumber;
//    }
//
//    public String swappedCase(String userInput) {
//        String swapCases = StringUtils.swapCase(userInput);
//        return userInput + " with cases swapped is: " + swapCases;
//    }
//
//    public String reversedCase(String userInput) {
//        String reverseString = StringUtils.reverse(userInput);
//        return userInput + " reversed is: " + reverseString;
//    }
//

//    public static void main(String[] args) {
//Input input = new Input();
//    StringApp stringapp = new StringApp();
//
//    String userInput = input.getString("Enter a sentence");
//
//        System.out.println(stringapp.checkIfNumber(userInput));
//                System.out.println(stringapp.swappedCase(userInput));
//                System.out.println(stringapp.reversedCase(userInput));
//                System.out.println(stringapp.reversedInPlaceCase(userInput));

//}
////
//
