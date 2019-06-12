package de.haubauer.business.services;

import de.haubauer.business.models.Person;
import de.haubauer.db.PersonDao;
import de.haubauer.helpers.Mapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class PersonService {
    private PersonDao personDao = new PersonDao();

    public List<Person> getAllTenants() {
        return Mapper.getInstance().map(this.personDao.getAllTenants(), new TypeToken<List<Person>>() {});
    }

    public void saveTenant(Person tenant) {
        this.personDao.save(Mapper.getInstance().map(tenant, de.haubauer.db.entities.Person.class));
    }

    public void updateTenant(Person tenant) {
        this.personDao.update(Mapper.getInstance().map(tenant, de.haubauer.db.entities.Person.class));
    }
}
