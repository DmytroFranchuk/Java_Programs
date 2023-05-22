import java.util.Random;

public class ArrayProcessor {
    private int arr[];
    private int maxValue;
    private int count;
    private String str;

    public int [] createArr(int lengthArr, int maxValue) {
        arr = new int[lengthArr];
        Random random = new Random();
        for (int i = 0; i < lengthArr; i++) {
            arr[i] = random.nextInt(maxValue);
        }
        random = null;
        return arr;
    }

    public int [] methodOne(int [] arr) {
        /****************************************************************
         * 1 2 6 5 9 8 4 7    --> [1+7, 2+4, 6+8, 5+9]
         * 1 2 6 5 11 9 8 4 7 --> [1+7, 2+4, 6+8, 5+9, 11]
         ****************************************************************/
        int [] arr1 = arr.length % 2 == 0 ? new int[arr.length / 2] : new int[arr.length / 2 + 1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (i == arr1.length-1) & (arr.length % 2 != 0) ? arr[i] : arr[i] + arr[(arr.length - 1) - i];
        }
        return arr1;
    }

    // Домашнее задание

    // Найти сумму всех элементов в массиве
    public int sumAllElements(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }
    // Найти наибольшее значение в массиве
    public int maxValueArr(int[] arr) {
        maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue)
                maxValue = arr[i];
        }
        return maxValue;
    }
    // Посчитать количество четных чисел в массиве
    public int countEvenNumber(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) count++;
        }
        return count;
    }
    // Проверить, содержит ли массив заданное значение
    public String checkValue(int checkValue, int[] arr) {
        str = "Массив не содержит значение: ";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == checkValue) str = "Массив содержит значение: ";
        }
        return str;
    }
    // Отсортировать массив по возрастанию
    public int [] sortArr(int[] arr) {
//        int max;
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }
        for (int x = arr1.length-1; x > 1; x--) {
            for (int i = 0; i < arr1.length-1; i++) {
                if (arr1[i] > arr1[i+1]) {
                    arr1[i] = arr1[i] + arr1[i+1] - (arr1[i+1] = arr1[i]);
//                    ************************* Обмен местами соседних элементов в массиве через переменную
//                    max = arr[i];
//                    arr[i] = arr[i+1];
//                    arr[i+1] = max;
//                    ************************* Обмен местами соседних элементов в массиве через операцию XOR
//                    arr[i] ^= arr[i + 1];
//                    arr[i+1] ^= arr[i];
//                    arr[i] ^= arr[i + 1];
//                    *************************
                }
            }
        }
        return arr1;
    }
    // Найти индекс первого вхождения заданного значения в массиве
    public int findIndex(int checkValue, int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == checkValue)
                return i;
        }
        return -1;
    }
    // Найти среднее значение всех элементов в массиве
    public double findAverage(int[] arr){
        return (double) sumAllElements(arr) / arr.length;
    }

    // Поменять порядок элементов массива на обратный
    public int[] reverseOrder(int[] arr) {
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[arr.length - 1 - i];
        }
        return arr1;
    }

    // Проверить, является ли массив палиндромом (элементы читаются одинаково с начала и с конца)
    public boolean checkIsPalindrome(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
            if(arr[i] != arr[j]) {
                return false;
            }
        }
        return true;
    }
//    public boolean checkIsPalindrome(int[] arr) {
//        int left = 0;
//        int right = arr.length - 1;
//        while (left < right) {
//            if (arr[left] != arr[right]) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }

//    public boolean checkIsPalindrome(int[] arr) {
//        boolean pal = false;
//        String str, str1;
//        str = "";
//        str1 = "";
//        for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
//            str += arr[i];
//            str1 += arr[j];
//        }
//        if(str.equals(str1)) {
//            pal = true;
//        }
//        return pal;
//    }


    // Найти наибольшую сумму подряд идущих элементов в массиве. Уточнение один элемент считается максимальным если он больше последовательности
    public int solve(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int maxSum = arr[0];
        int curSum = arr[0];
        for (int i = 1; i < arr.length ; i++) {
            if(arr[i-1]+1 == arr[i] || arr[i-1]-1 == arr[i]) { // Добавил || arr[i-1]-1 == arr[i])
                // правильно обрабатываются все возможные последовательности с разницей не больше 1, включая убывающие последовательности.
                curSum += arr[i];
            } else {
                if(curSum > maxSum) {
                    maxSum = curSum;
                }
                curSum = arr[i];
            }
            if  (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    // Найти наибольшую сумму подряд идущих элементов в массиве. Мой вариант без отрицательных чисел
    public int findSumLargest(int[] arr) {
        if (arr.length == 0) { // Чтобы правильно отрабатывал на пустом массиве
            return 0;
        }
        int curSum = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1]+1 == arr[i] || arr[i-1]-1 == arr[i]) {
                // Если предыдущий элемент отличается от следующего элемента на 1
                curSum += arr[i];
            } else {
                curSum = arr[i];
            }
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    // Вариант GPT, с учетом отрицательных чисел
    public int findSumLargest_GPT(int[] arr) {
        if (arr.length == 0) { // Чтобы правильно отрабатывал на пустом массиве
            return 0;
        }
        int maxSum = 0;  // Начальное значение максимальной суммы
        int curSum = 0;  // Текущая сумма
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && Math.abs(arr[i] - arr[i - 1]) > 1) {
                // Если разница между текущим и предыдущим элементом больше 1, сбрасываем текущую сумму
                curSum = 0;
            }
            // Добавляем текущий элемент к текущей сумме
            curSum += arr[i];
            // Обновляем максимальную сумму, если текущая сумма стала больше
            //maxSum = Math.max(maxSum, curSum);
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

}
