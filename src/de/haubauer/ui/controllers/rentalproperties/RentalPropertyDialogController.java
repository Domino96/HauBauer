package de.haubauer.ui.controllers.rentalproperties;

import de.haubauer.business.models.Address;
import de.haubauer.business.models.RentalProperty;
import de.haubauer.business.models.RentalType;
import de.haubauer.business.models.UsageType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import de.haubauer.business.services.RentalPropertyService;
import de.haubauer.ui.viewmodels.RentalPropertyDialogViewModel;
import javafx.stage.Stage;
import javafx.util.converter.BigDecimalStringConverter;

import java.net.URL;
import java.text.NumberFormat;
import java.util.List;
import java.util.ResourceBundle;

public abstract class RentalPropertyDialogController implements Initializable {
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
    protected RentalPropertyService service = new RentalPropertyService();
    protected RentalPropertyDialogViewModel viewModel = new RentalPropertyDialogViewModel();
    protected Stage getStage() {
        return (Stage) this.title.getScene().getWindow();
    }

    @FXML
    private Label title;

    public RentalPropertyDialogController(String title) {
        this.viewModel.setTitle(title);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.title.textProperty().bind(this.viewModel.titleProperty());


        final RentalProperty rentalProperty = this.viewModel.getRentalProperty();
        this.description_txtArea.textProperty().bindBidirectional(rentalProperty.descriptionProperty());
        this.area_txt.textProperty().bindBidirectional(rentalProperty.areaProperty(), NumberFormat.getNumberInstance());
        this.sqMeterCold_txt.textProperty().bindBidirectional(rentalProperty.squareMeterPriceColdProperty(), new BigDecimalStringConverter());
        this.sidecosts_txt.textProperty().bindBidirectional(rentalProperty.sideCostsMonthProperty(), new BigDecimalStringConverter());
        rentalProperty.parentProperty().bind(this.parent_cb.getSelectionModel().selectedItemProperty());
        this.note_txtArea.textProperty().bindBidirectional(rentalProperty.noteProperty());


        this.viewModel.rentalTypes.addAll(this.service.getAvailableRentalTypes());
        this.rentalType_cb.setItems(this.viewModel.rentalTypes);
        this.rentalType_cb.setConverter(new RentalType.StringConverter());

        if (this.viewModel.getRentalProperty().getRentalTypes() != null) {
            this.rentalType_cb.getSelectionModel().select(this.viewModel.getRentalProperty().getRentalTypes());
        }


        this.viewModel.usageTypes.addAll(this.service.getAvailableUsagetypes());
        this.usageType_cb.setItems(this.viewModel.usageTypes);
        this.usageType_cb.setConverter(new UsageType.StringConverter());

        if (this.viewModel.getRentalProperty().getUsageTypes() != null) {
            this.usageType_cb.getSelectionModel().select(this.viewModel.getRentalProperty().getUsageTypes());
        }



        final List<Address> sortedAddresses = rentalProperty.getAddresses();
        Address lastAddress;

        if (rentalProperty.getAddresses().isEmpty()) {
            lastAddress = new Address();

            rentalProperty.getAddresses().add(lastAddress);
        } else {
            lastAddress = sortedAddresses.get(sortedAddresses.size() - 1).clone();
        }

        this.street_txt.textProperty().bindBidirectional(lastAddress.streetProperty());
        this.houseNo_txt.textProperty().bindBidirectional(lastAddress.numberProperty(), NumberFormat.getIntegerInstance());
        this.town_txt.textProperty().bindBidirectional(lastAddress.townProperty());
        this.zipCode_txt.textProperty().bindBidirectional(lastAddress.zipCodeProperty(), NumberFormat.getIntegerInstance());

    }

    @FXML
    public abstract void save();
}
