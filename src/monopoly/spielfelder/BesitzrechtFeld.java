package monopoly.spielfelder;


import java.util.*;
import monopoly.spieler.Spieler;

/**
 * 
 */
public class BesitzrechtFeld implements Spielfelder {


    private int feldnummer;

    public String feldname;

    public int grundstueckswert;

    private int hypothek;

    private int miete;

    public Boolean isGekauft;

    private Boolean isHypothek;
    
    private Spieler spieler; //merken welchem Spieler das Feld gehört

  public BesitzrechtFeld(int feldnummer, String feldname, int grundstueckswert, int hypothek, int miete) {
        this.feldnummer = feldnummer;
        this.feldname = feldname;
        this.grundstueckswert = grundstueckswert;
        this.hypothek = hypothek;
        this.miete = miete;
    }

    public void setHypothek(boolean isHypothek) {
        this.isHypothek = isHypothek;
    }
    
    public void setGekauft(boolean isGekauft) {
        this.isGekauft = isGekauft;
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
    
    public int getHypothek() {
        return hypothek;
    }
    
    public int getMiete() {
        return miete;
    }
    
    //welchem Spieler gehört das Feld
    public Spieler getSpieler() {
        return spieler;
    }

}