package src.de.haubauer.business.models;

import src.de.haubauer.db.entities.Person;
import src.de.haubauer.db.entities.RentalProperty;
import src.de.haubauer.enums.AddressStatus;

import java.util.List;

public class Address {
    private int id;

    private String street;
    private int number;
    private int zipCode;
    private String town;
    private AddressStatus status;
    private List<RentalProperty> rentalProperties;
    private List<Person> people;

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getReadableAddress() {
        return this.getStreet() + " " + this.getNumber();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public AddressStatus getStatus() {
        return status;
    }

    public void setStatus(AddressStatus status) {
        this.status = status;
    }

    public List<RentalProperty> getRentalProperties() {
        return rentalProperties;
    }

    public void setRentalProperties(List<RentalProperty> rentalProperties) {
        this.rentalProperties = rentalProperties;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
