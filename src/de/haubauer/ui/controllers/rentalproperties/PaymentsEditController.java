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
import src.de.haubauer.db.entities.Payment;
import src.de.haubauer.enums.PaymentType;

import java.net.URL;
import java.util.Date;
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
    private ComboBox<PaymentType> payEPaymentTypeComboBox;

    //Label
    @FXML
    private Label payEIdLabel;

    private ObservableList<PaymentType> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.add(PaymentType.Payment);
        list.add(PaymentType.SideCostStatement);

        payEPaymentTypeComboBox.setItems(list);
    }
}
