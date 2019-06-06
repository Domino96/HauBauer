package src.de.haubauer.db.entities;

import javax.persistence.*;
import java.util.List;

@Entity
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

    @OneToMany
    @JoinColumn(name = "rentalPropertyId")
    List<RentalProperty> rentalProperty;

    @ManyToMany(mappedBy = "addresses")
    List<Person> Persons;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<RentalProperty> getRentalProperty() {
        return rentalProperty;
    }

    public void setRentalProperty(List<RentalProperty> rentalProperty) {
        this.rentalProperty = rentalProperty;
    }

    public List<Person> getPersons() {
        return Persons;
    }

    public void setPersons(List<Person> persons) {
        Persons = persons;
    }
}



