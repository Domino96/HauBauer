import java.util.Date;

public abstract class DatedEntity {
    private Date dateCreated;


    public DatedEntity() {
        this.dateCreated = new Date();
    }
}
