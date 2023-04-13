package com.itfactory.claseDeObiecte;

import java.util.Objects;

public class Imbracaminte extends Produs {
    private int termenRetur;

    public Imbracaminte(String denumire, double pret, double cantitate, int termenRetur) {
        super(denumire, pret, cantitate);
        this.termenRetur = termenRetur;
    }

    public int getTermenRetur() {
        return termenRetur;
    }

    public void setTermenRetur(int termenRetur) {
        this.termenRetur = termenRetur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Imbracaminte that)) return false;
        if (!super.equals(o)) return false;
        return getTermenRetur() == that.getTermenRetur();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTermenRetur());
    }

    @Override
    public String toString() {
        return getDenumire() +
                "\n cantitate: " + getCantitate() + " buc." +
                " | pret: " + getPret() + " lei";
    }
}

