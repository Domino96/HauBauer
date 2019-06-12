package src.de.haubauer.business.services;

import src.de.haubauer.business.models.Person;
import src.de.haubauer.db.BaseDao;
import src.de.haubauer.db.entities.Payment;
import src.de.haubauer.helpers.Mapper;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {
    private BaseDao baseDao = new BaseDao<>(Payment.class);

    public List<Payment> getAllPayments() {
        // return Mapper.map(this.personDao.getAllTenants(), Person.class);

        List<Payment> zahlung = new ArrayList<>();

        zahlung = baseDao.getAll();

        return zahlung;
    }

    public void savePayment(Payment payment) {
        this.baseDao.save(Mapper.map(payment, src.de.haubauer.db.entities.Payment.class));
    }

    public void updatePayment(Payment payment) {
        this.baseDao.update(Mapper.map(payment, src.de.haubauer.db.entities.Payment.class));
    }
}
