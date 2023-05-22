import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayProcessor arrayProcessor = new ArrayProcessor();
        int[] arr = arrayProcessor.createArr(11,100);
        System.out.println("Исходный массив: " + Arrays.toString(arr));
//        System.out.println("Новый массив: " + Arrays.toString(arrayProcessor.methodOne(arr)));
//        System.out.println("Сумма всех элементов: " + arrayProcessor.sumAllElements(arr));
//        System.out.println("Наибольшее значение в массиве: " + arrayProcessor.maxValueArr(arr));
//        System.out.println("Количество четных чисел в массиве: " + arrayProcessor.countEvenNumber(arr));
//        int checkValue = 33;
//        System.out.println(arrayProcessor.checkValue(checkValue, arr) + checkValue);
//        System.out.println("Сортировка массива по возрастанию: ");
//        System.out.println(Arrays.toString(arrayProcessor.sortArr(arr)));
//        System.out.println("Первое вхождение числа: " + checkValue + " в массиве под индексом: " + arrayProcessor.findIndex(checkValue, arr));
//        System.out.println("Среднее значение всех элементов в массиве: " + arrayProcessor.findAverage(arr));
//        int[] arr1 = arrayProcessor.sortArr(arr);
//        int [] arr1 = {0, 1, 2, 3, 4, 7, 2, 7, 4, 3, 2, 1, 0};
//        System.out.println("Прямой порядок:   " + Arrays.toString(arr1));
//        System.out.println("Обратный порядок: " + Arrays.toString(arrayProcessor.reverseOrder(arr)));
//        if(arrayProcessor.checkIsPalindrome(arr1)) {
//            System.out.println("Палиндром");
//        } else {
//            System.out.println("Не палиндром");
//        }
        int[] arr1 = {1, 2, 3, 12, 11, 10, 11, 7, 8, 30, 12}; //  12, 11, 10, 11, 12 или -2 -1 0 1 2
        int[] arr11 = {-3, -2,-1, 0, 1, 2};
        int[] arr2 = {};
        System.out.println(arrayProcessor.solve(arr1));
        System.out.println(arrayProcessor.findSumLargest(arr1));
        System.out.println(arrayProcessor.findSumLargest_GPT(arr1));
        System.out.println(arrayProcessor.solve(arr2));
        System.out.println(arrayProcessor.findSumLargest(arr2));
        System.out.println(arrayProcessor.findSumLargest_GPT(arr2));
        System.out.println(arrayProcessor.solve(arr11));
        System.out.println(arrayProcessor.findSumLargest(arr11));
        System.out.println(arrayProcessor.findSumLargest_GPT(arr11));

    }
}