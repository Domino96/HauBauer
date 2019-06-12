package de.haubauer.ui.viewmodels;

import de.haubauer.business.models.Payment;
import de.haubauer.business.models.RentalProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PaymentsViewModel {
    private ObservableList<Payment> payments = FXCollections.observableArrayList();
    private ObservableList<Payment> selectedPayments;
    private ObjectProperty<RentalProperty> rentalProperty = new SimpleObjectProperty<>();

    public ObservableList<Payment> getPayments() {
        return payments;
    }

    public ObservableList<Payment> getSelectedPayments() {
        return selectedPayments;
    }

    public void setSelectedPayments(ObservableList<Payment> selectedPayments) {
        this.selectedPayments = selectedPayments;
    }

    public RentalProperty getRentalProperty() {
        return rentalProperty.get();
    }

    public ObjectProperty<RentalProperty> rentalPropertyProperty() {
        return rentalProperty;
    }

    public void setRentalProperty(RentalProperty rentalProperty) {
        this.rentalProperty.set(rentalProperty);
    }
}