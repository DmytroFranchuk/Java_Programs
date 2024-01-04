package org.example.task1_vttFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


// Есть архив VttFiles.zip (см. в группе дискорд) с набором vtt-файлов (субтитры к аудиодорожкам).
// Из субтитров нужно собрать единый файл txt для последующего создания документа со скриптами аудиодорожек.
// В txt поместите только тексты из субтитров. Все лишние записи (время, WEBVTT) должны быть удалены.

public class Vtt {
    public static void main(String[] args) throws IOException {
        String vttFolderPath = "vttFiles";
        String outputFilePath = "src\\main\\java\\org\\example\\vttFiles\\result.txt";

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(outputFilePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            List<Path> files = Files.list(Paths.get(vttFolderPath)).toList();
            boolean isSubtitle = false;
            for (Path file : files) {
                if (file.toString().endsWith(".vtt")) {
                    List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
                    for (String line : lines) {
                        if (!line.matches("^\\d{2}:\\d{2}:\\d{2}\\.\\d{3} --> \\d{2}:\\d{2}:\\d{2}\\.\\d{3}$")
                                && !line.startsWith("Narrator:") && !line.startsWith("Track")
                                && !line.startsWith("PART") && !line.endsWith("WEBVTT") && !line.startsWith("Speaker")
                                && !line.isBlank() && !line.startsWith("TRACK")) {
                            bufferedWriter.write(line);
                            bufferedWriter.newLine();
                        }
                    }
                }
            }
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Текст успешно сохранен в файл " + outputFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}