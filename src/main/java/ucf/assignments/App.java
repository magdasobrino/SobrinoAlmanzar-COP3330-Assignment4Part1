/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Magdalena_Sobrino
 */

package ucf.assignments;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;


public class App extends Application {
    public static ArrayList<Item> myList;



    @Override
    public void start(Stage stage) throws Exception {

            URL url = getClass().getClassLoader().getResource("example.fxml");
            Parent root = FXMLLoader.load(url);

            Scene scene = new Scene(root);

            stage.setTitle("To Do App");
            stage.setScene(scene);
            stage.show();

    }
        public static void main (String[]args){

            launch(args);

        }
    }


