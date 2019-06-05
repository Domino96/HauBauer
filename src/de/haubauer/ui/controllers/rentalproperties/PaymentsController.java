package src.de.haubauer.ui.controllers.rentalproperties;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentsController extends Stage implements Initializable {
    //Buttons
    @FXML
    private Button paymentsEditButton;

    @FXML
    private Button paymentsSaveButton;

    @FXML
    private Button paymentsNewButton;

    @FXML
    private Button paymentsDeleteButton;





    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    public void editPayments(ActionEvent event) throws Exception
    {
        //
        Parent payments;
        try {
            payments = FXMLLoader.load(getClass().getResource("../../fxml/rentalproperties/payments-edit.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Zahlungen bearbeiten");
            stage.setScene(new Scene(payments, 450, 450));
            stage.show();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void newPayments(ActionEvent event) throws Exception {
        Parent payments;
        try {
            payments = FXMLLoader.load(getClass().getResource("../../fxml/rentalproperties/payments-add.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Zahlungen hinzufügen");
            stage.setScene(new Scene(payments, 450, 450));
            stage.show();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void deletePayments(ActionEvent event) throws Exception {
    }


}
