package de.haubauer.ui.controllers.rentalproperties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import de.haubauer.ui.controllers.SceneController;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class RentalPropertiesController implements Initializable {

    @FXML
    private TableColumn<TableInit, String> nummer;

    @FXML
    private TableColumn<TableInit, String> typ;

    @FXML
    private TableColumn<TableInit, String> beschreibung;

    @FXML
    private TableColumn<TableInit, String> anschrift;

    @FXML
    private TableColumn<TableInit, String> wohnflaeche;

    @FXML
    private TableColumn<TableInit, String> qm;

    @FXML
    private TableColumn<TableInit, String> nebenkosten;

    @FXML
    private TableColumn<TableInit, String> notiz;

    @FXML
    private TableView<TableInit> tableView;

    ObservableList<TableInit> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.add(new TableInit("16577", "Garage", "Testing", "Am Hackenbruch 51", "3m", "60qm", "180", "dump"));
        list.add(new TableInit("16577", "Haus", "Testing", "Kettwiger 51", "5m", "80qm", "300", "hello world"));
        list.add(new TableInit("16577", "Garage", "Testing", "Am Hackenbruch 51", "3m", "60qm", "180", "dump"));
        list.add(new TableInit("16577", "Haus", "Testing", "Kettwiger 51", "5m", "80qm", "300", "hello world"));

        this.tableView.setItems(list);
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
        ObservableList<TableInit> list = tableView.getSelectionModel().getSelectedItems();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Delete");
        alert.setContentText("Are you sure you want to delete these from the list?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            tableView.getItems().removeAll(list);
        }
    }

    public void zahlungUbersichtForItem() {
        TableInit item = tableView.getSelectionModel().getSelectedItem();
        tableView.getItems();
    }

    public void onDashboardClicked(ActionEvent actionEvent) {
        SceneController.getInstance().activate("Dashboard");
    }
}
