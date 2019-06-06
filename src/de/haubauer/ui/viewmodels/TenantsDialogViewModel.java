package src.de.haubauer.ui.viewmodels;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import src.de.haubauer.business.models.Person;

public class TenantsDialogViewModel {
    private StringProperty title = new SimpleStringProperty("");
    private ObjectProperty<Person> tenant = new SimpleObjectProperty<>(new Person());

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
}
