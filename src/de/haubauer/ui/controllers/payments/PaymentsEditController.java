package de.haubauer.ui.controllers.payments;

import de.haubauer.business.models.Payment;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PaymentsEditController extends PaymentsDialogController implements Initializable {
    @FXML
    private Label paymentIdLabel;

    public PaymentsEditController(final Payment payment) {
        super(payment);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);

        this.paymentIdLabel.setText(String.valueOf(this.viewModel.getPayment().getId()));
    }

    @Override
    public void save() {
        this.service.updatePayment(this.viewModel.getPayment());
    }
}
