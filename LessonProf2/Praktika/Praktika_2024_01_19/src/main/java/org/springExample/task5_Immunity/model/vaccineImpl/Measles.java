package org.springExample.task5_Immunity.model.vaccineImpl;

import org.springExample.task5_Immunity.model.interfaces.Vaccinations;
import org.springframework.stereotype.Component;

@Component
public class Measles implements Vaccinations {
    @Override
    public void printName() {
        System.out.println(Measles.class.getSimpleName() + " вакцина применена");
    }

    @Override
    public String toString() {
        return "Measles{}";
    }
}
