package src.de.haubauer.ui.controllers.rentalproperties;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PaymentsAddController implements Initializable {

    //Buttons
    @FXML
    private Button payASaveButton;

    //TextFields
    @FXML
    private TextField payATenantTextField;

    @FXML
    private TextField payADateTextField;

    @FXML
    private TextField payAAmountTextField;

    @FXML
    private TextField payANoteTextField;

    //ComboBox
    @FXML
    private ComboBox payAPaymentTypeComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
