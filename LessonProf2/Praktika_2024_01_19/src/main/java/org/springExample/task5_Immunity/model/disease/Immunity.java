package org.springExample.task5_Immunity.model.disease;


import org.springExample.task5_Immunity.model.interfaces.Vaccinations;

public class Immunity {
    private final Vaccinations vaccinations;


    public Immunity(Vaccinations vaccinations) {
        this.vaccinations = vaccinations;
    }

    public Vaccinations getVaccinations() {
        return vaccinations;
    }
}
