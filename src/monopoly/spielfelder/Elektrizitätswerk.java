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
        super(feldnummer,feldname,grundstueckswert,miete,color);
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