package de.haubauer.db;

import de.haubauer.db.entities.Person;

import java.util.List;

public class PersonDao extends BaseDao<Person> {
    public PersonDao() {
        super(Person.class);
    }

    public List<Person> getAllTenants() {
        return this.queryBuilder()
                .where("role", "= :role")
                .setParameter("role", "Mieter")
                .build()
                .list();
    }
}
