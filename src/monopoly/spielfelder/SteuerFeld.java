package monopoly.spielfelder;


import java.util.*;

/**
 * 
 */
public class SteuerFeld  implements Spielfelder{

    int feldnummer;

    private int steuern;

    //Default Constructor

    
    

    public SteuerFeld(int feldnummer, int steuern) {
    this.feldnummer = feldnummer;
        this.steuern = steuern;
    }
    
  

    public int getSteuern() {
        return steuern;
    }

    @Override
    public int getFeldnummer() {
         return feldnummer;
    }
}