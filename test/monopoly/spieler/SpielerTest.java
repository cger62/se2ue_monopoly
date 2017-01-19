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
        boolean expResult = false;
        boolean result = instance.istGefängnis();
        assertEquals(expResult, result);
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
        if (instance.getAktuellesFeldName() instanceof FreiParkenFeld) {
            System.out.println("Dein aktueller Kontostand beträgt: " + instance.getKontostand());
            System.out.println("Glückwunsch, du bist auf Frei Parken und erhälst den gesamten Pott in Höhe von: " + pott.getKontostand());
            instance.setKontostand(instance.getKontostand() + pott.auszahlen(pott.getKontostand()));
            System.out.println("Dein neuer Kontostand beträgt: " + instance.getKontostand());
        }
    }

}
