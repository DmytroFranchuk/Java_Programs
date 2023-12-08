package producer.consumer;

import producer.consumer.model.Buffer;
import producer.consumer.model.Consumer;
import producer.consumer.model.Producer;

/**
 * В этом примере {@link Buffer} представляет собой буфер для заданий,
 * которые создаются потоками-производителями {@link Producer} и
 * потребляются потоками-потребителями {@link Consumer}. Методы {@link Buffer#produce} и {@link Buffer#consume()}
 * синхронизированы, чтобы обеспечить безопасность работы с общим ресурсом.
 * При достижении максимального размера буфера (MAX_SIZE), потоки-производители ждут, пока потребители заберут задание,
 * и наоборот.
 */
public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
