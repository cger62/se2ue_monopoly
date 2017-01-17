package monopoly.spielfelder;


import java.util.*;

/**
 * 
 */
public class NurZuBesuchFeld extends GefängnisFeld implements Spielfelder{

 

 //Default Constructor
  

    public NurZuBesuchFeld(int feldnummer) {
       super(feldnummer);
    }

    public void setFeldnummer(int feldnummer) {
        this.feldnummer = feldnummer;
    }

    @Override
    public int getFeldnummer() {
       return feldnummer;
    }
}