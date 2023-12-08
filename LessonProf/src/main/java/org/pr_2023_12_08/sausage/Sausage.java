package org.pr_2023_12_08.sausage;

public class Sausage {
    private int length;

    public Sausage(int length) {
        this.length = length;
    }

    public synchronized int bite() {
        if (length <= 0) {
            System.out.println("Сосиска я закончилась меня уже нет !");
            return 0;
        }
        length --;
        System.out.println("Сосиска моя длина изменилась теперь моя длина: " + length);
        return 1;
    }
}
