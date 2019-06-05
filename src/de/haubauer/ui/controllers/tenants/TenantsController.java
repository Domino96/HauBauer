package src.de.haubauer.ui.controllers.tenants;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class TenantsController implements Initializable {

    @FXML
    private TableColumn<TableInit, String> titleColumn;

    @FXML
    private TableColumn<TableInit, String> vorname;

    @FXML
    private TableColumn<TableInit, String> nachname;

    @FXML
    private TableColumn<TableInit, String> anschrift;

    @FXML
    private TableColumn<TableInit, String> telefonnummer;

    @FXML
    private TableColumn<TableInit, String> email;

    @FXML
    private TableColumn<TableInit, String> kontoverbindung;

    @FXML
    private TableView<TableInit> tableView;

    ObservableList<TableInit> list = FXCollections.observableArrayList();

    public void initialize(URL location, ResourceBundle resources) {
        list.add(new TableInit("Herr", "Christian", "Mustermann", "Am Hackenbruch 51", "0174422124", "haubau@gmail.com", "DE0156165165732132437313"));
        list.add(new TableInit("Herr", "Christian", "Mustermann", "Am Hackenbruch 51", "0174422124", "haubau@gmail.com", "DE0156165165732132437313"));
        list.add(new TableInit("Herr", "Christian", "Mustermann", "Am Hackenbruch 51", "0174422124", "haubau@gmail.com", "DE0156165165732132437313"));
        list.add(new TableInit("Frau", "Elizabeth", "Muller", "Am Hackenbruch 51", "0174422124", "haubau@gmail.com", "DE0156165165732132437313"));
        list.add(new TableInit("Frau", "Elizabeth", "Muller", "Am Hackenbruch 51", "0174422124", "haubau@gmail.com", "DE0156165165732132437313"));
        list.add(new TableInit("Frau", "Elizabeth", "Muller", "Am Hackenbruch 51", "0174422124", "haubau@gmail.com", "DE0156165165732132437313"));
        list.add(new TableInit("Frau", "Elizabeth", "Muller", "Am Hackenbruch 51", "0174422124", "haubau@gmail.com", "DE0156165165732132437313"));

        this.tableView.setItems(list);
        this.titleColumn.setCellValueFactory(new PropertyValueFactory<>("titleColumn"));
        this.vorname.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        this.nachname.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        this.anschrift.setCellValueFactory(new PropertyValueFactory<>("anschrift"));
        this.telefonnummer.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
        this.email.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.kontoverbindung.setCellValueFactory(new PropertyValueFactory<>("kontoverbindung"));

        // selecting multiple table view items with SHIFT or STRG
        tableView.setOnMouseClicked(event -> tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE));
    }

    public void deleteItems() {
        final ObservableList<TableInit> itemsToDelete = tableView.getSelectionModel().getSelectedItems();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Delete");
        alert.setContentText("Are you sure you want to delete these from the list?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            tableView.getItems().removeAll(itemsToDelete);
        }
    }
}
