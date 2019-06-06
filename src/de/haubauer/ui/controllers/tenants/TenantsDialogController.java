package src.de.haubauer.ui.controllers.tenants;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import src.de.haubauer.business.services.PersonService;
import src.de.haubauer.ui.viewmodels.TenantsDialogViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class TenantsDialogController implements Initializable {
    protected PersonService service = new PersonService();
    protected TenantsDialogViewModel viewModel = new TenantsDialogViewModel();

    @FXML
    private Label title;

    public TenantsDialogController(String title) {
        this.viewModel.setTitle(title);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.title.textProperty().bind(this.viewModel.titleProperty());
    }

    public abstract void save();
}
