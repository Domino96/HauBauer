package de.haubauer.business.models;

import de.haubauer.enums.AddressStatus;
import de.haubauer.helpers.DatedObject;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Address extends DatedObject implements Cloneable {
    private int id;

    private StringProperty street = new SimpleStringProperty();
    private IntegerProperty number = new SimpleIntegerProperty();
    private IntegerProperty zipCode = new SimpleIntegerProperty();
    private StringProperty town = new SimpleStringProperty();
    private StringProperty phoneNumber = new SimpleStringProperty();
    private ObjectProperty<AddressStatus> status = new SimpleObjectProperty<>(AddressStatus.Primary);
    private ObservableList<RentalProperty> rentalProperties = FXCollections.observableArrayList();
    private ObservableList<Person> people = FXCollections.observableArrayList();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public int getNumber() {
        return number.get();
    }

    public IntegerProperty numberProperty() {
        return number;
    }

    public void setNumber(int number) {
        this.number.set(number);
    }

    public int getZipCode() {
        return zipCode.get();
    }

    public IntegerProperty zipCodeProperty() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode.set(zipCode);
    }

    public String getReadableAddress() {
        return this.getStreet() + " " + this.getNumber() + ", " + this.getTown() + " " + this.getZipCode();
    }

    public String getTown() {
        return town.get();
    }

    public StringProperty townProperty() {
        return town;
    }

    public void setTown(String town) {
        this.town.set(town);
    }

    public AddressStatus getStatus() {
        return status.get();
    }

    public ObjectProperty<AddressStatus> statusProperty() {
        return status;
    }

    public void setStatus(AddressStatus status) {
        this.status.set(status);
    }

    public ObservableList<RentalProperty> getRentalProperties() {
        return rentalProperties;
    }

    public void setRentalProperties(List<RentalProperty> rentalProperties) {
        this.rentalProperties.addAll(rentalProperties);
    }

    public ObservableList<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people.addAll(people);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    @Override
    public Address clone() {
        final Address address = new Address();

        address.setZipCode(this.getZipCode());
        address.setTown(this.getTown());
        address.setStatus(this.getStatus());
        address.setNumber(this.getNumber());
        address.setStreet(this.getStreet());
        address.setPeople(this.getPeople());
        address.setRentalProperties(this.getRentalProperties());
        address.setPhoneNumber(this.getPhoneNumber());

        return address;
    }
}
