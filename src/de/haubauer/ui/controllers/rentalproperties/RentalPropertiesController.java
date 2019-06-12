package de.haubauer.ui.controllers.rentalproperties;

import de.haubauer.business.models.RentalProperty;
import de.haubauer.business.services.RentalPropertyService;
import de.haubauer.ui.FxmlLibrary;
import de.haubauer.ui.viewmodels.RentalPropertyViewModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class RentalPropertiesController implements Initializable {

    private RentalPropertyViewModel viewModel = new RentalPropertyViewModel();
    private RentalPropertyService service = new RentalPropertyService();

    @FXML
    private TableColumn<RentalProperty, String> nummer;

    @FXML
    private TableColumn<RentalProperty, String> typ;

    @FXML
    private TableColumn<RentalProperty, String> beschreibung;

    @FXML
    private TableColumn<RentalProperty, String> anschrift;

    @FXML
    private TableColumn<RentalProperty, String> etage;

    @FXML
    private TableColumn<RentalProperty, String> wohnflaeche;

    @FXML
    private TableColumn<RentalProperty, String> qm;

    @FXML
    private TableColumn<RentalProperty, String> nebenkosten;

    @FXML
    private TableColumn<RentalProperty, String> mieter;

    @FXML
    private TableColumn<RentalProperty, String> notiz;

    @FXML
    private TableView<RentalProperty> tableView;

    @FXML
    private Button addBtn;


    /**
     * Initialsierung der Übersicht der Mietobjekte
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.service.getAllRentalProperties().forEach(p -> this.viewModel.getRentalProperties().add(p));
        this.viewModel.setSelectedRentalProperties(this.tableView.getSelectionModel().getSelectedItems());

        this.tableView.setItems(this.viewModel.getRentalProperties());

        this.nummer.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.typ.setCellValueFactory(new PropertyValueFactory<>("usageType"));
        this.beschreibung.setCellValueFactory(new PropertyValueFactory<>("description"));
        this.anschrift.setCellValueFactory(new PropertyValueFactory<>("address"));
        this.etage.setCellValueFactory(new PropertyValueFactory<>("floor"));
        this.wohnflaeche.setCellValueFactory(new PropertyValueFactory<>("area"));
        this.qm.setCellValueFactory(new PropertyValueFactory<>("squareMeterPriceCold"));
        this.nebenkosten.setCellValueFactory(new PropertyValueFactory<>("sideCostsMonth"));
        this.mieter.setCellValueFactory(new PropertyValueFactory<>("currentTenancy"));
        this.notiz.setCellValueFactory(new PropertyValueFactory<>("note"));

        this.tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.viewModel.setSelectedRentalProperties(this.tableView.getSelectionModel().getSelectedItems());

        // selecting multiple table view items with SHIFT or STRG
        tableView.setOnMouseClicked(event -> tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE));
    }

    /**
     * Dialog, wenn man Mietobjekte löschen möchte
     */
    public void deleteItems() {
        ObservableList<RentalProperty> list = tableView.getSelectionModel().getSelectedItems();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Delete");
        alert.setContentText("Are you sure you want to delete these from the list?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            tableView.getItems().removeAll(list);
        }
    }

    /**
     * Aufruf der des Add Schemas
     * @throws IOException
     */
    public void addItem() throws IOException {
        Stage addStage = new Stage();


        Parent root = FxmlLibrary.getRentalPropertyAdd();

        addStage.setScene(new Scene(root, 600, 480));
        addStage.show();
    }

    public void showPaymentsOverview() throws IOException {
        if (this.viewModel.getSelectedRentalProperties().size() == 1) {
            final Stage newStage = new Stage();
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.setTitle("Zahlungsübersicht");
            newStage.setScene(new Scene(FxmlLibrary.getPayments(this.viewModel.getSelectedRentalProperties().get(0)), 800, 450));
            newStage.showAndWait();
        }
    }

    public void onDashboardClicked(){

    }
}
