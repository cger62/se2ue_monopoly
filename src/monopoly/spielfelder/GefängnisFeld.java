package monopoly.spielfelder;


import java.util.*;

/**
 * 
 */
public class GefängnisFeld  implements Spielfelder{
    
  
int feldnummer;
String feldname;
    /**
     * Default constructor
     */
    public GefängnisFeld(int feldnummer, String feldname) {
        this.feldnummer = feldnummer;
        this.feldname = feldname;
    }

    @Override
    public int getFeldnummer() {
       return feldnummer; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFeldname() {
        return feldname; //To change body of generated methods, choose Tools | Templates.
    }


    

}