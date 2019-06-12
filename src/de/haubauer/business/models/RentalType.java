package de.haubauer.business.models;

import de.haubauer.helpers.DatedObject;

import java.util.List;

public class RentalType extends DatedObject {

    private int id;
    private String name;
    private String description;
    private List<RentalProperty> rentalProperties;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static class StringConverter extends javafx.util.StringConverter<RentalType> {
        @Override
        public String toString(RentalType object) {
            return object.getName();
        }

        @Override
        public RentalType fromString(String string) {
            RentalType newRentalType = new RentalType();
            newRentalType.setName(string);
            return newRentalType;
        }
    }
}
