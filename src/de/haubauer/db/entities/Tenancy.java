package src.de.haubauer.db.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "Tenancy")
public class Tenancy extends DatedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int tenancyId;

    Person tenant;
    Date startDate;
    Date endDate;
    List<Payment> payments;
    RentalProperty rental;
    int status;

}
