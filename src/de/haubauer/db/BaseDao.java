package src.de.haubauer.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import de.haubauer.db.QueryBuilder;

import java.util.List;

/**
 * Ein Basis-Data-Access-Object.
 * @param <T> Die Klasse der Entity, auf der Datenbankoperationen ausgeführt werden soll.
 */
public class BaseDao<T> {
    private static SessionFactory sessionFactory;
    private Session session;
    private Class<T> clazz;

    public BaseDao(Class<T> clazz) {
        if (sessionFactory == null) {
            BaseDao.initialize();
        }

        this.session = sessionFactory.openSession();
        this.clazz = clazz;
    }

    public static void initialize() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    protected Class<T> getEntityClass() {
        return this.clazz;
    }

    /**
     * Speichert die übergebenen Entities in der Datenbank.
     * @param entities Eine mit Komma separierte Liste von Entities.
     */
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

    /**
     * Speichert die übergebenen Entities in der Datenbank.
     * @param entities Eine Liste von Entities.
     */
    public final void save(List<T> entities) {
        Transaction transaction = session.beginTransaction();

        for (int i = 0; i < entities.size(); i++) {
            session.save(entities.get(i));

            if (i % 20 == 0) {
                try {
                    session.flush();
                    session.clear();
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
        }

        transaction.commit();
    }

    /**
     * Updatet die übergebenen Entities in der Datenbank.
     * @param entities Eine mit Komma separierte Liste von Entities.
     */
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

    /**
     * Updatet die übergebenen Entities in der Datenbank.
     * @param entities Eine Liste von Entities.
     */
    public final void update(List<T> entities) {
        Transaction transaction = session.beginTransaction();

        for (int i = 0; i < entities.size(); i++) {
            session.update(entities.get(i));

            if (i % 20 == 0) {
                session.flush();
                session.clear();
            }
        }

        transaction.commit();
    }

    /**
     * Löscht die übergebenen Entities aus der Datenbank.
     * @param entities Eine mit Komma separierte Liste von Entities.
     */
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

    /**
     * Löscht die übergebenen Entities aus der Datenbank.
     * @param entities Eine Liste von Entities.
     */
    public final void delete(List<T> entities) {
        Transaction transaction = session.beginTransaction();

        for (int i = 0; i < entities.size(); i++) {
            session.delete(entities.get(i));

            if (i % 20 == 0) {
                session.flush();
                session.clear();
            }
        }

        transaction.commit();
    }

    /**
     * Holt sich die Entity mit der übergebenen ID aus der Datenbank.
     * @param id Die ID der Entity.
     * @return Die resultierende Entity.
     */
    public final T getById(int id) {
        return session.get(this.getEntityClass(), id);
    }

    /**
     * Holt sich alle Entities vom Typ T.
     * @return Eine Liste aller Entities aus der Tabelle T.
     */
    public final List<T> getAll() {
        return session.createQuery("from " + this.getEntityClass().getSimpleName(), this.getEntityClass()).list();
    }

    /**
     * Holt sich limit Entities aus der Datenbank, angefangen von start.
     * @param start Wieviele Datensätze übersprungen werden sollen.
     * @param limit Wieviele Datensätze geholt werden sollen.
     * @return Eine Liste aller geholten Entities aus der Tabelle T.
     */
    public final List<T> getAll(int start, int limit) {
        return session.createQuery("from " + this.getEntityClass().getSimpleName(), this.getEntityClass())
                .setFirstResult(start)
                .setMaxResults(limit)
                .list();
    }

    /**
     * Erstellt einen QueryBuilder aus der Entity.
     * @return Ein neuer QueryBuilder.
     */
    public final QueryBuilder queryBuilder() {
        return new QueryBuilder<>(session, this.getEntityClass());
    }

    /**
     * Disposed die session.
     */
    public void dispose() {
        if (session != null) {
            session.close();
        }
    }
}
