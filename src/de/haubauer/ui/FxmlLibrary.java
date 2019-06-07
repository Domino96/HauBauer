package de.haubauer.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import de.haubauer.business.models.Person;
import de.haubauer.ui.controllers.tenants.TenantsAddController;
import de.haubauer.ui.controllers.tenants.TenantsEditController;

import java.io.IOException;

public class FxmlLibrary {
    public static Parent getRoot() throws IOException {
        return getTenantsList();
    }

    public static Parent getDashboard() throws IOException {
        return FXMLLoader.load(FxmlLibrary.class.getResource("fxml/dashboard.fxml"));
    }

    public static Parent getTenantsList() throws IOException {
        return FXMLLoader.load(FxmlLibrary.class.getResource("fxml/tenants/tenants.fxml"));
    }

    public static Parent getTenantsEditDialog(final Person tenant) throws IOException {
        FXMLLoader loader = new FXMLLoader(FxmlLibrary.class.getResource("fxml/tenants/edit.fxml"));
        loader.setController(new TenantsEditController(tenant));

        return loader.load();
    }

    public static Parent getTenantsAddDialog() throws IOException {
        FXMLLoader loader = new FXMLLoader(FxmlLibrary.class.getResource("fxml/tenants/edit.fxml"));
        loader.setController(new TenantsAddController());

        return loader.load();
    }
}
