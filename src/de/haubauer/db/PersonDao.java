package src.de.haubauer.db;

import src.de.haubauer.db.entities.Person;

import java.util.List;

public class PersonDao extends BaseDao<Person> {
    public PersonDao() {
        super(Person.class);
    }

    public List<Person> getAllTenants() {
        return this.queryBuilder().where("role", "= Mieter").build().list();
    }
}
