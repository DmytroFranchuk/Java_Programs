package org.lesson_Annotations.zadanie.task2;

import org.lesson_Annotations.zadanie.task2.color.Color;

// Создайте класс Color с полями red, green, blue и alpha (прозрачность), поля должны иметь геттеры и сеттеры,
// а также значения в диапазоне от 0 до 255. Создайте возможность клонирования цвета.
// Создайте класс ColorCache, в котором при создании будут храниться все цвета радуги и их названия.
// В ColorCache можно добавлять новые цвета, передавая новый цвет и его название явно или вызывая методы plusRed(),
// minusRed(), plusGreen(), minusGreen(), plusBlue(), minusBlue(), plusAlpha(), minusAlpha(). Эти метод принимают
// название оригинального цвета, который нужно изменить для получения нового, а также название результирующего цвета.
// Добавьте в ColorCache несколько цветов и выведите содержимое кэша на экран.
public class Task2 {
    public static void main(String[] args) {
        Color color1 = new Color(23, 34, 45, 56);
        Color clonedColor = color1.clone();
        System.out.println(clonedColor);
    }
}
