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
     * 
     * @param feldnummer
     * @param feldname
     * @param grundstueckswert
     * @param miete 
     */
  public BesitzrechtFeld(int feldnummer, String feldname, int grundstueckswert, int miete) {
        this.feldnummer = feldnummer;
        this.feldname = feldname;
        this.grundstueckswert = grundstueckswert;
        this.miete = miete;
    }
  
   public BesitzrechtFeld(int feldnummer, String feldname, int grundstueckswert, int miete, String color) {
      this.feldnummer = feldnummer;
        this.feldname = feldname;
        this.grundstueckswert = grundstueckswert;
        this.miete = miete;
        this.farbe =color;
    }

    
    public void setGekauft(boolean isGekauft) {
        this.istGekauft = isGekauft;
    }
    
    //wenn ein Feld von einem Spieler gekauft wird, muss der entsprechende Spieler im Attribut gesetzt werden
    public void setSpieler(Spieler spieler) {
        this.spieler = spieler;
    }
    
    public String getFeldname() {
        return feldname;
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
    
    //welchem Spieler gehört das Feld
    public Spieler getSpieler() {
        return spieler;
    }
    
        public String getFarbe() {
        return farbe;
    }

    @Override
    public int getFeldnummer() {
         return feldnummer;//To change body of generated methods, choose Tools | Templates.
    }

}