package monopoly.spielfelder;


/**
 * Diese Klasse realisiert das Gefaengnisfeld.
 * Die Klasse implementiert das Interface Spielfelder.
 * 
 * Landet ein Spieler im Gefaengnis, hat er die Moeglichkeit sich in der naechsten
 * Runde mit max. 3 Versuchen frei zu wuerfeln. Dazu wird zuvor eine passende
 * Zufallszahl generiert. 
 * Wird nach dem 3. Versuch nicht die richtige Zahl gewuerfelt,
 * muss der Spieler 1000 Euro an die Bank zahlen und kann in der naechsten 
 * Runde mit dem Spielen fortfahren.
 * 
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public class GefängnisFeld  implements Spielfelder{
   
int feldnummer;

String feldname;
    /**
     * Erzeugt ein Gefaengnisfeld anhand der uebergebenen Methodenparameter.
     * 
     * @param feldnummer die Nummer des Gefaengnisfeldes
     * @param feldname der Name des Spielfeldes
     */
    public GefängnisFeld(int feldnummer, String feldname) {
        this.feldnummer = feldnummer;
        this.feldname = feldname;
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