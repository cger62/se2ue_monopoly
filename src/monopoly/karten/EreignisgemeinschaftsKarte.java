package monopoly.karten;


import monopoly.pott.Pott;
import monopoly.map.MonopolyMap;
import monopoly.spieler.Spieler;

/**
 *
 * Diese Klasse realisiert die verschiedenen Ereigniskarten, die im Spiel 
 * verwendet werden.
 * 
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public class EreignisgemeinschaftsKarte  {

    public String text;
    private MonopolyMap map;
    

    /**
     * Erzeugt eine neue Ereigniskarte anhand des uebergebenen Namens.
     * 
     * @param text der Name der Ereigniskarte
     */
    public EreignisgemeinschaftsKarte(String text) {
        this.text = text;
    }

    /**
     * Unterscheidet die verschiedenen Ereigniskarten anhand des Namens,
     * setzt die Spielfigur entsprechend der gewurfelten Zahl und
     * erzeugt eine Konsolenausgabe welche Aktion die Ereigniskarte erfordert.
     * 
     * @param spieler der Spieler, der gerade an der Reihe ist
     */
    public void ereignis(Spieler spieler) {
        switch(text){
            case "Gefängnis" : System.out.println("Gehe ins Gefaengnis."); spieler.istGefängnis = true; break;
            case "Schulgeld" : System.out.println("Schulgeld ist faellig! Zahle 200 Euro."); Pott.einzahlen(200); spieler.setKontostand(spieler.getKontostand()-200);break;
            case "Versicherung" : System.out.println("Deine Lebensversicherung ist faellig! Kassiere 100 Euro."); spieler.auszahlen(100); break;
            case "Schönheitswettbewerb" : System.out.println("Herzlichen Glueckwunsch, du hast einen Schoenheitswettbewerb gewonnen! Kassiere 100 Euro"); spieler.auszahlen(100); break;
            case "Los" : System.out.println("Bewege dich zum Startfeld."); spieler.spielfigurSetzen(0); break;
            case "Geburtstag" : System.out.println("Herzlichen Glueckwunsch! Jeder Spieler muss dir 200 Euro zahlen."); for(Spieler s : map.spieler){s.einzahlen(200);}; spieler.auszahlen(200*(map.spieler.size()+1)); break;
            case "Krankenhaus" : System.out.println("Du bist im Krankhaus und musst die Kosten von 300 Euro zahlen"); Pott.einzahlen(300); spieler.setKontostand(spieler.getKontostand()-300);break;
            case "Urlaubsgeld" : System.out.println("Ab in die Ferien! Kassiere 100 Euro Urlaubsgeld."); spieler.auszahlen(100); break;
            case "Schlossallee" : System.out.println("Gehe zur Schlossallee."); spieler.spielfigurSetzen(39); break;
            case "Opernplatz" : System.out.println("Gehe zum Opernplatz"); spieler.spielfigurSetzen(24); break;
            case "Südbahnhof" : System.out.println("Gehe zum Suedbahnhof"); spieler.spielfigurSetzen(5); break;
            case "Wette" : System.out.println("Heute ist wohl nicht dein Glueckstag...Zahle jedem Spieler 50 Euro!"); spieler.einzahlen(50*(map.spieler.size())+1); for(Spieler s : map.spieler){s.auszahlen(50);}; break;
            case "3zurück" : System.out.println("Gehe drei Felder zurueck!"); spieler.spielfigurSetzen(spieler.aktuellesFeld -3); break;
            case "3vor" : System.out.println("Gehe drei Felder vor!"); spieler.spielfigurSetzen(spieler.aktuellesFeld + 3); break;
            case "Strafzettel" : System.out.println("Bezahle deinen Strafzettel in Hoehe von 50 Euro."); Pott.einzahlen(50); spieler.setKontostand(spieler.getKontostand()-50); break;
            case "Seestraße" : System.out.println("Gehe zur Seestrasse"); spieler.spielfigurSetzen(11); break;
        }
    }

}