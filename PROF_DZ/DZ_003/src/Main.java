import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 5, 5, 5, 4, 3, 2};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 16, 17, 18, 19, 20, 21, 22, 23, 24};
        System.out.println(ArrayList1.removingDuplicates(arr1));
        System.out.println(ArrayList1.reverseOrder(arr1));
        System.out.println(Set1.findIntersection(arr1, arr2));
        System.out.println(Set1.numUniqueElements(arr1));
    }
}
    // Задачи на ArrayList:
class ArrayList1 {
    // Удаление дубликатов: Напишите метод, который принимает массив int и возвращает ArrayList,
    // содержащий все уникальные элементы исходного массива, сохраняя их порядок.
    public static ArrayList<Integer> removingDuplicates(int[] arr) {
        ArrayList<Integer> uniqueElements = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!uniqueElements.contains(arr[i])) {
                uniqueElements.add(arr[i]);
            }
        }
        return uniqueElements;
    }
    // Обратный порядок: Напишите метод, который принимает массив int и возвращает ArrayList,
    // содержащий элементы исходного массива в обратном порядке.
    public static ArrayList<Integer> reverseOrder(int[] arr) {
        ArrayList<Integer> reverse = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            reverse.add(arr[arr.length - 1 - i]);
        }
        return reverse;
    }
}
    // Задачи на Set:
class Set1 {
    // Поиск пересечения: Напишите метод, который принимает два маcсива int и возвращает Set,
    // содержащий элементы, которые присутствуют и в первом, и во втором массивах.
    public static Set<Integer> findIntersection(int[] arr1, int[] arr2) {
        Set<Integer> intersectionSet = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            intersectionSet.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (intersectionSet.contains(arr2[i])) {
                intersection.add(arr2[i]);
            }
        }
        return intersection;
    }
    // Подсчет уникальных элементов: Напишите метод, который принимает массив int и возвращает
    // количество уникальных элементов в этом массиве, используя Set для хранения уникальных значений.
    public static int numUniqueElements(int[] arr) {
        int count = 0;
        Set<Integer> uniqueElements = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (uniqueElements.add(arr[i])) {
                count++;
            }
        }
        return count;
    }
}