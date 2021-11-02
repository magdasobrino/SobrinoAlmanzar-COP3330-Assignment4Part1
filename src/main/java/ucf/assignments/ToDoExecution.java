/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Magdalena_Sobrino
 */

package ucf.assignments;

public class ToDoExecution {
    String item;
    String Description;
    boolean complete=false;

    //declare an array of items

    public boolean checkDate(String DueDate){

        //Date in correct format//
        //create class date format//
        //Date format YYYY-MM-DD//
        //parse date string//
        // if incorrect prompt user to reenter the date on bar//

        return true;
    }

    public String getItem(){
        // In here the user will need to put the name of the item that it's going to be in the todo-list
        // Max of 100 items
        //minimum of three characters
        //Scan for the String input by the user
        // Add the item to the array
        return item;
    }

    public void addItem(){
        // User prompts for a new name, new description, and new due date
        // Creates a new instance of the list
        // add to the list's list
    }


    public void deleteItem(){
        // User deletes the item's whole row
        // return the string of the name of the to do list the user is on
        // remove the string from the list (list.remove)
    }

    public String getDescription(){
        // Here the user will need to put the description of the item
        return Description;
        // Scan for the string input by the user
        // added to the list
    }

    public void editDescription(){
        // User selects from the edit's dropdown menu "Description"
        // The description box's turns to editable and the user inputs the new description
        // Once the user hits any other space of the to do list, closes the app or even click on enter it saves automatically
        // encounters the string and replaces it
        // updates the list
    }


    public void editDueDate(){
        // User selects from the calendar menu "Due Date"
        // The description box's turns to editable and the user inputs the new description
        // Once the user hits any other space of the to do list, closes the app or even click on enter it saves automatically
        // encounters the string and replaces it
        // updates the list
    }

    public void MarkIncomplete(){
        //User can mark "Incomplete" an item
        //User can sort list by "Incomplete" item

    }

    public void MarkComplete(){
        //user can mark "Complete" an item
        //User can sort list by "Complete" item
    }


}




