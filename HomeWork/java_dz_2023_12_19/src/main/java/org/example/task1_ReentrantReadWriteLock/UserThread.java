package org.example.task1_ReentrantReadWriteLock;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UserThread extends Thread {
    private Document document;
    private static AtomicInteger count = new AtomicInteger(-1);

    public UserThread(Document document) {
        this.document = document;
    }

    @Override
    public void run() {
        int localCount = count.incrementAndGet();
        List<String> lines = document.read();
        document.addLine("New line from UserThread: " + this.getId());
        document.addLine("New line from UserThread for delete: " + this.getId());
        document.editLine(localCount + 6, "Edited line from UserThread: " + this.getId());
        document.deleteLine(localCount + 12);
        System.out.println("UserThread: " + this.getId() + " performed actions.");
    }
}
