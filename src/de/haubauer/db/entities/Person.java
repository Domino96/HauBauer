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

    public int getPersonId() {
        return personId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<RentalProperty> getRentalPropertys() {
        return rentalPropertys;
    }

    public void setRentalPropertys(List<RentalProperty> rentalPropertys) {
        this.rentalPropertys = rentalPropertys;
    }

    public List<Tenancy> getTenancy() {
        return tenancy;
    }

    public void setTenancy(List<Tenancy> tenancy) {
        this.tenancy = tenancy;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}