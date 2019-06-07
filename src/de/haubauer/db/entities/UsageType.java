package de.haubauer.db.entities;

import de.haubauer.helpers.DatedObject;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "UsageType")
public class UsageType extends DatedObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usageTypeId;
    private String name;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "rentalPropertyId")
    private List<RentalProperty> rentalProperties;


    //GETTER    AND     SETTER


    public int getUsageTypeId() {
        return usageTypeId;
    }

    public void setUsageTypeId(int usageTypeId) {
        this.usageTypeId = usageTypeId;
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

    public List<de.haubauer.db.entities.RentalProperty> getRentalProperties() {
        return rentalProperties;
    }

    public void setRentalProperties(List<de.haubauer.db.entities.RentalProperty> rentalProperties) {
        this.rentalProperties = rentalProperties;
    }
}

