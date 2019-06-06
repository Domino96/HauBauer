package src.de.haubauer.ui.controllers.tenants;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import src.de.haubauer.ui.viewmodels.TenantsDialogViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class TenantsEditController implements Initializable {
    private TenantsDialogViewModel viewModel = new TenantsDialogViewModel();

    @FXML
    private Label title;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.viewModel.setTitle("Mietstammdatensatz bearbeiten");

        this.title.textProperty().bind(this.viewModel.titleProperty());
    }
}
