package src.de.haubauer.db.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PaymentType")
public class PaymentType extends DatedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int paymentTypeId;

    String paymentTypeName;
    String PaymentTypeDescription;

    @OneToMany
    @JoinColumn(name = "paymentId")
    List<Payment> Payments;

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    public String getPaymentTypeDescription() {
        return PaymentTypeDescription;
    }

    public void setPaymentTypeDescription(String paymentTypeDescription) {
        PaymentTypeDescription = paymentTypeDescription;
    }

    public List<Payment> getPayments() {
        return Payments;
    }

    public void setPayments(List<Payment> payments) {
        Payments = payments;
    }
}
