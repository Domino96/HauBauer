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
    private TableColumn<RentalProperty, String> wohnflaeche;

    @FXML
    private TableColumn<RentalProperty, String> qm;

    @FXML
    private TableColumn<RentalProperty, String> nebenkosten;

    @FXML
    private TableColumn<RentalProperty, String> notiz;

    @FXML
    private TableView<RentalProperty> tableView;

    @FXML
    private Button addBtn;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.service.getAllRentalProperties().forEach(p -> this.viewModel.getRentalProperties().add(p));

        this.tableView.setItems(this.viewModel.getRentalProperties());

        this.nummer.setCellValueFactory(new PropertyValueFactory<>("nummer"));
        this.typ.setCellValueFactory(new PropertyValueFactory<>("typ"));
        this.beschreibung.setCellValueFactory(new PropertyValueFactory<>("beschreibung"));
        this.anschrift.setCellValueFactory(new PropertyValueFactory<>("anschrift"));
        this.wohnflaeche.setCellValueFactory(new PropertyValueFactory<>("wohnflaeche"));
        this.qm.setCellValueFactory(new PropertyValueFactory<>("qm"));
        this.nebenkosten.setCellValueFactory(new PropertyValueFactory<>("nebenkosten"));
        this.notiz.setCellValueFactory(new PropertyValueFactory<>("notiz"));

        // selecting multiple table view items with SHIFT or STRG
        tableView.setOnMouseClicked(event -> tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE));
    }

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

    public void addItem() throws IOException {
        Stage addStage = new Stage();


        Parent root = FxmlLibrary.getRentalPropertyAdd();

        addStage.setScene(new Scene(root, 600, 480));
        addStage.show();
    }

    public void zahlungUbersichtForItem() {
        RentalProperty item = tableView.getSelectionModel().getSelectedItem();
        tableView.getItems();
    }

    public void onDashboardClicked(){

    }
}
