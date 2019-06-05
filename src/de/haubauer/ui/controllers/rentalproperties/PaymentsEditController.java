package src.de.haubauer.ui.controllers.rentalproperties;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PaymentsEditController implements Initializable {
    //Buttons
    @FXML
    private Button payESaveButton;

    //TextFields
    @FXML
    private TextField payETenantTextField;

    @FXML
    private TextField payEDateTextField;

    @FXML
    private TextField payEAmountTextField;

    @FXML
    private TextField payENoteTextField;

    //ComboBox
    @FXML
    private ComboBox<String> payEPaymentTypeComboBox;

    //Label
    @FXML
    private Label payEIdLabel;

    ObservableList<String> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.add("Hello");
        list.add("New");
        list.add("World");

        payEPaymentTypeComboBox.setItems(list);
    }
}
