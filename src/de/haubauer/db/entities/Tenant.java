package src.de.haubauer.db.entities;

import javax.persistence.*;

@Entity
@Table(name = "Tenant")
public class Tenant extends DatedEntity{
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