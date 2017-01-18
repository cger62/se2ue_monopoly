package monopoly.spielfelder;

/**
 *  Die Klasse realisiert das Startfeld des Spiels.
 * Die Klasse implementiert das Interface Spielfelder.
 * 
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public class LosFeld implements Spielfelder {
    
int feldnummer;

String feldname;
    /**
     * Erzeugt ein LosFeld anhand der uebergebenen Methodenparameter.
     * 
     * @param feldnummer die Nummer des LosFeldes
     * @param feldname der Name des Spielfeldes
     */
    public LosFeld(int feldnummer,String feldname) {
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