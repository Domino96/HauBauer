package de.haubauer.business.services;

import de.haubauer.business.models.Person;
import de.haubauer.db.BaseDao;
import de.haubauer.db.PersonDao;
import de.haubauer.db.entities.UserRole;
import de.haubauer.helpers.Mapper;
import org.modelmapper.TypeToken;

import java.util.List;
import java.util.Set;

public class PersonService {
    private PersonDao personDao = new PersonDao();
    private BaseDao<UserRole> userRoleDao = new BaseDao<>(UserRole.class);

    public List<Person> getAllTenants() {
        return Mapper.getInstance().map(this.personDao.getAllTenants(), new TypeToken<List<Person>>() {});
    }

    public void saveTenant(Person tenant) {
        this.personDao.save(Mapper.getInstance().map(tenant, de.haubauer.db.entities.Person.class));
    }

    public void updateTenant(Person tenant) {
        this.personDao.update(Mapper.getInstance().map(tenant, de.haubauer.db.entities.Person.class));
    }

    public List<de.haubauer.business.models.UserRole> getAvailableRoles() {
        return Mapper.getInstance().map(this.userRoleDao.getAll(), new TypeToken<List<de.haubauer.business.models.UserRole>>() {});
    }
}
