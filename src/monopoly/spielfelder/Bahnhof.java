package monopoly.spielfelder;

/**
 * Diese Klasse realisiert den Bahnhof, welcher fuer das Spiel benoetigt wird.
 * 
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public class Bahnhof extends BesitzrechtFeld implements Spielfelder {

    /**
     * Erzeugt einen neuen Bahnhof mit Hilfe der Super-Klasse BesitzrechtFeld.
     */
    public Bahnhof(int feldnummer, String feldname, int grundstueckswert, int miete, String color) {
        super(feldnummer,feldname,grundstueckswert,miete, color);
    }
    
    @Override
    public String getFeldname(){
    return feldname;
    }

}