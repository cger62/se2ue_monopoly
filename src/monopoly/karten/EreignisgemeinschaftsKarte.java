package monopoly.karten;


import monopoly.pott.Pott;
import monopoly.spielfelder.Spielfelder;
import java.util.*;
import monopoly.map.MonopolyMap;
import monopoly.spieler.Spieler;

/**
 *
 */
public class EreignisgemeinschaftsKarte implements Spielfelder {

    public int wert;
    public String text;
    public Boolean isEinzahlung;
    private MonopolyMap map;
    private Spieler spieler;

    /**
     * @param wert
     * @param text
     * @param isEinzahlung
     */
    public EreignisgemeinschaftsKarte(int wert, String text, boolean isEinzahlung) {
        this.wert = wert;
        this.text = text;
        this.isEinzahlung = isEinzahlung;
    }

    public void ereignis() {
        switch(text){
            case "Gefängnis" : System.out.println("Gehe ins Gefaengnis."); spieler.istGefängnis = true; break;
            case "Schulgeld" : System.out.println("Schulgeld ist faellig! Zahle 50 Euro."); spieler.einzahlen(50); break;
            case "Versicherung" : System.out.println("Deine Lebensversicherung ist faellig! Kassiere 100 Euro."); spieler.einziehen(100); break;
            case "Schönheitswettbewerb" : System.out.println("Herzlichen Glueckwunsch, du hast einen Schoenheitswettbewerb gewonnen! Kassiere 10 Euro"); spieler.einziehen(10); break;
            case "Los" : System.out.println("Bewege dich zum Startfeld."); spieler.spielfigurSetzen(1); break;
            case "Geburtstag" : System.out.println("Herzlichen Glueckwunsch! Jeder Spieler muss dir 20 Euro zahlen."); for(Spieler s : map.spieler){s.einzahlen(20);}; spieler.einziehen(20*map.spieler.size()); break;
            case "Krankenhaus" : System.out.println(""); spieler.einzahlen(80);break;
            case "Urlaubsgeld" : System.out.println("Ab in die Ferien! Kassiere 50 Euro Urlaubsgeld."); spieler.einziehen(50); break;
            case "Schlossallee" : System.out.println("Gehe zur Schlossallee."); spieler.spielfigurSetzen(40); break;
            case "Opernplatz" : System.out.println("Gehe zum Opernplatz"); spieler.spielfigurSetzen(25); break;
            case "Südbahnhof" : System.out.println("Gehe zum Suedbahnhof"); spieler.spielfigurSetzen(6); break;
            case "Wette" : System.out.println("Heute ist wohl nicht dein Glueckstag...Zahle jedem Spieler 50 Euro!"); spieler.einzahlen(50*map.spieler.size()); for(Spieler s : map.spieler){s.einziehen(50);}; break;
            case "3zurück" : System.out.println("Gehe drei Felder zurueck!"); spieler.spielfigurSetzen(spieler.aktuellesFeld -3); break;
            case "3vor" : System.out.println("Gehe drei Felder vor!"); spieler.spielfigurSetzen(spieler.aktuellesFeld + 3); break;
            case "Strafzettel" : System.out.println("Bezahle deinen Strafzettel in Hoehe von 15 Euro."); spieler.einzahlen(15); break;
            case "Seestraße" : System.out.println("Gehe zur Seestrasse"); spieler.spielfigurSetzen(12); break;
        }
    }

}