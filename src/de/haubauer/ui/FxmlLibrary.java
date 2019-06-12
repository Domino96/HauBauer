package src.de.haubauer.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import src.de.haubauer.business.models.Person;
import src.de.haubauer.ui.controllers.tenants.TenantsAddController;
import src.de.haubauer.ui.controllers.tenants.TenantsEditController;

import java.io.IOException;

public class FxmlLibrary {
    public static Parent getRoot() throws IOException {
        return getPayments();
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

    public static Parent getPayments() throws IOException {
        return FXMLLoader.load(FxmlLibrary.class.getResource("fxml/rentalproperties/payments.fxml"));
    }

    public static Parent editPayments() throws IOException {
        return FXMLLoader.load(FxmlLibrary.class.getResource("fxml/rentalproperties/payments-edit.fxml"));
    }

    public static Parent addPayments() throws IOException {
        return FXMLLoader.load(FxmlLibrary.class.getResource("fxml/rentalproperties/payments-add.fxml"));
    }
}
