package de.haubauer;

import de.haubauer.db.BaseDao;
import de.haubauer.db.PersonDao;
import de.haubauer.db.TestDataGenerator;
import de.haubauer.db.entities.Person;
import de.haubauer.db.entities.RentalProperty;
import de.haubauer.db.entities.UserRole;

public class TestDataMain {
    public static void main(String[] args) {
        UserRole tenantRole = createRoles();

        BaseDao<RentalProperty> rentalPropertyBaseDao = new BaseDao<>(RentalProperty.class);
        BaseDao<Person> personDao = new BaseDao<>(Person.class);

        TestDataGenerator testDataGenerator = new TestDataGenerator();

        rentalPropertyBaseDao.save(testDataGenerator.generateRental(100));
        personDao.save(testDataGenerator.generatePerson(100, tenantRole));
    }

    /**
     * Erstellt die benötigten Rollen wenn sie noch nicht existieren.
     * @return Die Mieterrolle.
     */
    private static UserRole createRoles() {
        try {
            return new PersonDao().getTenantRole();
        } catch (RuntimeException e) {
            BaseDao<UserRole> userRoleDao = new BaseDao<>(UserRole.class);

            UserRole tenantRole = new UserRole();
            tenantRole.setName("Mieter");
            tenantRole.setDescription("Mietperson");

            userRoleDao.save(tenantRole);

            return tenantRole;
        }
    }
}

