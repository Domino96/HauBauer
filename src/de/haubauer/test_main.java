package de.haubauer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import de.haubauer.db.BaseDao;
import de.haubauer.db.TestDataGenerator;
import de.haubauer.db.entities.RentalProperty;
import de.haubauer.db.entities.User;

import java.io.IOException;

public class test_main extends Application {
    private static final String startFxml = "ui/fxml/rentalproperties/rental-properties.fxml";

    /*public static void main(String[] args) {
        BaseDao<RentalProperty> rentalPropertyBaseDao = new BaseDao<RentalProperty>(RentalProperty.class);

        TestDataGenerator testDataGenerator = new TestDataGenerator();

        rentalPropertyBaseDao.save(testDataGenerator.generateRental(10));


    }*/

    @Override
    public void start(Stage primaryStage) throws IOException {
        BaseDao.initialize();
        Parent root = FXMLLoader.load(getClass().getResource(startFxml));
        primaryStage.setTitle("HausBauer");

        primaryStage.setScene(new Scene(root, 600, 480));
        primaryStage.show();
    }

    public static class main {
    }
}

