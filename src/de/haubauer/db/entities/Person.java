package de.haubauer.db.entities;


import de.haubauer.helpers.DatedObject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Person")
public class Person extends DatedObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    private String title;
    private String firstName;
    private String lastName;
    private String landline;
    private String mobile;
    private String email;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "AddressPerson",
                joinColumns = {@JoinColumn(name = "personId")},
                inverseJoinColumns = {@JoinColumn(name = "addressId")})
    private Set<Address> addresses;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "RentalPropertyPerson",
            joinColumns = {@JoinColumn(name = "personId")},
            inverseJoinColumns = {@JoinColumn(name = "RentalPropertyId")})
    private Set<RentalProperty> rentalProperties;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tenancyId")
    private Set<Tenancy> tenancies;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId")
    private UserRole role;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bankAccountId")
    private BankAccount bankAccount;
    
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
    public void setAddresses(List<Address> addresses) {
        this.addresses = new HashSet<>(addresses);
    }

    public Set<RentalProperty> getRentalProperties() {
        return rentalProperties;
    }

    public void setRentalProperties(Set<RentalProperty> rentalProperties) {
        this.rentalProperties = rentalProperties;
    }
    public void setRentalProperties(List<RentalProperty> rentalProperties) {
        this.rentalProperties = new HashSet<>(rentalProperties);
    }

    public Set<Tenancy> getTenancies() {
        return this.tenancies;
    }

    public void setTenancies(Set<Tenancy> tenancies) {
        this.tenancies = tenancies;
    }
    public void setTenancies(List<Tenancy> tenancies) {
        this.tenancies = new HashSet<>(tenancies);
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}