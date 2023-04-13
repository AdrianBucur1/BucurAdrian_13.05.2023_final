package com.itfactory.claseDeObiecte;

import java.time.LocalDate;
import java.util.Objects;

public class Alimente extends Produs {
    private LocalDate dataValabilitate;

    public Alimente(String denumire, double pret, double cantitate, LocalDate dataValabilitate) {
        super(denumire, pret, cantitate);
        this.dataValabilitate = dataValabilitate;
    }

    public LocalDate getDataValabilitate() {
        return dataValabilitate;
    }

    public void setDataValabilitate(LocalDate dataValabilitate) {
        this.dataValabilitate = dataValabilitate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alimente alimente)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getDataValabilitate(), alimente.getDataValabilitate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDataValabilitate());
    }

    @Override
    public String toString() {
        return getDenumire() +
                "\n cantitate: " + getCantitate() + " buc." +
                " | pret: " + getPret() + " lei";
    }
}

