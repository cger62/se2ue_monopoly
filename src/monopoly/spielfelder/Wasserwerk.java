package monopoly.spielfelder;


import java.util.*;

/**
 * Diese Klasse stellt ein Wasserwerk dar, das für die Realisierung des Spiels benötigt wird. 
 *
 * @author Liane Lin, Annika Schoettle, Carsten Gericke, Sali Hassan
 */
public class Wasserwerk extends BesitzrechtFeld implements Spielfelder{

    /**
     * Der Konstruktor erzeugt ein Wasserwerk mit folgenenden Parametern:
     * 
     * @param feldnummer die Nummer des Feldes
     * @param feldname der Name des Feldes
     * @param grundstueckswert der Wert des Grundstuecks
     * @param miete die Höhe der Miete
     * @param farbe die Farbe des Feldes
     */
    public Wasserwerk(int feldnummer, String feldname, int grundstueckswert, int miete, String farbe) {
        super(feldnummer,feldname,grundstueckswert,miete,farbe );}

    @Override
    public int getFeldnummer() {
        return feldnummer;
    }

}