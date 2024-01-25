package be.vdab.main;
import be.vdab.util.ScaryExceptionTaken;
public class TestExceptionsTaken {


    public static void main(String[] args) {
        String test = "no";
        try{
            System.out.println("Start try");
            doRisky(test);
            System.out.println("end try");
        } catch (ScaryExceptionTaken ex){
            System.out.println(ex.getMessage()+ " scary exception");
        }
        finally {
            System.out.println("finally");
        }
        System.out.println("end of main");

    }

    static void doRisky(String test) throws ScaryExceptionTaken{
        System.out.println("start risky");
        if ("yes".equals(test)){
            throw new ScaryExceptionTaken("yes wrote here");
        }
        System.out.println("end risky");
    }
}
