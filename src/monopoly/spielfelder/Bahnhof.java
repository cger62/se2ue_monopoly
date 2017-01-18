package monopoly.spielfelder;

/**
 * Diese Klasse realisiert den Bahnhof, welcher fuer das Spiel benoetigt wird.
 * 
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public class Bahnhof extends BesitzrechtFeld implements Spielfelder {

    /**
     * Erzeugt einen neuen Bahnhof mit Hilfe der Super-Klasse BesitzrechtFeld.
     * 
     * @param feldnummer die Nummer des Feldes
     * @param feldname der Name des Feldes
     * @param grundstueckswert der Wert des Grundstuecks
     * @param miete die Miete, die gezahlt werden muss
     * @param farbe die Farbe des Feldes
     */
    public Bahnhof(int feldnummer, String feldname, int grundstueckswert, int miete, String farbe) {
        super(feldnummer,feldname,grundstueckswert,miete, farbe);
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