import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * В примере используется внутренний класс LockClass для организации двух потоков.
 * Константы TIME_WAIT и TIME_SLEEP используются потоками для организации определенных задержек при выполнении.
 * Текстовая переменная resource используется в качестве общего ресурса, значение которого будет изменяться внутри потоков.
 * Метод printMessage выводит в консоль сообщения потоков с указанием времени.
 * В конструкторе примера создается блокировка lock типа ReentrantLock и два потока, которые будут использовать lock
 * для блокирования доступа к текстовому ресурсу. Сначала каждый поток пытается в течение определенного времени
 * (TIME_WAIT, мс) блокировать доступ к ресурсу resource с использованием метода tryLock.
 * Если блокировка получена, то текст строки resource изменяется. После этого в потоке выполняется некоторая задержка
 * по времени (TIME_SLEEP, мс) и поток завершает свою работу с освобождением блокировки методом unlock.
 * Если поток в течение времени TIME_WAIT не смог блокировать ресурс, то он переходит к стадии задержки и завершению работы.
 * Оперируя временем ожидания блокировки TIME_WAIT и временем задержки TIME_SLEEP можно дать возможность либо каждому
 * из потоков изменить значение resource, либо только одному.
 * <p>
 * В примере TIME_WAIT, равное 7 c, больше значения TIME_SLEEP (5 c). Поэтому оба потока получают доступ к ресурсу
 * и изменяют значение ресурса.
 * 
 */
public class ReentrantLockExample {
    private String resource = "Hello, World!";
    private final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss  ");

    private final Lock lock;

    private final int TIME_WAIT = 7000;
    private final int TIME_SLEEP = 5000;

    public ReentrantLockExample() {
        lock = new ReentrantLock();
        Thread thread1 = new Thread(new LockClass("first", "Первый поток"));
        Thread thread2 = new Thread(new LockClass("second", "Второй поток"));
        thread1.start();
        thread2.start();

        printMessage(null);

        while (thread1.isAlive() || thread2.isAlive()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nЗавершение работы примера");
        System.exit(0);
    }

    //-----------------------------------------------------
    void printMessage(final String msg) {
        String text = sdf.format(new Date());
        text += msg == null ? resource : msg;
        System.out.println(text);
    }

    //-----------------------------------------------------
    class LockClass implements Runnable {
        String name;
        String text;

        public LockClass(String name, String text) {
            this.name = name;
            this.text = text;
        }

        @Override
        public void run() {
            boolean locked = false;
            try {
                // Получение блокировки в течение TIME_WAIT
                locked = lock.tryLock(TIME_WAIT, TimeUnit.MILLISECONDS);
                if (locked) {
                    resource = text;
                    printMessage(null);
                }
                Thread.sleep(TIME_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Убираем блокировку
                String text = name + " : завершил работу";
                printMessage(text);
                if (locked) lock.unlock();
            }
        }
    }

    //-----------------------------------------------------
    public static void main(String[] args) {
        new ReentrantLockExample();
    }
}