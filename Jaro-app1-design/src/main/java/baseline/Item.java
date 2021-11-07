/*
 * UCF COP3330 Fall 2021 Application Assignment 1 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
public class Item {
    //this class will create the description, as well as getting the due date and making sure
    //the item is complete or incomplete.
    private String description;
    private CreateDate dueDate;
    private boolean isComplete;

    //initialize description, dueDate, and isComplete.
    public Item(String description, CreateDate dueDate, boolean isComplete) {
        this.description = description;
        this.dueDate = dueDate;
        this.isComplete = isComplete;
    }

    public String getDescription(){
        //get the user's description of the item.
        return description;
    }
    public void setDescription(String description){
        //set the description to be whatever the parameter is.
        this.description = description;
    }
    public boolean getIsComplete(){
        //return whatever isComplete is.
        return isComplete;
    }
    public void setComplete (boolean isComplete){
        //set isComplete to whatever the parameter is.
        this.isComplete = isComplete;
    }
    public String getDueDateString(){
        //return the due date String.
        return  dueDate.getDate();
    }
    public void setDueDate(CreateDate dueDate){
        //set the date to whatever the due date is.
        this.dueDate = dueDate;
    }

}
