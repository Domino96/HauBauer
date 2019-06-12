package de.haubauer.db;

import de.haubauer.db.entities.Person;
import de.haubauer.db.entities.UserRole;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PersonDao extends BaseDao<Person> {
    public PersonDao() {
        super(Person.class);
    }

    public List<Person> getAllTenants() {
        final int userRoleId = this.getTenantRole().getUserRoleId();
        final Session session = this.getSessionFactory().getCurrentSession();
        final Transaction transaction = session.beginTransaction();

        final List<Person> list = this.queryBuilder(session)
                .where("role.userRoleId", "= :role")
                .setParameter("role", userRoleId)
                .build()
                .list();

        //final List<Person> list = this.getAll();

        transaction.commit();

        return list;
    }

    public List<Person> getAllTenants(int start, int limit) {
        final int userRoleId = this.getTenantRole().getUserRoleId();
        final Session session = this.getSessionFactory().getCurrentSession();
        final Transaction transaction = session.beginTransaction();

        final List<Person> list = this.getAll(start, limit);

        transaction.commit();

        return list;
    }

    public UserRole getTenantRole() {
        final Session session = this.getSessionFactory().getCurrentSession();
        final Transaction transaction = session.beginTransaction();

        List<UserRole> list = new BaseDao<>(UserRole.class)
                .queryBuilder(session)
                .where("name", "= :name")
                .setParameter("name", "Mieter")
                .build()
                .list();

        transaction.commit();

        if (list.isEmpty()) {
            throw new RuntimeException("Role Mieter does not exist!");
        }

        return list.get(0);
    }
}
