package src.de.haubauer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.de.haubauer.ui.controllers.SceneController;

import java.io.IOException;

public class Main extends Application {
    //private static final String startFxml = "ui/fxml/tenants/tenants.fxml";
    private static final String startFxml = "ui/fxml/dashboard.fxml";
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(startFxml));
        //primaryStage.setTitle("HausBauer");
        Scene scene = new Scene(root, 600, 480);

        SceneController.getInstance().setScene(scene);
        SceneController.getInstance().addScreen("Mieterstammdaten", FXMLLoader.load(getClass().getResource("ui/fxml/rentalproperties/rental-properties.fxml")));
        SceneController.getInstance().addScreen("Mietobjekt",FXMLLoader.load(getClass().getResource("ui/fxml/tenants/tenants.fxml")));
        SceneController.getInstance().addScreen("Dashboard",FXMLLoader.load(getClass().getResource("ui/fxml/dashboard.fxml")));
        SceneController.getInstance().addScreen("login",FXMLLoader.load(getClass().getResource("ui/fxml/login.fxml")));


        primaryStage.setTitle("Dashboard - Willkommen");
        primaryStage.setWidth(1200);
        primaryStage.setHeight(750);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
