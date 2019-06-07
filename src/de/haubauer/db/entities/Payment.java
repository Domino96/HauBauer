package src.de.haubauer.db.entities;

import src.de.haubauer.enums.PaymentType;
import src.de.haubauer.helpers.DatedObject;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Payment")
public class Payment extends DatedObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    private Date date;
    private BigDecimal value;
    private BigDecimal billed;
    private PaymentType type = PaymentType.Payment;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "tenancyId")
    private Tenancy tenancy;

    @ManyToOne
    @JoinColumn(name = "paymentTypeId")
    private PaymentType paymentType;

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

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
