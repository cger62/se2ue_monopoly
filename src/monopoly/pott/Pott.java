package monopoly.pott;


import java.util.*;
import monopoly.bank.Bank;

/**
 * 
 */
public class Pott {

    /**
     * Default constructor
     */
    public Pott() {
    }

    /**
     * 
     */
    private static int kontostand;


    /**
     * 
     */
    public void Pott() {
        kontostand=0;
    }

    /**
     * @param wert
     */
   public  static int auszahlen(int betrag) {
        // TODO implement here
        kontostand =- betrag;
        if(kontostand<0){
        kontostand = Bank.auszahlen(kontostand*(-1));
       
        return betrag;
        
        }
        else{
        return betrag;}
    }

    /**
     * @param einzahlung
     */
    public static void  einzahlen(int einzahlung) {
        kontostand =+ einzahlung;
    }
    /**
     * @return
     */
    public static int getKontostand() {
        // TODO implement here
        return 0;
    }

}