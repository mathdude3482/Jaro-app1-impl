/*
 * UCF COP3330 Fall 2021 Application Assignment 1 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class HelpWindowController {
//this class will specify what happens if the user needs assistance with the GUI.
    @FXML
    private TextArea helpTextBox;

    @FXML
    public void initialize() {
        //set the initial text.
        String toSet = "Welcome to the help window!\nHere, you can click on any button to the left to " +
                " learn more about this program!";

        helpTextBox.setText(toSet);
    }
    @FXML
    public void tableHelpClicked(MouseEvent event) {
        //call tableHelp.
        tableHelp();
    }
    @FXML
    public void addHelpClicked(MouseEvent event) {
        //call addHelp.
        addHelp();
    }

    @FXML
    public void clearHelpClicked(MouseEvent event) {
        //call clearHelp.
        clearHelp();
    }

    @FXML
    public void displayHelpClicked(MouseEvent event) {
        //call displayHelp.
        displayHelp();
    }

    @FXML
    public void editCompleteHelpClicked(MouseEvent event) {
        //call editCompleteHelp.
        editCompleteHelp();
    }

    @FXML
    public void editDescriptionHelpClicked(MouseEvent event) {
        //call editDescriptionHelp.
        editDescriptionHelp();
    }

    @FXML
    public void editDueDateHelpClicked(MouseEvent event) {
        //call editDueDateHelp.
        editDueDateHelp();
    }

    @FXML
    public void removeHelpClicked(MouseEvent event) {
        //call removeHelp.
        removeHelp();
    }

    @FXML
    public void saveHelpClicked(MouseEvent event) {
     //call saveHelp.
     saveHelp();
    }
    public void tableHelp() {
        //clear the helpTextBox
        helpTextBox.clear();

        //create the string that should be put in the text box
        String setString = "This program displays an editable table of items. This table contains three fields: description, " +
                "due date, and complete.\nThe description field contains a description of the item that will be completed.\nThe due date field" +
                " contains the date by which you want to complete said item in the format YYYY-MM-DD. The due date can also be sorted" +
                " by clicking on the \"Due Date\" header.\nThe complete field contains the current " +
                "completion status of the item.\nIf the description of an item is too large to fit into the default table, " +
                "you are able to increase the table size by increasing the size of the window and adjust the size of the different " +
                "table columns as you wish.";

        //put the setString into helpTextBox
        helpTextBox.setText(setString);
    }

    public void addHelp() {
        //clear the helpTextBox
        helpTextBox.clear();

        //create the string that should be put in the text box
        String setString = "You can add a new item to the list you are working on by clicking the \"Add Item\" button. " +
                "By doing this, you will add a default item with description \"New Item\", due date \"2000-01-01\" and completion status false.";

        //put the setString into helpTextBox
        helpTextBox.setText(setString);
    }

    public void removeHelp() {
        //clear the helpTextBox
        helpTextBox.clear();

        //create the string that should be put in the text box
        String setString = "You can remove an to the list you are working on by clicking the \"Remove Item\" button while currently selecting the item you want to remove. " +
                "By doing this, you will add a default item with description \"New Item\", due date \"2000-01-01\"and completion status false.";

        //put the setString into helpTextBox
        helpTextBox.setText(setString);
    }

    public void clearHelp() {
        //clear the helpTextBox
        helpTextBox.clear();

        //create the string that should be put in the text box
        String setString = "You can clear the entire text box by clicking the \"Clear List\" button.";

        //put the setString into helpTextBox
        helpTextBox.setText(setString);
    }

    public void editDescriptionHelp() {
        //clear the helpTextBox
        helpTextBox.clear();

        //create the string that should be put in the text box
        String setString = "You can edit the description of an item by clicking the \"Edit description\" button. " +
                "This will open up a pop-up window in which you can enter a new description between 1 and 256 characters " +
                "long. Then by clicking the \"Enter\" button in the new window, you will change the " +
                "description of the currently-selected item to the new one.";

        //put the setString into helpTextBox
        helpTextBox.setText(setString);
    }

    public void editDueDateHelp() {
        //clear the helpTextBox
        helpTextBox.clear();

        //create the string that should be put in the text box
        String setString = "You can edit the due date of an item by selecting the item you wish to change and then " +
                "clicking the \"Edit Due Date\" button. This will open up a new window. " +
                "You can enter any valid date in the Gregorian Calendar in the format YYYY-MM-DD, and upon clicking \"Enter\" will change " +
                "the currently-selected item's due date to the entered date.\nAdditionally, you can sort the list of items by clicking" +
                " on the header \"Due Date\"";

        //put the setString into helpTextBox
        helpTextBox.setText(setString);
    }

    public void editCompleteHelp() {
        //clear the helpTextBox
        helpTextBox.clear();

        //create the string that should be put in the text box
        String setString = "You can change the completion status of an item between true and false by selecting the item you wish to change " +
                "and clicking the \"Edit Complete\" button.";

        //put the setString into helpTextBox
        helpTextBox.setText(setString);
    }

    public void displayHelp() {
        //clear the helpTextBox
        helpTextBox.clear();

        //create the string that should be put in the text box
        String setString = "You can change which items are shown in the list. Through the View menu, you can change " +
                "between displaying all items in the list, all completed items in the list, and all incomplete items in the list.";

        //put the setString into helpTextBox
        helpTextBox.setText(setString);
    }

    public void saveHelp() {
        //clear the helpTextBox
        helpTextBox.clear();

        //create the string that should be put in the text box
        String setString = "You can save and load the list you are currently working on under the File menu. " +
                "Here you can select whether you want to save or load the list, and upon choosing one of the options, " +
                "you will be prompted for the location you want to save/load the file from.";

        //put the setString into helpTextBox
        helpTextBox.setText(setString);
    }

}
