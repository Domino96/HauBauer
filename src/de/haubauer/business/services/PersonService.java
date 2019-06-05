package src.de.haubauer.business.services;

import src.de.haubauer.business.models.Person;
import src.de.haubauer.db.PersonDao;
import src.de.haubauer.helpers.Mapper;

import java.util.List;

public class PersonService {
    private PersonDao personDao = new PersonDao();

    public List<Person> getAllTenants() {
        return Mapper.map(this.personDao.getAllTenants(), Person.class);
    }
}
