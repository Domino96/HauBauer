package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MietobjektController {

    @FXML
    public void onAddClicked(ActionEvent actionEvent) {
    }
    @FXML
    public void onEditClicked(ActionEvent actionEvent) {
    }
    @FXML
    public void onDeleteClicked(ActionEvent actionEvent) {
    }
    @FXML
    public void onZahlungseingangClicked(ActionEvent actionEvent) {
    }
    @FXML
    public void onReportsClicked(ActionEvent actionEvent) {
    }
    @FXML
    public void onDashboardClicked(ActionEvent actionEvent) {
        SceneController.getInstance().activate("Dashboard");
    }
}
