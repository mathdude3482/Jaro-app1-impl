/*
 * UCF COP3330 Fall 2021 Application Assignment 1 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemController {
    //this class will control the main GUI.
    private List<Item> allList = new ArrayList<>();
    @FXML
    public TableView<Item> itemTable;
    @FXML
    public TableColumn<Item, String> descDisplay;
    @FXML
    public TableColumn<Item, String> dateDisplay;
    @FXML
    public TableColumn<Item, String> completeDisplay;

    @FXML
    public void initialize() {
        //set the value factory of descDisplay, dateDisplay, and completeDisplay to
        //Item variables description, dueDateString, and isComplete respectively
        descDisplay.setCellValueFactory(new PropertyValueFactory<>("description"));
        dateDisplay.setCellValueFactory(new PropertyValueFactory<>("dueDateString"));
        completeDisplay.setCellValueFactory(new PropertyValueFactory<>("isComplete"));
    }

    @FXML
    public void addClicked(MouseEvent mouseEvent) {
        //call addItem() to add a new Item to allList
        Item defaultItem = addItem();

        //get the added Item from addItem and call addItemTable() with that as a parameter
        addItemTable(defaultItem);
    }

    @FXML
    public void removeClicked(MouseEvent mouseEvent) {
        //get the current selection in itemTable
        int currentIndex = itemTable.getSelectionModel().getSelectedIndex();

        //get the selected Item
        Item toRemove = itemTable.getItems().get(currentIndex);

        //call removeItem() and removeItemTable() with parameters toRemove and currentIndex
        removeItem(toRemove);
        removeItemTable(currentIndex);
    }

    @FXML
    public void clearClicked(MouseEvent mouseEvent) {
        //call clearList() and clearItemTable() to clear all Item objects
        clearList();
        clearItemTable();
    }

    @FXML
    public void editDescClicked(MouseEvent mouseEvent) {
        //call editDescription with the current index and Item that is desired to change
        editDescription(itemTable.getSelectionModel().getSelectedIndex(),
                itemTable.getItems().get(itemTable.getSelectionModel().getSelectedIndex()));
    }

    @FXML
    public void editDateClicked(MouseEvent mouseEvent) {
        //call editDueDate with the current index and Item that is desired to change
        editDueDate(itemTable.getSelectionModel().getSelectedIndex(),
                itemTable.getItems().get(itemTable.getSelectionModel().getSelectedIndex()));
    }

    @FXML
    public void editCompleteClicked(MouseEvent mouseEvent) {
        //get the current index
        int currentIndex = itemTable.getSelectionModel().getSelectedIndex();

        //call editComplete with the Item at currentIndex to edit allList
        editComplete(itemTable.getItems().get(currentIndex));

        //call editCompleteTable with currentIndex and the new boolean to edit itemTable
        editCompleteTable(currentIndex, itemTable.getItems().get(currentIndex));
    }

    @FXML
    public void displayAllClicked(ActionEvent actionEvent) {
        //call displayAll()
        displayAll();
    }

    @FXML
    public void displayCompleteClicked(ActionEvent actionEvent) {
        //call getCompleteList() to get a list of all completed items
        List<Item> completeList = getCompleteList();

        //call displayComplete() to display the completeList
        displayComplete(completeList);
    }

    @FXML
    public void displayIncompleteClicked(ActionEvent actionEvent) {
        //call getIncompleteList() to get the incomplete list
        List<Item> incompleteList = getIncompleteList();

        //call displayIncomplete to display the incomplete Items
        displayIncomplete(incompleteList);
    }

    @FXML
    public void saveListClicked(ActionEvent actionEvent) {
        //make new Serialization
        Serialization s = new Serialization();

        //call method openFileChooser() to get a path
        String path = openSaveFileChooser();

        //call Serialization method saveList with parameter path and allList
        s.saveList(path, allList);
    }

    @FXML
    public void loadListClicked(ActionEvent actionEvent) {
        //make new Serialization
        Serialization s = new Serialization();

        //call method openFileChooser() to get a path
        String path = openLoadFileChooser();

        //call Serialization method loadJson
        allList = s.loadJson(path);

        //display all of the list
        displayAll();
    }

    @FXML
    public void openHelpWindowClicked(ActionEvent actionEvent) {
        //try to open HelpWindowController.fxml
        try {
            Parent root = FXMLLoader.load(getClass().getResource("HelpWindowController.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.setTitle("Help");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Item addItem() {
        //create a new default Item
        Item defaultItem = new Item("New Item", new CreateDate(), false);

        //add the default item to allList
        allList.add(defaultItem);

        //return defaultItem so it can be added to the table
        return defaultItem;
    }

    public void addItemTable(Item defaultItem) {
        //add the defaultItem to itemTable
        itemTable.getItems().add(defaultItem);
    }

    public void removeItem(Item toRemove) {
        //match the Item that it to be removed with the Item in allList
        int foundIndex = matchItem(toRemove);

        //remove found Item from allList
        allList.remove(foundIndex);
    }

    public void removeItemTable(int index) {
        //remove the item at index in itemTable
        itemTable.getItems().remove(index);
    }

    public void clearList() {
        //clear allList
        allList.clear();
    }

    public void clearItemTable() {
        //clear itemTable
        itemTable.getItems().clear();
    }

    public void editDescription(int currentIndex, Item toChange) {
        boolean isValidDescription = false;
        String change = "";

        //open a new window for input & get a desired & valid change
        while (!isValidDescription) {
            change = openInputWindow("Enter your new description here.", toChange.getDescription());
            isValidDescription = Validator.validDescription(change);
        }

        //change the Item description with editDescription()
        Item changed = changeDescription(change, toChange);

        //put the changed Item into the table
        changeDescriptionTable(changed, currentIndex);
    }

    public Item changeDescription(String edit, Item toChange) {
        //call openEditWindow with parameter "Edit Description"
        int editIndex = matchItem(toChange);

        //change the description in allList
        allList.get(editIndex).setDescription(String.format("%256s", edit).trim());

        //return the now changed Item from allList
        return allList.get(editIndex);
    }

    public void changeDescriptionTable(Item toChange, int currentIndex) {
        //set changed Item to current index
        itemTable.getItems().set(currentIndex, toChange);
    }

    public void editDueDate(int currentIndex, Item toChange) {
        boolean isValidDate = false;
        String change = "";

        //open a new window for input & get desired change
        while (!isValidDate) {
            change = openInputWindow("Enter a new due date here in the format YYYY-MM-DD" +
                    " that is in the Gregorian Calendar", toChange.getDueDateString());
            isValidDate = Validator.validDueDate(change);
        }

        //change the Date in allList
        Item changed = changeDate(change, toChange);

        //change the date in the table
        changeDateTable(changed, currentIndex);
    }

    public Item changeDate(String edit, Item toChange) {
        //get the Item to change's index
        int editIndex = matchItem(toChange);

        //make a new Date with the edit String
        CreateDate newDate = new CreateDate(edit);

        //set the new Date into the appropriate index in allList
        allList.get(editIndex).setDueDate(newDate);

        //return the new Item
        return allList.get(editIndex);
    }

    public void changeDateTable(Item changed, int currentIndex) {
        //set changed Item to current index
        itemTable.getItems().set(currentIndex, changed);
    }

    public void editComplete(Item toSwap) {
        //get index of current Item in allList
        int foundIndex = matchItem(toSwap);

        //get the current state of boolean isComplete
        boolean currentComplete = allList.get(foundIndex).getIsComplete();

        //flip the boolean value
        currentComplete = !currentComplete;

        //set allList to the new boolean value
        allList.get(foundIndex).setComplete(currentComplete);
    }

    public void editCompleteTable(int currentIndex, Item toSwap) {
        //set the value at the given index to the corresponding item
        itemTable.getItems().set(currentIndex, toSwap);
    }

    public void displayAll() {
        //clear itemTable
        clearItemTable();

        //for all in allList
        for (int i = 0; i < allList.size(); i++) {
            //add the Item in allList to the same index in itemTable
            itemTable.getItems().add(i, allList.get(i));
        }
    }

    public void displayComplete(List<Item> completeList) {
        //clear table
        itemTable.getItems().clear();

        //for all Item in completeList
        for (int i = 0; i < completeList.size(); i++) {
            //add it to the table
            itemTable.getItems().add(i, completeList.get(i));
        }
    }

    public void displayIncomplete(List<Item> incompleteList) {
        //clear itemTable
        itemTable.getItems().clear();

        //for all in incompleteList
        for (int i = 0; i < incompleteList.size(); i++) {
            //add it to the table
            itemTable.getItems().add(i, incompleteList.get(i));
        }
    }

    public List<Item> getCompleteList() {
        //clear completeList
        List<Item> completeList = new ArrayList<>();

        //for all in allList
        for (int i = 0; i < allList.size(); i++) {
            //if the Item is complete
            if (allList.get(i).getIsComplete()) {
                //add it to the completed list
                completeList.add(allList.get(i));
            }
        }

        //return the list of completed items
        return completeList;
    }

    public List<Item> getIncompleteList() {
        //clear incompleteList
        List<Item> incompleteList = new ArrayList<>();

        //for all in allList
        for (int i = 0; i < allList.size(); i++) {
            //if the Item is incomplete
            if (!allList.get(i).getIsComplete()) {
                //add it to the incomplete list
                incompleteList.add(allList.get(i));
            }
        }

        //return the list of incomplete items
        return incompleteList;
    }

    public int matchItem(Item toFind) {
        //compare all Item in allList to find the same item and return the appropriate index
        for (int i = 0; i < allList.size(); i++) {
            if (toFind == allList.get(i)) {
                return i;
            }
        }

        return -1;
    }

    public String openInputWindow(String headerText, String currentValue) {
        //make TextInputDialog
        TextInputDialog tid = new TextInputDialog("");
        tid.setHeaderText(headerText);

        //set default value to current description
        tid.getEditor().setText(currentValue);

        //show TextInputDialog
        tid.showAndWait();

        //return the editor's text
        return tid.getEditor().getText();
    }

    public String openSaveFileChooser() {
        //make a new FileChooser
        FileChooser fileChooser = new FileChooser();

        Stage stage = new Stage();

        //give it default path "C://", initial file name "list", and extension ".json"
        fileChooser.setInitialDirectory(new File("C://"));
        fileChooser.setInitialFileName("list");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON file","*.json"));

        //show save dialogue
        File file = fileChooser.showSaveDialog(stage);

        //return selected file path
        return file.getPath();
    }

    public String openLoadFileChooser() {
        //make a new FileChooser
        FileChooser fileChooser = new FileChooser();

        Stage stage = new Stage();

        //give it default path "C://" and extension ".json"
        fileChooser.setInitialDirectory(new File("C://"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON file","*.json"));

        //show open dialogue
        File file = fileChooser.showOpenDialog(stage);

        //return selected file path
        return file.getPath();
    }

    public List<Item> getAllList() {
        //return allList
        return allList;
    }

}
