package src.de.haubauer.db.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Tenancy")
public class Tenancy extends DatedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int tenancyId;

    Date startDate;
    Date endDate;
    int status;

    @ManyToOne
    @JoinColumn(name = "personId")
    Person person;

    @OneToMany
    @JoinColumn(name = "paymentId")
    List<Payment> payment;

    @ManyToOne
    @JoinColumn(name = "rentalPropertyId")
    RentalProperty rentalProperty;

}
