package monopoly.spielfelder;


import java.util.*;

/**
 * 
 */
public class NurZuBesuchFeld extends GefängnisFeld {

 private int feldnummer;

 //Default Constructor
    public NurZuBesuchFeld() {
    }

    public NurZuBesuchFeld(int feldnummer) {
        this.feldnummer = feldnummer;
    }

    public void setFeldnummer(int feldnummer) {
        this.feldnummer = feldnummer;
    }
}