/*
 * UCF COP3330 Fall 2021 Application Assignment 1 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
public class CreateDate {
    //this class will be used to create the date.
    private double date;
    private double month;
    private double year;
    //create a constructor to set the variables to a value.
    public CreateDate(){
        year = 2000;
        month = 1;
        date = 1;
    }
    public CreateDate(String myDate){
        //split the date string.
        String[] myDateString = myDate.split("-");
        //attempt to get all the parameters. If not possible, catch the error.
        try{
            this.year = Double.parseDouble(myDateString[0]);
            this.month = Double.parseDouble(myDateString[1]);
            this.date = Double.parseDouble(myDateString[2]);
        }catch (NullPointerException | NumberFormatException e){
            e.printStackTrace();
        }
    }
    public CreateDate(String year, String month, String date) {
        //try to get all parameters. If not possible, catch the error.
        try {
            this.year = Double.parseDouble(year);
            this.month = Double.parseDouble(month);
            this.date = Double.parseDouble(date);
        } catch (NullPointerException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
    public String getDate(){
        //return the date as a String in format YYYY-MM-DD.
        return String.format("%04.0f-%02.0f-%02.0f", year, month, date);
    }
}
