package de.haubauer.business.models;

import de.haubauer.enums.PaymentType;
import de.haubauer.helpers.DatedObject;

import java.math.BigDecimal;
import java.util.Date;

public class Payment extends DatedObject {
    private int id;

    private Date date;
    private BigDecimal value;
    private BigDecimal billed;
    private String comment;
    private de.haubauer.business.models.Tenancy tenancy;
    private PaymentType paymentType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return this.paymentType;
    }

    public void setType(PaymentType type) {
        this.paymentType = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public de.haubauer.business.models.Tenancy getTenancy() {
        return tenancy;
    }

    public void setTenancy(de.haubauer.business.models.Tenancy tenancy) {
        this.tenancy = tenancy;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
