package hu.petrik.szuperhosprojekt;

import java.text.MessageFormat;

public abstract class Bosszuallo implements Szuperhos {
    private double szuperero;
    private boolean vanEGyengesege;

    public Bosszuallo(double szuperero, boolean vanEGyengesege) {
        this.szuperero = szuperero;
        this.vanEGyengesege = vanEGyengesege;
    }

    public double getSzuperero() {
        return szuperero;
    }

    public void setSzuperero(double szuperero) {
        this.szuperero = szuperero;
    }

    public boolean isVanEGyengesege() {
        return vanEGyengesege;
    }

    public void setVanEGyengesege(boolean vanEGyengesege) {
        this.vanEGyengesege = vanEGyengesege;
    }

    @Override
    public double mekkoraAzEreje() {
        return szuperero;
    }

    @Override
    public boolean legyoziE(Szuperhos ellenfel) {
        if (ellenfel instanceof Bosszuallo) {
            Bosszuallo bosszualloEllenfel = (Bosszuallo) ellenfel;
            return bosszualloEllenfel.vanEGyengesege && this.szuperero > bosszualloEllenfel.szuperero;
        } else if (ellenfel instanceof Batman) {
            return this.szuperero >= ((Batman) ellenfel).mekkoraAzEreje() * 2;
        }
        return false;
    }

    public abstract boolean megmentiAVilagot();

    @Override
    public String toString() {
        return MessageFormat.format("Szupererő: {0,number,#.##}; {1}",
                szuperero,
                vanEGyengesege ? "van gyengesége" : "nincs gyengesége");
    }
}
