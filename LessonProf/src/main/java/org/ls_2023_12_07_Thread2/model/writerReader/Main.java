package org.ls_2023_12_07_Thread2.model.writerReader;

import org.ls_2023_12_07_Thread2.model.writerReader.model.Reader;
import org.ls_2023_12_07_Thread2.model.writerReader.model.SharedResource;
import org.ls_2023_12_07_Thread2.model.writerReader.model.Writer;

/**
 * В этом примере {@link SharedResource} представляет общий ресурс, который читатели {@link Reader} могут только читать,
 * а писатели {@link Writer} могут как читать, так и записывать. Ресурс синхронизирован так, чтобы предотвратить
 * одновременное чтение и запись.
 */
public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        for (int i = 0; i < 10; i++) {
            Writer writer = new Writer(resource, i);
            writer.start();
        }
        for (int i = 0; i < 5; i++) {
            Reader reader = new Reader(resource);
            reader.start();
        }
    }
}

