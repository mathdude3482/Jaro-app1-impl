/*
 * UCF COP3330 Fall 2021 Application Assignment 1 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
public class Validator {
    //hide the implicit constructor.
    private Validator(){
    }
    //this class will check if the user input is correct.
    public static boolean validDescription(String myString){
        //if the user's string description is between 0 and 256 characters, return true.
        //otherwise, return false.
        if (myString.trim().length() == 0 || myString.length() > 256){
            return false;
        }
        return true;
    }
    private static boolean validFormat(String[] editedString){
        //check if the date is in the correct format.
        //if the format is correct, return true.
        //otherwise, return false.
        //if the year is not in the format of YYYY, return false.
        if(editedString[0].length() != 4){
            return false;
        }
        //if the month is not in the format of MM, return false.
        if (editedString[1].length() != 2){
            return false;
        }
        //if the day is not in the format of DD, return false.
        if (editedString[2].length() != 2){
            return false;
        }
        return true;
    }

    private static boolean validMonth(int month){
        //check if the month is between 1 and 12.
        return month >= 1 && month <= 12;
    }
    private static boolean validDate(int month, int date){
        //check if the date is a valid day within the specified month.
        //if so, return true.
        //otherwise, return false.
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (date < 1 || date > 31) {
                    return false;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                if (date < 1 || date > 30) {
                    return false;
                }
            default:
                break;
        }
        return true;
    }
    public static boolean validDueDate(String myDate){
        //if the user's date matches the format and is a valid date, return true.
        //otherwise, return false.
        int year;
        int month;
        int date;
        //split the myDate String so it can be validated.
        String[] splitmyDate = myDate.split("-");
        //check if the input matches the YYYY-MM-DD format.
        if (!validFormat(splitmyDate)) {
            return false;
        }
        //try to parse the year as an integer.
        try {
            year = Integer.parseInt(splitmyDate[0]);
        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        //try to parse the month as an integer.
        try {
            month = Integer.parseInt(splitmyDate[1]);
        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
            return false;
        }

        //try to parse the date as an integer.
        try {
            date = Integer.parseInt(splitmyDate[2]);
        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        //check if the month is valid.
        if (!validMonth(month)) {
            return false;
        }

        //check if the date is valid.
        if (!validDate(month, date)) {
            return false;
        }
        //check if the date in February is valid.
        if (month == 2 && !checkFebruary(year, date)) {
                return false;
        }
        return true;
    }
    private static boolean checkFebruary(int year, int date){
        //check the date specifically in February and see if it is valid for both normal
        //and leap years.
        //if valid, return true.
        //otherwise, return false.
        if (year % 4 == 0) {
            if (date < 1 || date > 29)
            {
                return false;
            }
        }
        else {
            if (date < 1 || date > 28)
            {
                return false;
            }
        }

        return true;
    }
}
