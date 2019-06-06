package src.de.haubauer.db.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RentalType")
public class RentalType extends DatedEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int rentalTypeId;
    String rentalTypeName;
    String rentalTypeDescription;

    @OneToMany
    @JoinColumn(name = "rentalPropertyId")
    List<RentalProperty> RentalProperty;



    public String getRentalTypeName() {
        return rentalTypeName;
    }

    public void setRentalTypeName(String rentalTypeName) {
        this.rentalTypeName = rentalTypeName;
    }

    public String getRentalTypeDescription() {
        return rentalTypeDescription;
    }

    public void setRentalTypeDescription(String rentalTypeDescription) {
        this.rentalTypeDescription = rentalTypeDescription;
    }

    public List<src.de.haubauer.db.entities.RentalProperty> getRentalProperty() {
        return RentalProperty;
    }

    public void setRentalProperty(List<src.de.haubauer.db.entities.RentalProperty> rentalProperty) {
        RentalProperty = rentalProperty;
    }
}