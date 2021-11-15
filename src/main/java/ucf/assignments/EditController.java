/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Magdalena_Sobrino
 */


package ucf.assignments;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.ErrorManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class EditController implements Initializable {

    @FXML
    private TextField Description_Field;
    @FXML
    DatePicker itemDate;
    @FXML
    Item item;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // create a list of Item objects

    }

    @FXML

    public int itemDescription(String Description) {
        if (Description.isEmpty()) {
            return 0;
        }
        if (Description.length() > 256) {
            return -1;
        }
        return 1;
    }


    public String DueDateGet(LocalDate localDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD", Locale.getDefault());
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        java.util.Date date = java.sql.Date.from(instant);
        String due_date = dateFormat.format(date);
        return due_date;
    }


    @FXML
    public void saveItem() {
        String description = Description_Field.getText().trim();
        if (itemDescription(description) == 0) {
            ErrorMessage("Error", "Please enter a description.");
            return;
        }

        if (itemDescription((description)) == -1) {
            ErrorMessage("Error", "Maximum of characters reached.");
            return;
        }

        LocalDate localDate = itemDate.getValue();

        String Due_Date = DueDateGet(localDate);

        item.setDescription(description);
        item.setDueDate(localDate);

        Stage stage = (Stage) itemDate.getScene().getWindow();

    }

    private void ErrorMessage(String title, String message) {
        Alert box = new Alert((Alert.AlertType.ERROR));
        box.setTitle(title);
        box.setContentText(message);
        box.showAndWait();
    }
}







