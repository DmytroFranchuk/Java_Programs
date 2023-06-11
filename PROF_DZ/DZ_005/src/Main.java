import java.sql.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Напишите программу, которая принимает на вход строку и выводит все перестановки символов этой строки
        String input = "abc";
        char[] chars = input.toCharArray();
        List<String> permutations = Permutations.generatePermutations(input);
        System.out.println(permutations);

        // Напишите программу, которая принимает на вход две строки и проверяет,
        // являются ли они анаграммами (т.е. содержат ли они одинаковые символы в разном порядке).
        String str1 = "abcdef";
        String str2 = "facdeb";
        if (AnagramChecker.areAnagrams(str1, str2)) {
            System.out.println(str1 + " и " + str2 + " являются анаграммами");
        } else {
            System.out.println(str1 + " и " + str2 + " являются анаграммами");
        }

        //  Напишите параметризованный класс "Pair", который принимает два различных типа данных
        //  в качестве параметров (например, "Pair"). Реализуйте методы для получения и установки значений
        //  каждого из элементов пары.
        Pair<String, Integer> pair1 = new Pair<>("Monika", 19);
        System.out.println(pair1.toString());
        Pair<Boolean, Double> pair2 = new Pair<>(true, 3.14);
        System.out.println(pair2.toString());
        Pair<Pair, Pair> pair3 = new Pair<>(pair1, pair2);
        System.out.println(pair3.toString());
        Pair<Integer, Pair> pair4 = new Pair<>(1, pair3);
        pair4.setKey(1);
        pair4.setValue(pair4); // зацикливание
        System.out.println(pair4.toString());
        System.out.println(pair1.getKey() + " и ей " + pair1.getValue() + " лет");

        // Реализуйте параметризованный метод "swap", который принимает массив элементов
        // и два индекса внутри массива. Метод должен поменять местами элементы по указанным
        // индексам.
        Integer[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(ArrayUtils.swap(numbers, 0, 1)));

        String[] words = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        System.out.println(Arrays.toString(ArrayUtils.swap(words, 1, 0)));

        Pair<Integer, String>[] pairs = new Pair[]{
                new Pair<>(1, "Dima"),
                new Pair<>(2, "Lena"),
                new Pair<>(3, "Karina")
        };

        // Создайте параметризованный класс "Stack", представляющий стек элементов.
        // Реализуйте методы "push", "pop" и "isEmpty" для добавления элемента в стек,
        // извлечения элемента из стека и проверки, пуст ли стек соответственно
        Stack<Integer> stack = new Stack<>();
        Stack<String> stack1 = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack1.push("Dima");
        stack1.push("Lena");
        stack1.push("Karina");
        System.out.println(stack);
        System.out.println(stack1);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack1.isEmpty());

        // Напишите параметризованный метод "printArray", который принимает массив элементов
        // и выводит их на консоль. Метод должен работать с любыми типами данных.
        ArrayUtils.printArray(numbers);
        ArrayUtils.printArray(words);
        ArrayUtils.printArray(pairs);
        System.out.println(pairs[1].toString());

        // Создайте параметризованный класс "LinkedList", представляющий связный список элементов.
        // Реализуйте методы "add", "remove" и "contains" для добавления элемента в список,
        // удаления элемента из списка и проверки, содержится ли элемент в списке соответственно.
        LinkedListEx<Integer> listInt = new LinkedListEx<>();
        listInt.add(7);
        listInt.add(7);
        listInt.add(7);
        listInt.add(7);
        listInt.add(7);
        listInt.add(5);
        listInt.add(2);
        listInt.add(9);
        listInt.add(6);
        listInt.add(3);
        listInt.add(3);



//        listInt.remove(5);
        listInt.remove(7);

        listInt.remove(3);
        listInt.remove(3);
//        listInt.remove(2);
        listInt.removeAll(7);
        System.out.println(listInt.getSize());
        listInt.display();
        LinkedListEx<String> listStr = new LinkedListEx<>();
        listStr.add("Lena");
        listStr.add("Karina");
        listStr.add("Valentina");
        System.out.println(listStr.contains("Lena"));
        listStr.remove("Lena");
        listStr.display();
        System.out.println(listStr.contains("Lena"));
    }
}
