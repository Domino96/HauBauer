package src.de.haubauer.business.models;

import src.de.haubauer.db.entities.BankAccount;
import src.de.haubauer.db.entities.RentalProperty;
import src.de.haubauer.db.entities.Tenancy;
import src.de.haubauer.enums.Role;

import java.util.List;

public class Person {
    private int id;
    private String title;
    private String firstName;
    private String lastName;
    private String landline;
    private String mobile;
    private String email;
    private Role role;
    private List<Address> addresses;
    private List<RentalProperty> rentalProperties;
    private List<Tenancy> tenancies;
    private BankAccount bankAccount;



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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<RentalProperty> getRentalProperties() {
        return rentalProperties;
    }

    public void setRentalProperties(List<RentalProperty> rentalProperties) {
        this.rentalProperties = rentalProperties;
    }

    public List<Tenancy> getTenancies() {
        return tenancies;
    }

    public void setTenancies(List<Tenancy> tenancies) {
        this.tenancies = tenancies;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
