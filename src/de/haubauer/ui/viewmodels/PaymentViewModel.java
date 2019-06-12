package de.haubauer.ui.viewmodels;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import de.haubauer.business.models.Payment;



public class PaymentViewModel {
    private ObjectProperty<Payment> selectedPayment = new SimpleObjectProperty<>(new Payment());
    private ObjectProperty<Payment> payment = new SimpleObjectProperty<>(new Payment());

    public ObjectProperty<Payment> getPayment() {
        return payment;
    }

    public ObjectProperty<Payment> getSelectedPayment() {
        return selectedPayment;
    }

    public void setSelectedPayment(ObjectProperty<Payment> selectedPayment) {
        this.selectedPayment = selectedPayment;
    }
}