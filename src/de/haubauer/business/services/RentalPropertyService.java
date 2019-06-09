package de.haubauer.business.services;

import de.haubauer.db.RentalPropertyDao;
import de.haubauer.business.models.RentalProperty;
import de.haubauer.helpers.Mapper;

import java.util.ArrayList;
import java.util.List;

public class RentalPropertyService {
    private RentalPropertyDao rentalPropertyDao = new RentalPropertyDao();

    public List<RentalProperty> getAllRentalProperies() {
        // return Mapper.map(this.personDao.getAllTenants(), Person.class);
        return Mapper.getInstance().map(this.rentalPropertyDao.getAll(),RentalProperty.class);

        // return Mapper.map(this.personDao.getAllTenants(), Person.class);
    }

    public void saveRentalProperty(RentalProperty rentalProperty) {
        this.rentalPropertyDao.save(Mapper.getInstance().map(rentalProperty, de.haubauer.db.entities.RentalProperty.class));
    }

    public void updateRentalProperty(RentalProperty rentalProperty) {
        this.rentalPropertyDao.update(Mapper.getInstance().map(rentalProperty, de.haubauer.db.entities.RentalProperty.class));
    }
}
