package de.haubauer.db;

import de.haubauer.db.entities.RentalProperty;
import de.haubauer.db.BaseDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RentalPropertyDao extends BaseDao<RentalProperty> {
    public RentalPropertyDao() {
        super(RentalProperty.class);
    }
}
