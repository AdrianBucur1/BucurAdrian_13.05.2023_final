package com.itfactory.claseDeObiecte;

import com.itfactory.exceptii.CantitateInsuficienta;

import java.util.Objects;

public class Produs {
    private double pret;
    private double cantitate;
    private String denumire;

    public Produs(String denumire, double pret, double cantitate) {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public double getCantitate() {
        return cantitate;
    }

    public void setCantitate(double cantitate) throws CantitateInsuficienta {
        if (cantitate < 0) {
            throw new CantitateInsuficienta("Cantitatea introdusa este mai mare decat stocul magazinului, iar achizitia nu s-a putut realiza.");
        } else {
            this.cantitate = cantitate;
        }
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produs produs)) return false;
        return Double.compare(produs.getPret(), getPret()) == 0 && Double.compare(produs.getCantitate(), getCantitate()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPret(), getCantitate());
    }

    @Override
    public String toString() {
        return getDenumire() +
                "\n cantitate: " + getCantitate() + " buc." +
                " | pret: " + getPret() + " lei";
    }

}
