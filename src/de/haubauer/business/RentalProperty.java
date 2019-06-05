package src.de.haubauer.business;

import src.de.haubauer.db.BaseDao;
import src.de.haubauer.db.entities.RentalType;
import src.de.haubauer.db.entities.Tenancy;
import src.de.haubauer.db.entities.UsageType;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 */
public class RentalProperty {
   private RentalType type = RentalType.Private;
   private String description;
   private String address;
   private int zipCode;
   private String town;
   private double area;
   private BigDecimal squareMeterPriceCold;
   private BigDecimal sideCostsMonth;
   private String note;
   private Tenancy currentTenancy;
   private List<Tenancy> pastTenancy;
   private RentalProperty parent;
   private UsageType usageType;
   private int floor;

   BaseDao<RentalProperty> rentalDao = new BaseDao<>(RentalProperty.class);

    /**
     * Fügt ein Mietobjekt in die Datenbank hinzu
     * @param instance
     */
   public void add(RentalProperty instance){
       rentalDao.save(instance);
   }

    /**
     * Editiert den übergebenen Datensatz in der Datenbank
     * @param instance
     */
   public void edit( RentalProperty instance){
       rentalDao.update(instance);
   }

    /**
     * Löscht den übergebenen Datensatz in der Datenbank
     * @param instance
     */
   public void delete(RentalProperty instance){
       rentalDao.delete(instance);
   }


   /*GETTER     AND     SETTER*/

    public RentalType getType() {
        return type;
    }

    public void setType(RentalType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Tenancy getCurrentTenancy() {
        return currentTenancy;
    }

    public void setCurrentTenancy(Tenancy currentTenancy) {
        this.currentTenancy = currentTenancy;
    }

    public List<Tenancy> getPastTenancy() {
        return pastTenancy;
    }

    public void setPastTenancy(List<Tenancy> pastTenancy) {
        this.pastTenancy = pastTenancy;
    }

    public RentalProperty getParent() {
        return parent;
    }

    public void setParent(RentalProperty parent) {
        this.parent = parent;
    }

    public UsageType getUsageType() {
        return usageType;
    }

    public void setUsageType(UsageType usageType) {
        this.usageType = usageType;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
