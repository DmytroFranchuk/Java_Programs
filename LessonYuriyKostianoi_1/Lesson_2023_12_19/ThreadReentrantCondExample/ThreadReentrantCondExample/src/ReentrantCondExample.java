import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * В примере описывается торговый склад, в который производитель завозит товар из списка GOODS.
 * Товар регистрируется в коллекции goods. Потребитель забирает товар со склада.
 * В конструкторе примера создаются торговый склад store и два потока: producer, consumer.
 * Метод printMessage выводит сообщения потоков в консоль.
 * <p>
 * Сообщения в консоли показывают, что сначала идет наполнение склада до 3-х единиц товара поскольку время задержки
 * Producer (2000 мс) значительно меньше времени задержки Consumer (8000 мс). При полном наполнении склада Producer
 * останавливается в ожидании освобождения склада. Как только со склада забирается товар, т.е. освобождается место,
 * сразу же производитель завозит новый товар и снова переходит в режим ожидания. Таким образом, видим, что блокировка
 * с условием работает точно так, как ей предписано документацией.
 */
public class ReentrantCondExample {
    Store store;
    SimpleDateFormat sdf;
    final String[] GOODS = {"Молоко", "Кефир", "Ряженка", "Кофе", "Чай"};
    List<String> goods = new ArrayList<>();

    public ReentrantCondExample() {
        store = new Store();
        sdf = new SimpleDateFormat("HH:mm:ss  ");

        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());
        producer.start();
        consumer.start();

        while (producer.isAlive() || consumer.isAlive()) {
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nЗавершение работы примера");
        System.exit(0);

    }

    //-----------------------------------------------------
    void printMessage(final String msg) {
        if (msg != null) {
            String text = sdf.format(new Date()) + msg;
            System.out.println(text);
        } else
            System.out.println("\tТоваров на складе:"
                    + goods.size());
    }

    //-----------------------------------------------------
    public static void main(String[] args) {
        new ReentrantCondExample();
    }

    // Производитель

    /**
     * Производитель представлен внутренним классом Producer. Время задержки в методе run класса определяет возможный
     * интервал доставки товара. Потребитель представлен классом Consumer. Время задержки в методе run класса определяет
     * возможный интервал реализации товара. Производитель завозит товар чаще (время задержки меньше), чем потребитель
     * забирает товар (время задержки больше). На складе всего 3 места для товара. Таким образом, работу производителя
     * необходимо притормаживать. Эту функцию выполняет блокировка lock с условием cond в классе Store.
     */
    class Producer implements Runnable {
        public void run() {
            for (String good : GOODS) {
                store.put(good);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //-----------------------------------------------------
// Потребитель
    class Consumer implements Runnable {
        public void run() {
            for (int i = 0; i < GOODS.length; i++) {
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                store.get();
            }
        }
    }

    // Склад с товаром

    /**
     * Класс Store включает метод получения товара put и метод выдачи товара get. Шаблон выполнения операций обоих методов
     * идентичен: сначала метод получает блокировку, чтобы другой поток не вошел в данный метод; после этого выполняется
     * проверка условий. Если условия не соблюдаются, то поток переводится в стадию ожидания методом cond.await().
     * Для второго потока условия должны быть соблюдены (такая бизнес-логика работы склада), и он должен выполнить свою
     * операцию. После этого второй поток «будит» первый, а сам завершает операцию и разблокирует метод. «Разбуженный»
     * первый поток вновь выполняет проверку условия, и далее действует согласно предписанному сценарию
     * (либо продолжение выполнения, либо переход в ожидание).
     */
    class Store {
        ReentrantLock lock;  // блокировка
        Condition cond;  // условие блокировки

        Store() {
            lock = new ReentrantLock();
            cond = lock.newCondition();
        }

        public void get() {
            lock.lock();
            try {
                // ожидание на пустом складе
                while (goods.size() < 1)
                    cond.await();

                printMessage("Реализация : " + goods.get(0));
                goods.remove(0);
                printMessage(null);
                // Сигнализация
                cond.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void put(final String good) {
            lock.lock();
            try {
                // ожидание освобождения места
                while (goods.size() >= 3)
                    cond.await();
                goods.add(good);

                printMessage("Доставка : " + good);
                printMessage(null);
                // Сигнализация
                cond.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}