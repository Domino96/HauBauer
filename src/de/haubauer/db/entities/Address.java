package src.de.haubauer.db.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Address")
public class Address extends DatedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int addressId;

    String street;
    int number;
    int zip_code;
    String town;
    String telefon;
    int status;

    @OneToMany
    @JoinColumn(name = "rentalPropertyId")
    List<RentalProperty> rentalProperty;

    @ManyToMany(mappedBy = "addresses")
    List<Person> Persons;
}



