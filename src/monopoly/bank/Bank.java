package monopoly.bank;


import java.util.*;

/**
 * 
 */
public class Bank {

    /**
     * Default constructor
     */
    public Bank() {
        kontostand = 200000;
    }

    /**
     * 
     */
    private static int kontostand;

    /**
     * @return
     */
    public static int auszahlen(int betrag) {
        // TODO implement here
        kontostand =- betrag;
        return betrag;
    }

    /**
     * @param einzahlung
     */
    public static void  einzahlen(int einzahlung) {
        kontostand =+ einzahlung;
    }

    /**
     * @return
     */
    public static int getKontostand() {
        // TODO implement here
        return kontostand;
    }

}