package org.example.Task1_Task2;

import org.example.Task1_Task2.Bread.Bread;
import org.example.Task1_Task2.Bread.TypeBread;
import org.example.Task1_Task2.exceptions.PriceExceptions;

import java.util.ArrayList;
import java.util.List;

public class Task2BuyFood {
    public static void main(String[] args) {
        List<Bread> breads = new ArrayList<>();
        breads.add(new Bread(TypeBread.WHITE_BREAD, 7.55));
        breads.add(new Bread(TypeBread.RYE_BREAD, 8.01));
        buyBread(breads);
    }

    public static void buyBread(List<Bread> breads){
        breads.stream().forEach(bread -> {
            try {
                bread.isAvailablePrice();
            } catch (PriceExceptions e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
//Напишите метод buyFood, внутри метода вызовите методы buyBread(используйте логику из предыдущей задачи),
//buyMeat, необходимо чтобы мы не падали, если при покупке хлеба выкинулась ошибка (используйте try/catch)