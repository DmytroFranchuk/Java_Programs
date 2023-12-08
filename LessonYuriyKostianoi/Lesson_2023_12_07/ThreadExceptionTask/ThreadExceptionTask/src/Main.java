class DataProcessor {
    private Object lock = new Object();

    public void processData() {
        try {
            synchronized (lock) {
                // Обработка данных
                System.out.println("Processing data...");

                // Имитация долгой обработки
                Thread.sleep(2000);

                System.out.println("Data processing complete.");
            }
        } catch (Exception e) { // TODO Обработайте IllegalMonitorStateException и InterruptedException отдельно.
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DataProcessor dataProcessor = new DataProcessor();

        // Создаем два потока для обработки данных
        Thread thread1 = new Thread(dataProcessor::processData);
        Thread thread2 = new Thread(dataProcessor::processData);

        // Запускаем потоки
        thread1.start();
        thread2.start();
    }
}
