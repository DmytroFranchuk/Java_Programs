package org.ls_2023_12_07_Thread2.model1_ConsumerProducer;

// Напишите программу о бабушках/дедушках и внуках.
// Каждая бабушка и каждый дедушка периодически кладут несколько конфет в специальную корзинку.
// Внуки иногда заглядывают в корзинку, чтобы взять конфетку.
// Если в корзинке нет конфет, то внуки ждут, пока они появятся.
// В корзинку помещается не больше 10 конфет.
// Когда корзинка полная, то бабушки и дедушки не могут добавить в неё новые конфеты.

public class Main {
    public static void main(String[] args) {
        System.out.println("Result task 1: ");
        Basket basket = new Basket();

        for (int i = 0; i < 10; i++) {
            Grandparent granny = new Grandparent(i, basket);
            GrandChild child = new GrandChild(i, basket);
            granny.start();
            child.start();
        }


    }
}
