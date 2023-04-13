package com.itfactory.claseDeObiecte;

import java.util.Objects;

public class Electronice extends Produs {

    private int termenGarantie;

    public Electronice(String denumire, double pret, double cantitate, int termenGarantie) {
        super(denumire, pret, cantitate);
        this.termenGarantie = termenGarantie;
    }

    public int getTermenGarantie() {
        return termenGarantie;
    }

    public void setTermenGarantie(int termenGarantie) {
        this.termenGarantie = termenGarantie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Electronice that)) return false;
        if (!super.equals(o)) return false;
        return getTermenGarantie() == that.getTermenGarantie();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTermenGarantie());
    }

    @Override
    public String toString() {
        return getDenumire() +
                "\n cantitate: " + getCantitate() + " buc." +
                " | pret: " + getPret() + " lei";
    }
}

