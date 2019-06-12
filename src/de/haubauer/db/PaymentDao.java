package de.haubauer.db;

import de.haubauer.db.entities.Payment;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PaymentDao extends BaseDao<Payment> {
    public PaymentDao() {
        super(Payment.class);
    }

    public List<Payment> getPaymentsForProperty(final int rentalPropertyId) {
        final Session session = this.getSessionFactory().getCurrentSession();
        final Transaction transaction = session.beginTransaction();

        final List<Payment> list = this.queryBuilder(session)
                .where("tenancy.rentalProperty.rentalPropertyId", "= :propertyId")
                .setParameter("propertyId", rentalPropertyId)
                .build()
                .list();

        transaction.commit();

        return list;
    }
}
