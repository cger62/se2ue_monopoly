package monopoly.spieler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import monopoly.spielfelder.Spielfelder;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import monopoly.bank.Bank;
import monopoly.map.MonopolyMap;
import monopoly.spielfelder.Bahnhof;
import monopoly.spielfelder.BesitzrechtFeld;
import monopoly.spielfelder.GefängnisFeld;
import monopoly.spielfelder.NurZuBesuchFeld;
import monopoly.spielfelder.Straße;

/**
 * Diese Klasse realisiert die Spieler, die am Monopoly beteiligt sind.
 *
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public class Spieler {

    private int kontostand;

    private final String spielfigur;

    private boolean istGefängnis;

    private final ArrayList<Spielfelder> felderInBesitz;

    private int wuerfelZahl;

    private int aktuellesFeld = 0;

    private Spielfelder aktuellesFeldName;

    private final HashMap<String, ArrayList> liste = new HashMap<>();

    //die moeglichen Farben, die eine Strasse haben kann
    private final ArrayList<Straße> braun = new ArrayList<>();
    private final ArrayList<Straße> hellblau = new ArrayList<>();
    private final ArrayList<Straße> pink = new ArrayList<>();
    private final ArrayList<Straße> orange = new ArrayList<>();
    private final ArrayList<Straße> rot = new ArrayList<>();
    private final ArrayList<Straße> gelb = new ArrayList<>();
    private final ArrayList<Straße> grün = new ArrayList<>();
    private final ArrayList<Straße> dunkelblau = new ArrayList<>();
    private final ArrayList<Bahnhof> bahnhoefe = new ArrayList<>();
    private final ArrayList<Spielfelder> werke = new ArrayList<>();

    private final InputStreamReader isr = new InputStreamReader(System.in);
    private final BufferedReader br = new BufferedReader(isr);

    /**
     * Erzeugt einen neuen Spieler und initialisiert die notwendigen Attribute.
     *
     * @param spielfigur der Name des Spielers
     */
    public Spieler(String spielfigur) {

        this.kontostand = 30000;
        this.spielfigur = spielfigur;
        this.istGefängnis = false;

        liste.put("braun", braun);
        liste.put("hellblau", hellblau);
        liste.put("pink", pink);
        liste.put("orange", orange);
        liste.put("rot", rot);
        liste.put("gelb", gelb);
        liste.put("grün", grün);
        liste.put("duneklblau", dunkelblau);
        liste.put("bahnhoefe", bahnhoefe);
        liste.put("werke", werke);
        felderInBesitz = new ArrayList<>();

    }

    /**
     * Es wird eine zufaellige Zahl zwischen 1 und 12 generiert. Die gewurfelte
     * Zahl wird auf der Konsole ausgegeben.
     *
     * Je nachdem auf welchem Spielfeld der Spieler nach dem Wuerfeln landet,
     * sind verschiedene Aktionen notwendig.
     *
     * Der neue Kontostand des Spielers und das Feld, auf dem er sich befindet,
     * werden auf der Konsole ausgegeben.
     */
    public void wuerfeln() {
        if (istGefängnis) {
            setIstGefängnis(false);
            if (aktuellesFeldName instanceof GefängnisFeld && !(aktuellesFeldName instanceof NurZuBesuchFeld)) {
                GefängnisFeld g = (GefängnisFeld) aktuellesFeldName;
                g.gefaengnisAktion(this);
                
                return;
            }

        } else {
            String[] worte = {"Eins", "Zwei", "Drei", "Vier", "Fünf", "Sechs", "Sieben", "Acht", "Neun", "Zehn", "Elf", "Zwölf"};

            wuerfelZahl = getRandomInteger(12, 1);

            this.aktuellesFeld = this.aktuellesFeld + wuerfelZahl + 1;
            if (this.aktuellesFeld >= 40) {
                setAktuellesFeld(0);

            }

            System.out.println(worte[wuerfelZahl] + " gewürfelt");

            aktuellesFeldName = spielfigurSetzen(this.aktuellesFeld);
            System.out.println("Du befindest dich auf Feld-Nr: " + (this.aktuellesFeld));
            boolean check = false;
            for (Spielfelder s : felderInBesitz) {
                if (aktuellesFeldName.equals(s)) {
                    check = true;
                }
            }

            if (!check) {
                aktuellesFeldName.spielfeldAktion(this, aktuellesFeldName);
            } else {
                System.out.println("Das Feld: " + aktuellesFeldName.getFeldname() + "(Nr: " + aktuellesFeldName.getFeldnummer() + ")gehört dir!");
                if (aktuellesFeldName instanceof Straße) {
                    Straße strasse = (Straße) aktuellesFeldName;
                    System.out.println("Farbe: " + strasse.getFarbe());
                    try {
                        strasse.hausBauen(this, strasse);
                    } catch (IOException ex) {
                        Logger.getLogger(Spieler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }
    }

    /**
     *
     * Setzt die Spielfigur anhand der uebergebenen Feldnummer.
     *
     * @param feldNummer das Feld, auf das die Spielfigur gesetzt werden muss
     *
     * @return get das Spielfeld, auf dem sich der Spieler befindet
     */
    public Spielfelder spielfigurSetzen(int feldNummer) {
        for (int i = 0; i < MonopolyMap.getSpielfelder().size(); i++) {
            Spielfelder get = MonopolyMap.getSpielfelder().get(i);
            if (get.getFeldnummer() == feldNummer) {
                this.aktuellesFeld = feldNummer;

                return get;
            }

        }
        return null;
    }

    /**
     * Ermoeglicht das Kaufen von BesitzrechtFeldern, wenn der Spieler den
     * entsprechenden Kaufpreis zahlen moechte/kann.
     *
     * @param feld das Spielfeld, das gekauft werden soll
     */
    public void kaufen(BesitzrechtFeld feld) {
        try {
            System.out.println("Dein aktueller Kontostand beträgt: " + getKontostand());
            System.out.println("Die kosten für: " + feld.getFeldname() + " (" + feld.getFarbe() + ") betragen :" + feld.getGrundstueckswert());
            System.out.println("Möchtest du kaufen? (ja/nein)");
            String eingabe = br.readLine();
            if (eingabe.trim().toLowerCase().equals("status")) {
                eingabe = meinStatus();

            }
            if (eingabe.trim().toLowerCase().equals("ja")) {
                if (einzahlen(feld.getGrundstueckswert())) {
                    feld.setGekauft(true);
                    feld.setSpieler(this);
                    felderInBesitz.add(feld);
                    switch (feld.getFarbe()) {
                        case "braun":
                            braun.add((Straße) feld);
                            System.out.println("Du hast die Straße: " + feld.getFeldname() + "(" + feld.getFarbe() + ") gekauft!");
                            System.out.println("Du hast " + braun.size() + " von 2 Feldern (" + feld.getFarbe() + ") in deinem Besitz");
                            if (braun.size() == 2) {
                                Straße s = (Straße) feld;
                                s.hausBauen(this, feld);
                                s.mieteÄndernStraße(braun);
                                break;
                            }
                            break;
                        case "hellblau":
                            hellblau.add((Straße) feld);
                            System.out.println("Du hast die Straße: " + feld.getFeldname() + "(" + feld.getFarbe() + ") gekauft!");
                            System.out.println("Du hast " + hellblau.size() + " von 3 Feldern (" + feld.getFarbe() + ") in deinem Besitz");
                            if (hellblau.size() == 3) {
                                Straße s = (Straße) feld;
                                s.hausBauen(this, feld);
                                s.mieteÄndernStraße(hellblau);
                                break;
                            }
                            break;
                        case "pink":
                            pink.add((Straße) feld);
                            System.out.println("Du hast die Straße: " + feld.getFeldname() + "(" + feld.getFarbe() + ") gekauft!");
                            System.out.println("Du hast " + pink.size() + " von 3 Feldern (" + feld.getFarbe() + ") in deinem Besitz");
                            if (pink.size() == 3) {
                                Straße s = (Straße) feld;
                                s.hausBauen(this, feld);
                                s.mieteÄndernStraße(pink);
                                break;
                            }
                            break;
                        case "orange":
                            orange.add((Straße) feld);
                            System.out.println("Du hast die Straße: " + feld.getFeldname() + "(" + feld.getFarbe() + ") gekauft!");
                            System.out.println("Du hast " + orange.size() + " von 3 Feldern (" + feld.getFarbe() + ") in deinem Besitz");
                            if (orange.size() == 3) {
                                Straße s = (Straße) feld;
                                s.hausBauen(this, feld);
                                s.mieteÄndernStraße(orange);
                                break;
                            }
                            break;
                        case "rot":
                            rot.add((Straße) feld);
                            System.out.println("Du hast die Straße: " + feld.getFeldname() + "(" + feld.getFarbe() + ") gekauft!");
                            System.out.println("Du hast " + rot.size() + " von 3 Feldern (" + feld.getFarbe() + ") in deinem Besitz");
                            if (rot.size() == 3) {
                                Straße s = (Straße) feld;
                                s.hausBauen(this, feld);
                                s.mieteÄndernStraße(rot);
                                break;
                            }
                            break;
                        case "gelb":
                            gelb.add((Straße) feld);
                            System.out.println("Du hast die Straße: " + feld.getFeldname() + "(" + feld.getFarbe() + ") gekauft!");
                            System.out.println("Du hast " + gelb.size() + " von 3 Feldern (" + feld.getFarbe() + ") in deinem Besitz");
                            if (gelb.size() == 3) {
                                Straße s = (Straße) feld;
                                s.hausBauen(this, feld);
                                s.mieteÄndernStraße(gelb);
                                break;
                            }
                            break;
                        case "grün":
                            grün.add((Straße) feld);
                            System.out.println("Du hast die Straße: " + feld.getFeldname() + "(" + feld.getFarbe() + ") gekauft!");
                            System.out.println("Du hast " + grün.size() + " von 3 Feldern (" + feld.getFarbe() + ") in deinem Besitz");
                            if (grün.size() == 3) {
                                Straße s = (Straße) feld;
                                s.hausBauen(this, feld);
                                s.mieteÄndernStraße(grün);
                                break;
                            }
                            break;
                        case "dunkelblau":
                            dunkelblau.add((Straße) feld);
                            System.out.println("Du hast die Straße: " + feld.getFeldname() + "(" + feld.getFarbe() + ") gekauft!");
                            System.out.println("Du hast " + dunkelblau.size() + " von 2 Feldern (" + feld.getFarbe() + ") in deinem Besitz");
                            if (dunkelblau.size() == 2) {
                                Straße s = (Straße) feld;
                                s.hausBauen(this, feld);
                                s.mieteÄndernStraße(dunkelblau);
                                break;
                            }
                            break;
                        case "bahnhof":
                            bahnhoefe.add((Bahnhof) feld);
                            System.out.println("Du hast den Bahnhof: " + feld.getFeldname() + " gekauft!");
                            System.out.println("Du hast " + bahnhoefe.size() + " von 4 Bahnhöfen in deinem Besitz");
                            Bahnhof b = (Bahnhof) feld;
                            b.mieteÄndernBahnhof(bahnhoefe);

                            break;
                        case "werk":
                            werke.add(feld);
                            System.out.println("Du hast das Werk: " + feld.getFeldname() + " gekauft!");
                            System.out.println("Du hast " + werke.size() + " von 2 Werken in deinem Besitz");
                            break;
                        default:
                            System.out.println("Feld konnte keiner Farbe/Kategorie zugeordnet werden");

                    }

                }
                System.out.println("Dein neuer Kontostand beträgt: " + getKontostand());
            }
        } catch (IOException ex) {
            Logger.getLogger(Spieler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Ermoeglicht das Zahlen der Miete anhand des Feldes, auf dem sich der
     * Spieler aktuell befindet.
     *
     * @param feld das Spielfeld, auf dem sich der Spieler aktuell befindet
     *
     */
    public void mieteZahlen(BesitzrechtFeld feld) {
        System.out.println("Dein aktueller Kontostand beträgt: " + getKontostand());
        Spieler spieler = feld.getSpieler();
        boolean einzahlen = einzahlen(feld.getMiete());
        if (!einzahlen) {
            MonopolyMap.spielerVerloren(spielfigur);
        } else {
            System.out.println("Du musst an " + feld.getSpieler().getSpielfigur() + " Miete in Höhe von " + feld.getMiete() + " zahlen (" + feld.getFeldname() + ")");
            spieler.auszahlen(feld.getMiete());
            System.out.println("Dein neuer Kontostand beträgt: " + getKontostand());
        }

    }

    /**
     * Ueberprueft, ob das Zahlen des uebergebenen Betrags moeglich ist. Wenn ja
     * wird der entsprechende Betrag an die Bank gezahlt. Wenn nicht, erfolgt
     * eine Konsolenausgabe.
     *
     * @param i der Betrag, der an die Bank gezahlt werden soll
     *
     * @return true, wenn das Einzahlen des Betrages moeglich ist false, wenn
     * das Zahlen des Betrages nicht moeglich ist, weil das Konto des Spielers
     * nicht ausreichend gedeckt ist
     */
    public boolean einzahlen(int i) {
        if (kontostand - i < 0) {
            System.out.println("Du hast leider nicht mehr genügend Geld.");
            return false;
        } else {

            kontostand = kontostand - i;
            Bank.einzahlen(i);
            return true;
        }
    }

    /**
     * Ermoeglicht das Auszahlen eines uebergebenen Betrages.
     *
     * @param i der Betrat, der ausgezahlt werden soll
     */
    public void auszahlen(int i) {
        kontostand = kontostand + i;
        Bank.auszahlen(i);
    }

    /**
     * Gibt allgemeine Informationen zum Spieler auf der Konsole aus.
     *
     * @return die aktuellen Statusinformationen
     */
    public String meinStatus() {
        try {
            System.out.println("--------------------STATUS--------------------");
            System.out.println("Spielfigur: " + spielfigur);
            System.out.println("Kontostand: " + kontostand);
            System.out.println("Aktuell befindest du dich auf: " + this.aktuellesFeldName.getFeldname());

            System.out.println("Folgende Felder sind in deinem Besitz :");
            System.out.println("----------------------------------------");
            for (Spielfelder s : felderInBesitz) {

                System.out.println("Feldname: " + s.getFeldname());
                System.out.println("Feldummer: " + s.getFeldnummer());

                if (s instanceof Straße) {
                    Straße bf = (Straße) s;
                    System.out.println("Farbe: " + bf.getFarbe());
                    System.out.println("Häuser: " + bf.getAnzahlHaeuser());
                    System.out.println("Hotels: " + bf.getAnzahlHotels());

                }
                System.out.println("----------------------------------------");
            }
            System.out.println("--------------------STATUS ENDE--------------------");
            System.out.println("Gebe JA ein um letzte Aktion durchzuführen");
            return br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Spieler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     * Generiert eine Zufallszahl zwischen den uebergebenen Methodenparametern.
     *
     * @param maximum die hoechste Zahl, die generiert werden kann
     * @param minimum die niedrigste Zahl, die generiert werden kann
     *
     * @return die Zufallszahl
     */
    public static int getRandomInteger(int maximum, int minimum) {
        return ((int) (Math.random() * (maximum - minimum))) + minimum;
    }

    public String getSpielfigur() {
        return spielfigur;
    }

    public int getKontostand() {
        return kontostand;
    }

    public void setKontostand(int kontostand) {
        this.kontostand = kontostand;
    }

    public void setIstGefängnis(boolean istGefängnis) {
        this.istGefängnis = istGefängnis;
    }

    public boolean istGefängnis() {
        return istGefängnis;
    }

    public int getWuerfelZahl() {
        return wuerfelZahl;
    }

    public int getAktuellesFeld() {
        return aktuellesFeld;
    }

    public HashMap<String, ArrayList> getListe() {
        return liste;
    }

    public void setAktuellesFeld(int aktuellesFeld) {
        this.aktuellesFeld = aktuellesFeld;
    }

    public void setAktuellesFeldName(Spielfelder s) {
        aktuellesFeldName = s;

    }

    public Spielfelder getAktuellesFeldName() {
        return aktuellesFeldName;
    }

}
