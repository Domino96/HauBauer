package de.haubauer.business.services;

import de.haubauer.business.models.RentalProperty;
import de.haubauer.db.entities.RentalType;
import de.haubauer.db.entities.UsageType;
import de.haubauer.db.BaseDao;
import de.haubauer.db.RentalPropertyDao;
import de.haubauer.db.entities.RentalType;
import de.haubauer.helpers.Mapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class RentalPropertyService {
    private RentalPropertyDao rentalPropertyDao = new RentalPropertyDao();
    private BaseDao<RentalType> rentalTypeBaseDao = new BaseDao<>(RentalType.class);
    private  BaseDao<UsageType> usageTypeBaseDao = new BaseDao<>(UsageType.class);

    /**
     * Mappt die Meitobjekte aus der Datenbank auf den Business Type des Programmes
     * @return
     */
    public List<RentalProperty> getAllRentalProperties() {
        return Mapper.getInstance().map(this.rentalPropertyDao.getAll(), new TypeToken<List<RentalProperty>>() {});
    }

    /**
     * Mappt die Meitobjekte aus der Datenbank auf den Business Type des Programmes
     * @param rentalProperty
     */
    public void saveRentalProperty(RentalProperty rentalProperty) {
        this.rentalPropertyDao.save(Mapper.getInstance().map(rentalProperty, de.haubauer.db.entities.RentalProperty.class));
    }

    /**
     * Mappt die Meitobjekte aus der Datenbank auf den Business Type des Programmes
     * @param rentalProperty
     */
    public void updateRentalProperty(RentalProperty rentalProperty) {
        this.rentalPropertyDao.update(Mapper.getInstance().map(rentalProperty, de.haubauer.db.entities.RentalProperty.class));
    }

    /**
     * Mappt die Meitobjekte aus der Datenbank auf den Business Type des Programmes
     * @return
     */
    public List<de.haubauer.business.models.RentalType> getAvailableRentalTypes() {
        return Mapper.getInstance().map(this.rentalTypeBaseDao.getAll(), new TypeToken<List<de.haubauer.business.models.RentalType>>() {});
    }

    /**
     * Mappt die Meitobjekte aus der Datenbank auf den Business Type des Programmes
     * @return
     */
    public List<de.haubauer.business.models.UsageType> getAvailableUsagetypes() {
        return Mapper.getInstance().map(this.usageTypeBaseDao.getAll(), new TypeToken<List<de.haubauer.business.models.UsageType>>() {});
    }
}
