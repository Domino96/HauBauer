package src.de.haubauer.business.services;

import src.de.haubauer.business.models.Address;
import src.de.haubauer.business.models.BankAccount;
import src.de.haubauer.business.models.Person;
import src.de.haubauer.db.PersonDao;
import src.de.haubauer.enums.AddressStatus;
import src.de.haubauer.enums.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonService {
    private PersonDao personDao = new PersonDao();
    private Random random = new Random();

    public List<Person> getAllTenants() {
        // return Mapper.map(this.personDao.getAllTenants(), Person.class);

        List<Person> tenants = new ArrayList<>();

        for (int i = 0; i < 200; i++) {
            tenants.add(this.generatePerson());
        }

        return tenants;
    }

    private Person generatePerson() {
        Person person = new Person();

        person.setTitle(random.nextBoolean() ? "Herr" : "Frau");
        person.setRole(Role.Tenant);
        person.setEmail("test@test.de");
        person.setFirstName("Christian");
        person.setLastName("Schulze");
        person.setLandline("051257987");
        person.setMobile("15775325");

        Address address1 = new Address();
        address1.setNumber(random.nextInt(200));
        address1.setStreet("Superstraße");
        address1.setTown("Somethingtown");
        address1.setZipCode(50532);

        int randomNumber = random.nextInt(2);

        switch (randomNumber) {
            case 0: address1.setStatus(AddressStatus.Primary); break;
            case 1: address1.setStatus(AddressStatus.Secondary); break;
            case 2: address1.setStatus(AddressStatus.Outdated); break;
        }

        person.getAddresses().add(address1);

        BankAccount bankAccount = new BankAccount();

        bankAccount.setBank("Raiffeisenbank");
        bankAccount.setBic("06532756543654");
        bankAccount.setIban("253634664643");
        bankAccount.setOwner("Saimann Laidwig");
        bankAccount.setPerson(person);

        person.setBankAccount(bankAccount);

        return person;
    }
}
