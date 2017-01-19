package monopoly.spielfelder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import monopoly.spieler.Spieler;

/**
 * Diese Klasse stellt eine Straße dar, die von einem Spieler gekauft werden
 * kann.
 *
 * @author Liane Lin, Annika Schoettle, Carsten Gericke, Sali Hassan
 */
public class Straße extends BesitzrechtFeld implements Spielfelder {

    private int anzahlHaeuser = 0;

    private int anzahlHotels = 0;

    private int kostenHaus;

    private int kostenHotel;

    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

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
     * Ermoeglicht das Bauen eines Hotels auf einer uebergebenen Strasse.
     *
     * @param s Spieler dem das Feld gehört
     * @param str die Strasse, auf der das Hotel gebaut werden soll
     */
    private void hotelBauen(Spieler s, Straße str) {
        try {
            System.out.println("Du kannst in der Straße: " + str.getFeldname() + " max. " + (int) str.getAnzahlHaeuser() / 8 + " Hotels bauen, wieviele möchtest du Bauen?");
            System.out.println("Ein Hotel kostet: " + str.getKostenHotel());
            int anzahl = Integer.parseInt(br.readLine());
            if (anzahl <= (int) str.getAnzahlHaeuser() / 4) {
                str.setAnzahlHotels(anzahl);

                s.einzahlen((str.getKostenHotel() * anzahl));
                str.setAnzahlHaeuser(str.getAnzahlHaeuser() + (anzahl * 4) * (-1));
            }
        } catch (IOException ex) {
            Logger.getLogger(Straße.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Ermoeglicht das Bauen von Haeusern auf einer Straße
     *
     * @param spielder dem das Feld gehört
     * @param feld das Sielfeld, auf dem das Haus gebaut werden soll
     * @throws IOException falls beim Bauen des Hauses ein allgemeiner Fehler
     * auftritt
     */
    public void hausBauen(Spieler s, BesitzrechtFeld feld) throws IOException {
        System.out.println("Dein aktueller Kontostand beträgt: " + s.getKontostand());
        String color = feld.getFarbe();
        for (Map.Entry pair : s.getListe().entrySet()) {
            if (pair.getKey().equals(color)) {
                if (feld instanceof Straße) {
                    System.out.println("Wieviele Häuser möchtest du auf der Straße:" + feld.feldname + " bauen?");
                    System.out.println("Ein Haus kostet: " + ((Straße) feld).getKostenHaus());
                    int anzahl = Integer.parseInt(br.readLine());

                    Straße str = (Straße) feld;
                    if (s.einzahlen(str.getKostenHaus() * anzahl)) {
                        str.setAnzahlHaeuser(str.getAnzahlHaeuser() + anzahl);
                        if (str.getAnzahlHaeuser() >= 4) {
                            System.out.println("Möchtest du " + ((str.getAnzahlHaeuser()) - (str.getAnzahlHaeuser() % 4)) + " deiner " + str.getAnzahlHaeuser() + " Häuser in Hotels umwandeln?");
                            String eingabe = br.readLine();
                            if (eingabe.trim().toLowerCase().equals("status")) {
                                eingabe = s.meinStatus();
                            }
                            if (eingabe.trim().toLowerCase().equals("ja")) {
                                str.setAnzahlHaeuser(str.getAnzahlHaeuser() + anzahl);
                                hotelBauen(s, str);
                            } else {

                                System.out.println("Du hast für die Straße: " + str.getFeldname() + "," + anzahl + " Häuser gebaut, insgesamt hast du dort jetzt " + str.getAnzahlHaeuser() + " Häuser");
                                System.out.println("Dein neuer Kontostand beträgt: " + s.getKontostand());
                            }
                        }
                    }

                }
            }
        }
    }

    /**
     * Ermoeglicht das Aendern der Miete einer Strasse anhand der Haeuseranzahl
     * und Hotelanzahl.
     *
     * @param strassen die Strassen, bei denen die Miete geaendert werden soll
     */
    public void mieteÄndernStraße(ArrayList<Straße> strassen) {

        for (Straße s : strassen) {
            s.setMiete(s.getMiete() * 2);

            if (s.getAnzahlHaeuser() > 0) {
                s.setMiete(s.getMiete() * (s.getAnzahlHaeuser() * 5));

            }
            if (s.getAnzahlHotels() > 0) {
                s.setMiete(s.getMiete() * (s.getAnzahlHotels() * 10));

            }
            System.out.println("Miete der Straße: " + s.getFeldname() + " beträgt: " + s.getMiete());
        }

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
