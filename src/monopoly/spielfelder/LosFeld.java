package monopoly.spielfelder;


import java.util.*;

/**
 * 
 */
public class LosFeld implements Spielfelder {
    
    


int feldnummer;
    /**
     * Default constructor
     */
    public LosFeld(int feldnummer) {
        this.feldnummer = feldnummer;
      
     
        
    }

    /**
     * @return den festgelegten Betrag beim Überschreiten des Losfeldes 
     */
  

    @Override
    public int getFeldnummer() {
        return feldnummer;
    }

}