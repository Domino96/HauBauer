package src.de.haubauer.db.entities;

import src.de.haubauer.enums.RentalType;
import src.de.haubauer.enums.UsageType;

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
    @JoinColumn(name = "addressId")
    Address address;

    @ManyToMany(mappedBy = "rentalProperties")
    List<Person> persons;

    @OneToMany
    @JoinColumn(name = "tenancyId")
    List<Tenancy> tenancy;
}



