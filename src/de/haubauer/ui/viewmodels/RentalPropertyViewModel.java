package de.haubauer.ui.viewmodels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import de.haubauer.business.models.RentalProperty;

public class RentalPropertyViewModel {
    private ObservableList<RentalProperty> rentalProperties = FXCollections.observableArrayList();
    private ObservableList<RentalProperty> selectedRentalPropertys;

    public ObservableList<RentalProperty> getRentalProperties() {
        return rentalProperties;
    }

    public ObservableList<RentalProperty> getSelectedRentalPropertys() {
        return selectedRentalPropertys;
    }

    public void setSelectedRentalPropertys(ObservableList<RentalProperty> selectedRentalPropertys) {
        this.selectedRentalPropertys = selectedRentalPropertys;
    }
}
