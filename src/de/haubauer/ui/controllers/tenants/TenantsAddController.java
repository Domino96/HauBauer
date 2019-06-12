package de.haubauer.ui.controllers.tenants;

import de.haubauer.business.models.Person;
import javafx.fxml.FXML;

public class TenantsAddController extends TenantsDialogController {
    public TenantsAddController(final Person tenant) {
        super("Mietstammdatensatz hinzufügen", tenant);
    }

    @FXML
    public void save() {
        this.service.saveTenant(this.viewModel.getTenant());

        this.getStage().close();
    }
}
