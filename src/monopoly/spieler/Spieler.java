package monopoly.spieler;


import monopoly.spielfelder.Spielfelder;
import java.util.*;

/**
 * 
 */
public class Spieler {

    /**
     * Default constructor
     */
    public Spieler() {
    }

    /**
     * 
     */
    private boolean istBank;

    /**
     * 
     */
    private int kontostand;

    /**
     * 
     */
    private String spielfigur;

    /**
     * 
     */
    public boolean istGefängnis;

    /**
     * 
     */
    public Array<Spielfelder> felderInBesitz;




    /**
     * @param istBank 
     * @param kontostand 
     * @param spielfigur 
     * @param istGefängnis
     */
    public void Spieler(boolean istBank, int kontostand, String spielfigur, boolean istGefängnis) {
        // TODO implement here
    }

    /**
     * 
     */
    public void wuerfeln() {
        // TODO implement here
    }

    /**
     * @param wuerfelZahl 
     * @return
     */
    public Spielfelder spielfigurSetzen(int wuerfelZahl) {
        // TODO implement here
        return null;
    }

    /**
     * @param feld
     */
    public void kaufen(Spielfelder feld) {
        // TODO implement here
    }

    /**
     * @param feld
     */
    public void bezahlen(Spielfelder feld) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getKontostand() {
        // TODO implement here
        return 0;
    }

    /**
     * 
     */
    public class Class1 {

        /**
         * Default constructor
         */
        public Class1() {
        }

    }

}