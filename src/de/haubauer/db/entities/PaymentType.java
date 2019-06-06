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

}
