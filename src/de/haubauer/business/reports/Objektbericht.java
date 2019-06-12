import java.util.Date;

public class Objektbericht {

    private String objNr;
    private String anschrift;
    //private String benutzername;
    private String mieter;

    private double offeneBetraege;
    //private String hinweis;

    private String monat;
    private Date datum;
    private double warmmiete;
    private double stellplatz;
    private double geleistet;
    private double offen;
    //private String hinweis;

    public Objektbericht() {
        super();
    }

    public Objektbericht(String objNr, String anschrift, String mieter,
                         double offeneBetraege, String monat, Date datum,
                         double warmmiete, double stellplatz, double geleistet,
                         double offen) {
        this.objNr = objNr;
        this.anschrift = anschrift;
        this.mieter = mieter;
        this.offeneBetraege = offeneBetraege;
        this.monat = monat;
        this.datum = datum;
        this.warmmiete = warmmiete;
        this.stellplatz = stellplatz;
        this.geleistet = geleistet;
        this.offen = offen;
    }

    public String getObjNr() {
        return objNr;
    }

    public void setObjNr(String objNr) {
        this.objNr = objNr;
    }

    public String getAnschrift() {
        return anschrift;
    }

    public void setAnschrift(String anschrift) {
        this.anschrift = anschrift;
    }

    public String getMieter() {
        return mieter;
    }

    public void setMieter(String mieter) {
        this.mieter = mieter;
    }

    public double getOffeneBetraege() {
        return offeneBetraege;
    }

    public void setOffeneBetraege(double offeneBetraege) {
        this.offeneBetraege = offeneBetraege;
    }

    public String getMonat() {
        return monat;
    }

    public void setMonat(String monat) {
        this.monat = monat;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getWarmmiete() {
        return warmmiete;
    }

    public void setWarmmiete(double warmmiete) {
        this.warmmiete = warmmiete;
    }

    public double getStellplatz() {
        return stellplatz;
    }

    public void setStellplatz(double stellplatz) {
        this.stellplatz = stellplatz;
    }

    public void setGeleistet(double geleistet) {
        this.geleistet = geleistet;
    }

    public double getGeleistet() {
        return geleistet;
    }

    public double getOffen() {
        return offen;
    }

    public void setOffen(double offen) {
        this.offen = offen;
    }
}
