package generator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Для тестирования генератора последовательности SequenceGenerator используем класс Sequence,
 * реализующий интерфейс Runnable. В качестве параметра конструктор класса получает идентификатор потока id,
 * размер последовательности count и генератор последовательности sg. В методе run в цикле с незначительными
 * задержками формируется последовательность чисел sequence. После завершения цикла значения последовательности
 * «выводятся» в консоль методом printSequence.
 */
public class Sequence implements Runnable {
    private final int id;
    private final Thread thread;
    private final int count;
    private final SequenceGenerator sg;
    private final List<BigInteger> sequence = new ArrayList<>();
    private boolean printed = false;

    public Sequence(final int id, final int count, SequenceGenerator sg) {
        this.count = count;
        this.id = id;
        this.sg = sg;
        this.thread = new Thread(this);

        System.out.println("Создан поток " + id);
        thread.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < count; i++) {
                sequence.add(sg.next());
                Thread.sleep(ThreadLocalRandom.current().nextLong(30L, 90L));
            }
        } catch (InterruptedException e) {
            System.out.println("Поток " + id + " прерван");
        }
        System.out.println("Поток " + id + " завершён");
        printSequence();
    }

    public void printSequence() {
        if (printed) return;
        StringBuilder tmp = new StringBuilder("[");
        for (int i = 0; i < sequence.size(); i++) {
            if (i > 0) tmp.append(", ");
            StringBuilder nb = new StringBuilder(String.valueOf(sequence.get(i)));
            while (nb.length() < 9) nb.insert(0, " ");
            tmp.append(nb);
        }
        tmp.append("]");
        System.out.println("Последовательность потока " + id + " : " + tmp);
        printed = true;
    }

    public Thread getThread() {
        return thread;
    }
}