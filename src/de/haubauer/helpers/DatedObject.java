package de.haubauer.helpers;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Repräsentiert ein mit Erstelldatum datiertes Objekt.
 */
@MappedSuperclass
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
