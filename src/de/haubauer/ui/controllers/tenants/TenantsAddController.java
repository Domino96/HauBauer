package de.haubauer.ui.controllers.tenants;

public class TenantsAddController extends TenantsDialogController {
    public TenantsAddController() {
        super("Mietstammdatensatz hinzufügen");
    }

    public void save() {
        this.service.saveTenant(this.viewModel.getTenant());
    }
}
