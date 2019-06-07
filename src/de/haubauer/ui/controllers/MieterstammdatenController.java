package src.de.haubauer.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MieterstammdatenController {

    @FXML
    public void onAddClicked(ActionEvent event)
    {

    }

    @FXML
    public void onEditClicked(ActionEvent event)
    {

    }

    @FXML
    public void onDeleteClicked(ActionEvent event)
    {

    }

    @FXML
    public void onZahlungseingangClicked(ActionEvent event)
    {

    }

    @FXML
    public void onReportsClicked(ActionEvent event)
    {

    }
    @FXML
    public void onDashboardClicked(ActionEvent actionEvent) {
        SceneController.getInstance().activate("Dashboard");
    }
}
