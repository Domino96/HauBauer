package src.de.haubauer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.SceneController;

import java.io.IOException;

public class Main extends Application {
    private static final String startFxml = "ui/fxml/tenants/tenants.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(startFxml));
        primaryStage.setTitle("HausBauer");
        Scene scene = new Scene(root, 600, 480);

        SceneController.getInstance().setScene(scene);
        SceneController.getInstance().addScreen("Mieterstammdaten", FXMLLoader.load(getClass().getResource("Mieterstammdaten_Mockup.fxml")));
        SceneController.getInstance().addScreen("Mietobjekt",FXMLLoader.load(getClass().getResource("Mieterstammdaten_Mockup.fxml")));
        SceneController.getInstance().addScreen("Dashboard",FXMLLoader.load(getClass().getResource("dashboard.fxml")));

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
