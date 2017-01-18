package monopoly.spielfelder;

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
