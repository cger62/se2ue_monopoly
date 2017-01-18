package monopoly.spielfelder;

/**
 * Diese Klasse repräsentiert ein Elektrizitätswerk, welches für das Spiel
 * benoetigt wird.
 * Die Klasse erbt von BesitzrechtFeld und implementier das Interface
 * Spielfelder.
 * 
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */

public class Elektrizitätswerk extends BesitzrechtFeld implements Spielfelder {

    /**
     * Erzeugt ein neues Elektrizitätswerk anhand der uebergebenen Werte.
     * Die Methodenparameter werden ueber den Konstruktor von Besitzrechtfeld 
     * initialisiert.
     * 
     * @param feldnummer die Nummer des Spielfeldes
     * @param feldname der Name des Spielfeldes
     * @param grundstueckswert der Wert des Grundstuecks
     * @param miete die Miete, die bezahlt werden muss
     * @param farbe die Farbe des Spielfeldes
     */
    public Elektrizitätswerk(int feldnummer, String feldname, int grundstueckswert, int miete, String farbe) {
        super(feldnummer,feldname,grundstueckswert,miete,farbe);
    }

    @Override
    public int getFeldnummer() {
         return feldnummer;
    }
    
    @Override
    public String getFeldname() {
        return feldname;
    }

}