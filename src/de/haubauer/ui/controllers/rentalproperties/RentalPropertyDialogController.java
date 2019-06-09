package de.haubauer.ui.controllers.rentalproperties;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import de.haubauer.business.services.RentalPropertyService;
import de.haubauer.ui.viewmodels.RentalPropertyDialogViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class RentalPropertyDialogController implements Initializable {
    protected RentalPropertyService service = new RentalPropertyService();
    protected RentalPropertyDialogViewModel viewModel = new RentalPropertyDialogViewModel();

    @FXML
    private Label title;

    public RentalPropertyDialogController(String title) {
        this.viewModel.setTitle(title);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.title.textProperty().bind(this.viewModel.titleProperty());
    }

    public abstract void save();
}
