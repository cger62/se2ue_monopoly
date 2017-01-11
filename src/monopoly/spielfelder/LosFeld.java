package monopoly.spielfelder;


import java.util.*;

/**
 * 
 */
public class LosFeld implements Spielfelder {
    
    public int losGeld;

    public int feldnummer;

    /**
     * Default constructor
     */
    public LosFeld() {
        losGeld = 200;
        feldnummer = 1; 
    }

    /**
     * @return den festgelegten Betrag beim Überschreiten des Losfeldes 
     */
    public int auszahlen() {
        return 200;
    }

}