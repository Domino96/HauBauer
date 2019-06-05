package src.de.haubauer.db.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person extends DatedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int personId;

    String title;
    String fistName;
    String lastName;
    String telefon;
    String phone;
    String email;
    String role;

    @ManyToMany
    @JoinTable(name = "AddressPerson",
                joinColumns = {@JoinColumn(name = "personId")},
                inverseJoinColumns = {@JoinColumn(name = "addressId")})
    List<Address> addresses;

    @ManyToMany
    @JoinTable(name = "RentalPropertyPerson",
            joinColumns = {@JoinColumn(name = "personId")},
            inverseJoinColumns = {@JoinColumn(name = "RentalPropertyId")})
    List<RentalProperty> rentalPropertys;

    @OneToMany
    @JoinColumn(name = "tenancyId")
    List<Tenancy> tenancy;

    @OneToOne
    @JoinColumn(name = "bankAccountId")
    BankAccount bankAccount;
}