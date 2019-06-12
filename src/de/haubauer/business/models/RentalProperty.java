package de.haubauer.business.models;

import javafx.beans.InvalidationListener;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 */
public class RentalProperty {
    private int id;
    private StringProperty description = new SimpleStringProperty("");
    private DoubleProperty area = new SimpleDoubleProperty();
    private StringProperty note = new SimpleStringProperty("");
    private IntegerProperty floor = new SimpleIntegerProperty();
    private ObservableList<Address> addresses = FXCollections.observableArrayList();
    private ObservableList<Tenancy> pastTenancy = FXCollections.observableArrayList();
    private ObservableList<UsageType> usageTypes = FXCollections.observableArrayList();
    private ObservableList<RentalType> rentalTypes = FXCollections.observableArrayList();
    private ObjectProperty<BigDecimal> squareMeterPriceCold = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> sideCostsMonth = new SimpleObjectProperty<>();
    private ObjectProperty<Tenancy> currentTenancy = new SimpleObjectProperty<>();
    private ObjectProperty<RentalProperty> parent = new SimpleObjectProperty<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


   /*GETTER     AND     SETTER*/

    public StringProperty descriptionProperty() {
        return description;
    }

    public DoubleProperty areaProperty() {
        return area;
    }

    public StringProperty noteProperty() {
        return note;
    }

    public IntegerProperty floorProperty() {
        return floor;
    }

    public void setAddresses(ObservableList<Address> address) {
        this.addresses = address;
    }

    public ObservableList<Address> getAddresses() {
        return addresses;
    }

    public void setPastTenancy(ObservableList<Tenancy> pastTenancy) {
        this.pastTenancy = pastTenancy;
    }

    public ObservableList<Tenancy> getPastTenancy() {
        return pastTenancy;
    }

    public ObjectProperty<BigDecimal> squareMeterPriceColdProperty() {
        return squareMeterPriceCold;
    }

    public ObjectProperty<BigDecimal> sideCostsMonthProperty() {
        return sideCostsMonth;
    }

    public ObjectProperty<Tenancy> currentTenancyProperty() {
        return currentTenancy;
    }

    public ObjectProperty<RentalProperty> parentProperty() {
        return parent;
    }



    public ObservableList<UsageType> getUsageTypes() {
        return usageTypes;
    }

    public void setUsageTypes(ObservableList<UsageType> usageTypes) {
        this.usageTypes = usageTypes;
    }

    public ObservableList<RentalType> getRentalTypes() {
        return rentalTypes;
    }

    public void setRentalTypes(ObservableList<RentalType> rentalTypes) {
        this.rentalTypes = rentalTypes;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public double getArea() {
        return area.get();
    }

    public void setArea(double area) {
        this.area.set(area);
    }

    public String getNote() {
        return note.get();
    }

    public void setNote(String note) {
        this.note.set(note);
    }

    public int getFloor() {
        return floor.get();
    }

    public void setFloor(int floor) {
        this.floor.set(floor);
    }

    public BigDecimal getSquareMeterPriceCold() {
        return squareMeterPriceCold.get();
    }

    public void setSquareMeterPriceCold(BigDecimal squareMeterPriceCold) {
        this.squareMeterPriceCold.set(squareMeterPriceCold);
    }

    public BigDecimal getSideCostsMonth() {
        return sideCostsMonth.get();
    }

    public void setSideCostsMonth(BigDecimal sideCostsMonth) {
        this.sideCostsMonth.set(sideCostsMonth);
    }

    public Tenancy getCurrentTenancy() {
        return currentTenancy.get();
    }

    public void setCurrentTenancy(Tenancy currentTenancy) {
        this.currentTenancy.set(currentTenancy);
    }

    public RentalProperty getParent() {
        return parent.get();
    }

    public void setParent(RentalProperty parent) {
        this.parent.set(parent);
    }


    /*

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public de.haubauer.business.models.Address getAddress() {
        return address;
    }

    public void setAddress(de.haubauer.business.models.Address address) {
        this.address = address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public BigDecimal getSquareMeterPriceCold() {
        return squareMeterPriceCold;
    }

    public void setSquareMeterPriceCold(BigDecimal squareMeterPriceCold) {
        this.squareMeterPriceCold = squareMeterPriceCold;
    }

    public BigDecimal getSideCostsMonth() {
        return sideCostsMonth;
    }

    public void setSideCostsMonth(BigDecimal sideCostsMonth) {
        this.sideCostsMonth = sideCostsMonth;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public de.haubauer.business.models.Tenancy getCurrentTenancy() {
        return currentTenancy;
    }

    public void setCurrentTenancy(de.haubauer.business.models.Tenancy currentTenancy) {
        this.currentTenancy = currentTenancy;
    }

    public List<de.haubauer.business.models.Tenancy> getPastTenancy() {
        return pastTenancy;
    }

    public void setPastTenancy(List<de.haubauer.business.models.Tenancy> pastTenancy) {
        this.pastTenancy = pastTenancy;
    }

    public RentalProperty getParent() {
        return parent;
    }

    public void setParent(RentalProperty parent) {
        this.parent = parent;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }*/
}
