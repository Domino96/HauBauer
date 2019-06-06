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
    String firstName;
    String lastName;
    String landline;
    String mobile;
    String email;

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

    @ManyToOne
    @JoinColumn(name = "userRoleId")
    List<UserRole> userRoles;

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

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}