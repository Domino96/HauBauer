package de.haubauer.db.entities;

import de.haubauer.helpers.DatedObject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PaymentType")
public class PaymentType extends DatedObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentTypeId;

    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "paymentId")
    private Set<Payment> Payments;

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Payment> getPayments() {
        return Payments;
    }

    public void setPayments(Set<Payment> payments) {
        Payments = payments;
    }
    public void setPayments(List<Payment> payments) {
        this.Payments = new HashSet<>(payments);
    }
}
