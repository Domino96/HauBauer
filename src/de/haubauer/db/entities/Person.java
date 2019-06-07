package src.de.haubauer.db.entities;


import src.de.haubauer.helpers.DatedObject;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany
    @JoinTable(name = "AddressPerson",
                joinColumns = {@JoinColumn(name = "personId")},
                inverseJoinColumns = {@JoinColumn(name = "addressId")})
    private List<Address> addresses;

    @ManyToMany
    @JoinTable(name = "RentalPropertyPerson",
            joinColumns = {@JoinColumn(name = "personId")},
            inverseJoinColumns = {@JoinColumn(name = "RentalPropertyId")})
    private List<RentalProperty> rentalProperties;

    @OneToMany
    @JoinColumn(name = "tenancyId")
    private List<Tenancy> tenancies;

    @OneToOne
    @JoinColumn(name = "bankAccountId")
    private BankAccount bankAccount;

    public int getPersonId() {
        return personId;
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


    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<RentalProperty> getRentalPropertys() {
        return rentalProperties;
    }

    public void setRentalPropertys(List<RentalProperty> rentalPropertys) {
        this.rentalProperties = rentalPropertys;
    }

    public List<Tenancy> getTenancy() {
        return this.tenancies;
    }

    public void setTenancy(List<Tenancy> tenancy) {
        this.tenancies = tenancy;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}