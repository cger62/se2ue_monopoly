package monopoly.spielfelder;

import java.util.*;

/**
 * Diese Klasse stellt eine Straße dar, die von einem Spieler gekauft werden kann.
 *
 * @author Liane Lin, Annika Schoettle, Carsten Gericke, Sali Hassan
 */
public class Straße extends BesitzrechtFeld implements Spielfelder{

    private int anzahlHaeuser = 0;

    private int anzahlHotels = 0;

    private int kostenHaus;
    
     private int kostenHotel;

    /**
     * Im Konstruktor wird eine Straße erzeugt mit folgenden Parametern:
     *
     * @param feldnummer die Nummer des Feldes
     * @param feldname der Name des Feldes
     * @param grundstueckswert Der Wert des Grundstuecks
     * @param miete die Höhe der Miete
     * @param farbe die Farbe der Straße
     * @param kostenHaus die Kosten eines Hauses
     * @param kostenHotel die Kosten eines Hotels
     */
    public Straße(int feldnummer, String feldname, int grundstueckswert, int miete, String farbe, int kostenHaus, int kostenHotel) {
        super(feldnummer, feldname, grundstueckswert, miete, farbe);
        this.kostenHaus = kostenHaus;
        this.kostenHotel = kostenHotel;
    }

    /**
     * @return die Anzahl der Haeuser
     */
    public int getAnzahlHaeuser() {
        return anzahlHaeuser;
    }

    public void setAnzahlHaeuser(int anzahlHaeuser) {
        this.anzahlHaeuser = anzahlHaeuser;
    }

    /**
     * @return die Anzahl der Hotels
     */
    public int getAnzahlHotels() {
        return anzahlHotels;
    }

    public void setAnzahlHotels(int anzahlHotels) {
        this.anzahlHotels = anzahlHotels;
    }

    /**
     * @return die Kosten eines Hauses
     */
    public int getKostenHaus() {
        return kostenHaus;
    }

    /**
     * @return die Kosten eines Hotels 
     */
    public int getKostenHotel() {
        return kostenHotel;
    }

    /**
     * @return die Nummer des Feldes 
     */
    @Override
    public int getFeldnummer() {
         return feldnummer;
    }

  

  

}
