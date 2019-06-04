package src.de.haubauer.ui.controllers.tenants;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class TenantsController implements Initializable {

    @FXML
    private TableColumn<TableInit, String> anrede;

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
        this.anrede.setCellValueFactory(new PropertyValueFactory<>("anrede"));
        this.vorname.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        this.nachname.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        this.anschrift.setCellValueFactory(new PropertyValueFactory<>("anschrift"));
        this.telefonnummer.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
        this.email.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.kontoverbindung.setCellValueFactory(new PropertyValueFactory<>("kontoverbindung"));

        // selecting multiple table view items with SHIFT or STRG
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            }
        });
    }

    public void deleteItems() {
        ObservableList<TableInit> list = tableView.getSelectionModel().getSelectedItems();
        tableView.getItems().removeAll(list);

    }
}
