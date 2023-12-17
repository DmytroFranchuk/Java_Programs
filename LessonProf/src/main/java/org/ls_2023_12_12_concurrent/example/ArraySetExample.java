package org.ls_2023_12_12_concurrent.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * В примере формируется набор данных list, на основании которого создается потокобезопасный набор cowSet типа
 * CopyOnWriteArraySet. В качестве данных используется внутренний класс User. Данные коллекции cowSet с помощью
 * итератора выводятся в консоль два раза. В первом цикле в коллекцию вносятся изменения: изменяется имя одного
 * объекта и добавляется другой. Во втором цикле данные выводятся без изменений. Результаты работы примера ниже
 * после листинга.
 * <p>
 * В первом цикле в консоль выдены исходные данные несмотря на внесение изменений в набор.
 * Во втором цикле — измененный набор данных. Пример подтверждает, что итератор набора данных CopyOnWriteArraySet не
 * вызвал исключения ConcurrentModificationException при одновременном переборе и изменении значений.
 */

//@Data
public class ArraySetExample {
    List<User> list;
    CopyOnWriteArraySet<User> cowSet;

    public ArraySetExample() {
        list = new ArrayList<>();
        list.add(new User("Прохор "));
        list.add(new User("Георгий"));
        list.add(new User("Георгий"));
        list.add(new User("Михаил"));
        list.add(new User("Михаил"));

        cowSet = new CopyOnWriteArraySet<>(list);

        System.out.println("Цикл с изменением");

        Iterator<User> itr = cowSet.iterator();
        int cnt = 0;
        while (itr.hasNext()) {
            User user = itr.next();
            System.out.println("  " + user.name);
            if (++cnt == 2) {
                cowSet.add(new User("Павел"));
                user.name += " Иванович";
            }
        }

        System.out.println("\nЦикл без изменения");
        itr = cowSet.iterator();
        while (itr.hasNext()) {
            User user = itr.next();
            System.out.println("  " + user.name);
        }
    }

    static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main(String[] args) {
        // рекомендуется сначала завершить итерацию, а затем внести необходимые изменения в коллекцию
        new ArraySetExample();
    }
}