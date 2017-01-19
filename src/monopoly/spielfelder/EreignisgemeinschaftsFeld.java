package monopoly.spielfelder;

import monopoly.karten.EreignisgemeinschaftsKarte;
import java.util.*;
import monopoly.map.MonopolyMap;
import monopoly.spieler.Spieler;

/**
 * Diese Klasse realisiert die verschiedenen Ereignisgemeinschaftsfelder anhand
 * des Namens. Die Klasse implementiert das Interface Spielfelder.
 *
 * @author Casten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public class EreignisgemeinschaftsFeld implements Spielfelder {

    private int feldnummer;
    private final String feldname;

    public EreignisgemeinschaftsKarte[] karten = {new EreignisgemeinschaftsKarte("Schulgeld"),
        new EreignisgemeinschaftsKarte("Geburtstag"),
        new EreignisgemeinschaftsKarte("Krankenhaus"),
        new EreignisgemeinschaftsKarte("Strafzettel"),
        new EreignisgemeinschaftsKarte("Urlaubsgeld"),
        new EreignisgemeinschaftsKarte("Versicherung"),
        new EreignisgemeinschaftsKarte("Schönheitswettbewerb"),
        new EreignisgemeinschaftsKarte("Wette"),
        new EreignisgemeinschaftsKarte("Los"),
        new EreignisgemeinschaftsKarte("Gefängnis"),
        new EreignisgemeinschaftsKarte("Südbahnhof"),
        new EreignisgemeinschaftsKarte("Opernplatz"),
        new EreignisgemeinschaftsKarte("Schlossallee"),
        new EreignisgemeinschaftsKarte("Seestraße"),
        new EreignisgemeinschaftsKarte("3zurück"),
        new EreignisgemeinschaftsKarte("3vor")};

    /**
     * Erzeugt ein neues Ereignisgemeinschaftsfeld anhand der uebergebenen
     * Methodenparameter.
     *
     * @param feldnummer die Nummer des Spielfeldes
     * @param feldname der Name des Spielfeldes
     */
    public EreignisgemeinschaftsFeld(int feldnummer, String feldname) {
        this.feldnummer = feldnummer;
        this.feldname = feldname;
    }

    /**
     * Iteriert ueber das Array karten und waehlt zufaellig eine Karte aus.
     *
     * @return die zufaellig ausgewaehlte Karte
     */
    public EreignisgemeinschaftsKarte zufaelligeKarteGenerieren() {

        int random = new Random().nextInt(karten.length - 1);
        EreignisgemeinschaftsKarte result = (karten[random]);
        return result;
    }

    @Override
    public void spielfeldAktion(Spieler s, Spielfelder f) {
        System.out.println("Dein aktueller Kontostand beträgt: " + s.getKontostand());
        EreignisgemeinschaftsFeld e = (EreignisgemeinschaftsFeld) f;
        EreignisgemeinschaftsKarte randomKarte = e.zufaelligeKarteGenerieren();
        randomKarte.ereignis(s);
        boolean einzahlen = s.einzahlen(0);
        if (!einzahlen) {
            MonopolyMap.spielerVerloren(s.getSpielfigur());
        } else {
            System.out.println("Dein neuer Kontostand beträgt: " + s.getKontostand());
        }
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
