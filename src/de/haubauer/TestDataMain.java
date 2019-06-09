package de.haubauer;

import de.haubauer.db.BaseDao;
import de.haubauer.db.TestDataGenerator;
import de.haubauer.db.entities.RentalProperty;

public class TestDataMain {
    public static void main(String[] args) {
        BaseDao<RentalProperty> rentalPropertyBaseDao = new BaseDao<>(RentalProperty.class);

        TestDataGenerator testDataGenerator = new TestDataGenerator();

        rentalPropertyBaseDao.save(testDataGenerator.generateRental(10));
    }
}

