package de.haubauer;

import de.haubauer.db.BaseDao;
import de.haubauer.db.RentalPropertyDao;
import de.haubauer.db.TestDataGenerator;
import de.haubauer.db.entities.RentalProperty;
import de.haubauer.ui.FxmlLibrary;
import de.haubauer.ui.controllers.SceneController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        BaseDao.initialize();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //generateData();
        Scene scene = new Scene(FxmlLibrary.getRoot(), 1200, 750);

        SceneController.getInstance().setScene(scene);

        primaryStage.setTitle("HausBauer – Dashboard");
        primaryStage.setWidth(1200);
        primaryStage.setHeight(750);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
