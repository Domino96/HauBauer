package src.de.haubauer.db.entities;

import src.de.haubauer.enums.RentalType;
import src.de.haubauer.enums.UsageType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "RentalProperty")
public class RentalProperty extends DatedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    RentalType type = RentalType.Private;
    String description;
    String address;
    int zipCode;
    String town;
    double area;
    BigDecimal squareMeterPriceCold;
    BigDecimal sideCostsMonth;
    String note;
    Tenancy currentTenancy;
    List<Tenancy> pastTenancy;
    List<RentalProperty> children;
    @ManyToOne
    @JoinColumn(referencedColumnName = "children")
    RentalProperty parent;
    UsageType usageType;
    int floor;
}



