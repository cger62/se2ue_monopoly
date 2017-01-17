package monopoly.spielfelder;


import java.util.*;

/**
 * 
 */
public class Elektrizitätswerk extends BesitzrechtFeld implements Spielfelder {

    /**
     * Default constructor
     */
    public Elektrizitätswerk(int feldnummer, String feldname, int grundstueckswert, int hypothek, int miete, String color) {
        super(feldnummer,feldname,grundstueckswert,hypothek,miete,color);
    }

    @Override
    public int getFeldnummer() {
        return feldnummer;//To change body of generated methods, choose Tools | Templates.
    }

}