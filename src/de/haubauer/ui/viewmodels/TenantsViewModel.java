package src.de.haubauer.ui.viewmodels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import src.de.haubauer.business.models.Person;

public class TenantsViewModel {
    private ObservableList<Person> tenants = FXCollections.observableArrayList();

    public ObservableList<Person> getTenants() {
        return tenants;
    }
}
