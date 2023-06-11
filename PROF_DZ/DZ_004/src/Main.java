import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 10;                     // количество элементов в ArrayList
        int maxValue = 20;              // максимальное положительное значение
        int minValue = -20;             // максимальное отрицательное значение
        Random rd = new Random();
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayListEx1 arrayListEx1 = new ArrayListEx1();
        for (int i = 0; i < n; i++) {
            arrayList1.add(rd.nextInt(maxValue - minValue + 1) + minValue);
        }
        System.out.println(arrayList1);
        ArrayList<Integer> arrayList2 = new ArrayList<> (List.of(1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 1));

        System.out.println("Сумма всех элементов: " + arrayListEx1.sumAllElements(arrayList1));
        System.out.println("Наибольшее значение в массиве: " + arrayListEx1.maxValueArr(arrayList1));
        System.out.println("Удаление всех четных чисел из ArrayList: " + arrayListEx1.removingEvenNumbers(arrayList1));
        System.out.println("Количество положительных чисел в ArrayList: " + arrayListEx1.numPositiveElements(arrayList1));
        System.out.println("Содержит ли ArrayList число: " + arrayListEx1.checkValue(10, arrayList1));
        System.out.println("Сортировка: " + arrayListEx1.sortArrayList(arrayList1));
        System.out.println("Нахождения второго наименьшего числа: " + arrayListEx1.findSecondMinNumber(arrayList1));
        System.out.println(arrayListEx1.removingDuplicates(arrayList1, arrayList2));
    }
}
