package org.example;

import org.example.pole.chudes.Bascket;
import org.example.pole.chudes.GrandChild;
import org.example.pole.chudes.Grandparent;

//Напишите программу о бабушках/дедушках и внуках.
// Каждая бабушка и каждый дедушка периодически кладут несколько
// конфет в специальную корзинку. Внуки иногда заглядывают в корзинку,
// чтобы взять конфетку. Если в корзинке нет конфет, то внуки ждут, пока они появятся.
// В корзинку помещается не больше 10 конфет. Когда корзинка полная,
// то бабушки и дедушки не могут добавить в неё новые конфеты.
public class Main {
    public static void main(String[] args) {

        Bascket bascket = new Bascket();

        for (int i = 0; i < 10; i++) {
            Grandparent granny = new Grandparent(i,bascket);
            GrandChild child = new GrandChild(i,bascket);
            granny.start();
            child.start();
        }

    }
}