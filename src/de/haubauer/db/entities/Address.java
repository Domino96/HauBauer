package src.de.haubauer.db.entities;

import javax.persistence.*;

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

}



