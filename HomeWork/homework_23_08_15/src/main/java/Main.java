import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Task 1
        Lists lists = new Lists();
        lists.addElemToLists(1000000);

        // Task 2
        long before = System.currentTimeMillis();
//        lists.randomSelectionArrayList(10000);
        long after = System.currentTimeMillis();
        System.out.println("ArrayList: " + (after - before));

        before = System.currentTimeMillis();
//        lists.randomSelectionLinkedList(10000);
        after = System.currentTimeMillis();
        System.out.println("LinkedList: " + (after - before));

        //Task 3
        List<Integer> integerList = new ArrayList<>();
//        System.out.println("Среднее арифмитическое: " + lists.average(integerList));

        //Task 4
        List<Integer> integerList1 = List.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        System.out.println(lists.bubbleSort(integerList1));

        //Task 5
        List<String> products = List.of("milk", "cottage cheese", "milk", "sour cream", "milk", "cheese","milk");
        System.out.println(lists.removeDuplicates(products));
        System.out.println(lists.removeDuplicates2(products));
    }
}