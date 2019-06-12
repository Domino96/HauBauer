package de.haubauer.business.services;

import de.haubauer.db.BaseDao;
import de.haubauer.db.entities.Payment;
import de.haubauer.helpers.Mapper;

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
        this.baseDao.save(Mapper.getInstance().map(payment, de.haubauer.db.entities.Payment.class));
    }

    public void updatePayment(Payment payment) {
        this.baseDao.update(Mapper.getInstance().map(payment, de.haubauer.db.entities.Payment.class));
    }
}
