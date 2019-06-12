package de.haubauer.ui.controllers;

import de.haubauer.business.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController extends NavigationController implements Initializable {
    @FXML
    private Label lblUserName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.lblUserName.setText(UserManager.getInstance().getLoggedInUser().getUserName());
    }
}
