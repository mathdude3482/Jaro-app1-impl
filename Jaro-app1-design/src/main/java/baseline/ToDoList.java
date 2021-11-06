/*
 * UCF COP3330 Fall 2021 Application Assignment 1 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import java.util.List;
public class ToDoList {
   //this class will simply get and set a user's list.
   private List<Item> myList;
   public List<Item> getMyList(){
       //simply return the user's list.
       return myList;
   }
   public void setMyList(List<Item> myList){
       //set the user's list.
      this.myList = myList;
   }
}
