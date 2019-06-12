package de.haubauer.ui.controllers.rentalproperties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import de.haubauer.enums.PaymentType;

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
    private ComboBox<PaymentType> payAPaymentTypeComboBox;

    private ObservableList<PaymentType> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.add(PaymentType.Payment);
        list.add(PaymentType.SideCostStatement);

        payAPaymentTypeComboBox.setItems(list);
    }

    private void checkFieldvalues(ActionEvent e)
    {
        String tenantName   =   payATenantTextField.getText();


    }
}
