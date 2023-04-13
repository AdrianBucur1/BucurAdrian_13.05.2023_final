package com.itfactory.claseDeObiecte;

import java.util.Objects;

public class IngrijirePersonala extends Produs {
    private boolean retur;


    public IngrijirePersonala(String denumire, double pret, double cantitate, boolean retur) {
        super(denumire, pret, cantitate);
        this.retur = retur;
    }

    public boolean isRetur() {
        return retur;
    }

    public void setRetur(boolean retur) {
        this.retur = retur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IngrijirePersonala that)) return false;
        if (!super.equals(o)) return false;
        return isRetur() == that.isRetur();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isRetur());
    }

    @Override
    public String toString() {
        return getDenumire() +
                "\n cantitate: " + getCantitate() + " buc." +
                " | pret: " + getPret() + " lei";
    }
}
