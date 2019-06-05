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
}
