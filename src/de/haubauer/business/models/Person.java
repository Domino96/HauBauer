package de.haubauer.business.models;

import de.haubauer.helpers.DatedObject;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

import java.util.Collection;
import java.util.List;

public class Person extends DatedObject {
    private int id;
    private StringProperty title = new SimpleStringProperty("");
    private StringProperty firstName = new SimpleStringProperty("");
    private StringProperty lastName = new SimpleStringProperty("");
    private StringProperty landline = new SimpleStringProperty("");
    private StringProperty mobile = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private ObjectProperty<UserRole> role = new SimpleObjectProperty<>();
    private ObservableList<Address> addresses = FXCollections.observableArrayList();
    private ObservableList<RentalProperty> rentalProperties = FXCollections.observableArrayList();
    private ObservableList<Tenancy> tenancies = FXCollections.observableArrayList();
    private ObjectProperty<BankAccount> bankAccount = new SimpleObjectProperty<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getLandline() {
        return landline.get();
    }

    public StringProperty landlineProperty() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline.set(landline);
    }

    public String getMobile() {
        return mobile.get();
    }

    public StringProperty mobileProperty() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile.set(mobile);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public UserRole getRole() {
        return role.get();
    }

    public Property<UserRole> roleProperty() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role.set(role);
    }

    public String getAddressString() {
        final SortedList<Address> sortedAddresses = this.getAddresses().sorted();

        if (sortedAddresses.isEmpty()) {
            return "";
        }

        final Address lastAddress = sortedAddresses.get(sortedAddresses.size() - 1).clone();

        return lastAddress.getReadableAddress();
    }

    public ObservableList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses.clear();
        this.addresses.addAll(addresses);
    }

    public ObservableList<RentalProperty> getRentalProperties() {
        return rentalProperties;
    }

    public void setRentalProperties(Collection<RentalProperty> rentalProperties) {
        this.rentalProperties.clear();
        this.rentalProperties.addAll(rentalProperties);
    }

    public ObservableList<Tenancy> getTenancies() {
        return tenancies;
    }

    public void setTenancies(Collection<Tenancy> tenancies) {
        this.tenancies.clear();
        this.tenancies.addAll(tenancies);
    }

    public String getBankAccountString() {
        if (this.getBankAccount() == null) {
            return "";
        }

        return this.getBankAccount().getBic();
    }

    public BankAccount getBankAccount() {
        return bankAccount.get();
    }

    public Property<BankAccount> bankAccountProperty() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount.set(bankAccount);
    }
}
