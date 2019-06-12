package de.haubauer.business.services;

import de.haubauer.business.models.PaymentType;
import de.haubauer.db.BaseDao;
import de.haubauer.db.PaymentDao;
import de.haubauer.db.entities.Payment;
import de.haubauer.db.entities.RentalProperty;
import de.haubauer.helpers.Mapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class PaymentService {
    private PaymentDao dao = new PaymentDao();
    private BaseDao<de.haubauer.db.entities.PaymentType> paymentTypeDao = new BaseDao<>(de.haubauer.db.entities.PaymentType.class);

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

    public List<PaymentType> getPaymentTypes() {
        return Mapper.getInstance().map(paymentTypeDao.getAll(), new TypeToken<List<PaymentType>>() {});
    }
}
