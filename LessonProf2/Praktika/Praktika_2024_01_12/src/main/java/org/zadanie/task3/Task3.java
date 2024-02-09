package org.zadanie.task3;

import org.zadanie.task3.logger.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// Вам требуется, чтобы на всю программу был лишь один логер.
// При этом логирование нужно производить в разных классах.
// Создайте singleton-логгер и используйте его в нескольких классах программы.
// Каждый класс работает в отдельном потоке.
public class Task3 {
    public static void main(String[] args) {

        List<Thread> threads = Arrays.stream(new Object[4])
                .map(e -> new Thread(
                        () -> {
                            long timeOut = ThreadLocalRandom.current().nextLong(500L);
                            int choise = ThreadLocalRandom.current().nextInt(4);
                            try {
                                for (int i = 0; i < 5; i++) {
                                    Thread.sleep(timeOut);
                                    switch (choise) {
                                        case 0 -> Logger.INSTANCE.debug("Логирует: " + Thread.currentThread().getId());
                                        case 1 -> Logger.INSTANCE.info("Логирует: " + Thread.currentThread().getId());
                                        case 2 -> Logger.INSTANCE.warning("Логирует: " + Thread.currentThread().getId());
                                        default -> Logger.INSTANCE.error("Логирует: " + Thread.currentThread().getId());
                                    }
                                }
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                ))
                .peek(Thread::start)
                .toList();
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });




    }
}
