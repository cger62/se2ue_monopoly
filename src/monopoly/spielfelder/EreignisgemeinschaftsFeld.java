package monopoly.spielfelder;


import monopoly.karten.EreignisgemeinschaftsKarte;
import java.util.*;

/**
 * 
 */
public class EreignisgemeinschaftsFeld implements Spielfelder{

    int feldnummer;
    private final String feldname;
    public EreignisgemeinschaftsKarte[] karten = {new EreignisgemeinschaftsKarte(50, "Schulgeld", true),
                                                  new EreignisgemeinschaftsKarte(20, "Geburtstag", false),
                                                  new EreignisgemeinschaftsKarte(80, "Krankenhaus", true),
                                                  new EreignisgemeinschaftsKarte(15, "Strafzettel", true),
                                                  new EreignisgemeinschaftsKarte(50, "Urlaubsgeld", false),
                                                  new EreignisgemeinschaftsKarte(100, "Versicherung", true),
                                                  new EreignisgemeinschaftsKarte(10, "Schönheitswettbewerb", false),
                                                  new EreignisgemeinschaftsKarte(50, "Wette", false),
                                                  new EreignisgemeinschaftsKarte(200, "Los", false),
                                                  new EreignisgemeinschaftsKarte(0, "Gefängnis", false),
                                                  new EreignisgemeinschaftsKarte(0, "Südbahnhof", false),
                                                  new EreignisgemeinschaftsKarte(0, "Opernplatz", false),
                                                  new EreignisgemeinschaftsKarte(0, "Schlossallee", false),
                                                  new EreignisgemeinschaftsKarte(0, "Seestraße", false),
                                                  new EreignisgemeinschaftsKarte(0, "3zurück", false),
                                                  new EreignisgemeinschaftsKarte(0, "3vor", false)};

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
         System.out.println(random);
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
