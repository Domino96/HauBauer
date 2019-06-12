package de.haubauer.ui.controllers.tenants;

import de.haubauer.business.models.Address;
import de.haubauer.business.models.BankAccount;
import de.haubauer.business.models.Person;
import de.haubauer.business.models.UserRole;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import de.haubauer.business.services.PersonService;
import de.haubauer.ui.viewmodels.TenantsDialogViewModel;
import javafx.stage.Stage;

import java.net.URL;
import java.text.NumberFormat;
import java.util.Observable;
import java.util.ResourceBundle;

public abstract class TenantsDialogController implements Initializable {
    protected PersonService service = new PersonService();
    protected TenantsDialogViewModel viewModel = new TenantsDialogViewModel();

    @FXML
    private Label title;

    @FXML
    private ComboBox<UserRole> roleComboBox;

    @FXML
    private TextField titleField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField streetField;

    @FXML
    private TextField landlineField;

    @FXML
    private TextField mobileField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField houseNumberField;

    @FXML
    private TextField zipCodeField;

    @FXML
    private TextField townField;

    @FXML
    private TextField ibanField;

    @FXML
    private TextField bicField;

    @FXML
    private TextField accountOwnerField;

    @FXML
    private TextField bankField;

    private ObservableList<UserRole> availableRoles = FXCollections.observableArrayList();

    protected Stage getStage() {
        return (Stage) this.title.getScene().getWindow();
    }

    public TenantsDialogController(String title, Person tenant) {
        this.viewModel.setTitle(title);
        this.viewModel.setTenant(tenant);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.title.textProperty().bind(this.viewModel.titleProperty());

        final Person tenant = this.viewModel.getTenant();
        this.titleField.textProperty().bindBidirectional(tenant.titleProperty());
        this.firstNameField.textProperty().bindBidirectional(tenant.firstNameProperty());
        this.lastNameField.textProperty().bindBidirectional(tenant.lastNameProperty());
        this.landlineField.textProperty().bindBidirectional(tenant.landlineProperty());
        this.mobileField.textProperty().bindBidirectional(tenant.mobileProperty());
        this.emailField.textProperty().bindBidirectional(tenant.emailProperty());

        this.availableRoles.addAll(this.service.getAvailableRoles());
        this.roleComboBox.setItems(this.availableRoles);
        this.roleComboBox.setConverter(new UserRole.StringConverter());

        if (this.viewModel.getTenant().getRole() != null) {
            this.roleComboBox.getSelectionModel().select(this.viewModel.getTenant().getRole());
        }

        this.viewModel.getTenant().roleProperty().bind(this.roleComboBox.getSelectionModel().selectedItemProperty());

        final SortedList<Address> sortedAddresses = tenant.getAddresses().sorted();
        Address lastAddress;

        if (tenant.getAddresses().isEmpty()) {
            lastAddress = new Address();

            tenant.getAddresses().add(lastAddress);
        } else {
            lastAddress = sortedAddresses.get(sortedAddresses.size() - 1).clone();
        }

        this.streetField.textProperty().bindBidirectional(lastAddress.streetProperty());
        this.houseNumberField.textProperty().bindBidirectional(lastAddress.numberProperty(), NumberFormat.getIntegerInstance());
        this.townField.textProperty().bindBidirectional(lastAddress.townProperty());
        this.zipCodeField.textProperty().bindBidirectional(lastAddress.zipCodeProperty(), NumberFormat.getIntegerInstance());

        if (tenant.getBankAccount() == null) {
            tenant.setBankAccount(new BankAccount());
        }

        this.ibanField.textProperty().bindBidirectional(tenant.getBankAccount().ibanProperty());
        this.bicField.textProperty().bindBidirectional(tenant.getBankAccount().bicProperty());
        this.accountOwnerField.textProperty().bindBidirectional(tenant.getBankAccount().ownerProperty());
        this.bankField.textProperty().bindBidirectional(tenant.getBankAccount().bankProperty());
    }

    @FXML
    public abstract void save();
}
