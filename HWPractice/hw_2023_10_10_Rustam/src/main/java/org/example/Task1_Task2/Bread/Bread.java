
package org.example.Task1_Task2.Bread;

import org.example.Task1_Task2.exceptions.PriceExceptions;

public final class Bread {
    private final TypeBread type;
    private final Double price;

    public Bread(TypeBread type, Double price) {
        this.type = type;
        this.price = price;
    }

    public void isAvailablePrice() throws PriceExceptions {
        if (price > 8){
            PriceExceptions ex = new PriceExceptions("хлеб " + this.type + " слишком дорой");
            throw ex;
        } else System.out.println("Цена за " + this.type + " доступная" );
    }
}
