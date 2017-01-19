package monopoly.spielfelder;

import monopoly.map.MonopolyMap;
import monopoly.spieler.Spieler;
import static monopoly.spieler.Spieler.getRandomInteger;

/**
 * Diese Klasse realisiert das Gefaengnisfeld. Die Klasse implementiert das
 * Interface Spielfelder.
 *
 * Landet ein Spieler im Gefaengnis, hat er die Moeglichkeit sich in der
 * naechsten Runde mit max. 3 Versuchen frei zu wuerfeln. Dazu wird zuvor eine
 * passende Zufallszahl generiert. Wird nach dem 3. Versuch nicht die richtige
 * Zahl gewuerfelt, muss der Spieler 1000 Euro an die Bank zahlen und kann in
 * der naechsten Runde mit dem Spielen fortfahren.
 *
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public class GefängnisFeld implements Spielfelder {

    protected int feldnummer;

    protected String feldname;

    /**
     * Erzeugt ein Gefaengnisfeld anhand der uebergebenen Methodenparameter.
     *
     * @param feldnummer die Nummer des Gefaengnisfeldes
     * @param feldname der Name des Spielfeldes
     */
    public GefängnisFeld(int feldnummer, String feldname) {
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
        s.setIstGefängnis(true);
        System.out.println("Du musst ins gefängnis");
    }

    /**
     * Diese Methode realisiert das Verhalten, wenn ein Spieler auf das
     * Gefängnisfeld kommt
     *
     * @param s Spieler auf Gefängnisfeld
     */
    public void gefaengnisAktion(Spieler s) {

        int zahl = getRandomInteger(12, 1);
        System.out.println("Du bist im Gefängnis, würfel eine " + zahl + " um raus zu kommen, du kannst dann in der nächsten Runde weiterspielen");
        int wuerfel;

        boolean gefunden = false;
        for (int i = 0; i < 3; i++) {
            wuerfel = getRandomInteger(12, 1);
            System.out.println("Du hast " + wuerfel + " gefwuerfelt");
            if (wuerfel == zahl) {
                System.out.println("Richtige Zahl ( " + wuerfel + " )du, kannst nächste runde weiterspielen");

                gefunden = true;
                return;
            }

        }
        if (!gefunden) {
            System.out.println("Leider war die richtige Zahl nicht dabei, du zahlst 1000 Euro und darfst nächste Runde weiterspielen");

            boolean einzahlen = s.einzahlen(1000);
            if (!einzahlen) {
                MonopolyMap.spielerVerloren(s.getSpielfigur());
                return;
            } else {
                System.out.println("Dein neuer Kontostand beträgt: " + s.getKontostand());
                return;
            }
        }

    }

}
