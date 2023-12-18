package org.example.task2;

public class Main {
    public static void main(String[] args) {

        ComplexNumber complex1 = new ComplexNumber(3.0, 4.0);
        ComplexNumber complex2 = new ComplexNumber(5.0, -2.0);

        System.out.println("Первое комплексное число: [" + complex1 + "]");
        System.out.println("Второе комплексное число: [" + complex2 + "]");

        System.out.println("Действительная часть первого числа: " + complex1.getRealPart());
        System.out.println("Мнимая часть первого числа: " + complex1.getImaginaryPart());
    }
}
