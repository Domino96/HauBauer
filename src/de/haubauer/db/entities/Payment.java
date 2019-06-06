package src.de.haubauer.db.entities;

import src.de.haubauer.enums.PaymentType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Payment")
public class Payment extends DatedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int paymentId;

    Date date;
    BigDecimal value;
    BigDecimal billed;
    PaymentType type = PaymentType.Payment;
    String comment;

    @ManyToOne
    @JoinColumn(name = "tenancyId")
    Tenancy tenancy;

    @ManyToOne
    @JoinColumn(name = "paymentTypeId")
    src.de.haubauer.db.entities.PaymentType paymentType;

    public int getPaymentId() {
        return paymentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getBilled() {
        return billed;
    }

    public void setBilled(BigDecimal billed) {
        this.billed = billed;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Tenancy getTenancy() {
        return tenancy;
    }

    public void setTenancy(Tenancy tenancy) {
        this.tenancy = tenancy;
    }

    public src.de.haubauer.db.entities.PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(src.de.haubauer.db.entities.PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
