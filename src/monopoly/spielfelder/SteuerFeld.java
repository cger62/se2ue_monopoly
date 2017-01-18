package monopoly.spielfelder;

import java.util.*;

/**
 * Diese Klasse stellt ein Steuerfeld dar. Wenn man auf eins dieser Felder gelangt, 
 * legt man eine bestimmte Summe in den Pott. 
 *
 * @author Liane Lin, Annika Schoettle, Carsten Gericke, Sali Hassan
 */
public class SteuerFeld implements Spielfelder {

    private int feldnummer;
    
    private String feldname;

    private int steuern;
    
    /**
     * Im Konstruktor wird ein Steuerfeld erzeugt mit folgenden Parametern:
     *
     * @param feldnummer
     * @param feldname
     * @param steuern
     */
    public SteuerFeld(int feldnummer, String feldname, int steuern) {
        this.feldnummer = feldnummer;
        this.feldname = feldname;
        this.steuern = steuern;
    }

    public int getSteuern() {
        return steuern;
    }

    @Override
    public int getFeldnummer() {
        return feldnummer;
    }

    @Override
    public String getFeldname() {
        return feldname; //To change body of generated methods, choose Tools | Templates.
    }
}
