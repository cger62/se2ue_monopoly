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
import monopoly.spielfelder.SteuerFeld;
import monopoly.spielfelder.Straße;
import monopoly.spielfelder.Wasserwerk;

/**
 *
 */
public class Map {

    /**
     * Default constructor
     */
    public Map() {
     
           
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
                    Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            //Bahnhofs-Felder
            Bahnhof bahnhof1 = new Bahnhof();
            spielfelder.add(bahnhof1);
            Bahnhof bahnhof2 = new Bahnhof();
            spielfelder.add(bahnhof2);
            Bahnhof bahnhof3 = new Bahnhof();
            spielfelder.add(bahnhof3);
            Bahnhof bahnhof4 = new Bahnhof();
            spielfelder.add(bahnhof4);
            
            //Wasserwerk-Feld
            Wasserwerk wasserwerk = new Wasserwerk();
            spielfelder.add(wasserwerk);
            
            //Elektrizitätswerk-Feld
            Elektrizitätswerk stromwerk = new Elektrizitätswerk();
            spielfelder.add(stromwerk);
            
            //Steuer-Felder
            SteuerFeld zusatzsteuer = new SteuerFeld();
            spielfelder.add(zusatzsteuer);
            SteuerFeld einkommenssteuer = new SteuerFeld();
            spielfelder.add(einkommenssteuer);
            
            // LosFeld
            LosFeld losfeld = new LosFeld();
            spielfelder.add(losfeld);
            
            //FreiParken Feld
            FreiParkenFeld freiparken = new FreiParkenFeld();
            spielfelder.add(freiparken);
            
            //Gefängnisfelder
            GefängnisFeld gefängnis = new GefängnisFeld();
            spielfelder.add(gefängnis);
            GefängnisFeld besuchGefängnis = new GefängnisFeld();
            spielfelder.add(besuchGefängnis);
            
            //Ereigns- und Gemeinschaftsfelder
            EreignisgemeinschaftsFeld egF1 = new EreignisgemeinschaftsFeld();
            spielfelder.add((Spielfelder) egF1);
            EreignisgemeinschaftsFeld egF2 = new EreignisgemeinschaftsFeld();
            spielfelder.add((Spielfelder) egF2);
            EreignisgemeinschaftsFeld egF3 = new EreignisgemeinschaftsFeld();
            spielfelder.add((Spielfelder) egF3);
            EreignisgemeinschaftsFeld egF4 = new EreignisgemeinschaftsFeld();
            spielfelder.add((Spielfelder) egF4);
            EreignisgemeinschaftsFeld egF5 = new EreignisgemeinschaftsFeld();
            spielfelder.add((Spielfelder) egF5);
            EreignisgemeinschaftsFeld egF6 = new EreignisgemeinschaftsFeld();
            spielfelder.add((Spielfelder) egF6);
            
            //Straßen-Felder
            Straße badstr = new Straße();
            spielfelder.add(badstr);
            Straße turmstr = new Straße();
            spielfelder.add(turmstr);
            Straße chausseestr = new Straße();
            spielfelder.add(chausseestr);
            Straße elisenstr = new Straße();
            spielfelder.add(elisenstr);
            Straße poststr = new Straße();
            spielfelder.add(poststr);
            Straße seestr = new Straße();
            spielfelder.add(seestr);
            Straße hafenstr = new Straße();
            spielfelder.add(hafenstr);
            Straße neuestr = new Straße();
            spielfelder.add(neuestr);
            Straße muenchnerstr = new Straße();
            spielfelder.add(muenchnerstr);
            Straße wienerstr = new Straße();
            spielfelder.add(wienerstr);
            Straße berlinerstr = new Straße();
            spielfelder.add(berlinerstr);
            Straße theaterstr = new Straße();
            spielfelder.add(theaterstr);
            Straße museumsstr = new Straße();
            spielfelder.add(museumsstr);
            Straße opernplatz = new Straße();
            spielfelder.add(opernplatz);
            Straße lessingstr = new Straße();
            spielfelder.add(lessingstr);
            Straße schillerstr = new Straße();
            spielfelder.add(schillerstr);
            Straße goethestr = new Straße();
            spielfelder.add(goethestr);
            Straße rathausplatz = new Straße();
            spielfelder.add(rathausplatz);
            Straße hauptstr = new Straße();
            spielfelder.add(hauptstr);
            Straße bahnhofsstr = new Straße();
            spielfelder.add(bahnhofsstr);
            Straße parkstr = new Straße();
            spielfelder.add(parkstr);
            Straße schlossallee = new Straße();
            spielfelder.add(schlossallee);
        } catch (IOException ex) {
            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
