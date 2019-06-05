package src.de.haubauer.ui.controllers.tenants;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import src.de.haubauer.business.models.Person;
import src.de.haubauer.business.services.PersonService;
import src.de.haubauer.ui.viewmodels.TenantsViewModel;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class TenantsController implements Initializable {
    private TenantsViewModel viewModel = new TenantsViewModel();
    private PersonService service = new PersonService();

    @FXML
    private TableColumn<Person, String> titleColumn;

    @FXML
    private TableColumn<Person, String> firstNameColumn;

    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private TableColumn<Person, String> addressColumn;

    @FXML
    private TableColumn<Person, String> landlineColumn;

    @FXML
    private TableColumn<Person, String> mobileColumn;

    @FXML
    private TableColumn<Person, String> emailColumn;

    @FXML
    private TableColumn<Person, String> bankAccountColumn;

    @FXML
    private TableView<Person> tableView;

    public void initialize(URL location, ResourceBundle resources) {
        this.service.getAllTenants().forEach(p -> this.viewModel.getTenants().add(p));

        this.tableView.setItems(this.viewModel.getTenants());
        this.titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        this.firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        this.lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        this.landlineColumn.setCellValueFactory(new PropertyValueFactory<>("landline"));
        this.emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        // this.bankAccountColumn.setCellValueFactory(new PropertyValueFactory<>("bankAccount"));

        // selecting multiple table view items with SHIFT or STRG
        tableView.setOnMouseClicked(event -> tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE));
    }

    public void deleteItems() {
        final ObservableList<Person> itemsToDelete = tableView.getSelectionModel().getSelectedItems();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sind Sie sicher?");
        alert.setHeaderText("Löschen");
        alert.setContentText("Sind Sie sicher, dass sie die ausgewählten Mieter unwiderruflich löschen möchen?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            tableView.getItems().removeAll(itemsToDelete);
        }
    }
}
