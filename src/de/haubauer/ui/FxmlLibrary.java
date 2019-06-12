package de.haubauer.ui;

import de.haubauer.business.Payments;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import de.haubauer.business.models.Person;
import de.haubauer.ui.controllers.tenants.TenantsAddController;
import de.haubauer.ui.controllers.tenants.TenantsEditController;

import java.io.IOException;

/**
 * Eine Library zum einfachen Laden von fxmls.
 */
public class FxmlLibrary {
    /**
     * Holt sich die Root-Ansicht.
     * @return Der Container der Root-Ansicht.
     */
    public static Parent getRoot() throws IOException {
        return getDashboard();
    }

    /**
     * Holt sich das Dashboard.
     * @return Der Container des Dashboards.
     */
    public static Parent getDashboard() throws IOException {
        return FXMLLoader.load(FxmlLibrary.class.getResource("fxml/dashboard.fxml"));
    }

    /**
     * Holt sich die Übersicht der Mieterstammdaten.
     * @return Der Container der Mieterstammdaten.
     */
    public static Parent getTenantsList() throws IOException {
        return FXMLLoader.load(FxmlLibrary.class.getResource("fxml/tenants/tenants.fxml"));
    }

    /**
     * Holt sich die "Mieterstammdaten bearbeiten"-View.
     * @param tenant Der Mieter, dessen Stammdaten bearbeitet werden sollen.
     * @return Der Container der Bearbeitungsansicht.
     */
    public static Parent getTenantsEditDialog(final Person tenant) throws IOException {
        FXMLLoader loader = new FXMLLoader(FxmlLibrary.class.getResource("fxml/tenants/edit.fxml"));
        loader.setController(new TenantsEditController(tenant));

        return loader.load();
    }

    /**
     * Holt sich die "Mieterstammdatensatz anlegen"-View.
     * @return Der Container der Anlegungssicht.
     */
    public static Parent getTenantsAddDialog() throws IOException {
        FXMLLoader loader = new FXMLLoader(FxmlLibrary.class.getResource("fxml/tenants/edit.fxml"));
        loader.setController(new TenantsAddController());

        return loader.load();
    }

    public static Parent getPayments() throws IOException {
        return FXMLLoader.load(FxmlLibrary.class.getResource("fxml/rentalproperties/payments.fxml"));
    }

    public static Parent editPayments(final Payments payments) throws IOException {
        return FXMLLoader.load(FxmlLibrary.class.getResource("fxml/rentalproperties/payments-edit.fxml"));
    }

    public static Parent addPayments() throws IOException {
        return FXMLLoader.load(FxmlLibrary.class.getResource("fxml/rentalproperties/payments-add.fxml"));
    }
}
