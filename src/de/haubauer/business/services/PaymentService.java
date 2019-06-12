package de.haubauer.business.services;

import de.haubauer.db.PaymentDao;
import de.haubauer.db.entities.Payment;
import de.haubauer.db.entities.RentalProperty;
import de.haubauer.helpers.Mapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class PaymentService {
    private PaymentDao dao = new PaymentDao();

    public List<de.haubauer.business.models.Payment> getPayments(final de.haubauer.business.models.RentalProperty rentalProperty) {
        return Mapper.getInstance().map(this.dao.getPaymentsForProperty(rentalProperty.getId()),
                new TypeToken<List<de.haubauer.business.models.Payment>>() {});
    }

    public void savePayment(de.haubauer.business.models.Payment payment) {
        this.dao.save(Mapper.getInstance().map(payment, Payment.class));
    }

    public void updatePayment(de.haubauer.business.models.Payment payment) {
        this.dao.update(Mapper.getInstance().map(payment, Payment.class));
    }
}
