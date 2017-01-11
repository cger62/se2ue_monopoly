package monopoly.spielfelder;


import java.util.*;

/**
 * 
 */
public class Straße extends BesitzrechtFeld {
    
    
    private int anzahlHaueser;

    private int kostenHaus;

    /**
     * Default constructor
     * @param feldnummer
     * @param feldname
     * @param grundstueckswert
     * @param hypothek
     * @param miete
     */
    public Straße(int feldnummer, String feldname, int grundstueckswert, int hypothek, int miete) {
        super(feldnummer,feldname,grundstueckswert,hypothek,miete);
    }


    /**
     * @param anzahl
     */
    public void addHaus(int anzahl) {
        // TODO implement here
    }

}