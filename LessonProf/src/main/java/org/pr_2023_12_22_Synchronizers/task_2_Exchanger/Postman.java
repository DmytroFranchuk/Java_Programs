package org.pr_2023_12_22_Synchronizers.task_2_Exchanger;

import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ThreadLocalRandom;

public class Postman implements Runnable {
    private String name;
    private List<Letter> letters;
    private String from;
    private String to;
    private Exchanger<Letter> exchanger;


    public Postman(String name, List<Letter> letters, String from, String to, Exchanger<Letter> exchanger) {
        this.name = name;
        this.letters = letters;
        this.from = from;
        this.to = to;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        System.out.println("Почтальон " + name + " получил письма " + letters);
        System.out.println("Почтальон " + name + " идет из " + from + " в " + to);
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(3000));
            System.out.println("Почтальон " + name + " зашел в пункт D для обмена письмами");
            Letter giveLetter = letters.stream()
                    .filter(l -> !l.address().equals(to))
                    .findFirst()
                    .orElseThrow();
            Letter letter = exchanger.exchange(giveLetter);
            letters.remove(giveLetter);

            System.out.println("Почтальон " + name + " получил письмо " + letter);
            letters.add(letter);
            System.out.println("Почтальон " + name + " идет в пункт " + to + " несет письма " + letters);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
