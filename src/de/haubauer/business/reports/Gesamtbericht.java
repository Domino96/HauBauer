public class Gesamtbericht {
    private String wohnung;
    private double zahlungenIst;
    private double zahlungenSoll;
    private double fehlbetrag;

    public Gesamtbericht() {
        super();
    }

    public  Gesamtbericht(String wohnung, double zahlungenIst, double zahlungenSoll, double fehlbetrag){
        this.wohnung = wohnung;
        this.zahlungenIst = zahlungenIst;
        this.zahlungenSoll = zahlungenSoll;
        this.fehlbetrag = fehlbetrag;
    }

    public String getWohnung() {
        return wohnung;
    }

    public void setWohnung(String strasse, String plz, String ort, String objNr) {
        wohnung = "Anschrift: " + strasse + ", " + plz + " " + ort + "\n" + objNr;
        this.wohnung = wohnung;
    }

    public double getZahlungenIst() {
        return zahlungenIst;
    }

    public void setZahlungenIst(double zahlungenIst) {
        this.zahlungenIst = zahlungenIst;
    }

    public double getZahlungenSoll() {
        return zahlungenSoll;
    }

    public void setZahlungenSoll(double zahlungenSoll) {
        this.zahlungenSoll = zahlungenSoll;
    }

    public double getFehlbetrag() {
        return fehlbetrag;
    }

    public void setFehlbetrag(double fehlbetrag) {
        this.fehlbetrag = fehlbetrag;
    }
}
