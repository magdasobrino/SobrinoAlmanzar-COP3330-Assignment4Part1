package ucf.assignments.test;

import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    String date = "2021-11-07";
    String newdate = "2021-12-09";
    LocalDate localDate= LocalDate.parse(date);
    LocalDate newlocalDate= LocalDate.parse(newdate);
    ObservableList x= new ObservableListBase(localDate, "dog barks", false);

    @Test
    public void getItem() {

        // actual and expected a name for the item

    }

    @Test
    void addItem(){
        // add the item into the list
        //add a new item to the items array list
        // print the list
    }

    @Test
    void deleteItem(){
        // Set up the items and delete for one of them
        // print out the list to see if it was deleted
        //delete  item fromt the items array list
    }

    @Test
    public void getDescription(){
        // for loop until 100 items
        // actual and expected a name for the description
        //print description
        //
    }

    @Test
    void editDescription(){
        // input a new description for the item
        // test to see if it replaces the new with the old one
    }

}

