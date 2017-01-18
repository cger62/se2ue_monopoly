package monopoly.spielfelder;

import monopoly.spieler.Spieler;

/**
 * Diese Klasse dient als Super-Klasse fuer die restlichen Felder.
 * 
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */

public class BesitzrechtFeld  implements Spielfelder{

    int feldnummer;
    
    public String feldname;

    public int grundstueckswert;

    private int miete;

    public Boolean istGekauft = false;
    
    private Spieler spieler; //merken welchem Spieler das Feld gehört
    
    private String farbe ="";

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
        this.farbe =farbe;
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