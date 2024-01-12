package org.example.task1;
// Для класса Book с полями String name, double price, boolean isPresent
// реализовать методы equals(Object o), hashCode(), compareTo(Book another)

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Atom", 23.34, true);
        Book book2 = new Book("Baton", 29.23, true);
        Book book3 = new Book("Biatlon", 23.34, false);
        System.out.println(book1.equals(book3));
        System.out.println(book1.compareTo(book3));

        System.out.println(book2.equals(book3));
        System.out.println(book2.compareTo(book3));

        System.out.println(book1.equals(book2));
        System.out.println(book1.compareTo(book2));
    }
}