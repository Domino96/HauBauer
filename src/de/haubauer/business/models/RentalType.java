package de.haubauer.business.models;

import de.haubauer.helpers.DatedObject;

import java.util.List;

public class RentalType extends DatedObject {

    private int id;
    private String name;
    private String description;
    private List<RentalProperty> rentalProperties;

    public int getRentalTypeId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RentalProperty> getRentalProperties() {
        return rentalProperties;
    }

    public void setRentalProperties(List<RentalProperty> rentalProperties) {
        this.rentalProperties = rentalProperties;
    }
}
