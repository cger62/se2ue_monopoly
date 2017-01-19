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
 * Diese Klasse realisiert das "Spielbrett" fuer Monopoly.
 * Es werden alle Spielfelder initialisiert.
 * 
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public class MonopolyMap {

    public static ArrayList<Spielfelder> spielfelder;

    public static ArrayList<Spieler> spieler;

    public static int anzahlSpieler;

    /**
     * Erstellt eine neue Map: die Spielfelder werden initailisert und
     * die gewuenschten Spieler werden angelegt.
     */
    public MonopolyMap() {
        try {

            //Spieler Array initialisieren
            spieler = new ArrayList<>();

            //SpielFelder Array initialisieren
            spielfelder = new ArrayList<>();

            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            // Abfrage nach Anzahl der Spieler
            anzahlSpieler = 0;
            System.out.println("Wie viele Spieler nehmen Teil?");

            anzahlSpieler = Integer.parseInt(br.readLine());

            //Überprüfung der min./max. Anzahl
            while (anzahlSpieler > 8 || anzahlSpieler < 2) {
                System.out.println("Es dürfen nicht weniger als 2 und nicht mehr als 8 Spieler teilnehmen, bitte korrekte Anzahl eingeben!");
                anzahlSpieler = Integer.parseInt(br.readLine());

            }

            //Spieler initialisieren
            for (int i = 1; i <= anzahlSpieler; i++) {

//                try {
//                    System.out.println("Wie heisst Spieler-Nr.: " + i + " ?");
//
//                    String name = br.readLine();

                    spieler.add(new Spieler("Spieler"+i));

//                } catch (IOException ex) {
//                    Logger.getLogger(MonopolyMap.class.getName()).log(Level.SEVERE, null, ex);
//                }

            }
            
            System.out.println("Es nehmen " + anzahlSpieler + " Spieler in dieser Runde teil.");

            //Bahnhofs-Felder
            Bahnhof nordbahnhof = new Bahnhof(25, "Nordbahnhof", 4000, 500, "bahnhof");
            spielfelder.add(nordbahnhof);

            Bahnhof westbahnhof = new Bahnhof(15, "Westbahnhof", 4000, 500, "bahnhof");
            spielfelder.add(westbahnhof);

            Bahnhof suedbahnhof = new Bahnhof(5, "Südbahnhof", 4000, 500, "bahnhof");
            spielfelder.add(suedbahnhof);

            Bahnhof hauptbahnhof = new Bahnhof(35, "Hauptbahnhof", 4000, 500, "bahnhof");
            spielfelder.add(hauptbahnhof);

            //Wasserwerk-Feld
            Wasserwerk wasserwerk = new Wasserwerk(28, "Wasserwerk", 3000, 0, "werk");
            spielfelder.add(wasserwerk);

            //Elektrizitätswerk-Feld
            Elektrizitätswerk stromwerk = new Elektrizitätswerk(12, "Elektrizitätswerk", 3000, 1500, "werk");

            spielfelder.add(stromwerk);

            //Steuer-Felder
            SteuerFeld zusatzsteuer = new SteuerFeld(38,"Zusatzsteuer" ,2000);
            spielfelder.add(zusatzsteuer);

            SteuerFeld einkommenssteuer = new SteuerFeld(4,"Einkommenssteuer", 4000);

            spielfelder.add(einkommenssteuer);

            // LosFeld
            LosFeld losfeld = new LosFeld(0,"Los-Feld");
            spielfelder.add(losfeld);

            //FreiParken Feld
            FreiParkenFeld freiparken = new FreiParkenFeld(20,"Frei-Parken");
            spielfelder.add(freiparken);

            //Gefängnisfelder
            GefängnisFeld gefängnis = new GefängnisFeld(30, "Gefängnis");
            spielfelder.add(gefängnis);

            NurZuBesuchFeld besuchGefängnis = new NurZuBesuchFeld(10, "Nur zu Besuch im Gefängnis");

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
            Straße badstr = new Straße(1, "Badstraße", 1200, 40, "braun", 1000, 1000);
            spielfelder.add(badstr);

            Straße turmstr = new Straße(3, "Turmstraße", 1200, 80, "braun", 1000, 1000);
            spielfelder.add(turmstr);

            Straße chausseestr = new Straße(6, "Chausseestraße", 2000, 120, "hellblau", 1000, 1000);
            spielfelder.add(chausseestr);

            Straße elisenstr = new Straße(8, "Elisenstraße", 2000, 120, "hellblau", 1000, 1000);
            spielfelder.add(elisenstr);

            Straße poststr = new Straße(9, "Poststraße", 2400, 160, "hellblau", 1000, 1000);
            spielfelder.add(poststr);

            Straße seestr = new Straße(11, "Seestraße", 2800, 200, "pink", 2000, 2000);
            spielfelder.add(seestr);

            Straße hafenstr = new Straße(13, "Hafenstraße", 2800, 200, "pink", 2000, 2000);
            spielfelder.add(hafenstr);

            Straße neuestr = new Straße(14, "Neue Straße", 3200, 240, "pink", 2000, 2000);
            spielfelder.add(neuestr);

            Straße muenchnerstr = new Straße(16, "Münchner Straße", 3600, 280, "orange", 2000, 2000);
            spielfelder.add(muenchnerstr);

            Straße wienerstr = new Straße(18, "Wiener Straße", 3600, 280, "orange", 2000, 2000);
            spielfelder.add(wienerstr);

            Straße berlinerstr = new Straße(19, "Berliner Straße", 4000, 320, "orange", 2000, 2000);
            spielfelder.add(berlinerstr);

            Straße theaterstr = new Straße(21, "Theaterstraße", 4400, 360, "rot", 3000, 3000);
            spielfelder.add(theaterstr);

            Straße museumsstr = new Straße(23, "Museumsstraße", 4400, 360, "rot", 3000, 3000);
            spielfelder.add(museumsstr);

            Straße opernplatz = new Straße(24, "Opernplatz", 4800, 400, "rot", 3000, 3000);
            spielfelder.add(opernplatz);

            Straße lessingstr = new Straße(26, "Lessingstraße", 5200, 440, "gelb", 3000, 3000);
            spielfelder.add(lessingstr);

            Straße schillerstr = new Straße(27, "Schillerstraße", 5200, 440, "gelb", 3000, 3000);
            spielfelder.add(schillerstr);

            Straße goethestr = new Straße(29, "Goethestraße", 5600, 480, "gelb", 3000, 3000);
            spielfelder.add(goethestr);

            Straße rathausplatz = new Straße(31, "Rathausplatz",6000, 520, "grün", 4000, 4000);
            spielfelder.add(rathausplatz);

            Straße hauptstr = new Straße(32, "Hauptstraße", 6000, 520, "grün", 4000, 4000);
            spielfelder.add(hauptstr);

            Straße bahnhofsstr = new Straße(34, "Bahnhofstraße", 6400, 560, "grün", 4000, 4000);
            spielfelder.add(bahnhofsstr);

            Straße parkstr = new Straße(37, "Parkstraße", 7000, 700 , "dunkelblau", 4000, 4000);
            spielfelder.add(parkstr);

            Straße schlossallee = new Straße(39, "Schlossallee", 8000, 1000, "dunkelblau", 4000, 4000);
            spielfelder.add(schlossallee);
            System.out.println("//////////////// Spielbrett erfolgreich initialisiert ////////////////");
          

        } catch (IOException ex) {
            Logger.getLogger(MonopolyMap.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Wenn ein Spieler nicht mehr genuegend Geld auf dem Konto hat, hat er das
     * Spiel verloren und wird aus der Spielerliste entfernt.
     * 
     * @param name der Name des Spielers, der verloren hat
     */
    public static void spielerVerloren(String name) {

        List<Spieler> list = spieler;
        for (Iterator<Spieler> iterator = list.iterator(); iterator.hasNext();) {
            Spieler s = iterator.next();
            if (s.getSpielfigur().equals(name)) {

               Bank.einzahlen(s.getKontostand());
                System.out.println(s.getSpielfigur() + " ist Pleite und wird aus der Liste der Spieler entfernt.");
                iterator.remove();
                anzahlSpieler = anzahlSpieler - 1;
                break;
            }
        }

    }

    /**
     * Ermoeglicht das Spielen von Monopoly.
     * Die einzelnen Spielen sind nacheinander an der Reihe mit dem
     * naechsten Spielzug.
     * Bei jedem Spielzug erscheint eine entsprechende Ausgabe auf
     * der Konsole.
     */
    public void spielen() {
    
        System.out.println("//////////////// Spiel beginnt mit :"+spieler.size() +" Spielern ////////////////");
        while (spieler.size() >= 1) {
            
                
        if (spieler.size() == 1) {
            System.out.println("//////////////// Spiel beendet, Spieler :" + spieler.get(0).getSpielfigur() + " hat gewonnen ////////////////");
            break;

        }
            for (Spieler s : spieler) {
                
                System.out.println("------------------------------------------------------------");
                System.out.println("Spieler: " + s.getSpielfigur() + " ist an der Reihe");
                s.wuerfeln();
                System.out.println("------------------------------------------------------------");
                
            }
        }

    }
}
