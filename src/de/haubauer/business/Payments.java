package src.de.haubauer.business;


import src.de.haubauer.enums.PaymentType;
import src.de.haubauer.db.entities.Tenancy;

import java.math.BigDecimal;
import java.util.Date;


public class Payments {

    private int id;
    private Date date;
    private Tenancy tenancy;
    private BigDecimal value;
    private BigDecimal billed;
    private PaymentType type;
    private String comment;


    private void decidePaymentTypeAction()
    {
        switch(type) {
            case Payment:
                setCashInputBilled();
                break;

            case SideCostStatement:
                setSideCostStatementValue();
                break;

            default:
                break;
        }

    }

    //SRF3.1
    private BigDecimal setCashInputBilled()
    {
        //Werte aus DB zu Objekt zusammenrechnen zu Warmmiete
        //Wert setzen


        return billed;
    };

    //SRF3.2
    private BigDecimal setSideCostStatementValue()
    {
        //Werte aus DB zu Objekt an PaymentTabelle - alle NK-Beträge zu einem bestimmten Zeitraum

        return value;
    }










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

    public Tenancy getTenancy() {
        return tenancy;
    }

    public void setTenancy(Tenancy tenancy) {
        this.tenancy = tenancy;
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















}
