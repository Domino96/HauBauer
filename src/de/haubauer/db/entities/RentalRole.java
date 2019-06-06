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
}
