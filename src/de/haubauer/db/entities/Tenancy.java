package src.de.haubauer.db.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Tenancy")
public class Tenancy extends DatedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tenancyId;

    private Date startDate;
    private Date endDate;
    private int status;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    @OneToMany
    @JoinColumn(name = "paymentId")
    private List<Payment> payments;

    @ManyToOne
    @JoinColumn(name = "rentalPropertyId")
    private RentalProperty rentalProperty;

    public int getTenancyId() {
        return tenancyId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public RentalProperty getRentalProperty() {
        return rentalProperty;
    }

    public void setRentalProperty(RentalProperty rentalProperty) {
        this.rentalProperty = rentalProperty;
    }
}
