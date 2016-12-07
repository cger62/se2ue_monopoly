package monopoly.spielfelder;


import java.util.*;

/**
 * 
 */
public class Straße extends BesitzrechtFeld {

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
     * 
     */
    public int anzahlHaueser;

    /**
     * 
     */
    public int kostenHaus;

    /**
     * @param anzahl
     */
    public void addHaus(int anzahl) {
        // TODO implement here
    }

}