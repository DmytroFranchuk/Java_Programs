package de.dzJava.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class TestTask4 {

    public static void downloader(List<String> listUrlImage) {
        int count = 1;
        String nameFile;
        for (String urlImage : listUrlImage) {
            nameFile = "ImageDoodle-" + count++ + getFileExtension(urlImage);;
            downloadImage(urlImage, nameFile);
        }
    }

    private static void downloadImage(String imageUrl, String file) {
        try (InputStream in = new URL(imageUrl).openStream()) {
            Path path = Path.of(file);
            Files.copy(in, path, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image downloaded: " + file);
        } catch (IOException e) {
            System.out.println("Failed to download: " + imageUrl);
            e.printStackTrace();
        }
    }

    /**
     * getFileExtension - Получает расширение файла из URL
     *
     * @param url URL скачиваемого файла
     * @return Расширение файла или пустая строка, если расширение не найдено
     *
     */
    private static String getFileExtension(String url) {
        int lastDotIndex = url.lastIndexOf('.');
        return (lastDotIndex != -1) ? url.substring(lastDotIndex) : "";
    }
}
