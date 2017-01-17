package monopoly.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import monopoly.spieler.Spieler;
import monopoly.spielfelder.Spielfelder;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import monopoly.bank.Bank;
import monopoly.spielfelder.Bahnhof;
import monopoly.spielfelder.Elektrizitätswerk;
import monopoly.spielfelder.EreignisgemeinschaftsFeld;
import monopoly.spielfelder.FreiParkenFeld;
import monopoly.spielfelder.GefängnisFeld;
import monopoly.spielfelder.LosFeld;
import monopoly.spielfelder.NurZuBesuchFeld;
import monopoly.spielfelder.SteuerFeld;
import monopoly.spielfelder.Straße;
import monopoly.spielfelder.Wasserwerk;

/**
 *
 */
public class MonopolyMap {

    /**
     * Default constructor
     */
    /**
     *
     */
    public static ArrayList<Spielfelder> spielfelder;

    /**
     *
     */
    public static ArrayList<Spieler> spieler;

    /**
     *
     */
    public static int anzahlSpieler;

    /**
     *
     */
    public MonopolyMap() {
        try {

            //Spieler Array initialisieren
            spieler = new ArrayList<>();

            //SpielFelder Array initialisieren
            spielfelder = new ArrayList<>();

            //StreamReader & Buffredreader
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            // Abfrage nach Anzahl der Spieler
            anzahlSpieler = 0;
            System.out.println("Wie viele Spieler nehmen Teil?");

            anzahlSpieler = Integer.parseInt(br.readLine());

            //Überprüfung der min./max. Anzahl
            if (anzahlSpieler > 8 || anzahlSpieler < 2) {
                System.out.println("Es können nur maximal 8 Spieler teilnehmen, bitte korrekte Anzahl eingeben!");
                anzahlSpieler = Integer.parseInt(br.readLine());

            }

            //Spieler initialisieren
            for (int i = 1; i <= anzahlSpieler; i++) {

                try {
                    System.out.println("Wie heisst Spieler-Nr.: " + i + " ?");

                    String name = br.readLine();

                    spieler.add(new Spieler(name));

                } catch (IOException ex) {
                    Logger.getLogger(MonopolyMap.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            //Bahnhofs-Felder
            Bahnhof nordbahnhof = new Bahnhof(25, "Nordbahnhof", 25, 25, 25, "bahnhof");
            spielfelder.add(nordbahnhof);

            Bahnhof westbahnhof = new Bahnhof(15, "Westbahnhof", 25, 25, 25, "bahnhof");
            spielfelder.add(westbahnhof);

            Bahnhof suedbahnhof = new Bahnhof(5, "Südbahnhof", 25, 25, 25, "bahnhof");
            spielfelder.add(suedbahnhof);

            Bahnhof hauptbahnhof = new Bahnhof(35, "Hauptbahnhof", 25, 25, 25, "bahnhof");
            spielfelder.add(hauptbahnhof);

            //Wasserwerk-Feld
            Wasserwerk wasserwerk = new Wasserwerk(28, "Wasserwerk", 25, 25, 25, "werk");
            spielfelder.add(wasserwerk);

            //Elektrizitätswerk-Feld
            Elektrizitätswerk stromwerk = new Elektrizitätswerk(12, "Elektrizitätswerk", 25, 25, 25, "werk");

            spielfelder.add(stromwerk);

            //Steuer-Felder
            SteuerFeld zusatzsteuer = new SteuerFeld(38, 25);
            spielfelder.add(zusatzsteuer);

            SteuerFeld einkommenssteuer = new SteuerFeld(4, 24);

            spielfelder.add(einkommenssteuer);

            // LosFeld
            LosFeld losfeld = new LosFeld(0);
            spielfelder.add(losfeld);

            //FreiParken Feld
            FreiParkenFeld freiparken = new FreiParkenFeld(20);
            //FreiParkenFeld.feldnummer = 21;
            spielfelder.add(freiparken);

            //Gefängnisfelder
            GefängnisFeld gefängnis = new GefängnisFeld(30);
            spielfelder.add(gefängnis);

            NurZuBesuchFeld besuchGefängnis = new NurZuBesuchFeld(10);

            spielfelder.add(besuchGefängnis);

            //Ereigns- und Gemeinschaftsfelder
            EreignisgemeinschaftsFeld egF1 = new EreignisgemeinschaftsFeld(2, "Gemeinschaftsfeld");
            spielfelder.add((Spielfelder) egF1);

            EreignisgemeinschaftsFeld egF2 = new EreignisgemeinschaftsFeld(7, "Ereignisfeld");
            spielfelder.add((Spielfelder) egF2);

            EreignisgemeinschaftsFeld egF3 = new EreignisgemeinschaftsFeld(17, "Gemeinschaftsfeld");
            spielfelder.add((Spielfelder) egF3);

            EreignisgemeinschaftsFeld egF4 = new EreignisgemeinschaftsFeld(22, "Ereignisfeld");
            spielfelder.add((Spielfelder) egF4);

            EreignisgemeinschaftsFeld egF5 = new EreignisgemeinschaftsFeld(33, "Gemeinschaftsfeld");
            spielfelder.add((Spielfelder) egF5);

            EreignisgemeinschaftsFeld egF6 = new EreignisgemeinschaftsFeld(36, "Ereignisfeld");
            spielfelder.add((Spielfelder) egF6);

            //Straßen-Felder
            Straße badstr = new Straße(1, "Badstraße", 25, 25, 25, "braun", 25, 25);
            spielfelder.add(badstr);

            Straße turmstr = new Straße(3, "Turmstraße", 25, 25, 25, "braun", 25, 25);
            spielfelder.add(turmstr);

            Straße chausseestr = new Straße(6, "Chausseestraße", 25, 25, 25, "hellblau", 25, 25);
            spielfelder.add(chausseestr);

            Straße elisenstr = new Straße(8, "Elisenstraße", 25, 25, 25, "hellblau", 25, 25);
            spielfelder.add(elisenstr);

            Straße poststr = new Straße(9, "Poststraße", 25, 25, 25, "hellblau", 25, 25);
            spielfelder.add(poststr);

            Straße seestr = new Straße(11, "Seestraße", 25, 25, 25, "pink", 25, 25);
            spielfelder.add(seestr);

            Straße hafenstr = new Straße(13, "Hafenstraße", 25, 25, 25, "pink", 25, 25);
            spielfelder.add(hafenstr);

            Straße neuestr = new Straße(14, "Neue Straße", 25, 25, 25, "pink", 25, 25);
            spielfelder.add(neuestr);

            Straße muenchnerstr = new Straße(16, "Münchner Straße", 25, 25, 25, "orange", 25, 25);
            spielfelder.add(muenchnerstr);

            Straße wienerstr = new Straße(18, "Wiener Straße", 25, 25, 25, "orange", 25, 25);
            spielfelder.add(wienerstr);

            Straße berlinerstr = new Straße(19, "Berliner Straße", 25, 25, 25, "orange", 25, 25);
            spielfelder.add(berlinerstr);

            Straße theaterstr = new Straße(21, "Theaterstraße", 25, 25, 25, "rot", 25, 25);
            spielfelder.add(theaterstr);

            Straße museumsstr = new Straße(23, "Museumsstraße", 25, 25, 25, "rot", 25, 25);
            spielfelder.add(museumsstr);

            Straße opernplatz = new Straße(24, "Opernplatz", 25, 25, 25, "rot", 25, 25);
            spielfelder.add(opernplatz);

            Straße lessingstr = new Straße(26, "Lessingstraße", 25, 25, 25, "gelb", 25, 25);
            spielfelder.add(lessingstr);

            Straße schillerstr = new Straße(27, "Schillerstraße", 25, 25, 25, "gelb", 25, 25);
            spielfelder.add(schillerstr);

            Straße goethestr = new Straße(29, "Goethestraße", 25, 25, 25, "gelb", 25, 25);
            spielfelder.add(goethestr);

            Straße rathausplatz = new Straße(31, "Rathausplatz", 25, 25, 25, "grün", 25, 25);
            spielfelder.add(rathausplatz);

            Straße hauptstr = new Straße(32, "Hauptstraße", 25, 25, 25, "grün", 25, 25);
            spielfelder.add(hauptstr);

            Straße bahnhofsstr = new Straße(34, "Bahnhofstraße", 25, 25, 25, "grün", 25, 25);
            spielfelder.add(bahnhofsstr);

            Straße parkstr = new Straße(37, "Parkstraße", 25, 25, 25, "dunkelblau", 25, 25);
            spielfelder.add(parkstr);

            Straße schlossallee = new Straße(39, "Schlossallee", 25, 25, 25, "dunkelblau", 25, 25);
            spielfelder.add(schlossallee);

            for (Spielfelder s : spielfelder) {
                System.out.println(s.getFeldnummer());

            }

        } catch (IOException ex) {
            Logger.getLogger(MonopolyMap.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void spielerVerloren(String name) {

        for (Spieler s : spieler) {
            if (s.getSpielfigur().equals(name)) {

                Bank.einzahlen(s.getKontostand());

                spieler.remove(s);
                anzahlSpieler = anzahlSpieler - 1;
            }
        }

    }

    public void spielen() {
        if (spieler.size() == 1) {
            System.out.println("Spiel beendet, Spieler :" + spieler.get(1) + " hat gewonnen");

        }

        while (spieler.size() != 1) {
            int i = 0;
            for (Spieler s : spieler) {
                
                System.out.println("------------------------------");
                System.out.println("Spieler: " + s.getSpielfigur() + " ist an der Reihe");
                spieler.get(i).wuerfeln();
                i = +1;
            }
        }

    }
}
