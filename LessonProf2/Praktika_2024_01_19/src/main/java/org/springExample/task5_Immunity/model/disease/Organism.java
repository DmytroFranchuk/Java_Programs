package org.springExample.task5_Immunity.model.disease;

import org.springExample.task5_Immunity.model.disease.Immunity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Organism {
    private Immunity rabiesImmunity;
    private Immunity fluImmunity;
    private Immunity coronaImmunity;
    private Immunity measlesImmunity;

    @Autowired
    public Organism(
            @Qualifier("immuntyRabies") Immunity rabiesImmunity,
            @Qualifier("immuntyFlu") Immunity fluImmunity,
            @Qualifier("immuntyCorona") Immunity coronaImmunity,
            @Qualifier("immuntyMeasles") Immunity measlesImmunity) {
        this.rabiesImmunity = rabiesImmunity;
        this.fluImmunity = fluImmunity;
        this.coronaImmunity = coronaImmunity;
        this.measlesImmunity = measlesImmunity;
    }

    @Override
    public String toString() {
        return "Organism{" +
                "rabiesImmunity=" + rabiesImmunity.getVaccinations() +
                ", fluImmunity=" + fluImmunity.getVaccinations() +
                ", coronaImmunity=" + coronaImmunity .getVaccinations()+
                ", measlesImmunity=" + measlesImmunity.getVaccinations() +
                '}';
    }
}
