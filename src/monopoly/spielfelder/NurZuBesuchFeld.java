package monopoly.spielfelder;


import java.util.*;

/**
 * Diese Klasse stellt das NurZuBesuchfeld dar, das für die Realisierung des Spiels benötigt wird.
 *
 * @author Liane Lin, Annika Schoettle, Carsten Gericke, Sali Hassan
 */
public class NurZuBesuchFeld extends GefängnisFeld implements Spielfelder{

    /**
     * Im Konstruktor wird ein NurzuBesuchfeld mit folgenden Parametern erzeugt:
     *
     * @param feldnummer die Nummer des Feldes
     * @param feldname der Name des Feldes
     */
    public NurZuBesuchFeld(int feldnummer, String feldname) {
       super(feldnummer, feldname);
    }

    public void setFeldnummer(int feldnummer) {
        this.feldnummer = feldnummer;
    }

    /**
     * @return die Nummer des Feldes
     */
    @Override
    public int getFeldnummer() {
       return feldnummer;
    }
}