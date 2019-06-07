package src.de.haubauer.helpers;

import java.util.Date;

public abstract class DatedObject implements Comparable<DatedObject> {
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

    @Override
    public int compareTo(DatedObject o) {
        return this.getDateCreated().compareTo(o.getDateCreated());
    }
}
