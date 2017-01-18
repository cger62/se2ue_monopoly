package monopoly.spielfelder;

/**
 * Diese Klasse realisiert das FreiParkenFeld.
 * Wenn jemand auf diesem Spielfeld landet, erhaelt der Spieler den Inhalt
 * des Potts.
 * Die Klasse implementiert das Interface Spielfelder.
 * 
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public class FreiParkenFeld implements Spielfelder{
    
    int feldnummer;
    
    String feldname;
     

    /**
     * Erzeugt ein FreiParkenFeld anhand der uebergebenen Methodenparamter.
     * 
     * @param feldnummer die Nummer des FreiParkenFeldes
     * @param feldname der Name des Spielfeldes
     */
    public FreiParkenFeld(int feldnummer, String feldname) {
        this.feldnummer= feldnummer;
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