package de.haubauer.ui.controllers.tenants;

import javafx.fxml.FXML;

public class TenantsAddController extends TenantsDialogController {
    public TenantsAddController() {
        super("Mietstammdatensatz hinzufügen");
    }

    @FXML
    public void save() {
        this.service.saveTenant(this.viewModel.getTenant());

        this.getStage().close();
    }
}
