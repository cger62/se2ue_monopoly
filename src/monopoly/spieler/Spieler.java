package monopoly.spieler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import monopoly.spielfelder.Spielfelder;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import monopoly.bank.Bank;
import monopoly.karten.EreignisgemeinschaftsKarte;
import monopoly.map.MonopolyMap;
import monopoly.pott.Pott;
import monopoly.spielfelder.Bahnhof;
import monopoly.spielfelder.BesitzrechtFeld;
import monopoly.spielfelder.Elektrizitätswerk;
import monopoly.spielfelder.EreignisgemeinschaftsFeld;
import monopoly.spielfelder.FreiParkenFeld;
import monopoly.spielfelder.GefängnisFeld;
import monopoly.spielfelder.NurZuBesuchFeld;
import monopoly.spielfelder.SteuerFeld;
import monopoly.spielfelder.Straße;
import monopoly.spielfelder.Wasserwerk;

/**
 * Diese Klasse realisiert die Spieler, die am Monopoly beteiligt sind.
 * 
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public class Spieler {

    private int kontostand;

    private String spielfigur;

    public boolean istGefängnis;

    public ArrayList<Spielfelder> felderInBesitz;

    private Bank bank;

    public int wuerfelZahl;

    public int aktuellesFeld = 0;
    
    public Spielfelder aktuellesFeldName;
    
    public HashMap<String, ArrayList> liste = new HashMap<>();

    //die moeglichen Farben, die eine Strasse haben kann
    public ArrayList<Straße> braun = new ArrayList<>();
    public ArrayList<Straße> hellblau = new ArrayList<>();
    public ArrayList<Straße> pink = new ArrayList<>();
    public ArrayList<Straße> orange = new ArrayList<>();
    public ArrayList<Straße> rot = new ArrayList<>();
    public ArrayList<Straße> gelb = new ArrayList<>();
    public ArrayList<Straße> grün = new ArrayList<>();
    public ArrayList<Straße> dunkelblau = new ArrayList<>();
    public ArrayList<Bahnhof> bahnhoefe = new ArrayList<>();
    public ArrayList<Spielfelder> werke = new ArrayList<Spielfelder>();

    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

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

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setKontostand(int kontostand) {
        this.kontostand = kontostand;
    }

    /**
     * Es wird eine zufaellige Zahl zwischen 1 und 12 generiert.
     * Die gewurfelte Zahl wird auf der Konsole ausgegeben.
     * 
     * Je nachdem auf welchem Spielfeld der Spieler nach dem Wuerfeln
     * landet, sind verschiedene Aktionen notwendig.
     * 
     * Der neue Kontostand des Spielers und das Feld, auf dem er sich
     * befindet, werden auf der Konsole ausgegeben.
     */
    public void wuerfeln() {

        if (istGefängnis) {
            //System.out.println("Dein aktueller Kontostand beträgt: " + getKontostand());
            int zahl = getRandomInteger(12, 1);
            System.out.println("Du bist im Gefängnis, würfel eine " + zahl + " um raus zu kommen, du kannst dann in der nächsten Runde weiterspielen");
            int wuerfel;
            boolean gefunden = false;
            for (int i = 0; i < 3; i++) {
                wuerfel = getRandomInteger(12, 1);
                System.out.println("Du hast " + wuerfel + " gefwuerfelt");
                if (wuerfel == zahl) {
                    System.out.println("Richtige Zahl ( " + wuerfel + " )du, kannst nächste runde weiterspielen");
                    istGefängnis = false;
                    gefunden = true;
                    return;
                }

            }
            if (!gefunden) {
                System.out.println("Leider war die richtige Zahl nicht dabei, du zahlst 1000 Euro und darfst nächste Runde weiterspielen");
                istGefängnis = false;
                ;
                boolean einzahlen = einzahlen(1000);
                if (!einzahlen) {
                    MonopolyMap.spielerVerloren(spielfigur);
                    return;
                } else {
                    System.out.println("Dein neuer Kontostand beträgt: " + getKontostand());
                    return;
                }
            }

        }
        String[] worte = {"Eins", "Zwei", "Drei", "Vier", "Fünf", "Sechs", "Sieben", "Acht", "Neun", "Zehn", "Elf", "Zwölf"};

        wuerfelZahl = getRandomInteger(12, 1);

        this.aktuellesFeld = this.aktuellesFeld + wuerfelZahl + 1;
        if (this.aktuellesFeld > 39) {
            auszahlen(4000);
            System.out.println("Du gehst über Los und erhälst 4000 Mark");
            this.aktuellesFeld = this.aktuellesFeld - 39;
        }
        if (this.aktuellesFeld == 40) {
            this.aktuellesFeld = 0;
            System.out.println("Du bist auf Los und erhälst 4000 Mark");
            auszahlen(4000);
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
            if (aktuellesFeldName instanceof NurZuBesuchFeld) {
                System.out.println("Zu Besuch im Gefängnis");

            }

            if (aktuellesFeldName instanceof FreiParkenFeld) {
                System.out.println("Dein aktueller Kontostand beträgt: " + getKontostand());
                System.out.println("Glückwunsch, du bist auf Frei Parken und erhälst den gesamten Pott in Höhe von: " + Pott.getKontostand());
                kontostand = kontostand + Pott.auszahlen(Pott.getKontostand());
                System.out.println("Dein neuer Kontostand beträgt: " + getKontostand());

            }
            if (aktuellesFeldName instanceof GefängnisFeld && !(aktuellesFeldName instanceof NurZuBesuchFeld)) {
                istGefängnis = true;
                System.out.println("Du musst ins gefängnis");

            }

            if (aktuellesFeldName instanceof EreignisgemeinschaftsFeld) {
                System.out.println("Dein aktueller Kontostand beträgt: " + getKontostand());
                EreignisgemeinschaftsFeld ereignis = (EreignisgemeinschaftsFeld) aktuellesFeldName;
                EreignisgemeinschaftsKarte randomKarte = ereignis.zufaelligeKarteGenerieren();
                randomKarte.ereignis(this);
                boolean einzahlen = einzahlen(0);
                if (!einzahlen) {
                    MonopolyMap.spielerVerloren(spielfigur);
                } else {
                    System.out.println("Dein neuer Kontostand beträgt: " + getKontostand());
                }
            }

            if (aktuellesFeldName instanceof SteuerFeld) {
                SteuerFeld s = (SteuerFeld) aktuellesFeldName;
                if (s.getFeldnummer() == 4) {
                    System.out.println("Dein aktueller Kontostand beträgt: " + getKontostand());
                    System.out.println("Du musst 4000 Euro  Einkommenssteuer Zahlen");
                    boolean einzahlen = einzahlen(4000);
                    if (!einzahlen) {
                        MonopolyMap.spielerVerloren(spielfigur);
                    } else {
                        Pott.einzahlen(s.getSteuern());
                        kontostand = kontostand - s.getSteuern();
                        System.out.println("Dein neuer Kontostand beträgt: " + getKontostand());
                    }
                }
                if (s.getFeldnummer() == 38) {
                    System.out.println("Dein aktueller Kontostand beträgt: " + getKontostand());
                    System.out.println("Du musst 2000 Euro Zusatzsteuer Zahlen");
                    boolean einzahlen = einzahlen(2000);
                    if (!einzahlen) {
                        MonopolyMap.spielerVerloren(spielfigur);
                    } else {
                        Pott.einzahlen(s.getSteuern());
                        kontostand = kontostand - s.getSteuern();
                        System.out.println("Dein neuer Kontostand beträgt: " + getKontostand());
                    }
                }
            }

            if (aktuellesFeldName instanceof BesitzrechtFeld) {
                BesitzrechtFeld bf = (BesitzrechtFeld) aktuellesFeldName;

                if (bf.istGekauft) {
                    if (bf instanceof Straße || bf instanceof Bahnhof) {
                        mieteZahlen(bf);
                    }
                    if (bf instanceof Wasserwerk) {
                        Wasserwerk w = (Wasserwerk) bf;
                        w.setMiete(wuerfelZahl * 80);
                        mieteZahlen(w);

                    }
                    if (bf instanceof Elektrizitätswerk) {
                        Elektrizitätswerk e = (Elektrizitätswerk) bf;
                        e.setMiete(wuerfelZahl * 80);
                        mieteZahlen(e);

                    }

                } else {
                    kaufen(bf);
                }
            }
        } else {
            System.out.println("Das Feld: " + aktuellesFeldName.getFeldname() + "(Nr: " + aktuellesFeldName.getFeldnummer() + ")gehört dir!");
        }
    }

    /**
     * Setzt die Spielfigur anhand der gewurfelten Zahl.
     * 
     * @param feldNummer das Feld, auf das die Spielfigur gesetzt werden muss
     * 
     * @return get das Spielfeld, auf dem sich der Spieler befindet
     */
    public Spielfelder spielfigurSetzen(int feldNummer) {
        for (int i = 0; i < MonopolyMap.spielfelder.size(); i++) {
            Spielfelder get = MonopolyMap.spielfelder.get(i);
            if (get.getFeldnummer() == feldNummer) {
                this.aktuellesFeld = feldNummer;

                return get;
            }

        }
        return null;
    }

    /**
     * Ermoeglicht das Kaufen von BesitzrechtFeldern, wenn der Spieler
     * den entsprechenden Kaufpreis zahlen moechte/kann.
     * 
     * @param feld das Spielfeld, das gekauft werden soll
     */
    public void kaufen(BesitzrechtFeld feld) {
        try {
            System.out.println("Dein aktueller Kontostand beträgt: " + getKontostand());
            System.out.println("Die kosten für: " + feld.feldname + " betragen :" + feld.grundstueckswert);
            System.out.println("Möchtest du kaufen? (ja/nein)");
            String eingabe = br.readLine();
            if (eingabe.trim().toLowerCase().equals("status")) {
                eingabe = meinStatus();

            }
            if (eingabe.trim().toLowerCase().equals("ja")) {
                if (einzahlen(feld.grundstueckswert)) {
                    feld.istGekauft = true;
                    feld.setSpieler(this);
                    felderInBesitz.add(feld);
                    switch (feld.getFarbe()) {
                        case "braun":
                            braun.add((Straße) feld);
                            System.out.println("Du hast die Straße: " + feld.getFeldname() + "(" + feld.getFarbe() + ") gekauft!");
                            System.out.println("Du hast " + braun.size() + " von 2 Feldern (" + feld.getFarbe() + ") in deinem Besitz");
                            if (braun.size() == 2) {
                                hausBauen(feld);
                                mieteÄndernStraße(braun);
                                break;
                            }
                            break;
                        case "hellblau":
                            hellblau.add((Straße) feld);
                            System.out.println("Du hast die Straße: " + feld.getFeldname() + "(" + feld.getFarbe() + ") gekauft!");
                            System.out.println("Du hast " + hellblau.size() + " von 3 Feldern (" + feld.getFarbe() + ") in deinem Besitz");
                            if (hellblau.size() == 3) {
                                hausBauen(feld);
                                mieteÄndernStraße(hellblau);
                                break;
                            }
                            break;
                        case "pink":
                            pink.add((Straße) feld);
                            System.out.println("Du hast die Straße: " + feld.getFeldname() + "(" + feld.getFarbe() + ") gekauft!");
                            System.out.println("Du hast " + pink.size() + " von 3 Feldern (" + feld.getFarbe() + ") in deinem Besitz");
                            if (pink.size() == 3) {
                                hausBauen(feld);
                                mieteÄndernStraße(pink);
                                break;
                            }
                            break;
                        case "orange":
                            orange.add((Straße) feld);
                            System.out.println("Du hast die Straße: " + feld.getFeldname() + "(" + feld.getFarbe() + ") gekauft!");
                            System.out.println("Du hast " + orange.size() + " von 3 Feldern (" + feld.getFarbe() + ") in deinem Besitz");
                            if (orange.size() == 3) {
                                hausBauen(feld);
                                mieteÄndernStraße(orange);
                                break;
                            }
                            break;
                        case "rot":
                            rot.add((Straße) feld);
                            System.out.println("Du hast die Straße: " + feld.getFeldname() + "(" + feld.getFarbe() + ") gekauft!");
                            System.out.println("Du hast " + rot.size() + " von 3 Feldern (" + feld.getFarbe() + ") in deinem Besitz");
                            if (rot.size() == 3) {
                                hausBauen(feld);
                                mieteÄndernStraße(rot);
                                break;
                            }
                            break;
                        case "gelb":
                            gelb.add((Straße) feld);
                            System.out.println("Du hast die Straße: " + feld.getFeldname() + "(" + feld.getFarbe() + ") gekauft!");
                            System.out.println("Du hast " + gelb.size() + " von 3 Feldern (" + feld.getFarbe() + ") in deinem Besitz");
                            if (gelb.size() == 3) {
                                hausBauen(feld);
                                mieteÄndernStraße(gelb);
                                break;
                            }
                            break;
                        case "grün":
                            grün.add((Straße) feld);
                            System.out.println("Du hast die Straße: " + feld.getFeldname() + "(" + feld.getFarbe() + ") gekauft!");
                            System.out.println("Du hast " + grün.size() + " von 3 Feldern (" + feld.getFarbe() + ") in deinem Besitz");
                            if (grün.size() == 3) {
                                hausBauen(feld);
                                mieteÄndernStraße(grün);
                                break;
                            }
                            break;
                        case "dunkelblau":
                            dunkelblau.add((Straße) feld);
                            System.out.println("Du hast die Straße: " + feld.getFeldname() + "(" + feld.getFarbe() + ") gekauft!");
                            System.out.println("Du hast " + dunkelblau.size() + " von 2 Feldern (" + feld.getFarbe() + ") in deinem Besitz");
                            if (dunkelblau.size() == 2) {
                                hausBauen(feld);
                                mieteÄndernStraße(dunkelblau);
                                break;
                            }
                            break;
                        case "bahnhof":
                            bahnhoefe.add((Bahnhof) feld);
                            System.out.println("Du hast den Bahnhof: " + feld.getFeldname() + " gekauft!");
                            System.out.println("Du hast " + bahnhoefe.size() + " von 4 Bahnhöfen in deinem Besitz");
                            mieteÄndernBahnhof();

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
     * @param felddas Spielfeld, auf dem sich der Spieler aktuell befindet
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
     * Ermoeglicht das Bauen von Haeusern auf einem BesitzrechtFeld.
     * 
     * @param feld das Sielfeld, auf dem das Haus gebaut werden soll
     * @throws IOException falls beim Bauen des Hauses ein allgemeiner
     * Fehler auftritt
     */
    public void hausBauen(BesitzrechtFeld feld) throws IOException {
        System.out.println("Dein aktueller Kontostand beträgt: " + getKontostand());
        String color = feld.getFarbe();
        Iterator it = liste.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (pair.getKey().equals(color)) {
                    if (feld instanceof Straße) {
                        System.out.println("Wieviele Häuser möchtest du auf der Straße:" + feld.feldname + " bauen?");
                        System.out.println("Ein Haus kostet: " + ((Straße) feld).getKostenHaus());
                        int anzahl = Integer.parseInt(br.readLine());

                        Straße str = (Straße) feld;
                        if (einzahlen(str.getKostenHaus() * anzahl)) {
                            str.setAnzahlHaeuser(str.getAnzahlHaeuser() + anzahl);
                            if (str.getAnzahlHaeuser() >= 4) {
                                System.out.println("Möchtest du " + ((str.getAnzahlHaeuser()) - (str.getAnzahlHaeuser() % 4)) + " deiner " + str.getAnzahlHaeuser() + "Häuser in Hotels umwandeln?");
                                String eingabe = br.readLine();
                                if (eingabe.trim().toLowerCase().equals("status")) {
                                    eingabe = meinStatus();
                                }
                                if (eingabe.trim().toLowerCase().equals("ja")) {
                                    str.setAnzahlHaeuser(str.getAnzahlHaeuser() + anzahl);
                                    hotelBauen(str);
                                } else {

                                    System.out.println("Du hast für die Straße: " + str.getFeldname() + "," + anzahl + " Häuser gebaut, insgesamt hast du dort jetzt " + str.getAnzahlHaeuser() + " Häuser");
                                    System.out.println("Dein neuer Kontostand beträgt: " + getKontostand());
                                }
                            }
                        }
                    }
                }
        }
    }

    public int getKontostand() {
        return kontostand;
    }

    /**
     * Ueberprueft, ob das Zahlen des uebergebenen Betrags moeglich ist.
     * Wenn ja wird der entsprechende Betrag an die Bank gezahlt.
     * Wenn nicht, erfolgt eine Konsolenausgabe.
     * @param i der Betrag, der an die Bank gezahlt werden soll
     * 
     * @return true, wenn das Einzahlen des Betrages moeglich ist
     *         false, wenn das Zahlen des Betrages nicht moeglich ist, weil
     * das Konto des Spielers nicht ausreichend gedeckt ist
     */
    public boolean einzahlen(int i) {
        if (kontostand - i >= 0) {
            kontostand = kontostand - i;
            Bank.einzahlen(i);
            return true;
        } else {
            System.out.println("Du hast leider nicht genug Geld für den Kauf");
            return false;
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
     * Ermoeglicht das Bauen eines Hotels auf einer uebergebenen Strasse.
     * 
     * @param str die Strasse, auf der das Hotel gebaut werden soll
     */
    private void hotelBauen(Straße str) {
        try {
            System.out.println("Du kannst in der Straße: " + str.getFeldname() + " max. " + (int) str.getAnzahlHaeuser() / 4 + " Hotels bauen, wieviele möchtest du Bauen?");
            System.out.println("Ein Hotel kostet: " + str.getKostenHotel());
            int anzahl = Integer.parseInt(br.readLine());
            if (anzahl <= (int) str.getAnzahlHaeuser() / 4) {
                str.setAnzahlHotels(anzahl);

                einzahlen((str.getKostenHotel() * anzahl));
                str.setAnzahlHaeuser((anzahl * 4)*(-1));
            }
        } catch (IOException ex) {
            Logger.getLogger(Spieler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getSpielfigur() {
        return spielfigur;
    }

    /**
     * Ermoeglicht das Aendern des Mietbetrages eines Bahnhofs anhand der
     * Anzahl der Bahnhoefe. 
     * Je mehr Bahnhoefe vorhanden sind, desto hoeher ist die zu zahlende
     * Miete.
     */
    private void mieteÄndernBahnhof() {

        if (bahnhoefe.size() == 2) {
            for (Spielfelder s : bahnhoefe) {
                Bahnhof b = (Bahnhof) s;
                b.setMiete(b.getMiete() * 2);
                System.out.println("Miete des Bahnhofs: " + b.getFeldname() + " beträgt: " + b.getMiete());
            }
        }
        if (bahnhoefe.size() == 3) {
            for (Spielfelder s : bahnhoefe) {
                Bahnhof b = (Bahnhof) s;
                b.setMiete(b.getMiete() * 4);
                System.out.println("Miete des Bahnhofs: " + b.getFeldname() + " beträgt: " + b.getMiete());
            }
        }
        if (bahnhoefe.size() == 4) {
            for (Spielfelder s : bahnhoefe) {
                Bahnhof b = (Bahnhof) s;
                b.setMiete(b.getMiete() * 8);
                System.out.println("Miete des Bahnhofs: " + b.getFeldname() + " beträgt: " + b.getMiete());
            }
        }
    }

    /**
     * Gibt allgemeine Informationen zum Spieler auf der Konsole aus.
     * @return die aktuellen Statusinformationen
     */
    public String meinStatus() {
        try {
            System.out.println("--------------------STATUS--------------------");
            System.out.println("Spielfigur: " + spielfigur);
            System.out.println("Kontostand: " + kontostand);
            System.out.println("Aktuell befindest du dich auf: " + this.aktuellesFeldName.getFeldname());

            System.out.println("Folgende Felder sind in deinem Besitz :");
            for (Spielfelder s : felderInBesitz) {

                System.out.println("Feldname: " + s.getFeldname());
                System.out.println("Feldummer: " + s.getFeldnummer());

                if (s instanceof Straße) {
                    Straße bf = (Straße) s;
                    System.out.println("Farbe: " + bf.getFarbe());
                    System.out.println("Häuser: " + bf.getAnzahlHaeuser());
                    System.out.println("Hotels: " + bf.getAnzahlHotels());

                }
                System.out.println("--------------------STATUS ENDE--------------------");
            }
            System.out.println("Gebe JA ein um letzte Aktion durchzuführen");
            return br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Spieler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }



    /**
     * Ermoeglicht das Aendern der Miete einer Strasse anhand der 
     * Haeuseranzahl und Hotelanzahl.
     * 
     * @param strassen die Strassen, bei denen die Miete geaendert
     * werden soll
     */
    private void mieteÄndernStraße(ArrayList<Straße> strassen) {

        for (Straße s : strassen) {
            s.setMiete(s.getMiete() * 2);

            if (s.getAnzahlHaeuser() > 0) {
                s.setMiete(s.getMiete() * (s.getAnzahlHaeuser() * 5));

            }
            if (s.getAnzahlHotels() > 0) {
                s.setMiete(s.getMiete() * (s.getAnzahlHotels() * 10));

            }
            System.out.println("Miete der Straße: " + s.getFeldname() + " beträgt: " + s.getMiete());
        }

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

}
