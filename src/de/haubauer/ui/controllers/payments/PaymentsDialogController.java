package de.haubauer.ui.controllers.payments;

import de.haubauer.business.models.Payment;
import de.haubauer.business.models.PaymentType;
import de.haubauer.business.services.PaymentService;
import de.haubauer.ui.viewmodels.PaymentsDialogViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.converter.BigDecimalStringConverter;
import javafx.util.converter.DateStringConverter;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public abstract class PaymentsDialogController implements Initializable {

    protected PaymentService service = new PaymentService();
    protected PaymentsDialogViewModel viewModel = new PaymentsDialogViewModel();

    //TextFields
    @FXML
    private TextField payETenantTextField;

    @FXML
    private TextField payEDateTextField;

    @FXML
    private TextField payEAmountTextField;

    @FXML
    private TextField payENoteTextField;

    @FXML
    private ComboBox<PaymentType> payEPaymentTypeComboBox;

    public PaymentsDialogController(final Payment payment) {
        this.viewModel.setPayment(payment);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.viewModel.getAvailablePaymentTypes().addAll(this.service.getPaymentTypes());

        payEPaymentTypeComboBox.setItems(this.viewModel.getAvailablePaymentTypes());
        this.payETenantTextField.setText(this.viewModel.getPayment().getTenancy().getPerson().getFullName());
        this.payEAmountTextField.textProperty().bindBidirectional(this.viewModel.getPayment().valueProperty(), new BigDecimalStringConverter());
        this.payEDateTextField.textProperty().bindBidirectional(this.viewModel.getPayment().dateProperty(), new DateStringConverter());
        this.payENoteTextField.textProperty().bindBidirectional(this.viewModel.getPayment().commentProperty());
    }

    @FXML
    public abstract void save();
}
