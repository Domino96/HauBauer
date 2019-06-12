package de.haubauer.ui.viewmodels;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import de.haubauer.business.models.RentalProperty;

public class RentalPropertyDialogViewModel {
    private StringProperty title = new SimpleStringProperty("");
    private ObjectProperty<RentalProperty> rentalProperty = new SimpleObjectProperty<>(new RentalProperty());

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

    public ObjectProperty<RentalProperty> rentalProperty() {
        return rentalProperty;
    }

    public void setRentalProperty(RentalProperty rentalProperty) {
        this.rentalProperty.set(rentalProperty);
    }
}
