package src.de.haubauer.db.entities;

import java.util.Date;

public abstract class DatedEntity {
    private Date dateCreated;


    public DatedEntity() {
        this.dateCreated = new Date();
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
