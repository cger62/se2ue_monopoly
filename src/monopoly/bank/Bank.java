package monopoly.bank;

/**
 * Diese Klasse realisiert die Bank des Spiels und ermoeglicht Ein- und
 * Auszahlungen.
 *
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public class Bank {

    private static int kontostand;

    public Bank() {
        kontostand = 200000;
    }

    /**
     * Zahlt den uebergebenen Betrag von der Bank an einen Spieler aus.
     *
     * @param betrag der Betrag, der an einen Spieler ausgezahlt werden soll
     * @return betrag der Betrag, der ausgezahlt wurde
     */
    public static int auszahlen(int betrag) {
        kontostand = kontostand - betrag;
        return betrag;
    }

    /**
     * Ein Spieler zahlt den uebergebenen Betrag an die Bank.
     *
     * @param einzahlung der Betrag, der an die Bank gezahlt werden muss
     */
    public static void einzahlen(int einzahlung) {
        kontostand = +einzahlung;
    }

    /**
     * @return den aktuellen Kontostand
     */
    public static int getKontostand() {
        return kontostand;
    }

}
