package org.pr_2023_12_15;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Сначала все дети собирают опавшие с деревьев листья в большую кучу.
// Когда куча становится высотой 1 метра, дети наперегонки начинают прыгать в кучу листьев.
// Каждый прыжок ребёнка в кучу листьев уменьшает её размер на 10 см.
// Как только куча уменьшается до 30 см прыгать в неё становиться уже не так мягко и
// дети начинают собирать кучу снова. Смоделируйте ситуацию, используя атомарные классы.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        AtomicInteger heightOfHeap = new AtomicInteger();
        AtomicBoolean isGrabbing = new AtomicBoolean(true);
        List<Thread> threads = Arrays.stream(new int[5])
                .mapToObj(e -> new Thread(() -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        boolean isGrab = isGrabbing.get();
                        int delta = ThreadLocalRandom.current().nextInt(30)*(isGrab ? 1 : -1);
                        int newHeigh = 0;
                        if (!isGrab && heightOfHeap.get() + delta <= 0) {
                            heightOfHeap.set(0);
                        } else {
                            newHeigh = heightOfHeap.addAndGet(delta);
                        }
                        System.out.printf("Ребенок %d %s %d сантиметров теперь куча %d сантиметров %n",
                                Thread.currentThread().getId(), isGrab ? "Смял" : "Смял", Math.abs(delta),
                                heightOfHeap.get());
                        if (heightOfHeap.get() <= 30) {
                            isGrabbing.set(true);
                        } else if (heightOfHeap.get() > 100) {
                            isGrabbing.set(false);
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }))
                .peek(Thread::start)
                .toList();
        Thread.sleep(20_000);
        threads.forEach(Thread::interrupt);
    }
}
