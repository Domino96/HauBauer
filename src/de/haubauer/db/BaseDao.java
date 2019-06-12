package de.haubauer.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Ein Basis-Data-Access-Object.
 * @param <T> Die Klasse der Entity, auf der Datenbankoperationen ausgeführt werden soll.
 */
public class BaseDao<T> {
    private static SessionFactory sessionFactory;
    private Class<T> clazz;

    public BaseDao(Class<T> clazz) {
        if (sessionFactory == null) {
            BaseDao.initialize();
        }
        
        this.clazz = clazz;
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
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
        final Session currentSession = sessionFactory.getCurrentSession();
        final Transaction transaction = currentSession.beginTransaction();

        for (int i = 0; i < entities.length; i++) {
            currentSession.save(entities[i]);

            if (i % 20 == 0) {
                currentSession.flush();
                currentSession.clear();
            }
        }

        transaction.commit();
    }

    /**
     * Speichert die übergebenen Entities in der Datenbank.
     * @param entities Eine Liste von Entities.
     */
    public final void save(List<T> entities) {
        final Session currentSession = sessionFactory.getCurrentSession();
        final Transaction transaction = currentSession.beginTransaction();

        for (int i = 0; i < entities.size(); i++) {
            currentSession.save(entities.get(i));

            if (i % 20 == 0) {
                try {
                    currentSession.flush();
                    currentSession.clear();
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
        final Session currentSession = sessionFactory.getCurrentSession();
        final Transaction transaction = currentSession.beginTransaction();

        for (int i = 0; i < entities.length; i++) {
            currentSession.update(entities[i]);

            if (i % 20 == 0) {
                currentSession.flush();
                currentSession.clear();
            }
        }

        transaction.commit();
    }

    /**
     * Updatet die übergebenen Entities in der Datenbank.
     * @param entities Eine Liste von Entities.
     */
    public final void update(List<T> entities) {
        final Session currentSession = sessionFactory.getCurrentSession();
        final Transaction transaction = currentSession.beginTransaction();

        for (int i = 0; i < entities.size(); i++) {
            currentSession.update(entities.get(i));

            if (i % 20 == 0) {
                currentSession.flush();
                currentSession.clear();
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
        final Session currentSession = sessionFactory.getCurrentSession();
        final Transaction transaction = currentSession.beginTransaction();

        for (int i = 0; i < entities.length; i++) {
            currentSession.delete(entities[i]);

            if (i % 20 == 0) {
                currentSession.flush();
                currentSession.clear();
            }
        }

        transaction.commit();
    }

    /**
     * Löscht die übergebenen Entities aus der Datenbank.
     * @param entities Eine Liste von Entities.
     */
    public final void delete(List<T> entities) {
        final Session currentSession = sessionFactory.getCurrentSession();
        final Transaction transaction = currentSession.beginTransaction();

        for (int i = 0; i < entities.size(); i++) {
            currentSession.delete(entities.get(i));

            if (i % 20 == 0) {
                currentSession.flush();
                currentSession.clear();
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
        return sessionFactory.getCurrentSession().get(this.getEntityClass(), id);
    }

    /**
     * Holt sich alle Entities vom Typ T.
     * @return Eine Liste aller Entities aus der Tabelle T.
     */
    public final List<T> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from " + this.getEntityClass().getSimpleName(), this.getEntityClass()).list();
    }

    /**
     * Holt sich limit Entities aus der Datenbank, angefangen von start.
     * @param start Wieviele Datensätze übersprungen werden sollen.
     * @param limit Wieviele Datensätze geholt werden sollen.
     * @return Eine Liste aller geholten Entities aus der Tabelle T.
     */
    public final List<T> getAll(int start, int limit) {
        return sessionFactory.getCurrentSession().createQuery("from " + this.getEntityClass().getSimpleName(), this.getEntityClass())
                .setFirstResult(start)
                .setMaxResults(limit)
                .list();
    }

    /**
     * Erstellt einen QueryBuilder aus der Entity.
     * @param session Die momentane Session.
     * @return Ein neuer QueryBuilder.
     */
    public final QueryBuilder queryBuilder(Session session) {
        return new QueryBuilder<>(session, this.getEntityClass());
    }
}
