package monopoly.spielfelder;


import java.util.*;

/**
 * 
 */
public class SteuerFeld implements Spielfelder {

    private int feldnummer;

    private int steuern;

    //Default Constructor
    public SteuerFeld() {
    }
    
    

    public SteuerFeld(int feldnummer, int steuern) {
        this.feldnummer = feldnummer;
        this.steuern = steuern;
    }
    
    public void setFeldnummer(int feldnummer) {
        this.feldnummer = feldnummer;
    }

    public int getSteuern() {
        return steuern;
    }
}