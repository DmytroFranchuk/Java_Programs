package org.pr_2023_12_08.fileThread.log;

import lombok.Getter;
import org.pr_2023_12_08.fileThread.exception.LoggerException;
import org.pr_2023_12_08.fileThread.io.FileAccessor;

import java.nio.file.Path;
import java.util.List;

public class Logger {
    private FileAccessor fileAccessor;
    private int countReader;
    private int countWriter;

    @Getter
    private int lieneCount;

    public Logger(Path path) {
        this.fileAccessor = new FileAccessor(path);
        this.countReader = 0;
        this.countWriter = 0;
        this.lieneCount = 0;
    }

    public synchronized void startReading() {
        while (countWriter > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new LoggerException("Прервано ожидание начала чтения", e);
            }
            countReader++;
        }
    }

    public List<String> readLastNLines(int nLines) {
        return fileAccessor.readLastLines(nLines);
    }

    public synchronized void endReading() {
        countReader--;
        notifyAll();
    }

    public synchronized void startWriting() {
        while (countReader > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new LoggerException("Прервано ожидание начала записи", e);
            }
            countWriter++;
        }
    }

    public void writeAtEnd(String text) {
        fileAccessor.writeAddEnd(text);
        lieneCount += text.lines().count();
    }

    public synchronized void endWriting() {
        countWriter--;
        notifyAll();
    }

}
