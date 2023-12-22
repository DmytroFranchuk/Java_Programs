package org.pr_2023_12_22_Synchronizers.task_2_Exchanger;

// Два почтальона из пунктов А и Б отправляются в соседние поселки В и Г
// доставить письма. Каждый из почтальонов должен доставить по письму в каждый из поселков.
// Чтобы не делать лишний круг, они встречаются в промежуточном поселке Д и обмениваются одним
// письмом. В результате этого каждому из почтальонов придется доставить письма только в один поселок.
// Все «шаги» почтальонов укажите выводом соответствующих сообщений в консоль.

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class task_2 {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<Letter> exchanger = new Exchanger<>();
        List<Letter> list1 = new ArrayList<>();
        list1.add(new Letter("B", "Rein"));
        list1.add(new Letter("Г", "Kain"));
        List<Letter> list2 = new ArrayList<>();
        list2.add(new Letter("B", "Avel"));
        list2.add(new Letter("Г", "Beiron"));
        Postman postman1 = new Postman("Pechkin", list1, "A", "B", exchanger);
        Postman postman2 = new Postman("Snegovik", list2, "Б", "Г", exchanger);
        new Thread(postman1).start();
        Thread.sleep(1000);
        new Thread(postman2).start();
    }
}
