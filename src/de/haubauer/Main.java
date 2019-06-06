package src.de.haubauer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.de.haubauer.ui.FxmlLibrary;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("HausBauer");

        primaryStage.setScene(new Scene(FxmlLibrary.getRoot(), 1000, 800));
        primaryStage.show();
    }
}
