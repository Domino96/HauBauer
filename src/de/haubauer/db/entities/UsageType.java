package src.de.haubauer.db.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "UsageType")
public class UsageType extends DatedEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int usageTypeId;
    String usageTypeName;
    String usageTypeDescription;
    @OneToMany
    @JoinColumn(name = "rentalPropertyId")
    List<RentalProperty> RentalProperty;


    //GETTER    AND     SETTER


    public int getUsageTypeId() {
        return usageTypeId;
    }

    public String getUsageTypeName() {
        return usageTypeName;
    }

    public void setUsageTypeName(String usageTypeName) {
        this.usageTypeName = usageTypeName;
    }

    public String getUsageTypeDescription() {
        return usageTypeDescription;
    }

    public void setUsageTypeDescription(String usageTypeDescription) {
        this.usageTypeDescription = usageTypeDescription;
    }

    public List<src.de.haubauer.db.entities.RentalProperty> getRentalProperty() {
        return RentalProperty;
    }

    public void setRentalProperty(List<src.de.haubauer.db.entities.RentalProperty> rentalProperty) {
        RentalProperty = rentalProperty;
    }
}

