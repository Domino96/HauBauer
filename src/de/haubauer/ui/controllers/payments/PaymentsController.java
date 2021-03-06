package de.haubauer.ui.controllers.payments;

import de.haubauer.business.models.Payment;
import de.haubauer.business.models.PaymentType;
import de.haubauer.business.models.Person;
import de.haubauer.business.models.RentalProperty;
import de.haubauer.ui.FxmlLibrary;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import de.haubauer.business.services.PaymentService;
import de.haubauer.ui.viewmodels.PaymentsViewModel;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class PaymentsController extends Stage implements Initializable {

    private PaymentsViewModel viewModel = new PaymentsViewModel();
    private PaymentService service = new PaymentService();

    @FXML
    private Label paymentsObjectIdLabel;

    @FXML
    private TableColumn<Person, String> tenantColumn;

    @FXML
    private TableColumn<PaymentType, String> paymentTypeColumn;

    @FXML
    private TableView<Payment> tableView;

    public PaymentsController(final RentalProperty rentalProperty) {
        this.viewModel.setRentalProperty(rentalProperty);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.service.getPayments(this.viewModel.getRentalProperty()).forEach(p -> this.viewModel.getPayments().add(p));

        this.tableView.setItems(this.viewModel.getPayments());
        this.tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.viewModel.setSelectedPayments(this.tableView.getSelectionModel().getSelectedItems());

        // create bindings from getters
        this.paymentsObjectIdLabel.setText(String.valueOf(this.viewModel.getRentalProperty().getId()));
        this.tenantColumn.setCellValueFactory(cell -> Bindings.createStringBinding(() -> cell.getValue().getFullName(), cell.getValue().firstNameProperty(), cell.getValue().lastNameProperty()));
        this.paymentTypeColumn.setCellValueFactory(cell -> Bindings.createStringBinding(() -> cell.getValue().getName(), cell.getValue().nameProperty()));
    }


    @FXML
    public void editPayments(ActionEvent event) throws IOException {
        if (this.viewModel.getSelectedPayments().size() == 1) {
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.setTitle("Zahlungssatz bearbeiten");
            //final Payment copiedPayment = new Payment(this.viewModel.getSelectedPayments().get(0));
            dialog.setScene(new Scene(FxmlLibrary.getPaymentEditDialog(this.viewModel.getSelectedPayments().get(0)), 500, 700));
            dialog.setOnCloseRequest(e -> {
                // this.viewModel.getSelectedPayments().get(0).copy(copiedPayment);
            });
            dialog.showAndWait();
        }
    }

    @FXML
    public void newPayments(ActionEvent event) throws IOException {
        final Stage dialog = new Stage();
        AtomicBoolean cancelledAdd = new AtomicBoolean(false);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Zahlungssatz hinzufügen");
        Payment paymentToAdd = new Payment();
        dialog.setScene(new Scene(FxmlLibrary.getPaymentAddDialog(paymentToAdd), 500, 700));
        dialog.setOnCloseRequest(e -> cancelledAdd.set(true));
        dialog.showAndWait();

        if (!cancelledAdd.get()) {
            this.viewModel.getPayments().add(paymentToAdd);
        }
    }

    @FXML
    public void deletePayments(ActionEvent event) throws Exception
    {
        if (!this.viewModel.getSelectedPayments().isEmpty()) {
            final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Sind Sie sicher?");
            alert.setHeaderText("Löschen");
            alert.setContentText("Sind Sie sicher, dass Sie den/die ausgewählten Datensatz/Datensätze unwiderruflich löschen möchten?");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                this.viewModel.getPayments().removeAll(this.viewModel.getSelectedPayments());
            }
        }
    }


}
