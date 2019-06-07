package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Controller  {

        public Controller()throws Exception{

    }

    @FXML
    private void onMietobjektClicked(ActionEvent event) {
        SceneController.getInstance().activate("Mieterstammdaten");
    }

    @FXML
    private void onMieterstammdatenClicked(ActionEvent event) {
        SceneController.getInstance().activate("Mieterstammdaten");
    }
}
