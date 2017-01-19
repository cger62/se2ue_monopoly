package monopoly.spielfelder;

import monopoly.map.MonopolyMap;
import monopoly.pott.Pott;
import monopoly.spieler.Spieler;

/**
 * Diese Klasse stellt ein Steuerfeld dar. Wenn man auf eins dieser Felder
 * gelangt, legt man eine bestimmte Summe in den Pott.
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
     * @param feldnummer die Nummer des Feldes
     * @param feldname der Name des Feldes
     * @param steuern die Summe der Steuern
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
        return feldname;
    }

    @Override
    public void spielfeldAktion(Spieler s, Spielfelder f) {
        SteuerFeld steuer = (SteuerFeld) f;
        if (steuer.getFeldnummer() == 4) {
            System.out.println("Dein aktueller Kontostand beträgt: " + s.getKontostand());
            System.out.println("Du musst 4000 Euro  Einkommenssteuer Zahlen");
            boolean einzahlen = s.einzahlen(4000);
            if (!einzahlen) {
                MonopolyMap.spielerVerloren(s.getSpielfigur());
            } else {
                Pott.einzahlen(steuer.getSteuern());
                System.out.println("Dein neuer Kontostand beträgt: " + s.getKontostand());
            }
        }
        if (steuer.getFeldnummer() == 38) {
            System.out.println("Dein aktueller Kontostand beträgt: " + s.getKontostand());
            System.out.println("Du musst 2000 Euro Zusatzsteuer Zahlen");
            boolean einzahlen = s.einzahlen(2000);
            if (!einzahlen) {
                MonopolyMap.spielerVerloren(s.getSpielfigur());
            } else {
                Pott.einzahlen(steuer.getSteuern());
                System.out.println("Dein neuer Kontostand beträgt: " + s.getKontostand());
            }
        }
    }
}
