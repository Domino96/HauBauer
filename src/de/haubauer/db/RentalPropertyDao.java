package de.haubauer.db;

import de.haubauer.db.entities.RentalProperty;
import de.haubauer.db.BaseDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RentalPropertyDao extends BaseDao<RentalProperty> {
    public RentalPropertyDao() {
        super(RentalProperty.class);
    }

    public List<RentalProperty> getAllTenants() {
        final Session session = this.getSessionFactory().getCurrentSession();
        final Transaction transaction = session.beginTransaction();

        final List<RentalProperty> list = this.queryBuilder(session)
                .where("role", "= :role")
                .setParameter("role", "Mieter")
                .build()
                .list();

        transaction.commit();

        return list;
    }
}
