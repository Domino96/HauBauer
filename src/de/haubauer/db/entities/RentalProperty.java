package de.haubauer.db.entities;


import de.haubauer.helpers.DatedObject;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RentalProperty")
public class RentalProperty extends DatedObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentalPropertyId;

    private String description;
    private double area;
    private BigDecimal squareMeterPriceCold;
    private BigDecimal sideCostsMonth;
    private String note;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent")
    private List<RentalProperty> children = new ArrayList<RentalProperty>();
    @ManyToOne(cascade = CascadeType.ALL)
    private RentalProperty parent;
    private int floor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private Address address;

    @ManyToMany(mappedBy = "rentalProperties", cascade = CascadeType.ALL)
    private List<Person> people;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tenancyId")
    private List<Tenancy> tenancy;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usageTypeId")
    private UsageType usageType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rentalTypeId")
    private RentalType rentalType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rentalRoleId")
    private RentalRole rentalRole;


    public int getRentalPropertyId() {
        return rentalPropertyId;
    }

    public void setRentalPropertyId(int rentalPropertyId) {
        this.rentalPropertyId = rentalPropertyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
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



