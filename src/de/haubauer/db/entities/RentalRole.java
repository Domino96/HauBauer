package src.de.haubauer.db.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RentalRole")
public class RentalRole extends DatedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int rentalRoleId;

    String rentalRoleName;
    String rentalRoleDescription;
    @OneToMany
    @JoinColumn(name = "rentalPropertyId")
    List<RentalProperty> rentalProperties;

    public int getRentalRoleId() {
        return rentalRoleId;
    }

    public String getRentalRoleName() {
        return rentalRoleName;
    }

    public void setRentalRoleName(String rentalRoleName) {
        this.rentalRoleName = rentalRoleName;
    }

    public String getRentalRoleDescription() {
        return rentalRoleDescription;
    }

    public void setRentalRoleDescription(String rentalRoleDescription) {
        this.rentalRoleDescription = rentalRoleDescription;
    }

    public List<RentalProperty> getRentalProperties() {
        return rentalProperties;
    }

    public void setRentalProperties(List<RentalProperty> rentalProperties) {
        this.rentalProperties = rentalProperties;
    }
}
