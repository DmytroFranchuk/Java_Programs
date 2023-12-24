package org.example.Task1_Task2;

import org.example.Task1_Task2.Bread.Bread;
import org.example.Task1_Task2.Bread.TypeBread;
import org.example.Task1_Task2.exceptions.PriceExceptions;

import java.util.ArrayList;
import java.util.List;

public class Task1CheckPrice {
    public static void main(String[] args) {
        List<Bread> breads = new ArrayList<>();
        breads.add(new Bread(TypeBread.WHITE_BREAD, 7.55));
        breads.add(new Bread(TypeBread.RYE_BREAD, 8.01));
        breads.stream().forEach(e-> {
                try {
                    e.isAvailablePrice();
                } catch (PriceExceptions ex) {
                    ex.printStackTrace();
                }
            });
    }
}
