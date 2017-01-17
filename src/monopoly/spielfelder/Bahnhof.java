package monopoly.spielfelder;


import java.util.*;

/**
 * 
 */
public class Bahnhof extends BesitzrechtFeld implements Spielfelder {

    /**
     * Default constructor
     */
    public Bahnhof(int feldnummer, String feldname, int grundstueckswert, int hypothek, int miete, String color) {
        super(feldnummer,feldname,grundstueckswert,hypothek,miete, color);
    }

}