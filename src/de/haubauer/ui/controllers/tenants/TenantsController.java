package src.de.haubauer.ui.controllers.tenants;

import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import src.de.haubauer.business.models.Person;
import src.de.haubauer.business.services.PersonService;
import src.de.haubauer.ui.FxmlLibrary;
import src.de.haubauer.ui.viewmodels.TenantsViewModel;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class TenantsController implements Initializable {
    private TenantsViewModel viewModel = new TenantsViewModel();
    private PersonService service = new PersonService();

    @FXML
    private TableColumn<Person, String> addressColumn;

    @FXML
    private TableColumn<Person, String> bankAccountColumn;

    @FXML
    private TableView<Person> tableView;

    public void initialize(URL location, ResourceBundle resources) {
        this.service.getAllTenants().forEach(p -> this.viewModel.getTenants().add(p));

        this.tableView.setItems(this.viewModel.getTenants());
        this.tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.viewModel.setSelectedTenants(this.tableView.getSelectionModel().getSelectedItems());

        // create bindings from getters
        this.addressColumn.setCellValueFactory(cell -> Bindings.createStringBinding(() -> cell.getValue().getAddressString(), cell.getValue().getAddresses()));
        this.bankAccountColumn.setCellValueFactory(cell -> Bindings.createStringBinding(() -> cell.getValue().getBankAccountString(), cell.getValue().getBankAccount().bicProperty()));
    }

    public void deleteItems() {
        final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sind Sie sicher?");
        alert.setHeaderText("Löschen");
        alert.setContentText("Sind Sie sicher, dass Sie die ausgewählten Mieter unwiderruflich löschen möchen?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            this.viewModel.getTenants().removeAll(this.viewModel.getSelectedTenants());
        }
    }

    public void addItem() throws IOException {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Mietstammdatensatz hinzufügen");
        dialog.setScene(new Scene(FxmlLibrary.getTenantsAddDialog(), 500, 700));
        dialog.show();
    }

    public void editItem() throws IOException {
        if (this.viewModel.getSelectedTenants().size() == 1) {
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.setTitle("Mietstammdatensatz bearbeiten");
            dialog.setScene(new Scene(FxmlLibrary.getTenantsEditDialog(this.viewModel.getSelectedTenants().get(0)), 500, 700));
            dialog.show();
        }
    }
}
