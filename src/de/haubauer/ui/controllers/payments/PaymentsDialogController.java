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
import java.util.ResourceBundle;

public abstract class PaymentsDialogController implements Initializable {

    protected PaymentService service = new PaymentService();
    protected PaymentsDialogViewModel viewModel = new PaymentsDialogViewModel();

    //TextFields
    @FXML
    private TextField tenantTextField;

    @FXML
    private TextField dateTextField;

    @FXML
    private TextField valueTextField;

    @FXML
    private TextField commentTextField;

    @FXML
    private ComboBox<PaymentType> paymentTypeComboBox;

    public PaymentsDialogController(final Payment payment) {
        this.viewModel.setPayment(payment);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.viewModel.getAvailablePaymentTypes().addAll(this.service.getPaymentTypes());

        this.paymentTypeComboBox.setItems(this.viewModel.getAvailablePaymentTypes());
        // The tenant text field should ideally auto-complete possible tenants, but this functionality is not implemented,
        // so it just displays the current tenant's name, if it exists. Any changes to the field are disregarded.

        if (this.viewModel.getPayment().getTenancy() != null && this.viewModel.getPayment().getTenancy().getPerson() != null) {
            this.tenantTextField.setText(this.viewModel.getPayment().getTenancy().getPerson().getFullName());
        }

        this.valueTextField.textProperty().bindBidirectional(this.viewModel.getPayment().valueProperty(), new BigDecimalStringConverter());
        this.dateTextField.textProperty().bindBidirectional(this.viewModel.getPayment().dateProperty(), new DateStringConverter());
        this.commentTextField.textProperty().bindBidirectional(this.viewModel.getPayment().commentProperty());
    }

    @FXML
    public abstract void save();
}
