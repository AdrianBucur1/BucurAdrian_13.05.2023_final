package com.itfactory.claseDeObiecte;

import com.itfactory.exceptii.BugetInvalid;

import java.util.Objects;

public class Cumparator {

    double buget;

    public Cumparator(double bugetCumparator) {
        this.buget = bugetCumparator;
    }

    public double getBuget() {
        return buget;
    }

    public void setBuget(double buget) throws BugetInvalid {
        if (buget < 0) {
            throw new BugetInvalid("Fonduri insuficiente");
        }
        this.buget = buget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cumparator that)) return false;
        return Double.compare(that.getBuget(), getBuget()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBuget());
    }



}
