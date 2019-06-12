package de.haubauer.ui.controllers.rentalproperties;

import de.haubauer.db.BaseDao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import de.haubauer.business.models.Address;
import de.haubauer.business.models.RentalProperty;

import java.math.BigDecimal;
import java.util.ArrayList;


public class RentalPropertyAddController extends RentalPropertyDialogController{
    @FXML
    private ComboBox rentalType_cb;

    @FXML
    private ComboBox usageType_cb;

    @FXML
    private TextField area_txt;

    @FXML
    private TextField sqMeterCold_txt;

    @FXML
    private TextField sidecosts_txt;

    @FXML
    private ComboBox parent_cb;

    @FXML
    private TextField street_txt;

    @FXML
    private TextField houseNo_txt;

    @FXML
    private TextField zipCode_txt;

    @FXML
    private TextField town_txt;

    @FXML
    private TextArea description_txtArea;

    @FXML
    private TextArea note_txtArea;

    @FXML
    private Button saveButton;


    public RentalPropertyAddController() {
        super("Mietobjekt hinzufügen");
    }
    public void save(){
        RentalProperty rentalProperty = new RentalProperty();
        de.haubauer.db.BaseDao<RentalProperty> rentalPropertyBaseDao = new BaseDao<RentalProperty>(RentalProperty.class);

        Address address = new Address();

        address.setStreet(street_txt.getText());
        address.setZipCode(Integer.valueOf(zipCode_txt.getText()));
        address.setTown(town_txt.getText());
        address.setNumber(Integer.valueOf(houseNo_txt.getText()));

        rentalProperty.setSquareMeterPriceCold(new BigDecimal(sqMeterCold_txt.getText()));
        rentalProperty.setArea(Integer.valueOf(area_txt.getText()));
        rentalProperty.setSideCostsMonth(new BigDecimal(sidecosts_txt.getText()));
        rentalProperty.setDescription(description_txtArea.getText());
        rentalProperty.setNote(note_txtArea.getText());
        rentalProperty.setAddress(address);

        rentalPropertyBaseDao.save(rentalProperty);

        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }
}
