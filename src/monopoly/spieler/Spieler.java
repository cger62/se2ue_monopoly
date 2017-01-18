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
 *
 */
public class Spieler {

    private int kontostand;

    private String spielfigur;

    public boolean istGefängnis;

    public ArrayList<Spielfelder> felderInBesitz;

    private Bank bank;

    public int wuerfelZahl;

    public int aktuellesFeld;
    public HashMap<String, ArrayList> liste = new HashMap<>();

    public ArrayList<Spielfelder> braun = new ArrayList<Spielfelder>();
    public ArrayList<Spielfelder> hellblau = new ArrayList<Spielfelder>();
    public ArrayList<Spielfelder> pink = new ArrayList<Spielfelder>();
    public ArrayList<Spielfelder> orange = new ArrayList<Spielfelder>();
    public ArrayList<Spielfelder> rot = new ArrayList<Spielfelder>();
    public ArrayList<Spielfelder> gelb = new ArrayList<Spielfelder>();
    public ArrayList<Spielfelder> grün = new ArrayList<Spielfelder>();
    public ArrayList<Spielfelder> dunkelblau = new ArrayList<Spielfelder>();
    public ArrayList<Spielfelder> bahnhoefe = new ArrayList<Spielfelder>();
    public ArrayList<Spielfelder> werke = new ArrayList<Spielfelder>();

    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);

    public Spieler(String spielfigur) {

        this.kontostand = 20000;
        this.spielfigur = spielfigur;
        this.istGefängnis = false;
        //this.aktuellesFeld = 0;

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
     *
     */
    public void wuerfeln() {
       
        if (istGefängnis) {
            int zahl = (int) (Math.random() * 12) + 1;
            System.out.println("Du bist im Gefängnis, würfel eine " + zahl + "um raus zu kommen, du kannst dann in der nächsten Runde weiterspielen");
            int wuerfel;
            boolean gefunden = false;
            for (int i = 0; i < 3; i++) {
                wuerfel = (int) (Math.random() * 12) + 1;
                System.out.println("Du hast " + wuerfel + "gefwuerfelt");
                if (wuerfel == zahl) {
                    System.out.println("Richtige Zahl ( " + wuerfel + " )du, kannst nächste runde weiterspielen");
                    istGefängnis = false;
                    gefunden = true;
                }

            }
            if (!gefunden) {
                System.out.println("Leider war die richtige Zahl nicht dabei, du zahlst 1000 Euro und darfst nächste Runde weiterspielen");
                istGefängnis = false;
                einzahlen(1000);
            }

        }
        //System.out.println(this.aktuellesFeld);
        String[] worte = {"Eins", "Zwei", "Drei", "Vier", "Fünf", "Sechs", "Sieben", "Acht", "Neun", "Zehn", "Elf", "Zwölf"};

        wuerfelZahl = (int) (Math.random() * 12) + 1;

        this.aktuellesFeld = this.aktuellesFeld + wuerfelZahl + 1;
        //System.out.println(this.aktuellesFeld);
        if (this.aktuellesFeld > 39) {
            auszahlen(200);
            this.aktuellesFeld = this.aktuellesFeld - 39;
        }
        if (this.aktuellesFeld == 40) {
            this.aktuellesFeld = 0;
        }

        System.out.println(worte[wuerfelZahl - 1] + " gewürfelt");
        Spielfelder sf = spielfigurSetzen(this.aktuellesFeld);
        System.out.println("Du befindest dich auf Feld-Nr: " + (this.aktuellesFeld));
        System.out.println("Feld-Name: " + sf.getFeldname());
        boolean check = false;
        for (Spielfelder s : felderInBesitz) {
            if (sf.equals(s)) {
                check = true;
            }
        }

        if (!check) {
            if (sf instanceof NurZuBesuchFeld) {
                System.out.println("Zu Besuch im Gefängnis");

            }

            if (sf instanceof FreiParkenFeld) {
                System.out.println("Glückwunsch, du bist auf Frei Parken und erhälst den gesamten Pott in Höhe von: " + Pott.getKontostand());
                Pott.auszahlen(Pott.getKontostand());

            }
            if (sf instanceof GefängnisFeld) {
                istGefängnis = true;
                System.out.println("Du musst ins gefängnis");

            }

            if (sf instanceof EreignisgemeinschaftsFeld) {
                EreignisgemeinschaftsFeld ereignis = (EreignisgemeinschaftsFeld) sf;
                EreignisgemeinschaftsKarte randomKarte = ereignis.randomKarte();
                randomKarte.ereignis(this);
            }

            if (sf instanceof SteuerFeld) {
                SteuerFeld s = (SteuerFeld) sf;
                if (s.getFeldnummer() == 4) {
                    System.out.println("Du musst 4000 Euro  Einkommenssteuer Zahlen");
                    Pott.einzahlen(s.getSteuern());
                }
                if (s.getFeldnummer() == 38) {
                    System.out.println("Du musst 2000 Euro Zusatzsteuer Zahlen");
                    Pott.einzahlen(s.getSteuern());
                }
            }

            if (sf instanceof BesitzrechtFeld) {
                BesitzrechtFeld bf = (BesitzrechtFeld) sf;

                if (bf.isGekauft) {
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
        }

    }

    /**
     * @param feldNummer
     * @return
     */
    public Spielfelder spielfigurSetzen(int feldNummer) {
        for (int i = 1; i < MonopolyMap.spielfelder.size(); i++) {

            if (i == feldNummer) {
                this.aktuellesFeld = feldNummer;

                return MonopolyMap.spielfelder.get(i);
            }

        }
        return null;
    }

    /**
     * @param feld
     */
    public void kaufen(BesitzrechtFeld feld) {
        try {
            System.out.println("Dein Kontostand beträgt: " + getKontostand());
            System.out.println("Die kosten für: " + feld.feldname + " betragen :" + feld.grundstueckswert);
            System.out.println("Möchtest du kaufen? (ja/nein)");
            if (br.readLine().trim().toLowerCase().equals("ja")) {
                if (einzahlen(feld.grundstueckswert)) {
                    felderInBesitz.add(feld);
                    switch (feld.getColor()) {
                        case "braun":
                            braun.add(feld);
                            if (braun.size() == 2) {
                                hausBauen(feld);
                                break;
                            }
                        case "hellblau":
                            hellblau.add(feld);
                            if (hellblau.size() == 3) {
                                hausBauen(feld);
                                break;
                            }
                        case "pink":
                            pink.add(feld);
                            if (pink.size() == 3) {
                                hausBauen(feld);
                                break;
                            }
                        case "orange":
                            orange.add(feld);
                            if (orange.size() == 3) {
                                hausBauen(feld);
                            }
                            break;
                        case "rot":
                            rot.add(feld);
                            if (rot.size() == 3) {
                                hausBauen(feld);
                            }
                            break;
                        case "gelb":
                            gelb.add(feld);
                            if (gelb.size() == 3) {
                                hausBauen(feld);
                            }
                            break;
                        case "grün":
                            grün.add(feld);
                            if (grün.size() == 3) {
                                hausBauen(feld);
                            }
                            break;
                        case "dunkelblau":
                            dunkelblau.add(feld);
                            if (dunkelblau.size() == 2);
                            hausBauen(feld);
                            break;
                        case "bahnhof":
                            bahnhoefe.add(feld);
                            mieteÄndernBahnhof();
                            break;
                        case "werk":
                            werke.add(feld);

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
     * @param feld
     */
    public void mieteZahlen(BesitzrechtFeld feld) {
        Spieler spieler = feld.getSpieler();
        boolean einzahlen = einzahlen(feld.getMiete());
        if (!einzahlen) {
            System.out.println("Du bist pleite und aus dem Spiel");
            MonopolyMap.spielerVerloren(spielfigur);
        } else {
            spieler.auszahlen(feld.getMiete());
        }

    }

    public void hausBauen(BesitzrechtFeld feld) throws IOException {
        String color = feld.getColor();
        Iterator it = liste.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (pair.getKey().equals(color)) {
                ArrayList<Spielfelder> list = (ArrayList<Spielfelder>) pair.getValue();
                Spielfelder letztesFeld = list.get(list.size() - 1);
                if (!letztesFeld.equals(null)) {

                    if (feld instanceof Straße) {
                        System.out.println("Wieviele Häuser möchtest du auf der Straße:" + feld.feldname + " bauen?");
                        int anzahl = Integer.parseInt(br.readLine());

                        Straße str = (Straße) feld;
                        if (einzahlen(str.getKostenHaus() * anzahl)) {
                            str.setAnzahlHaueser(str.getAnzahlHaueser() + anzahl);
                            if (str.getAnzahlHaueser() + anzahl > 4) {
                                System.out.println("Möchtest du " + ((str.getAnzahlHaueser()) - (str.getAnzahlHaueser() % 4)) + " deiner " + str.getAnzahlHaueser() + "Häuser in Hotels umwandeln?");
                                if (br.readLine().trim().toLowerCase().equals("ja")) {
                                    str.setAnzahlHaueser(str.getAnzahlHaueser() + anzahl);
                                    hotelBauen(str);
                                } else {

                                    System.out.println("Du hast für die Straße: " + str.getFeldname() + "," + anzahl + " Häuser gebaut, insgesamt hast du jetzt " + str.getAnzahlHaueser() + " Häuser");

                                }
                            }
                        }
                    }
                }
            }

        }

    }

    /**
     * @param anzahl
     */
    /**
     * @return
     */
    public int getKontostand() {
        // TODO implement here
        return kontostand;
    }

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

    public void auszahlen(int i) {
        kontostand = kontostand + i;
        Bank.auszahlen(i);
    }

    private void hotelBauen(Straße str) {
        try {
            System.out.println("Du kannst in der Straße: " + str.getFeldname() + " max. " + (int) str.getAnzahlHaueser() / 4 + "Hotels bauen, wieviele möchtest du Bauen?");
            int anzahl = Integer.parseInt(br.readLine());
            if (anzahl <= (int) str.getAnzahlHaueser() / 4) {
                str.setAnzahlHotels(anzahl);

                einzahlen((str.getKostenHotel() * anzahl) + str.getAnzahlHaueser() * anzahl);
                str.setAnzahlHaueser(-(anzahl * 4));
            }
        } catch (IOException ex) {
            Logger.getLogger(Spieler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getSpielfigur() {
        return spielfigur;
    }

    private void mieteÄndernBahnhof() {

        if (bahnhoefe.size() == 2) {
            for (Spielfelder s : bahnhoefe) {
                Bahnhof b = (Bahnhof) s;
                b.setMiete(b.getMiete() * 2);
            }
        }
        if (bahnhoefe.size() == 3) {
            for (Spielfelder s : bahnhoefe) {
                Bahnhof b = (Bahnhof) s;
                b.setMiete(b.getMiete() * 4);
            }
        }
        if (bahnhoefe.size() == 4) {
            for (Spielfelder s : bahnhoefe) {
                Bahnhof b = (Bahnhof) s;
                b.setMiete(b.getMiete() * 8);
            }
        }
    }
}
