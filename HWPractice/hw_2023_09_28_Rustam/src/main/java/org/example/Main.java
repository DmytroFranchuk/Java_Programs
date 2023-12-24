package org.example;
// Дан список строк. С помощью Stream API найти самую длинную строку. Найдите самую короткую строку
// С помощью рандома сгенерируйте 100 чисел (от 0 до 50), в полученном списке отфильтруйте все, которые меньше 25,
// после увеличьте его значение на 10, после возведите в квадрат, и найдите первое число меньше 100, если такого нет,
// верните -1
// Создайте People(int age, String firstName, String lastName, double weight, int high). Создайте лист и заполните
// его 10 различными People
// создайте новый List, к которому примените фильтр возраст больше 18, рост меньше 180, и имя начинается на букву A
// создайте новый List фамилий, к каждому человеку примените фильтр возраст больше 30, фамилия начинается на букву A,
// длина имени больше 5
// Задано множество фамилий сотрудников. Разработать программу, которая отображает все фамилии, начинающиеся на букву J


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Task 1
        List<String> strings = Arrays.asList("Java", "Python", "JavaScript", "C", "Ruby", "Swift");
        Optional<String> longestString = strings.stream()
                .max(Comparator.comparingInt(String::length));
        Optional<String> shortestString = strings.stream()
                .min(Comparator.comparingInt(String::length));
        longestString.ifPresent(longest -> System.out.println("Самая длинная строка: " + longest));
        shortestString.ifPresent(shortest -> System.out.println("Самая короткая строка: " + shortest));

        // Task 2
        Random random = new Random();
        List<Integer> numbers = random.ints(100, 0, 51)
                .boxed()
                .toList();
        List<Integer> filteredNumbers = numbers.stream()
                .filter(num -> num < 25)
                .map(num -> num + 10)
                .map(num -> num * num)
                .toList();
        int result = filteredNumbers.stream()
                .filter(num -> num < 100)
                .findFirst()
                .orElse(-1);
        System.out.println("Первое число меньше 100: " + result);

        // Task 3
        List<Person> people = Arrays.asList(
                new Person("Alice", 25, 175),
                new Person("Bob", 20, 185),
                new Person("Andrew", 30, 170),
                new Person("Anna", 22, 178),
                new Person("Alex", 19, 182)
        );
        List<Person> filteredPeople = people.stream()
                .filter(person -> person.getAge() > 18)
                .filter(person -> person.getHeight() < 180)
                .filter(person -> person.getName().startsWith("A"))
                .toList();
        System.out.println("Люди, удовлетворяющие условиям:");
        filteredPeople.forEach(System.out::println);

        // Task 4
        List<Person1> peopleList = Arrays.asList(
                new Person1("Alice", "Adams", 35),
                new Person1("Bob", "Brown", 25),
                new Person1("Andrew", "Anderson", 40),
                new Person1("Anna", "Alvarez", 28),
                new Person1("Alexandra", "Andrews", 45)

        );
        List<String> filteredLastNames = peopleList.stream()
                .filter(person -> person.getAge() > 30)
                .filter(person -> person.getLastName().startsWith("A"))
                .filter(person -> person.getFirstName().length() > 5)
                .map(Person1::getLastName)
                .toList();
        System.out.println("Фамилии, удовлетворяющие условиям:");
        filteredLastNames.forEach(System.out::println);

        // Task 5
        Set<String> employeeLastNames = new HashSet<>();
        employeeLastNames.add("Johnson");
        employeeLastNames.add("Smith");
        employeeLastNames.add("Jones");
        employeeLastNames.add("Jackson");
        employeeLastNames.add("Williams");
        System.out.println("Фамилии сотрудников, начинающиеся на 'J':");
        employeeLastNames.stream()
                .filter(lastName -> lastName.startsWith("J"))
                .forEach(System.out::println);



        
    }
}