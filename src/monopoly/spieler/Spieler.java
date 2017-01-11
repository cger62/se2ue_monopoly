package monopoly.spieler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import monopoly.spielfelder.Spielfelder;
import java.util.*;
import monopoly.bank.Bank;
import monopoly.map.MonopolyMap;
import monopoly.spielfelder.BesitzrechtFeld;

/**
 *
 */
public class Spieler {

    private boolean istBank;

    private int kontostand;

    private String spielfigur;

    public boolean istGefängnis;

    public ArrayList<Spielfelder> felderInBesitz;

    private Bank bank;

    public int wuerfelZahl;

    public int aktuellesFeld;
    
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    public Spieler(String spielfigur) {
        this.istBank = false;
        this.kontostand = 1500;
        this.spielfigur = spielfigur;
        this.istGefängnis = false;
        this.aktuellesFeld = 0;
        if (bank != null) {
            this.istBank = true;
        }

    }

    public void setBank(Bank bank) {
        this.bank = bank;
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
        Spielfelder sf = spielfigurSetzen(aktuellesFeld);
        System.out.println("Du befindest dich auf Feld-Nr: " + aktuellesFeld);

        if (!felderInBesitz.contains(sf)) {

            BesitzrechtFeld bf = (BesitzrechtFeld) sf;

            if (bf.isGekauft) {
                bezahlen(bf);

            } else {
                kaufen(bf);
            }
        }

    }

    /**
     * @param feldNummer
     * @return
     */
    public BesitzrechtFeld spielfigurSetzen(int feldNummer) {
        for (int i = 1; i < MonopolyMap.spielfelder.size(); i++) {

            if (i == feldNummer) {
                if (feldNummer < aktuellesFeld) {
                    einziehen(100);
                }
                return (BesitzrechtFeld) MonopolyMap.spielfelder.get(i);
            }

        }
        return null;
    }

    /**
     * @param feld
     */
    public void kaufen(BesitzrechtFeld feld) {
        System.out.println("Dein Kontostand beträgt: " + kontostand);
        System.out.println("Die kosten für: " + feld.feldname + " betragen :" + feld.grundstueckswert);
        System.out.println("Möchtest du kaufen? (ja/nein)");

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
        return kontostand;
    }

    public void einzahlen(int i) {
        kontostand = kontostand - i;
    }

    public void einziehen(int i) {
        kontostand = kontostand + i;
    }

}
