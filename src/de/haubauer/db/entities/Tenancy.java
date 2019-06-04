import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Tenancy")
public class Tenancy extends DatedEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int tenancyId;

    Tenant tenant;
    Date startDate;
    Date endDate;
    List<Payment> payments;
    RentalProperty rental;
    int status;

}
