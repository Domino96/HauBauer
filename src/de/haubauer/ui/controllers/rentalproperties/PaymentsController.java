package de.haubauer.ui.controllers.rentalproperties;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import de.haubauer.business.models.Payment;
import de.haubauer.business.services.PaymentService;
import de.haubauer.ui.viewmodels.PaymentViewModel;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class PaymentsController extends Stage implements Initializable {

    private PaymentViewModel viewModel = new PaymentViewModel();
    private PaymentService service = new PaymentService();

    @FXML
    private Button paymentsEditButton;

    @FXML
    private Button paymentsSaveButton;

    @FXML
    private Button paymentsNewButton;

    @FXML
    private Button paymentsDeleteButton;

    @FXML
    private TableView<Payment> tableView;

    @FXML
    private Label paymentsObjectIdLabel;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.service.getAllPayments().forEach(p -> this.viewModel.getPayment().add(p));

        this.tableView.setItems(this.viewModel.getPayment());
        this.tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.viewModel.setSelectedPayment(this.tableView.getSelectionModel().getSelectedItems());

        // create bindings from getters
        //this.addressColumn.setCellValueFactory(cell -> Bindings.createStringBinding(() -> cell.getValue().getAddressString(), cell.getValue().getAddresses()));
        //this.bankAccountColumn.setCellValueFactory(cell -> Bindings.createStringBinding(() -> cell.getValue().getBankAccountString(), cell.getValue().bankAccountProperty()));
            //                                                  ämder das mal in nen str            wert d zelle aus methode                wenn sich der wert ändert - lade das nadere feld neu
    }


    @FXML
    public void editPayments(ActionEvent event) throws Exception
    {
        //
        Parent payments;
        try {
            payments = FXMLLoader.load(getClass().getResource("../../fxml/rentalproperties/payments-edit.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);     //Form dahinter nichtmehr anklickbar
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
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Zahlungen hinzufügen");
            stage.setScene(new Scene(payments, 450, 450));
            stage.show();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void deletePayments(ActionEvent event) throws Exception
    {
        final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sind Sie sicher?");
        alert.setHeaderText("Löschen");
        alert.setContentText("Sind Sie sicher, dass Sie den/die ausgewählten Datensatz/Datensätze unwiderruflich löschen möchten?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            this.viewModel.getPayment().removeAll(this.viewModel.getSelectedPayment());
        }
    }


}
