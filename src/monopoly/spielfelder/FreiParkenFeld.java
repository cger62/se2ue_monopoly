package monopoly.spielfelder;


import java.util.*;

/**
 * 
 */
public class FreiParkenFeld implements Spielfelder{
    int feldnummer;
     

    /**
     * Default constructor
     */
    public FreiParkenFeld(int feldnummer) {
        this.feldnummer= feldnummer;
          
    }

    @Override
    public int getFeldnummer() {
        return feldnummer; //To change body of generated methods, choose Tools | Templates.
    }

   


}