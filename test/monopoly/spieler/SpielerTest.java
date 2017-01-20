/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.spieler;

import java.io.ByteArrayInputStream;
import monopoly.map.MonopolyMap;
import monopoly.pott.Pott;
import monopoly.spielfelder.BesitzrechtFeld;
import monopoly.spielfelder.FreiParkenFeld;
import monopoly.spielfelder.Spielfelder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carsten Gericke, Liane Lin, Sali Hassan, Annika Schoettle
 */
public class SpielerTest {

    public SpielerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * In dieser Methode wird getestet, ob dem Spieler das dreimalige Wuerfeln
     * gestattet ist, sobald er sich im Gefaengnis befindet und ob er - egal ob
     * er anschließend zahlen muss oder nicht - in der naechsten Runde wieder
     * aus dem Gefaengnis entlassen wird.
     */
    @Test
    public void testWuerfelnGefaengnis() {
        System.out.println("Test: 3x würfeln, um aus dem Gefängnis zu kommen");
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        MonopolyMap map = new MonopolyMap();
        Spieler instance = map.getSpieler().get(2);
        instance.setIstGefängnis(true);
        instance.wuerfeln();
        boolean result = instance.istGefängnis();
        assertFalse(result);
    }

    /**
     * Diese Methode testet, ob ein Spieler mithilfe der
     * spielfigurSetzen()-Methode beim Übergeben einer Feldnummer auch genau auf
     * dem Feld mit dieser Nummer landet.
     */
    @Test
    public void testSpielfigurSetzen() {
        System.out.println("\n\nTest: Spielfigur setzen");
        int feldNummer = 7;
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        MonopolyMap map = new MonopolyMap();
        Spieler instance = map.getSpieler().get(2);
        instance.setAktuellesFeld(0);
        int expResult = map.getSpielfelder().get(13).getFeldnummer(); //ANMERKUNG: Das Feld mit der Feldnummer 7 befindet sich an 14. Stelle im Spielfelder-Array (deshalb die 13)
        int result = instance.spielfigurSetzen(feldNummer).getFeldnummer();
        assertEquals(expResult, result);
        System.out.println(instance.getSpielfigur() + " sollte sich jetzt auf Feld Nummer " + expResult + " befinden. Aktelles Feld: " + result);
    }

    /**
     * Diese Methode testet, ob der Spieler korrekt aus dem Spiel ausscheidet,
     * sobald er auf ein Feld kommt, dessen Miete er nicht mehr zahlen kann.
     */
    @Test
    public void testMieteZahlen() {
        System.out.println("\n\nTest: Verlieren");
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        MonopolyMap map = new MonopolyMap();
        int spielerVorher = map.getAnzahlSpieler();
        Spieler instance = map.getSpieler().get(2);
        instance.setKontostand(50);
        instance.setAktuellesFeld(32);
        instance.mieteZahlen((BesitzrechtFeld) map.getSpielfelder().get(32));
        int expResult = spielerVorher - 1;
        int result = map.getAnzahlSpieler();
        assertNotEquals(spielerVorher, result);
        assertEquals(expResult, result);
        System.out.println("Es sind jetzt noch " + result + " Teilnehmer im Spiel.");
    }

    /**
     * In dieser Methode wird getestet, ob der Spieler den gesamten Betrag aus
     * dem Pott bekommt, sobald er auf das FreiParken-Feld kommt.
     */
    @Test
    public void testFreiParken() {
        System.out.println("\n\nTest: FreiParken");
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        MonopolyMap map = new MonopolyMap();
        Pott pott = new Pott();
        pott.setKontostand(5000);
        Spieler instance = map.getSpieler().get(2);
        instance.setAktuellesFeldName(instance.spielfigurSetzen(20));
        instance.getAktuellesFeldName().spielfeldAktion(instance, instance.getAktuellesFeldName());
        assertEquals(pott.getKontostand(), 0);
    }
    
    /**
     * In dieser Methode wird getestet, ob Steuern korrekt in den Pott gezahlt
     * werden, sobald ein Spieler auf ein SteuerFeld kommt.
     */
    @Test
    public void testSteuerFeld() {
        System.out.println("\n\nTest: SteuerFeld");
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        MonopolyMap map = new MonopolyMap();
        Pott pott = new Pott();
        System.out.println("Im Pott befinden sich " + pott.getKontostand());
        Spieler instance = map.getSpieler().get(2);
        Spieler instance2 = map.getSpieler().get(0);
        System.out.println(instance.getSpielfigur() + ":");
        instance.setAktuellesFeldName(instance.spielfigurSetzen(4));
        instance.getAktuellesFeldName().spielfeldAktion(instance, instance.getAktuellesFeldName());
        System.out.println(instance2.getSpielfigur() + ":");
        instance2.setKontostand(2000);
        instance2.setAktuellesFeldName(instance2.spielfigurSetzen(4));
        instance2.getAktuellesFeldName().spielfeldAktion(instance2, instance2.getAktuellesFeldName());
        System.out.println("Es sind jetzt noch " + map.getAnzahlSpieler() + " Teilnehmer im Spiel.");
        System.out.println("Im Pott befinden sich nun " + pott.getKontostand());
    }

}
