package src.de.haubauer.db.entities;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RentalProperty")
public class RentalProperty extends DatedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int rentalPropertyId;

    String description;
    int zipCode;
    String town;
    double area;
    BigDecimal squareMeterPriceCold;
    BigDecimal sideCostsMonth;
    String note;
    @OneToMany
    @JoinColumn(name = "parent")
    List<RentalProperty> children = new ArrayList<RentalProperty>();
    @ManyToOne
    RentalProperty parent;
    int floor;

    @ManyToOne
    @JoinColumn(name = "adressId")
    Address address;

    @ManyToMany(mappedBy = "rentalPropertys")
    List<Person> persons;

    @OneToMany
    @JoinColumn(name = "tenancyId")
    List<Tenancy> tenancy;

    @ManyToOne
    @JoinColumn(name = "usageTypeId")
    UsageType usageType;

    @ManyToOne
    @JoinColumn(name = "rentalTypeId")
    RentalType rentalType;

    @ManyToOne
    @JoinColumn(name = "rentalRoleId")
    RentalRole rentalRole;


    public int getRentalPropertyId() {
        return rentalPropertyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public BigDecimal getSquareMeterPriceCold() {
        return squareMeterPriceCold;
    }

    public void setSquareMeterPriceCold(BigDecimal squareMeterPriceCold) {
        this.squareMeterPriceCold = squareMeterPriceCold;
    }

    public BigDecimal getSideCostsMonth() {
        return sideCostsMonth;
    }

    public void setSideCostsMonth(BigDecimal sideCostsMonth) {
        this.sideCostsMonth = sideCostsMonth;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<RentalProperty> getChildren() {
        return children;
    }

    public void setChildren(List<RentalProperty> children) {
        this.children = children;
    }

    public RentalProperty getParent() {
        return parent;
    }

    public void setParent(RentalProperty parent) {
        this.parent = parent;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Tenancy> getTenancy() {
        return tenancy;
    }

    public void setTenancy(List<Tenancy> tenancy) {
        this.tenancy = tenancy;
    }

    public UsageType getUsageType() {
        return usageType;
    }

    public void setUsageType(UsageType usageType) {
        this.usageType = usageType;
    }

    public RentalType getRentalType() {
        return rentalType;
    }

    public void setRentalType(RentalType rentalType) {
        this.rentalType = rentalType;
    }
}



