package monopoly.spielfelder;


import java.util.*;

/**
 * 
 */
public class LosFeld implements Spielfelder {
    
    


int feldnummer;
String feldname;
    /**
     * Default constructor
     */
    public LosFeld(int feldnummer,String feldname) {
        this.feldnummer = feldnummer;
        this.feldname = feldname;
     
        
    }

    /**
     * @return den festgelegten Betrag beim Überschreiten des Losfeldes 
     */
  

    @Override
    public int getFeldnummer() {
        return feldnummer;
    }

    @Override
    public String getFeldname() {
        return feldname; //To change body of generated methods, choose Tools | Templates.
    }

}