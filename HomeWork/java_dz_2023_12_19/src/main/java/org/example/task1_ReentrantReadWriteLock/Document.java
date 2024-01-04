package org.example.task1_ReentrantReadWriteLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Document {
    private List<String> documentLines;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public Document() {
        this.documentLines = new ArrayList<>();
        documentLines.add("Line 0");
        documentLines.add("Line 1");
        documentLines.add("Line 2");
        documentLines.add("Line 3");
        documentLines.add("Line 4");
        documentLines.add("Line 5");
        documentLines.add("Line 6");
        documentLines.add("Line 7");
        documentLines.add("Line 8");
        documentLines.add("Line 9");
        documentLines.add("Line 10");
        documentLines.add("Line 11");
    }

    public List<String> getDocumentLines() {
        return documentLines;
    }

    public List<String> read() {
        lock.readLock().lock();
        try {
            return new ArrayList<>(documentLines);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void addLine(String line) {
        lock.writeLock().lock();
        try {
            documentLines.add(line);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void editLine(int index, String newLine) {
        lock.writeLock().lock();
        try {
            if (index >= 0 && index < documentLines.size()) {
                documentLines.set(index, newLine);
            } else {
                System.out.println("Invalid index");
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void deleteLine(int index) {
        lock.writeLock().lock();
        try {
            if (index >= 0 && index < documentLines.size()) {
                documentLines.remove(index);
            } else {
                System.out.println("Invalid index.");
            }

        } finally {
            lock.writeLock().unlock();
        }
    }
}
