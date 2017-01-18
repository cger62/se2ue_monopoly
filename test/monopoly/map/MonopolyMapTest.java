/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.map;

import java.io.ByteArrayInputStream;
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
public class MonopolyMapTest {
    
    public MonopolyMapTest() {
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
     * Diese Methode testet, ob bei einer korrekten Eingabe der Anzahl der Spielteilnehmer
     * auch die entsprechende Anzahl von Spielern erstellt wird, ohne dass eine
     * Fehlermeldung erscheint.
     */
    @Test
    public void testRichtigeAnzahlSpieler() {
        System.out.println("Test: Korrekte Anzahl von Spielern");
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        MonopolyMap instance = new MonopolyMap();
        int expResult = 3;
        int result = instance.spieler.size();
        assertEquals(expResult, result);
    }
    
}