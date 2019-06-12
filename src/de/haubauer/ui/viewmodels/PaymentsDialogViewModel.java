package de.haubauer.ui.viewmodels;

import de.haubauer.business.models.Payment;
import de.haubauer.business.models.PaymentType;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PaymentsDialogViewModel {
    private ObjectProperty<Payment> payment = new SimpleObjectProperty<>();
    private ObservableList<PaymentType> availablePaymentTypes = FXCollections.observableArrayList();

    public ObservableList<PaymentType> getAvailablePaymentTypes() {
        return availablePaymentTypes;
    }

    public void setAvailablePaymentTypes(ObservableList<PaymentType> availablePaymentTypes) {
        this.availablePaymentTypes = availablePaymentTypes;
    }

    public Payment getPayment() {
        return payment.get();
    }

    public ObjectProperty<Payment> paymentProperty() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment.set(payment);
    }
}
