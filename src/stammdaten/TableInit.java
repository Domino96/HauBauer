package stammdaten;

public class TableInit {

    private String anrede;
    private String vorname;
    private String nachname;
    private String anschrift;
    private String telefonnummer;
    private String email;
    private String kontoverbindung;

    public TableInit(
        String anrede,
        String vorname,
        String nachname,
        String anschrift,
        String telefonnummer,
        String email,
        String kontoverbindung
    ) {
        this.anrede = anrede;
        this.vorname = vorname;
        this.nachname = nachname;
        this.anschrift = anschrift;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.kontoverbindung = kontoverbindung;
    }

    public String getAnrede() {
        return anrede;
    }

    public void setAnrede(String anrede) {
        this.anrede = anrede;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getAnschrift() {
        return anschrift;
    }

    public void setAnschrift(String anschrift) {
        this.anschrift = anschrift;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKontoverbindung() {
        return kontoverbindung;
    }

    public void setKontoverbindung(String kontoverbindung) {
        this.kontoverbindung = kontoverbindung;
    }
}
