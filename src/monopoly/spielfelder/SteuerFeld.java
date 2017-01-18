package monopoly.spielfelder;


import java.util.*;

/**
 * 
 */
public class SteuerFeld  implements Spielfelder{

    int feldnummer;
    String feldname;

    private int steuern;

    //Default Constructor

    
    

    public SteuerFeld(int feldnummer, String feldname, int steuern) {
    this.feldnummer = feldnummer;
    this.feldname=feldname;
        this.steuern = steuern;
    }
    
  

    public int getSteuern() {
        return steuern;
    }

    @Override
    public int getFeldnummer() {
         return feldnummer;
    }

    @Override
    public String getFeldname() {
       return feldname; //To change body of generated methods, choose Tools | Templates.
    }
}