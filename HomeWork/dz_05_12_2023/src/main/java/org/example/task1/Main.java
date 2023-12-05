package org.example.task1;
//  1 Создайте класс Траншея. У траншеи есть целевая длина и текущая длина.
// Создайте класс Землекоп, объекты которого копают траншею (увеличивают текущую длину),
// пока не будет достигнута целевая длина. Каждый землекоп может прокопать 1 м траншеи,
// а затем он отдыхает 10 секунд. В программе создайте траншею и двух землекопов.
// Измерьте, за какое время траншею прокопает один землекоп и за какое время с такой же
// траншеей управятся двое.

public class Main {
    public static void main(String[] args) {
        int countDigger = 2;

        Digger[] diggers = new Digger[countDigger];
        Trench trench = new Trench(10, 0);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < countDigger; i++) {
            diggers[i] = new Digger(trench);
        }
        for (Digger digger : diggers) {
            try {
                digger.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Running time: " + (System.currentTimeMillis() - startTime) / 1000);
    }
}