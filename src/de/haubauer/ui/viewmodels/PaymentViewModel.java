package src.de.haubauer.ui.viewmodels;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import src.de.haubauer.business.models.Payment;



public class PaymentViewModel {
    private ObservableList<Payment> payment = FXCollections.observableArrayList();
    private ObservableList<Payment> selectedPayment;

    public ObservableList<Payment> getPayment() {
        return payment;
    }

    public ObservableList<Payment> getSelectedPayment() {
        return selectedPayment;
    }

    public void setSelectedPayment(ObservableList<Payment> selectedPayment) {
        this.selectedPayment = selectedPayment;
    }
}