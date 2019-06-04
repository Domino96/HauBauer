import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Payment")
public class Payment extends DatedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    Date date;
    Tenancy tenancy;
    BigDecimal value;
    BigDecimal billed;
    PaymentType type;
    String comment;

}
