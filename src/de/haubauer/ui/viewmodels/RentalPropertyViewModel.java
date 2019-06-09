package de.haubauer.ui.viewmodels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import de.haubauer.business.models.RentalProperty;

public class RentalPropertyViewModel {
    private ObservableList<RentalProperty> rentalProperties = FXCollections.observableArrayList();

    public ObservableList<RentalProperty> getRentalProperties() {
        return rentalProperties;
    }
}
