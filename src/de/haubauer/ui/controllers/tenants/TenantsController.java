package de.haubauer.ui.controllers.tenants;

import de.haubauer.business.models.Person;
import de.haubauer.business.services.PersonService;
import de.haubauer.ui.FxmlLibrary;
import de.haubauer.ui.viewmodels.TenantsViewModel;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class TenantsController implements Initializable {
    private TenantsViewModel viewModel = new TenantsViewModel();
    private PersonService service = new PersonService();

    @FXML
    private TableColumn<Person, String> addressColumn;

    @FXML
    private TableColumn<Person, String> bankAccountColumn;

    @FXML
    private TableColumn<Person, String> roleColumn;

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
        this.roleColumn.setCellValueFactory(cell -> Bindings.createStringBinding(() -> {
            if (cell.getValue().getRole() != null) {
                return cell.getValue().getRole().getName();
            }

            return "";
        }, cell.getValue().roleProperty()));
    }

    @FXML
    public void deleteItems() {
        if (!this.viewModel.getSelectedTenants().isEmpty()) {
            final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Sind Sie sicher?");
            alert.setHeaderText("Löschen");
            alert.setContentText("Sind Sie sicher, dass Sie die ausgewählten Mieter unwiderruflich löschen möchen?");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                this.viewModel.getTenants().removeAll(this.viewModel.getSelectedTenants());
            }
        }
    }

    @FXML
    public void addItem() throws IOException {
        final Stage dialog = new Stage();
        AtomicBoolean cancelledAdd = new AtomicBoolean(false);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Mietstammdatensatz hinzufügen");
        Person tenantToAdd = new Person();
        dialog.setScene(new Scene(FxmlLibrary.getTenantsAddDialog(tenantToAdd), 500, 700));
        dialog.setOnCloseRequest(event -> cancelledAdd.set(true));
        dialog.showAndWait();

        if (!cancelledAdd.get()) {
            this.viewModel.getTenants().add(tenantToAdd);
        }
    }

    @FXML
    public void editItem() throws IOException {
        if (this.viewModel.getSelectedTenants().size() == 1) {
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.setTitle("Mietstammdatensatz bearbeiten");
            final Person copiedTenant = new Person(this.viewModel.getSelectedTenants().get(0));
            dialog.setScene(new Scene(FxmlLibrary.getTenantsEditDialog(this.viewModel.getSelectedTenants().get(0)), 500, 700));
            dialog.setOnCloseRequest(event -> {
                this.viewModel.getSelectedTenants().get(0).roleProperty().unbind();
                this.viewModel.getSelectedTenants().get(0).copy(copiedTenant);
            });
            dialog.showAndWait();
        }
    }
}
