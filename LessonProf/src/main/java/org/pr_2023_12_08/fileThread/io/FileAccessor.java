package org.pr_2023_12_08.fileThread.io;

import org.apache.commons.io.input.ReversedLinesFileReader;
import org.pr_2023_12_08.fileThread.exception.FileAccessorException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileAccessor {
    private Path path;

    public FileAccessor(Path path) {
        this.path = path;
    }

    private void verify(Path path) {
        if (path == null) throw new FileAccessorException("Path is null");
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new FileAccessorException("Can't not create " + path, e);
            }
        }
        if (Files.isRegularFile(path)) throw new FileAccessorException("Is not file");
        if (Files.isReadable(path)) throw new FileAccessorException("Can't read" + path);
        if (Files.isWritable(path)) throw new FileAccessorException("Can't write" + path);
    }

    public void writeAddEnd(String text) {
        try {
            Files.writeString(path, text, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new FileAccessorException("Can't write in" + path, e);
        }
    }

    public List<String> readLastLines(int lines) {
        if (lines <= 0) throw new FileAccessorException("Incorrect count of lines " + lines);
        try (ReversedLinesFileReader reader = ReversedLinesFileReader.builder()
                .setPath(path).setCharset(Charset.defaultCharset()).get()) {
            return reader.readLines(lines); // TODO отсортировать в обратном порядке при необходимости
        } catch (IOException e) {
            throw new FileAccessorException("Can't write in" + path, e);
        }
    }
}
