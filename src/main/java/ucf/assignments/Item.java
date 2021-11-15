/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Magdalena_Sobrino
 */

package ucf.assignments;

import java.io.Serializable;
import java.time.LocalDate;

public class Item implements Serializable {
    String Item;
    private String Description;
    private LocalDate DueDate;
    boolean completeStatus;




    public Item(String item, String description, LocalDate dueDate, boolean complete) {
        this.Item= item;
        this.Description = description;
        this.DueDate = dueDate;
        this.completeStatus = false;
    }

    // Due Date//
    public LocalDate editDueDate(LocalDate newDueDate) {
        DueDate = newDueDate;
        return DueDate;

    }
    // if incorrect prompt user to reenter the date on date picker//

    public LocalDate getDueDate() {
        return DueDate;
    }

    public void  setDueDate(LocalDate dueDate) {
        this.DueDate = dueDate;
    }

    // Item//
    public Item() {

    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    //Description//
    public String getDescription() {
        // Here the user will need to put the description of the item
        return Description;
    }

    public String editDescription(String newDescription) {
        this.Description = newDescription;
        return Description;
    }

    public void setDescription(String Description) {

        this.Description = Description;
    }

    //CheckBox ----
    public boolean ItemIsComplete() {
        return completeStatus;
    }

    public void setComplete(boolean complete) {
        this.completeStatus = complete;
    }


    @Override
    public String toString() {

        // if get itemComplete is set to True -> item is complete
        // if get itemComplete is set to false -> items is incomplete

        if (ItemIsComplete()) {
            return Description + "\n" + DueDate + "\n" + "Complete";
        } else {
            return Description + "\n" + DueDate + "\n" + "Incomplete";
        }

    }
}



