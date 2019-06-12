package de.haubauer.ui.viewmodels;

import de.haubauer.business.models.UserRole;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import de.haubauer.business.models.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TenantsDialogViewModel {
    private StringProperty title = new SimpleStringProperty("");
    private ObjectProperty<Person> tenant = new SimpleObjectProperty<>();
    private ObservableList<UserRole> availableRoles = FXCollections.observableArrayList();

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public Person getTenant() {
        return tenant.get();
    }

    public ObjectProperty<Person> tenantProperty() {
        return tenant;
    }

    public void setTenant(Person tenant) {
        this.tenant.set(tenant);
    }

    public ObservableList<UserRole> getAvailableRoles() {
        return availableRoles;
    }

    public void setAvailableRoles(ObservableList<UserRole> availableRoles) {
        this.availableRoles = availableRoles;
    }
}
