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
import monopoly.spielfelder.BesitzrechtFeld;
import monopoly.spielfelder.Straße;

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

        this.kontostand = 1500;
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

    /**
     *
     */
    public void wuerfeln() {
        System.out.println(this.aktuellesFeld);
        String[] worte = {"Eins", "Zwei", "Drei", "Vier", "Fünf", "Sechs", "Sieben", "Acht", "Neun", "Zehn", "Elf", "Zwölf"};
        wuerfelZahl = (int) (Math.random() * 12);
        this.aktuellesFeld = this.aktuellesFeld + wuerfelZahl+1;
           System.out.println(this.aktuellesFeld);
        if (this.aktuellesFeld > 39) {
            auszahlen(200);
            this.aktuellesFeld = this.aktuellesFeld - 39;
        }
        if(this.aktuellesFeld == 40){
        this.aktuellesFeld =0;
        }

        System.out.println(worte[wuerfelZahl] + " gewürfelt");
        Spielfelder sf = spielfigurSetzen(this.aktuellesFeld);
        System.out.println("Du befindest dich auf Feld-Nr: " + (this.aktuellesFeld));
        boolean check = false;
        for (Spielfelder s : felderInBesitz) {
            if (sf.equals(s)) {
                check = true;
            }
        }

        if (!check) {
            if (sf instanceof BesitzrechtFeld) {
                BesitzrechtFeld bf = (BesitzrechtFeld) sf;

                if (bf.isGekauft) {
                    mieteZahlen(bf);

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
             
                return  MonopolyMap.spielfelder.get(i);
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
                            if (braun.size()==2) {
                                hausBauen(feld);
                                break;
                            }
                        case "hellblau":
                            hellblau.add(feld);
                            if (hellblau.size()==3) {
                                hausBauen(feld);
                                break;
                            }
                        case "pink":
                            pink.add(feld);
                            if (pink.size()==3) {
                                hausBauen(feld);
                                break;
                            }
                        case "orange":
                            orange.add(feld);
                            if (orange.size()==3) {
                                hausBauen(feld);
                            }
                            break;
                        case "rot":
                            rot.add(feld);
                            if (rot.size()==3) {
                                hausBauen(feld);
                            }
                            break;
                        case "gelb":
                            gelb.add(feld);
                            if (gelb.size()==3) {
                                hausBauen(feld);
                            }
                            break;
                        case "grün":
                            grün.add(feld);
                            if (grün.size()==3) {
                                hausBauen(feld);
                            }
                            break;
                        case "dunkelblau":
                            dunkelblau.add(feld);
                            if (dunkelblau.size()==2);
                            hausBauen(feld);
                            break;
                        case "bahnhof":
                            bahnhoefe.add(feld);
                            if (bahnhoefe.size()==4) {
                                
                            }
                            break;
                        case "werk":
                            werke.add(feld);
                            if (werke.size()==2) {
                               
                            }
                            break;
                        default:
                            System.out.println("Feld konnte keiner Farbe/Kategorie zugeordnet werden");

                    }

                }

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
                        if (einzahlen(str.getKostenHaus() + anzahl)) {
                            if (str.getAnzahlHaueser() + anzahl > 4) {
                                System.out.println("Möchtest du " + ((str.getAnzahlHaueser() + anzahl) - (str.getAnzahlHaueser() + anzahl % 4)) + " deiner " + str.getAnzahlHaueser() + anzahl + " in Hotels umwandeln?");
                                if (br.readLine().trim().toLowerCase().equals("ja")) {
                                    str.setAnzahlHaueser(str.getAnzahlHaueser() + anzahl);
                                    hotelBauen(str);
                                }
                                if (br.readLine().trim().toLowerCase().equals("nein")) {
                                    str.setAnzahlHaueser(str.getAnzahlHaueser() + anzahl);
                                    einzahlen(str.getKostenHaus() * anzahl);
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
            System.out.println("Du kannst in der Straße: " + str.getFeldname() + " max. " + (int) str.getAnzahlHaueser() / 4 + "bauen, wieviele möchtest du Bauen?");
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
}
