package monopoly.spielfelder;


import java.util.*;

/**
 * 
 */
public class Wasserwerk extends BesitzrechtFeld implements Spielfelder{

    /**
     * Default constructor
     */
    public Wasserwerk(int feldnummer, String feldname, int grundstueckswert, int hypothek, int miete, String color) {
        super(feldnummer,feldname,grundstueckswert,hypothek,miete,color );}

    @Override
    public int getFeldnummer() {
        return feldnummer;
    }

}