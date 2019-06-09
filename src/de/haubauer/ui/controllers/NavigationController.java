package de.haubauer.ui.controllers;

import de.haubauer.ui.FxmlLibrary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class NavigationController {
    @FXML
    private void onDashboardClicked(ActionEvent event) throws IOException {
        SceneController.getInstance().activate(FxmlLibrary.getDashboard());
    }

    @FXML
    private void onRentalPropertiesListClicked(ActionEvent event) throws IOException {
        SceneController.getInstance().activate(FxmlLibrary.getRentalPropertiesList());
    }

    @FXML
    private void onTenantsListClicked(ActionEvent event) throws IOException {
        SceneController.getInstance().activate(FxmlLibrary.getTenantsList());
    }
}
