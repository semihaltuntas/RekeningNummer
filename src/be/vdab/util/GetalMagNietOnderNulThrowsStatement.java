package be.vdab.util;

import java.util.Scanner;

public class GetalMagNietOnderNulThrowsStatement extends Exception {
    public GetalMagNietOnderNulThrowsStatement(String message) {
        super(message);
    }

    static class Invoer {
        public void geefGetal(int getal) throws GetalMagNietOnderNulThrowsStatement {
            if (getal < 0) {
                throw new GetalMagNietOnderNulThrowsStatement("Het getal moet" +
                        "groter zijn dan 0");
            }
        }
    }

    public static void main(String[] args) {
        try{
            var toetsenbord = new Scanner(System.in);
            new Invoer().geefGetal(toetsenbord.nextInt());
        }catch (GetalMagNietOnderNulThrowsStatement ex){
            System.out.println("Fout :"+ ex.getMessage());
        }
    }
}
