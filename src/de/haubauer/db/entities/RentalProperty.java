package src.de.haubauer.db.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RentalProperty")
public class RentalProperty extends DatedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int rentalPropertyId;


    RentalType type = RentalType.Private;
    String description;
    int zipCode;
    String town;
    double area;
    BigDecimal squareMeterPriceCold;
    BigDecimal sideCostsMonth;
    String note;
    @OneToMany
    @JoinColumn(name = "parent")
    List<RentalProperty> children = new ArrayList<RentalProperty>();
    @ManyToOne
    RentalProperty parent;
    UsageType usageType;
    int floor;

    @ManyToOne
    @JoinColumn(name = "adressId")
    Address address;

    @ManyToMany(mappedBy = "rentalPropertys")
    List<Person> persons;

    @OneToMany
    @JoinColumn(name = "tenancyId")
    List<Tenancy> tenancy;
}



