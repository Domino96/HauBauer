package HauBauer.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class BaseDao<T> {
    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    private Session session;
    private Class<T> clazz;

    public BaseDao(Class<T> clazz) {
        this.session = sessionFactory.openSession();
        this.clazz = clazz;
    }

    protected Class<T> getEntityClass() {
        return this.clazz;
    }

    @SafeVarargs
    public final void save(T... entities) {
        Transaction transaction = session.beginTransaction();

        for (int i = 0; i < entities.length; i++) {
            session.save(entities[i]);

            if (i % 20 == 0) {
                session.flush();
                session.clear();
            }
        }

        transaction.commit();
    }

    @SafeVarargs
    public final void update(T... entities) {
        Transaction transaction = session.beginTransaction();

        for (int i = 0; i < entities.length; i++) {
            session.update(entities[i]);

            if (i % 20 == 0) {
                session.flush();
                session.clear();
            }
        }

        transaction.commit();
    }

    @SafeVarargs
    public final void delete(T... entities) {
        Transaction transaction = session.beginTransaction();

        for (int i = 0; i < entities.length; i++) {
            session.delete(entities[i]);

            if (i % 20 == 0) {
                session.flush();
                session.clear();
            }
        }

        transaction.commit();
    }

    public final T getById(int id) {
        return session.get(this.getEntityClass(), id);
    }

    public final List<T> getAll() {
        return session.createQuery("from " + this.getEntityClass().getSimpleName(), this.getEntityClass()).list();
    }

    public final List<T> getAll(int start, int limit) {
        return session.createQuery("from " + this.getEntityClass().getSimpleName(), this.getEntityClass())
                .setFirstResult(start)
                .setMaxResults(limit)
                .list();
    }

    public void dispose() {
        if (session != null) {
            session.close();
        }

        sessionFactory.close();
    }
}
