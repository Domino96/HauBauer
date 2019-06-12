package de.haubauer.db.entities;

import de.haubauer.helpers.DatedObject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "RentalType")
public class RentalType extends DatedObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentalTypeId;
    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rentalPropertyId")
    private Set<RentalProperty> rentalProperties;

    public int getRentalTypeId() {
        return rentalTypeId;
    }

    public void setRentalTypeId(int rentalTypeId) {
        this.rentalTypeId = rentalTypeId;
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

    public Set<RentalProperty> getRentalProperties() {
        return rentalProperties;
    }

    public void setRentalProperties(Set<RentalProperty> rentalProperties) {
        this.rentalProperties = rentalProperties;
    }
    public void setRentalProperties(List<RentalProperty> rentalProperties) {
        this.rentalProperties = new HashSet<>(rentalProperties);
    }
}