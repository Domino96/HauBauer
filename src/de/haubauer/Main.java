package src.de.haubauer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static final String startFxml = "ui/fxml/rentalproperties/payments.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(startFxml));
        primaryStage.setTitle("HausBauer");

        primaryStage.setScene(new Scene(root, 600, 480));
        primaryStage.show();
    }
}
