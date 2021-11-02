/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Magdalena_Sobrino
 */

package ucf.assignments;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

    public class App extends javafx.application.Application {

        @Override
        public void start(Stage stage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("ToDoApp.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("To Do App");
            stage.show();

        }
        public static void main(String[] args) {
        /*
        create To do App
         */
            launch(args);

        }
    }



