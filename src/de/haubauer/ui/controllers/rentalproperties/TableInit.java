package src.de.haubauer.ui.controllers.rentalproperties;

public class TableInit {

    private String nummer;
    private String typ;
    private String beschreibung;
    private String anschrift;
    private String wohnflaeche;
    private String qm;
    private String nebenkosten;
    private String notiz;

    public TableInit(
        String nummer,
        String typ,
        String beschreibung,
        String anschrift,
        String wohnflaeche,
        String qm,
        String nebenkosten,
        String notiz
    ) {
        this.nummer = nummer;
        this.typ = typ;
        this.beschreibung = beschreibung;
        this.anschrift = anschrift;
        this.wohnflaeche = wohnflaeche;
        this.qm = qm;
        this.nebenkosten = nebenkosten;
        this.notiz = notiz;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getAnschrift() {
        return anschrift;
    }

    public void setAnschrift(String anschrift) {
        this.anschrift = anschrift;
    }

    public String getWohnflaeche() {
        return wohnflaeche;
    }

    public void setWohnflaeche(String wohnflaeche) {
        this.wohnflaeche = wohnflaeche;
    }

    public String getQm() {
        return qm;
    }

    public void setQm(String qm) {
        this.qm = qm;
    }

    public String getNebenkosten() {
        return nebenkosten;
    }

    public void setNebenkosten(String nebenkosten) {
        this.nebenkosten = nebenkosten;
    }

    public String getNotiz() {
        return notiz;
    }

    public void setNotiz(String notiz) {
        this.notiz = notiz;
    }
}
