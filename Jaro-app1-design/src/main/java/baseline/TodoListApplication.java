/*
 * UCF COP3330 Fall 2021 Application Assignment 1 Solution
 * Copyright 2021 James Jaro
 */
package baseline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class TodoListApplication extends Application{
    public static void main(String[] args) {
        //launch the GUI.
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        //this method will contain all logic needed to launch the GUI.
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ItemController.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.setTitle("Item Controller");
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
