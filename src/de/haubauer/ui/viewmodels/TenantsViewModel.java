package de.haubauer.ui.viewmodels;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import de.haubauer.business.models.Person;

public class TenantsViewModel {
    private ObservableList<Person> tenants = FXCollections.observableArrayList();
    private ObservableList<Person> selectedTenants;

    public ObservableList<Person> getTenants() {
        return tenants;
    }

    public ObservableList<Person> getSelectedTenants() {
        return selectedTenants;
    }

    public void setSelectedTenants(ObservableList<Person> selectedTenants) {
        this.selectedTenants = selectedTenants;
    }
}
