package de.haubauer.ui.viewmodels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import de.haubauer.business.models.RentalProperty;


public class RentalPropertyViewModel {
    private ObservableList<RentalProperty> rentalProperties = FXCollections.observableArrayList();
    private ObservableList<RentalProperty> selectedRentalProperties;

    public ObservableList<RentalProperty> getRentalProperties() {
        return rentalProperties;
    }

    public ObservableList<RentalProperty> getSelectedRentalProperties() {
        return selectedRentalProperties;
    }

    public void setSelectedRentalProperties(ObservableList<RentalProperty> selectedRentalProperties) {
        this.selectedRentalProperties = selectedRentalProperties;
    }
}
