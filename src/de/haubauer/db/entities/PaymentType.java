package src.de.haubauer.db.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PaymentType")
public class PaymentType extends DatedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentTypeId;

    private String name;
    private String description;

    @OneToMany
    @JoinColumn(name = "paymentId")
    private List<Payment> Payments;

    public int getPaymentTypeId() {
        return paymentTypeId;
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

    public List<Payment> getPayments() {
        return Payments;
    }

    public void setPayments(List<Payment> payments) {
        Payments = payments;
    }
}
