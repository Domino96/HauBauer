package de.haubauer.ui.controllers.tenants;

import de.haubauer.business.models.Person;

public class TenantsEditController extends TenantsDialogController {
    public TenantsEditController(final Person tenant) {
        super("Mietstammdatensatz bearbeiten");

        this.viewModel.setTenant(tenant);
    }

    public void save() {
        this.service.updateTenant(this.viewModel.getTenant());
    }
}
