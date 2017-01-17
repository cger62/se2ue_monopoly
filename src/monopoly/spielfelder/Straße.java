package monopoly.spielfelder;

import java.util.*;

/**
 *
 */
public class Straße extends BesitzrechtFeld implements Spielfelder{

    private int anzahlHaueser = 0;

    private int anzahlHotels = 0;

    private int kostenHaus;
    
     private int kostenHotel;

    /**
     * Default constructor
     *
     * @param feldnummer
     * @param feldname
     * @param grundstueckswert
     * @param hypothek
     * @param miete
     */
    public Straße(int feldnummer, String feldname, int grundstueckswert, int hypothek, int miete, String color, int kostenHaus, int kostenHotel) {
        super(feldnummer, feldname, grundstueckswert, hypothek, miete, color);
        this.kostenHaus = kostenHaus;
        this.kostenHotel = kostenHotel;
    }

    public int getAnzahlHaueser() {
        return anzahlHaueser;
    }

    public void setAnzahlHaueser(int anzahlHaueser) {
        this.anzahlHaueser = anzahlHaueser;
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
