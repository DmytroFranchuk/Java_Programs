package writer.reader;

import writer.reader.model.Reader;
import writer.reader.model.SharedResource;
import writer.reader.model.Writer;

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
