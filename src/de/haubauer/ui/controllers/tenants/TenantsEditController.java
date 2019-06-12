package de.haubauer.ui.controllers.tenants;

import de.haubauer.business.models.Person;
import javafx.fxml.FXML;

public class TenantsEditController extends TenantsDialogController {
    public TenantsEditController(final Person tenant) {
        super("Mietstammdatensatz bearbeiten", tenant);
    }

    @FXML
    public void save() {
        this.service.updateTenant(this.viewModel.getTenant());

        this.getStage().close();
    }
}
