package monopoly.pott;

import monopoly.bank.Bank;

/**
 * Wenn ein Spieler Steuern zahlen muss, werden diese in den Pott eingezahlt.
 * Landet ein Spieler auf dem FreiParkenFeld erhaelt er den gesamten Inhalt des
 * Potts.
 *
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public class Pott {

    public static int kontostand;

    public Pott() {
        kontostand = 0;
    }

    /**
     * Zahlt den Pott an den Spieler aus, der sich auf dem FreiParkenFeld
     * befindet.
     *
     * @param betrag der Betrag, der an den Spieler ausgezahlt werden muss
     * @return betrag der Betrag, der ausgezahlt wurde
     */
    public static int auszahlen() {
        int auszahlung = kontostand;
        setKontostand(0);
        return auszahlung;
    }

    /**
     * Realisiert das Einzahlen der Steuern in den Pott.
     *
     * @param einzahlung die Steuern, die ein Spieler in den Pott einzahlen muss
     */
    public static void einzahlen(int einzahlung) {
        kontostand = +einzahlung;
        System.out.println("Im Pott befinden sich: " + kontostand);
    }

    public static int getKontostand() {
        return kontostand;
    }

    public static void setKontostand(int kontostand) {
        Pott.kontostand = kontostand;
    }

}
