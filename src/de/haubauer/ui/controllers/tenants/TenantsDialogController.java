package src.de.haubauer.ui.controllers.tenants;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import src.de.haubauer.business.models.Address;
import src.de.haubauer.business.models.BankAccount;
import src.de.haubauer.business.models.Person;
import src.de.haubauer.business.services.PersonService;
import src.de.haubauer.ui.viewmodels.TenantsDialogViewModel;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public abstract class TenantsDialogController implements Initializable {
    protected PersonService service = new PersonService();
    protected TenantsDialogViewModel viewModel = new TenantsDialogViewModel();

    @FXML
    private Label title;

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

    public TenantsDialogController(String title) {
        this.viewModel.setTitle(title);
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

    public abstract void save();
}
