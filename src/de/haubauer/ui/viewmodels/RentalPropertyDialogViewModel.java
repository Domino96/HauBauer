package de.haubauer.ui.viewmodels;

import de.haubauer.business.models.RentalType;
import de.haubauer.business.models.UsageType;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import de.haubauer.business.models.RentalProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RentalPropertyDialogViewModel {
    private StringProperty title = new SimpleStringProperty("");
    private ObjectProperty<RentalProperty> rentalProperty = new SimpleObjectProperty<>(new RentalProperty());
    public ObservableList<RentalType> availableRentalTypes = FXCollections.observableArrayList();
    public ObservableList<UsageType> availableUsageTypes = FXCollections.observableArrayList();

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public RentalProperty getRentalProperty() {
        return rentalProperty.get();
    }

    public ObjectProperty<RentalProperty> rentalPropertyProperty() {
        return rentalProperty;
    }

    public void setAvailableRentalTypes(ObservableList<RentalType> availableRentalTypes) {
        this.availableRentalTypes = availableRentalTypes;
    }

    public ObservableList<UsageType> getAvailableUsageTypes() {
        return availableUsageTypes;
    }

    public void setAvailableUsageTypes(ObservableList<UsageType> availableUsageTypes) {
        this.availableUsageTypes = availableUsageTypes;
    }

    public ObservableList<RentalType> getAvailableRentalTypes(){
        return availableRentalTypes;
    }

    public ObjectProperty<RentalProperty> rentalProperty() {
        return rentalProperty;
    }

    public void setRentalProperty(RentalProperty rentalProperty) {
        this.rentalProperty.set(rentalProperty);
    }
}
