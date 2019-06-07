package src.de.haubauer.db.entities;

import src.de.haubauer.helpers.DatedObject;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RentalRole")
public class RentalRole extends DatedObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentalRoleId;

    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name = "rentalPropertyId")
    private List<RentalProperty> rentalProperties;

    public int getRentalRoleId() {
        return rentalRoleId;
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
