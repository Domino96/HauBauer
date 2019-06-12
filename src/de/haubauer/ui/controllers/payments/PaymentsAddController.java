package de.haubauer.ui.controllers.payments;

import de.haubauer.business.models.Payment;

public class PaymentsAddController extends PaymentsDialogController {
    public PaymentsAddController(final Payment payment) {
        super(payment);
    }

    @Override
    public void save() {
        this.service.savePayment(this.viewModel.getPayment());
    }
}