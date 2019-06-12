package de.haubauer.business.models;

import de.haubauer.enums.PaymentType;
import de.haubauer.helpers.DatedObject;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.math.BigDecimal;
import java.util.Date;

public class Payment extends DatedObject {
    private int id;
    private ObjectProperty<Date> date = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> value = new SimpleObjectProperty<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date.get();
    }

    public ObjectProperty<Date> dateProperty() {
        return date;
    }

    public void setDate(Date date) {
        this.date.set(date);
    }

    public BigDecimal getValue() {
        return value.get();
    }

    public ObjectProperty<BigDecimal> valueProperty() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value.set(value);
    }

    public BigDecimal getBilled() {
        return billed.get();
    }

    public ObjectProperty<BigDecimal> billedProperty() {
        return billed;
    }

    public void setBilled(BigDecimal billed) {
        this.billed.set(billed);
    }

    public String getComment() {
        return comment.get();
    }

    public StringProperty commentProperty() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment.set(comment);
    }

    public Tenancy getTenancy() {
        return tenancy.get();
    }

    public ObjectProperty<Tenancy> tenancyProperty() {
        return tenancy;
    }

    public void setTenancy(Tenancy tenancy) {
        this.tenancy.set(tenancy);
    }

    public PaymentType getPaymentType() {
        return paymentType.get();
    }

    public ObjectProperty<PaymentType> paymentTypeProperty() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType.set(paymentType);
    }

    private ObjectProperty<BigDecimal> billed = new SimpleObjectProperty<>();
    private StringProperty comment = new SimpleStringProperty("");

    private ObjectProperty<Tenancy> tenancy = new SimpleObjectProperty<>();
    private ObjectProperty<PaymentType> paymentType = new SimpleObjectProperty<>();

}
