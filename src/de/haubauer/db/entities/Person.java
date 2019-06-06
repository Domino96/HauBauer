package src.de.haubauer.db.entities;

import src.de.haubauer.enums.Role;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person extends DatedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int personId;

    String title;
    String firstName;
    String lastName;
    String landline;
    String mobile;
    String email;
    Role role;

    @ManyToMany
    @JoinTable(name = "AddressPerson",
                joinColumns = {@JoinColumn(name = "personId")},
                inverseJoinColumns = {@JoinColumn(name = "addressId")})
    List<Address> addresses;

    @ManyToMany
    @JoinTable(name = "RentalPropertyPerson",
            joinColumns = {@JoinColumn(name = "personId")},
            inverseJoinColumns = {@JoinColumn(name = "RentalPropertyId")})
    List<RentalProperty> rentalProperties;

    @OneToMany
    @JoinColumn(name = "tenancyId")
    List<Tenancy> tenancies;

    @OneToOne
    @JoinColumn(name = "bankAccountId")
    BankAccount bankAccount;
}