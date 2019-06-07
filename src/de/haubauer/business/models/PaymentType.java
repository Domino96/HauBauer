package src.de.haubauer.business.models;

import src.de.haubauer.helpers.DatedObject;

import java.util.List;

public class PaymentType extends DatedObject {
    private int id;

    private String name;
    private String description;

    private List<Payment> payments;

    public int getId() {
        return id;
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
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
