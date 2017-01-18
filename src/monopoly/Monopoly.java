
package monopoly;

import monopoly.map.MonopolyMap;

/** 
 * Diese Klasse erstellt eine neue MonopolyMap und startet das Spiel.
 *
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public class Monopoly {

    public static void main(String[] args) {
        
    MonopolyMap m = new MonopolyMap();
    System.out.println("------------------------------");
    m.spielen();
     System.out.println("------------------------------");
    }
    
}
