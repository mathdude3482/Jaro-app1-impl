/*
 * UCF COP3330 Fall 2021 Application Assignment 1 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class Serialization {
    //this class will allow the user to save the todolist in their local storage and load a specific todoList.
    public void saveList(String path, List<Item> list){
        //this method will allow the user to save the todoList.
        //make a new gson object.
        Gson myGson = new Gson();
        //turn the list into a ToDoList.
        ToDoList myList = new ToDoList();
        myList.setMyList(list);
        //try new FileWriter with String path as its path. If not found, catch the error.
        try (FileWriter myPath = new FileWriter(path)) {
            //call Gson method toJson.
            myGson.toJson(myList, myPath);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public List<Item> loadJson(String path){
        //this method will allow the user to load a specific file.
        //create a new Gson object.
        Gson myGson = new Gson();
        //create a new ToDoList.
        ToDoList savedList = new ToDoList();
        //try FileReader with String path as its path. If not, catch an error.
        try (FileReader myPath = new FileReader(path)) {
            //call Gson method fromJson.
            savedList = myGson.fromJson(myPath, ToDoList.class);
        }catch(IOException e){
            e.printStackTrace();
        }
        //return whatever the list is.
        return savedList.getMyList();
    }
}
