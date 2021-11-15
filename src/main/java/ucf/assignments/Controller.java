/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Magdalena_Sobrino
 */

package ucf.assignments;

import java.awt.event.ActionEvent;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Window;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller implements Initializable {


    @FXML
    private TableColumn<Item, Boolean> CompleteStatus;

    @FXML
    private TableColumn<Item, String> Description;

    @FXML
    private TextField Description_Field;

    @FXML
    private TableColumn<Item, String> DueDate;

    @FXML
    private TableColumn<Item, String> Item;

    @FXML
    private TextField Item_Field;

    @FXML
    private DatePicker DueDate1;

    @FXML
    private TableView<Item> Table;

    @FXML
    private Button Help;

    @FXML
    private ComboBox<String> menu;

    @FXML
    private MenuBar File;

    @FXML
    public AnchorPane Todo;


    FileChooser fileChooser= new FileChooser();
    public ObservableList<Item> TodoList = FXCollections.observableArrayList();
    private LocalDate localDate;

    @Override
    public void initialize (URL location, ResourceBundle resources){
        Item.setCellValueFactory(new PropertyValueFactory<Item,String>("item"));
        Description.setCellValueFactory(new PropertyValueFactory<Item, String>("Description"));
        DueDate.setCellValueFactory(new PropertyValueFactory<Item,String>("DueDate"));
        CompleteStatus.setCellValueFactory(new PropertyValueFactory<>("complete"));
        menu.getItems().add("All");
        menu.getItems().add("Incomplete");
        menu.getItems().add("Complete");
        menu.setValue("All");
    }

    @FXML
    private Button Clear;

    @FXML
    private CheckBox Complete_CB;

    public CheckBox getComplete_CB() {

        return Complete_CB;
    }

    public void setComplete_CB(CheckBox complete_CB) {

        this.Complete_CB = complete_CB;
    }


    public Button getClear() {
        return Clear;
    }

    public void setClear(Button clear) {
        Clear = clear;
    }

    @FXML
    private void ErrorMessage(String title, String message){
        Alert box= new Alert((Alert.AlertType.ERROR));
        box.setTitle(title);
        box.setContentText(message);
        box.showAndWait();
    }
    @FXML
    public void Add() {

        String description= Description_Field.getText();
        String name= Item_Field.getText();

        if(name.isEmpty()) {
            ErrorMessage("Error", "Please enter a name for the item");
        }else if (description.isEmpty()){
            ErrorMessage("Error", "Please enter a description");
            return;
        } else if (description.length()>=256){
            ErrorMessage("Error","Maximum of characters reached");
            return;
        } else {
            TodoList = addHelper(Item_Field.getText(), Description_Field.getText(), DueDate1.getValue(), false);
            Table.setItems(TodoList);
            Table.refresh();
            Item item= new Item();
            item.setDescription(description);
            item.setComplete(false);
        }

        if(Table.getItems().size() >=100){
            ErrorMessage("Error","Maximum capacity reached. You cannot add any more items");
            return;
        }


    }

    @FXML
    void Delete(ActionEvent event){
        int SelectID= Table.getSelectionModel().getSelectedIndex();
        Table.getItems().remove(SelectID);
    }

    public void Delete(javafx.event.ActionEvent actionEvent) {
        Item selectedItem = Table.getSelectionModel().getSelectedItem();
        Table.getItems().remove(selectedItem);

    }

    public ObservableList<Item> addHelper(String item, String Description,LocalDate Duedate1, Boolean Complete){
        Item new_task = new Item(item, Description, DueDate1.getValue(),Complete);
        ObservableList<Item> temp= TodoList;
        temp.add(new_task);

        return temp;
    }

    public ObservableList<Item> RemoveHelper(String item, String Description,LocalDate Duedate1, Boolean Complete){
        Item new_task = new Item(item,Description, DueDate1.getValue(), Complete);
        ObservableList<Item> temp= TodoList;
        temp.remove(new_task);

        return temp;
    }

    @FXML
    void Complete_CB(ActionEvent event) {
        int index= Table.getSelectionModel().getSelectedIndex();
        if(Complete_CB.isSelected()){
            if(TodoList.get(index).ItemIsComplete()==true){
                TodoList.get(index).setComplete(false);
            }else{
                TodoList.get(index).setComplete(true);
            }
        }
        Table.refresh();
    }


    @FXML
    public void Complete_CB(){
        int index = Table.getSelectionModel().getSelectedIndex();
        if(index < 0)
            return;
        if(Table.getItems().get(index).ItemIsComplete()){
            Table.getItems().get(index).setComplete(false);
        }else {
            Table.getItems().get(index).setComplete(true);
        }
        Table.refresh();
    }


    @FXML
    void Clear(javafx.event.ActionEvent actionEvent) {
        TodoList.clear();
    }

    public TableColumn<Item, String> getDueDate() {
        return DueDate;
    }


    public void DueDate1(javafx.event.ActionEvent actionEvent) {
    }



    public void Edit(javafx.event.ActionEvent actionEvent) {
        int index= Table.getSelectionModel().getSelectedIndex();
        String modifiedDescription = Description_Field.getText();
        LocalDate modifiedDate= DueDate1.getValue();
        if(Table.getSelectionModel().getSelectedItem()==null){
            ErrorMessage("Error", "Please select an item to modify");
        }else{
            if(modifiedDescription != TodoList.get(index).getDescription()){
                TodoList.get(index).setDescription(modifiedDescription);
            }
            if(modifiedDate != TodoList.get(index).getDueDate()){
                TodoList.get(index).setDueDate(modifiedDate);
            }
        }
        Table.refresh();

    }

    public void DisplayButton(javafx.event.ActionEvent actionEvent) {
        ObservableList<Item> CurrentList = FXCollections.observableArrayList();
        if(menu.getSelectionModel().getSelectedItem().equals("Complete")){
            for(int i=0; i<TodoList.size(); i++){
                if(TodoList.get(i).ItemIsComplete()) {
                    CurrentList.add(TodoList.get(i));
                }
            }
            Table.setItems(CurrentList);
        }else if(menu.getSelectionModel().getSelectedItem().equals("Incomplete")) {
            for (int i = 0; i < TodoList.size(); i++) {
                if (TodoList.get(i).ItemIsComplete() == false) {
                    CurrentList.add(TodoList.get(i));
                }
            }
            Table.setItems(CurrentList);
        }else{
            Table.setItems(TodoList);
        }

    }
    public void SaveButton(javafx.event.ActionEvent actionEvent) {
        Window stage = Todo.getScene().getWindow();
        fileChooser.setTitle("Save To-do List");
        fileChooser.setInitialFileName("To-Do List");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));

        try{
            File file = fileChooser.showSaveDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile()); //Save the chosen directory
            FileWriter W = new FileWriter(file); //Here we are going to write
            W.write("Item:          Due_Date:        Description:         Status:");
            //Now we are going to iterate to write each value to the text file desired.
            String status = null;
            for(int i = 0; i < TodoList.size(); i++)
            {
                //If the status is true; we want to write complete and not boolean
                if(TodoList.get(i).ItemIsComplete()){
                    status = "Completed";
                }
                //Is false so is Incomplete
                else{
                    status = "Incomplete";

                }
                W.write("\n" + TodoList.get(i).getItem()+"\t\t"+ TodoList.get(i).getDueDate().toString() + "\t\t" + TodoList.get(i).getDescription() + "\t\t" + status);
            }
            W.close(); //Closing write
        }catch (Exception ex) {

        }
    }

    public void LoadButton(javafx.event.ActionEvent actionEvent) {
        Window stage = Todo.getScene().getWindow();
        fileChooser.setTitle("Save To-do List");
        fileChooser.setInitialFileName("To-Do List");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text file", "*.txt"));
        try{
            File file= fileChooser.showOpenDialog(stage);
            fileChooser.setInitialDirectory(file.getParentFile());
            FileReader reader= new FileReader(file.getPath());
            BufferedReader bs= new BufferedReader(reader);
            String line = bs.readLine();
            while((line=bs.readLine())!= null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                String item = tokenizer.nextToken();
                String DueDate = tokenizer.nextToken();
                String Description = tokenizer.nextToken();
                String status = tokenizer.nextToken();
                LocalDate date = LocalDate.parse(DueDate);
                boolean completed = false;
                if (status.toLowerCase().equals("Completed")) {
                    completed = true;
                } else {
                    completed = false;
                }
                TodoList.add(new Item (item, Description,date,completed));
            }
        }catch(Exception ex){

        }
    }

    public void HelpButton(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Help.fxml"));
        Parent root1 = fxmlLoader.load();

        Stage stage = new Stage();
        stage.setTitle("Help");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }

}

