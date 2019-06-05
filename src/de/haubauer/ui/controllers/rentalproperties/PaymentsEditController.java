package src.de.haubauer.ui.controllers.rentalproperties;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    private ComboBox payEPaymentTypeComboBox;

    //Label
    @FXML
    private Label payEIdLabel;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
