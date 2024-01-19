package org.springExample.task5_Immunity.model.vaccineImpl;

import org.springExample.task5_Immunity.model.interfaces.Vaccinations;
import org.springframework.stereotype.Component;

@Component
public class Flu implements Vaccinations {
    @Override
    public void printName() {
        System.out.println(Flu.class.getSimpleName() + " вакцина применена");
    }

    @Override
    public String toString() {
        return "Flu{}";
    }
}
