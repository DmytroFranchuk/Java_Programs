package org.ls_2023_11_28_lambda.primer_lambda;

public class CheckIfHopper implements CheckTrait {
    @Override
    public boolean test(Animal a) {
        return a.CanHop();
    }
}
