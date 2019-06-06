package src.de.haubauer.db.entities;

import src.de.haubauer.enums.AddressStatus;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Address")
public class Address extends DatedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    private String street;
    private int number;
    private int zipCode;
    private String town;
    private AddressStatus status;

    @OneToMany
    @JoinColumn(name = "rentalPropertyId")
    private List<RentalProperty> rentalProperties;

    @ManyToMany(mappedBy = "addresses")
    private List<Person> people;
}



