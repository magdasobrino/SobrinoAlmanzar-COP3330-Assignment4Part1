/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Magdalena_Sobrino
 */



package ucf.assignments;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class HelpButton implements Initializable{

    @FXML
    public TextArea HelpText;

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        LoadHELP();
    }

    private void LoadHELP() {
        String message = helpPageContent();
        HelpText.setText(message);
    }

    private String helpPageContent() {

        String message = " Welcome user!. To start using this interface, please follow the following guidelines\n" + "This Application will automatically load all the previously saved items from the external storage during startup"+
                "1.In order to start adding up the items into your ToDo list app, start by filling up the required fields as the name,description and due date\n"+
                "2.After filling up each required field, make sure to click the 'Add' button to add the item into the list\n" +
                "3.In order to set up the Due Date, click on the calendar icon on the right side of the field in order to select the correct due date. The Due Date will be displayed in the format YYYY-MM-DD\n"+
                "4.The checkbox default is false, so in order to the set the item as completed, make sure to select the row of the item and click on the check box, and it will immediately change the status of the item to either complete or incomplete\n"+
                "5.In case you want to delete an item from the list, make sure to select the row and click 'Delete'\n"+
                "6.In case you want to clear all your ToDo list, please make sure to click 'Clear'. This will remove all of the items of your To Do list\n"+
                "7.In order to edit and item's description or due date, double click and replace the text and due date\n"+
                "8.To save the list, please click on the right corner 'File' button 'Save List' and select the file location and it will be downloaded as a .txt file\n"+
                "9.To load the past list,please click on the right corner 'File' button 'Load List' and select the last file downloaded\n "+
                "Error that can be displayed: \n"+
                "\t-an item is missing due date\n" +
                "\t-an item is missing description\n" +
                "\t-an item's description exceeds 256 character limit\n" +
                "\t-more than 100 items have been added to the list\n\n" +
                "Enjoy your To Do list!";

        return message;
    }

}



