package monopoly.spielfelder;


import monopoly.karten.EreignisgemeinschaftsKarte;
import java.util.*;

/**
 * 
 */
public class EreignisgemeinschaftsFeld implements Spielfelder{

    int feldnummer;
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
     * @param feldnummer 
     * @param feldname
     */
    public EreignisgemeinschaftsFeld(int feldnummer, String feldname) {
       this.feldnummer = feldnummer;
        this.feldname = feldname;        
    }
    
    public EreignisgemeinschaftsKarte randomKarte() {
       
        int random = new Random().nextInt(karten.length-1);
        EreignisgemeinschaftsKarte result = (karten[random]); 
        return result;
    }

    @Override
    public int getFeldnummer() {
         return feldnummer; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFeldname() {
       return feldname;//To change body of generated methods, choose Tools | Templates.
    }
}
