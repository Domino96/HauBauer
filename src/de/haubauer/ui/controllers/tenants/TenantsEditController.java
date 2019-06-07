package src.de.haubauer.ui.controllers.tenants;

public class TenantsEditController extends TenantsDialogController {
    public TenantsEditController() {
        super("Mietstammdatensatz bearbeiten");
    }

    public void save() {
        this.service.updateTenant(this.viewModel.getTenant());
    }
}
