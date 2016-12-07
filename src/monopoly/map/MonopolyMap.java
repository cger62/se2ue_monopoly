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
    public MonopolyMap() {

        initMap();

    }

    /**
     *
     */
    public ArrayList<Spielfelder> spielfelder;

    /**
     *
     */
    public ArrayList<Spieler> spieler;

    /**
     *
     */
    public int anzahlSpieler;

    /**
     *
     */
    private void initMap() {
        try {
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
            for (int i = 0; i < anzahlSpieler; i++) {

                try {
                    System.out.println("Wie heisst Spieler-Nr.: " + i + " ?");

                    String name = br.readLine();
                    System.out.println("Ist " + name + " die Bank?(ja/nein)");
                    String bank = br.readLine();
                    if (bank.trim().toLowerCase().equals("ja")) {

                        spieler.add(new Spieler(name, new Bank()));
                    } else {
                        spieler.add(new Spieler(name, null));
                    }
                } catch (IOException ex) {
                    Logger.getLogger(MonopolyMap.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            //Bahnhofs-Felder
            Bahnhof nordbahnhof = new Bahnhof(26, "Nordbahnhof", 25, 25, 25);
            spielfelder.add(nordbahnhof);

            Bahnhof westbahnhof = new Bahnhof(16, "Westbahnhof", 25, 25, 25);
            spielfelder.add(westbahnhof);

            Bahnhof suedbahnhof = new Bahnhof(6, "Südbahnhof", 25, 25, 25);
            spielfelder.add(suedbahnhof);

            Bahnhof hauptbahnhof = new Bahnhof(36, "Hauptbahnhof", 25, 25, 25);
            spielfelder.add(hauptbahnhof);

            //Wasserwerk-Feld
            Wasserwerk wasserwerk = new Wasserwerk(29, "Wasserwerk", 25, 25, 25);
            spielfelder.add(wasserwerk);

            //Elektrizitätswerk-Feld
            Elektrizitätswerk stromwerk = new Elektrizitätswerk(13, "Elektrizitätswerk", 25, 25, 25);

            spielfelder.add(stromwerk);

            //Steuer-Felder
            SteuerFeld zusatzsteuer = new SteuerFeld();
            spielfelder.add(zusatzsteuer);

            SteuerFeld einkommenssteuer = new SteuerFeld();
            einkommenssteuer.setFeldnummer(5);
            spielfelder.add(einkommenssteuer);

            // LosFeld
            LosFeld.feldnummer = 1;
            LosFeld losfeld = new LosFeld();
            spielfelder.add(losfeld);

            //FreiParken Feld
            FreiParkenFeld freiparken = new FreiParkenFeld();
            FreiParkenFeld.feldnummer = 21;
            spielfelder.add(freiparken);

            //Gefängnisfelder
            GefängnisFeld gefängnis = new GefängnisFeld();
            spielfelder.add(gefängnis);
            NurZuBesuchFeld besuchGefängnis = new NurZuBesuchFeld();
            besuchGefängnis.setFeldnummer(11);
            spielfelder.add(besuchGefängnis);

            //Ereigns- und Gemeinschaftsfelder
            EreignisgemeinschaftsFeld egF1 = new EreignisgemeinschaftsFeld();
            egF1.feldnummer = 3;
            egF1.feldname = "Gemeinschaftsfeld";
            spielfelder.add((Spielfelder) egF1);

            EreignisgemeinschaftsFeld egF2 = new EreignisgemeinschaftsFeld();
            egF2.feldnummer = 8;
            egF2.feldname = "Ereignisfeld";
            spielfelder.add((Spielfelder) egF2);

            EreignisgemeinschaftsFeld egF3 = new EreignisgemeinschaftsFeld();
            egF3.feldnummer = 18;
            egF3.feldname = "Gemeinschaftsfeld";
            spielfelder.add((Spielfelder) egF3);

            EreignisgemeinschaftsFeld egF4 = new EreignisgemeinschaftsFeld();
            egF4.feldnummer = 23;
            egF4.feldname = "Ereignisfeld";
            spielfelder.add((Spielfelder) egF4);

            EreignisgemeinschaftsFeld egF5 = new EreignisgemeinschaftsFeld();
            egF5.feldnummer = 34;
            egF5.feldname = "Gemeinschaftsfeld";

            spielfelder.add((Spielfelder) egF5);

            EreignisgemeinschaftsFeld egF6 = new EreignisgemeinschaftsFeld();
            egF6.feldnummer = 37;
            egF6.feldname = "Ereignisfeld";
            spielfelder.add((Spielfelder) egF6);

            //Straßen-Felder
            Straße badstr = new Straße(2, "Badstraße", 25, 25, 25);
            spielfelder.add(badstr);

            Straße turmstr = new Straße(4, "Turmstraße", 25, 25, 25);
            spielfelder.add(turmstr);

            Straße chausseestr = new Straße(7, "Chausseestraße", 25, 25, 25);
            spielfelder.add(chausseestr);

            Straße elisenstr = new Straße(9, "Elisenstraße", 25, 25, 25);
            spielfelder.add(elisenstr);

            Straße poststr = new Straße(10, "Poststraße", 25, 25, 25);
            spielfelder.add(poststr);

            Straße seestr = new Straße(12, "Seestraße", 25, 25, 25);
            spielfelder.add(seestr);

            Straße hafenstr = new Straße(14, "Hafenstraße", 25, 25, 25);
            spielfelder.add(hafenstr);

            Straße neuestr = new Straße(15, "Neue Straße", 25, 25, 25);
            spielfelder.add(neuestr);

            Straße muenchnerstr = new Straße(17, "Münchner Straße", 25, 25, 25);
            spielfelder.add(muenchnerstr);

            Straße wienerstr = new Straße(19, "Wiener Straße", 25, 25, 25);
            spielfelder.add(wienerstr);

            Straße berlinerstr = new Straße(20, "Berliner Straße", 25, 25, 25);
            spielfelder.add(berlinerstr);

            Straße theaterstr = new Straße(22, "Theaterstraße", 25, 25, 25);
            spielfelder.add(theaterstr);

            Straße museumsstr = new Straße(24, "Museumsstraße", 25, 25, 25);
            spielfelder.add(museumsstr);

            Straße opernplatz = new Straße(25, "Opernplatz", 25, 25, 25);
            spielfelder.add(opernplatz);

            Straße lessingstr = new Straße(27, "Lessingstraße", 25, 25, 25);
            spielfelder.add(lessingstr);

            Straße schillerstr = new Straße(28, "Schillerstraße", 25, 25, 25);
            spielfelder.add(schillerstr);

            Straße goethestr = new Straße(30, "Goethestraße", 25, 25, 25);
            spielfelder.add(goethestr);

            Straße rathausplatz = new Straße(32, "Rathausplatz", 25, 25, 25);
            spielfelder.add(rathausplatz);

            Straße hauptstr = new Straße(33, "Hauptstraße", 25, 25, 25);
            spielfelder.add(hauptstr);

            Straße bahnhofsstr = new Straße(35, "Bahnhofstraße", 25, 25, 25);
            spielfelder.add(bahnhofsstr);

            Straße parkstr = new Straße(38, "Parkstraße", 25, 25, 25);
            spielfelder.add(parkstr);

            Straße schlossallee = new Straße(40, "Schlossallee", 25, 25, 25);
            spielfelder.add(schlossallee);

        } catch (IOException ex) {
            Logger.getLogger(MonopolyMap.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
