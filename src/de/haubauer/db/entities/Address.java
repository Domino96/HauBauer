package de.haubauer.db.entities;

import de.haubauer.enums.AddressStatus;
import de.haubauer.helpers.DatedObject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Address")
public class Address extends DatedObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    private String street;
    private int number;
    private int zipCode;
    private String town;
    private String phoneNumber;
    private AddressStatus status;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rentalPropertyId")
    private Set<RentalProperty> rentalProperties;

    @ManyToMany(mappedBy = "addresses", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Person> people;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AddressStatus getStatus() {
        return status;
    }

    public void setStatus(AddressStatus status) {
        this.status = status;
    }

    public Set<RentalProperty> getRentalProperties() {
        return rentalProperties;
    }

    public void setRentalProperties(Set<RentalProperty> rentalProperties) {
        this.rentalProperties = rentalProperties;
    }
    public void setRentalProperties(List<RentalProperty> rentalProperties) {
        this.rentalProperties = new HashSet<>(rentalProperties);
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }
    public void setPeople(List<Person> people) {
        this.people = new HashSet<>(people);
    }
}



