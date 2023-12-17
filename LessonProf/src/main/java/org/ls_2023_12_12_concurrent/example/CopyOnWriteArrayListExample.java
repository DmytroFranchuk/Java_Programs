package org.ls_2023_12_12_concurrent.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * В примере формируется набор данных lst, на основании которого создается потокобезопасная
 * коллекция list типа CopyOnWriteArrayList. Данные коллекции list с помощью итератора выводятся
 * в консоль два раза.
 * В первом цикле в коллекцию вносятся изменения, во втором цикле данные выводятся без изменений.
 */

public class CopyOnWriteArrayListExample {
    List<String> list;

    public CopyOnWriteArrayListExample() {
        List<String> lst = new ArrayList<String>();
        lst.add("Java");
        lst.add("J2EE");
        lst.add("J2SE");
        lst.add("Collection");
        lst.add("Concurrent");

        list = new CopyOnWriteArrayList<>(lst);

        System.out.println("ЦИКЛ с изменением");
        printCollection(true);
        System.out.println("\nЦИКЛ без изменения");
        printCollection(false);

    }

    private void printCollection(boolean change) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (change) {
                if (element.equals("Collection")) {
                    list.add("Новая строка");
                    list.remove(element);
                }
            }
            System.out.printf("  %s %n", element);
        }
    }

    public static void main(String[] args) {
        new CopyOnWriteArrayListExample();
        System.exit(0);
    }
}
