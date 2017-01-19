package monopoly.spielfelder;

import monopoly.spieler.Spieler;

/**
 * Diese Klasse dient als Super-Klasse fuer die restlichen Felder.
 *
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public class BesitzrechtFeld implements Spielfelder {

    protected int feldnummer;

    protected String feldname;

    protected int grundstueckswert;

    protected int miete;

    protected Boolean istGekauft = false;

    protected Spieler spieler; //merken welchem Spieler das Feld gehört

    protected String farbe = "";

    /**
     * Erzeugt ein neues BesitzrechtFeld mit den uebergebenen Parametern.
     *
     * @param feldnummer die Nummer des Feldes
     * @param feldname der Name des Feldes
     * @param grundstueckswert der Wert, den das entsprechende Feld hat
     * @param miete die Miete, die fuer das Feld zu zahlen ist
     */
    public BesitzrechtFeld(int feldnummer, String feldname, int grundstueckswert, int miete) {
        this.feldnummer = feldnummer;
        this.feldname = feldname;
        this.grundstueckswert = grundstueckswert;
        this.miete = miete;
    }

    /**
     * Dieser Konstruktor bekommt zusaetzlich eine Farbe uebergeben.
     *
     * @param feldnummer die Nummer des Feldes
     * @param feldname der Name des Feldes
     * @param grundstueckswert der Wert, den das entsprechende Feld hat
     * @param miete die Miete, die fuer das Feld zu zahlen ist
     * @param farbe die Farbe des BesitzrechtFeldes
     */
    public BesitzrechtFeld(int feldnummer, String feldname, int grundstueckswert, int miete, String farbe) {
        this.feldnummer = feldnummer;
        this.feldname = feldname;
        this.grundstueckswert = grundstueckswert;
        this.miete = miete;
        this.farbe = farbe;
    }

    @Override
    public void spielfeldAktion(Spieler s, Spielfelder f) {
        BesitzrechtFeld bf = (BesitzrechtFeld) f;

        if (bf.istGekauft) {
            if (bf instanceof Straße || bf instanceof Bahnhof) {
                s.mieteZahlen(bf);
            }
            if (bf instanceof Wasserwerk) {
                Wasserwerk w = (Wasserwerk) bf;
                w.setMiete(s.getWuerfelZahl() * 80);
                s.mieteZahlen(w);

            }
            if (bf instanceof Elektrizitätswerk) {
                Elektrizitätswerk e = (Elektrizitätswerk) bf;
                e.setMiete(s.getWuerfelZahl() * 80);
                s.mieteZahlen(e);

            }

        } else {
            s.kaufen(bf);
        }
    }

    public void setGekauft(boolean istGekauft) {
        this.istGekauft = istGekauft;
    }

    //wenn ein Feld von einem Spieler gekauft wird, muss der entsprechende Spieler im Attribut gesetzt werden
    public void setSpieler(Spieler spieler) {
        this.spieler = spieler;
    }

    public int getGrundstueckswert() {
        return grundstueckswert;
    }

    public int getMiete() {
        return miete;
    }

    public void setMiete(int miete) {
        this.miete = miete;
    }

    /**
     *
     * @return spieler der Spieler, dem das Feld gehoert
     */
    public Spieler getSpieler() {
        return spieler;
    }

    public String getFarbe() {
        return farbe;
    }

    @Override
    public int getFeldnummer() {
        return feldnummer;
    }

    @Override
    public String getFeldname() {
        return feldname;
    }

}
