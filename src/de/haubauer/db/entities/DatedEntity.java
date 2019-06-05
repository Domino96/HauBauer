package src.de.haubauer.db.entities;

import java.util.Date;

public abstract class DatedEntity {
    private Date dateCreated;


    public DatedEntity() {
        this.dateCreated = new Date();
    }
}
