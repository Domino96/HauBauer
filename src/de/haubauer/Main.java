package de.haubauer;

import de.haubauer.db.BaseDao;
import de.haubauer.db.RentalPropertyDao;
import de.haubauer.db.TestDataGenerator;
import de.haubauer.db.entities.RentalProperty;
import de.haubauer.db.entities.RentalType;
import de.haubauer.db.entities.UsageType;
import de.haubauer.ui.FxmlLibrary;
import de.haubauer.ui.controllers.SceneController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    //private static final String startFxml = "ui/fxml/rentalproperties/payments.fxml";

    public static void main(String[] args) {
        BaseDao.initialize();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        generateData();
        Scene scene = new Scene(FxmlLibrary.getRoot(), 1200, 750);

        SceneController.getInstance().setScene(scene);

        primaryStage.setTitle("HausBauer – Dashboard");
        primaryStage.setWidth(1200);
        primaryStage.setHeight(750);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generateData(){
        TestDataGenerator testDataGenerator = new TestDataGenerator();

        BaseDao<RentalProperty> rentalPropertyBaseDao = new BaseDao<>(RentalProperty.class);
        BaseDao<UsageType> usageTypeBaseDao = new BaseDao<>(UsageType.class);
        BaseDao<RentalType> rentalTypeBaseDao = new BaseDao<>(RentalType.class);

        //rentalPropertyBaseDao.save(testDataGenerator.generateRental(10));
        usageTypeBaseDao.save(testDataGenerator.generateUsageType());
        rentalTypeBaseDao.save(testDataGenerator.generateRentalTypes());
    }
}
