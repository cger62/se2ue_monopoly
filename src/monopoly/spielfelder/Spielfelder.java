package monopoly.spielfelder;

import monopoly.spieler.Spieler;

/**
 * Diese Klasse schreibt die zu implementierenden Methoden fuer die Spielfelder
 * vor.
 *
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public interface Spielfelder {

    int getFeldnummer();

    String getFeldname();

    /**
     *
     * @param s Spieler auf auf dem Feld
     * @param f Feld auf dem sich Spieler befindet
     */
    void spielfeldAktion(Spieler s, Spielfelder f);
}
