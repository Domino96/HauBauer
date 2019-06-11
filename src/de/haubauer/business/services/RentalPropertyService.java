package src.de.haubauer.business.services;

import de.haubauer.business.models.RentalProperty;
import src.de.haubauer.db.RentalPropertyDao;
import de.haubauer.helpers.Mapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class RentalPropertyService {
    private RentalPropertyDao rentalPropertyDao = new RentalPropertyDao();

    public List<RentalProperty> getAllRentalProperties() {
        return Mapper.getInstance().map(this.rentalPropertyDao.getAll(), new TypeToken<List<RentalProperty>>() {});
    }

    public void saveRentalProperty(RentalProperty rentalProperty) {
        this.rentalPropertyDao.save(Mapper.getInstance().map(rentalProperty, de.haubauer.db.entities.RentalProperty.class));
    }

    public void updateRentalProperty(RentalProperty rentalProperty) {
        this.rentalPropertyDao.update(Mapper.getInstance().map(rentalProperty, de.haubauer.db.entities.RentalProperty.class));
    }
}
