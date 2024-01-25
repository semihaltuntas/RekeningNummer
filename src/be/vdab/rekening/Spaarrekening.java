package be.vdab.rekening;

public class Spaarrekening extends Rekening{
    private static  double intrest;

    public Spaarrekening(String reknr, double intrest) {
        this(reknr, intrest, 0.0);
    }

    public Spaarrekening(String reknr, double intrest, double saldo) {
        super(reknr, saldo);
        setIntrest(intrest);
    }

    public static double getIntrest() {
        return intrest;
    }

    public final void setIntrest(double intrestInput) {
        if (intrestInput > 0){
            intrest = intrestInput;
        }else{
            throw new IllegalArgumentException("intrest wordt niet kleiner dan 0 zijn");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", " + intrest;
    }

    @Override
    public void afhalen(double bedrag){
        if (bedrag > 0.0){
            var testSaldo = getSaldo()-bedrag;
            if (testSaldo >= 0){
                super.afhalen(bedrag);
            }
        }
    }

    @Override
    public double berekenIntrest() {
        return getSaldo() * intrest / 100;
    }
}
