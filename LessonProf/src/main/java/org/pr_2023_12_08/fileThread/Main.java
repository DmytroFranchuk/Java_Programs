package org.pr_2023_12_08.fileThread;

import org.pr_2023_12_08.fileThread.log.Logger;
import org.pr_2023_12_08.fileThread.model.Reader;
import org.pr_2023_12_08.fileThread.model.Writer;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

// Есть 3 потока, которые периодически записывают данные о произошедших в системе
// событиях в лог (файл).
// События могут быть уровня info, warning и error. Другие два потока читают
// новую информацию в логе.
// Первый читающий поток ведёт статистику событий с помощью класса Statistics.
// Второй читающий поток анализирует записи на предмет содержания чувствительной
// информации (пароли, email’ы) с помощью класса Secure.
// Ещё в одном потоке работает экземпляр класса Signalization, который принимает данные
// от Statistics и Secure.
// Если в собранной статистике доля событий типа error в системе становится больше
// заданного процента (например, 20%),  то Signalization выдаёт предупреждение
// команде эксплуатации, что система находится в критическом состоянии.
public class Main {
    public static void main(String[] args) {
        Path path = Path.of("log.txt");
        Logger logger = new Logger(path);

        List<Reader> readers = Arrays.stream(new int[3]).
                mapToObj(e -> new Reader(logger)).toList();
//        List<Thread> readerThreads = readers.stream()


    }
}
