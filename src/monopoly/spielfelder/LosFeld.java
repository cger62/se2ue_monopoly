package monopoly.spielfelder;

import monopoly.spieler.Spieler;

/**
 * Die Klasse realisiert das Startfeld des Spiels. Die Klasse implementiert das
 * Interface Spielfelder.
 *
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public class LosFeld implements Spielfelder {

    private int feldnummer;

    private String feldname;

    /**
     * Erzeugt ein LosFeld anhand der uebergebenen Methodenparameter.
     *
     * @param feldnummer die Nummer des LosFeldes
     * @param feldname der Name des Spielfeldes
     */
    public LosFeld(int feldnummer, String feldname) {
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

    @Override
    public void spielfeldAktion(Spieler s, Spielfelder f) {
        System.out.println("Du bist auf Los und erhälst 4000 Mark");
        s.auszahlen(4000);
        System.out.println("Aktueller Kontostand: "+ s.getKontostand());
    }

}
