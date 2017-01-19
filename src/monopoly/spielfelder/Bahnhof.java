package monopoly.spielfelder;

import java.util.ArrayList;
import monopoly.spieler.Spieler;

/**
 * Diese Klasse realisiert den Bahnhof, welcher fuer das Spiel benoetigt wird.
 *
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public class Bahnhof extends BesitzrechtFeld implements Spielfelder {

    /**
     * Erzeugt einen neuen Bahnhof mit Hilfe der Super-Klasse BesitzrechtFeld.
     *
     * @param feldnummer die Nummer des Feldes
     * @param feldname der Name des Feldes
     * @param grundstueckswert der Wert des Grundstuecks
     * @param miete die Miete, die gezahlt werden muss
     * @param farbe die Farbe des Feldes
     */
    public Bahnhof(int feldnummer, String feldname, int grundstueckswert, int miete, String farbe) {
        super(feldnummer, feldname, grundstueckswert, miete, farbe);
    }

    @Override
    public int getFeldnummer() {
        return feldnummer;
    }

    @Override
    public String getFeldname() {
        return feldname;
    }

    /**
     * Ermoeglicht das Aendern des Mietbetrages eines Bahnhofs anhand der Anzahl
     * der Bahnhoefe. Je mehr Bahnhoefe vorhanden sind, desto hoeher ist die zu
     * zahlende Miete.
     */
    public void mieteÄndernBahnhof(ArrayList<Bahnhof> bahnhoefe) {

        if (bahnhoefe.size() == 2) {
            for (Spielfelder s : bahnhoefe) {
                Bahnhof b = (Bahnhof) s;
                b.setMiete(b.getMiete() * 2);
                System.out.println("Miete des Bahnhofs: " + b.getFeldname() + " beträgt: " + b.getMiete());
            }
        }
        if (bahnhoefe.size() == 3) {
            for (Spielfelder s : bahnhoefe) {
                Bahnhof b = (Bahnhof) s;
                b.setMiete(b.getMiete() * 4);
                System.out.println("Miete des Bahnhofs: " + b.getFeldname() + " beträgt: " + b.getMiete());
            }
        }
        if (bahnhoefe.size() == 4) {
            for (Spielfelder s : bahnhoefe) {
                Bahnhof b = (Bahnhof) s;
                b.setMiete(b.getMiete() * 8);
                System.out.println("Miete des Bahnhofs: " + b.getFeldname() + " beträgt: " + b.getMiete());
            }
        }
    }

}
