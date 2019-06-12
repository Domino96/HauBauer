package de.haubauer.db;

import de.haubauer.db.entities.RentalProperty;
import de.haubauer.db.BaseDao;

import java.util.List;

public class RentalPropertyDao extends BaseDao<RentalProperty> {
    public RentalPropertyDao() {
        super(RentalProperty.class);
    }

    public List<RentalProperty> getAllTenants() {
        return this.queryBuilder()
                .where("role", "= :role")
                .setParameter("role", "Mieter")
                .build()
                .list();
    }
}
