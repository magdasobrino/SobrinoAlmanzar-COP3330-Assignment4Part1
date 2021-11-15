/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Magdalena_Sobrino
 */

package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class DisplayExecution {

    @FXML
    ListView<Item> displayAllitems;

    public void loadItems(List<Item> items)
    {
        displayAllitems.getItems().addAll(items);
    }


    @FXML
    public void addList(){
        // User by clicking the "add" button must be able to add a new to-do list
        // create a new array
    }


    @FXML
    public void deleteList(){
        // User by clicking the "delete" button must be able to delete the to-do list that it's been displayed
        // delete from the list
    }

    @FXML
    public void EditTitle(){
        // User by clicking the "Edit Title" button must be able to edit the to-do list's title
        // The title will turn to editable mode and saved
        // encounter the string
        // switch with the new input
        // update title
    }

    public void SaveAllListClicked(){
        // User by clicking the "Save" button must be able to save the to-do list
        // As soon as the save button is clicked, there will be a pop/up window saying
        // Select all the to-do lists you to save
        // Ask for a user's file location and name for the data that it's going to be saved
        // return a single text file
        //create a file
        // write on the file and close
    }

    public void SaveOneListClicked(){
        //User will Save All list
        //output a header for each key value to the txt file
        //output each list item to the txt file

    }

    public void OpenOneListClicked(){
        //User will open one list to make updates//
        //read in file information
        //parse file information into a new map of To Do List
        //return the new lists
        //show all list details, due date, status description//

    }
    public void OpenAllListClicked(){
        //User will open all list to make updates//
        //read in file information
        //parse file information into a new map of To Do List
        //return the new lists
        //show all list details, due date, status description using txt.files //

    }

    public void DisplayIncomplete(){
        // All existing items
        // Incomplete items
        // with if statements choose what to display depending on their option

    }

    public void DisplayComplete(){
        // All existing items
        // Complete items
        // with if statements choose what to display depending on their option

    }
    public void updateList(){
        //if there are existing List items click update button
        // delete all List items

    }
    public void CheckStatus(){
        //display list status
        // incomplete or complete

    }

}

