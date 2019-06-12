package de.haubauer.ui.viewmodels;

<<<<<<< HEAD
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import de.haubauer.business.models.RentalProperty;


public class RentalPropertyViewModel {
    private ObservableList<RentalProperty> rentalProperty = FXCollections.observableArrayList();
    private ObservableList<RentalProperty> selectedRentalProperty;

    public ObservableList<RentalProperty> getRentalProperty() {
        return rentalProperty;
    }

    public ObservableList<RentalProperty> getSelectedRentalProperty() {
        return selectedRentalProperty;
    }

    public void setSelectedRentalProperty(ObservableList<RentalProperty> selectedRentalProperty) {
        this.selectedRentalProperty = selectedRentalProperty;
=======
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import de.haubauer.business.models.RentalProperty;

public class RentalPropertyViewModel {
    private ObservableList<RentalProperty> rentalProperties = FXCollections.observableArrayList();

    public ObservableList<RentalProperty> getRentalProperties() {
        return rentalProperties;
>>>>>>> master
    }
}
