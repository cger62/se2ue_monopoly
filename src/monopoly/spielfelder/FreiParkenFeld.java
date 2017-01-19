package monopoly.spielfelder;

import monopoly.pott.Pott;
import monopoly.spieler.Spieler;

/**
 * Diese Klasse realisiert das FreiParkenFeld. Wenn jemand auf diesem Spielfeld
 * landet, erhaelt der Spieler den Inhalt des Potts. Die Klasse implementiert
 * das Interface Spielfelder.
 *
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public class FreiParkenFeld implements Spielfelder {

    private int feldnummer;

    private String feldname;

    /**
     * Erzeugt ein FreiParkenFeld anhand der uebergebenen Methodenparamter.
     *
     * @param feldnummer die Nummer des FreiParkenFeldes
     * @param feldname der Name des Spielfeldes
     */
    public FreiParkenFeld(int feldnummer, String feldname) {
        this.feldnummer = feldnummer;
        this.feldname = feldname;

    }

    @Override
    public int getFeldnummer() {
        return feldnummer;
    }

    @Override
    public String getFeldname() {
        return feldname;
    }

    @Override
    public void spielfeldAktion(Spieler s, Spielfelder f) {
        System.out.println("Dein aktueller Kontostand beträgt: " + s.getKontostand());
        System.out.println("Glückwunsch, du bist auf Frei Parken und erhälst den gesamten Pott in Höhe von: " + Pott.getKontostand());
        s.setKontostand(s.getKontostand() + Pott.auszahlen(Pott.getKontostand()));
        System.out.println("Dein neuer Kontostand beträgt: " + s.getKontostand());
    }

}
