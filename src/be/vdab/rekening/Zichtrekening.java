package be.vdab.rekening;

public class Zichtrekening extends Rekening {
    private static int maxKrediet;
    public static final double INTREST_ZICHTREKENİNG = 0.25;

    public Zichtrekening(String rekeningNummer, int bedrag) {
        this(rekeningNummer, 0.0, bedrag);
    }


    public Zichtrekening(String rekeningNummer, double saldo, int bedrag) {
        super(rekeningNummer, saldo);
        setMaxKrediet(bedrag);
    }

    public static int getMaxKrediet() {
        return maxKrediet;
    }

    public void setMaxKrediet(int maxKrediet) {
        if (maxKrediet > 0) {
            this.maxKrediet = maxKrediet;
        } else {
            throw new IllegalArgumentException("maxKrediet wordt niet kleiner dan 0 zijn");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", " + maxKrediet;
    }

    @Override
    public void afhalen(double bedrag) {
        if (bedrag > 0.0) {
            var testSaldo = getSaldo() - bedrag + maxKrediet;
            if (testSaldo >= 0)
                super.afhalen(bedrag);
        }
    }

    @Override
    public double berekenIntrest() {
        if (getSaldo() > 0) {
            return getSaldo() * INTREST_ZICHTREKENİNG / 100;
        } else
            return 0.0;
    }

}
