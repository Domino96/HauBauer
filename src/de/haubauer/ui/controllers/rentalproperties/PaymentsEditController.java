package de.haubauer.ui.controllers.rentalproperties;

import de.haubauer.business.models.Payment;
import de.haubauer.business.services.PaymentService;
import de.haubauer.ui.viewmodels.PaymentViewModel;
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

import de.haubauer.enums.PaymentType;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class PaymentsEditController implements Initializable {

    protected PaymentService service = new PaymentService();
    protected PaymentViewModel viewModel = new PaymentViewModel();

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

        final Payment payment = this.viewModel.getPayment();
        this.payEAmountTextField.textProperty().bindBidirectional(payment);
    }

    @FXML
    public void save() {
        this.service.updatePayment(this.viewModel.getPayment());


    }
}
