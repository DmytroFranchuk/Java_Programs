package org.example.task1_ReentrantReadWriteLock;

import java.util.ArrayList;
import java.util.List;

// Разработайте программу, эмулирующую работу нескольких пользователей (потоков) с
// единым электронным документом. Все пользователи могут добавлять, редактировать и удалять
// записи (одна запись – одна строка). Каждый новый пользователь получает актуальную копию
// документа и работает с ней. После внесения изменений пользователь сохраняет изменения.
// Для оптимизации доступа к документу используйте ReentrantReadWriteLock.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Document shareDocument = new Document();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Thread userThread = new UserThread(shareDocument);
            threads.add(userThread);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        shareDocument.getDocumentLines().forEach(System.out::println);
    }
}
