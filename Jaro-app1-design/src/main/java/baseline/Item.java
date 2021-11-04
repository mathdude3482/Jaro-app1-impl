package baseline;

public class Item {
    //this class will create the description, as well as getting the due date and making sure
    //the item is complete or incomplete.
    private String description;
    private CreateDate dueDate;
    private String dueDateString;
    private boolean isComplete;
    public String getDescription(){
        //get the user's description of the item.
        return "";
    }
    public boolean getIsComplete(){
        //return whatever isComplete is.
        return true;
    }
    public String getDueDateString(){
        //return the due date String.
        return "";
    }
    public void setDescription(String description){
        //set the description to be whatever the parameter is.
    }
    public void setDueDate(CreateDate dueDate){
        //set the date to whatever the due date is.
    }
    public void setComplete (boolean isComplete){
        //set isComplete to whatever the parameter is.
    }
}
