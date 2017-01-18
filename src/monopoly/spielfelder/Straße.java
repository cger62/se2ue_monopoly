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
     * @param feldnummer
     * @param feldname
     * @param grundstueckswert
     * @param hypothek
     * @param miete
     * @param farbe
     * @param kostenHaus
     * @param kostenHotel
     */
    public Straße(int feldnummer, String feldname, int grundstueckswert, int hypothek, int miete, String farbe, int kostenHaus, int kostenHotel) {
        super(feldnummer, feldname, grundstueckswert, miete, farbe);
        this.kostenHaus = kostenHaus;
        this.kostenHotel = kostenHotel;
    }

    public int getAnzahlHaeuser() {
        return anzahlHaeuser;
    }

    public void setAnzahlHaeuser(int anzahlHaeuser) {
        this.anzahlHaeuser = anzahlHaeuser;
    }

    public int getAnzahlHotels() {
        return anzahlHotels;
    }

    public void setAnzahlHotels(int anzahlHotels) {
        this.anzahlHotels = anzahlHotels;
    }

    public int getKostenHaus() {
        return kostenHaus;
    }

    public int getKostenHotel() {
        return kostenHotel;
    }

    @Override
    public int getFeldnummer() {
         return feldnummer;
    }

  

  

}
