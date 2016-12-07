package monopoly.spieler;

import monopoly.spielfelder.Spielfelder;
import java.util.*;
import monopoly.bank.Bank;
import monopoly.map.MonopolyMap;

/**
 *
 */
public class Spieler {

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
    public ArrayList<Spielfelder> felderInBesitz;

    /**
     *
     */
    private Bank bank;

    /**
     *
     */
    public int wuerfelZahl;

    /**
     *
     */
    public int aktuellesFeld;

    public Spieler(String spielfigur, Bank bank) {
        this.istBank = false;
        this.kontostand = 1500;
        this.spielfigur = spielfigur;
        this.istGefängnis = false;
        this.aktuellesFeld = 0;
        this.bank = bank;
        if (bank != null) {
            this.istBank = true;
        }
        MonopolyMap m = new MonopolyMap();
        
    }

    /**
     *
     */
    public void wuerfeln() {
        String[] worte = {"Eins", "Zwei", "Drei", "Vier", "Fünf", "Sechs"};
        wuerfelZahl = (int) (Math.random() * 6);
        aktuellesFeld = +wuerfelZahl;
        if (aktuellesFeld > 40) {

            aktuellesFeld = aktuellesFeld - 40;
        }

        System.out.println(worte[wuerfelZahl] + " gewürfelt");
        spielfigurSetzen(aktuellesFeld);
        System.out.println("Du befindest dich auf Feld-Nr: " + aktuellesFeld);

    }

    /**
     * @param wuerfelZahl
     * @return
     */
    public Spielfelder spielfigurSetzen(int feldNummer) {
       for()
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

}
