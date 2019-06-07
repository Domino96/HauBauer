package src.de.haubauer.helpers;

import java.util.Date;

public abstract class DatedObject {
    private Date dateCreated;


    public DatedObject() {
        this.dateCreated = new Date();
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
