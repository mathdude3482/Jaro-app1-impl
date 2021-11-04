package baseline;

public class Validator {
    //this class will check if the user input is correct.
    public static boolean validDescription(String myString){
        //if the user's string description is between 0 and 256 characters, return true.
        //otherwise, return false.
        return true;
    }
    private static boolean validFormat(String[] editedString){
        //check if the date is in the correct format.
        //if the format is correct, return true.
        //otherwise, return false.
        return true;
    }
    private static boolean validMonth(int month){
        //check if the month is between 1 and 12.
        return true;
    }
    private static boolean validDate(int month, int date){
        //check if the date is a valid day within the specified month.
        //if so, return true.
        //otherwise, return false.
        return true;
    }
    public static boolean validDueDate(String myDate){
        //if the user's date matches the format and is a valid date, return true.
        //otherwise, return false.
        return true;
    }
    private static boolean checkFebruary(int year, int date){
        //check the date specifically in February and see if it is valid for both normal
        //and leap years.
        //if valid, return true.
        //otherwise, return false.
        return true;
    }
}
