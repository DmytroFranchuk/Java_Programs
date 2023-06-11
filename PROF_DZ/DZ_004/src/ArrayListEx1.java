import java.util.*;

public class ArrayListEx1 {
    // =================================================================================================================
    // Напишите метод для нахождения суммы всех элементов в ArrayList<Integer> =========================================
    public int sumAllElements(ArrayList<Integer> list) {
        int result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result += list.get(i);
        }
        return result;
    }
    //==================================================================================================================
    // Напишите метод для поиска наибольшего числа в ArrayList<Integer> ================================================
    public int maxValueArr(ArrayList<Integer> list) {
        int maxValue = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > maxValue) {
                maxValue = list.get(i);
            }
        }
        return maxValue;
    }
    //==================================================================================================================
    // Напишите метод для удаления всех четных чисел из ArrayList<Integer> =============================================
    public ArrayList<Integer> removingEvenNumbers(ArrayList<Integer> list) {
        ArrayList<Integer> list1 = new ArrayList<>(list);
        for (int i = list1.size() - 1; i >= 0; i--) {
            if (list1.get(i) % 2 == 0) {
                list1.remove(i);
            }
        }
        return list1;
    }
    //==================================================================================================================
    // Напишите метод для определения количества положительных чисел в ArrayList<Integer> ==============================
    public int numPositiveElements(ArrayList<Integer> list) {
        int result = 0;
        for (int num : list) {
            if (num >= 0) {
                result++;
            }
        }
        return result;
    }
    //==================================================================================================================
    // Напишите метод, который проверяет, содержит ли ArrayList<Integer> заданное число ================================
    public boolean checkValue(int checkValue, ArrayList<Integer> list) {
        for (int x : list) {
            if (checkValue == x) {
                return true;
            }
        }
        return false;
    }
    //==================================================================================================================
    // Напишите метод для сортировки ArrayList<Integer> в порядке возрастания ==========================================
    public ArrayList<Integer> sortArrayList(ArrayList<Integer> list) {
        ArrayList<Integer> sortArr = new ArrayList<>(list);
        //==============================================================================================================
        for (int i = 0; i < sortArr.size()-1; i++) {
            for (int j = i+1; j < sortArr.size() ; j++) {
                if (sortArr.get(j) < sortArr.get(i)) {
                    int temp = sortArr.get(i);
                    sortArr.set(i, sortArr.get(j));
                    sortArr.set(j, temp);
                }
            }
        }
        /*
        Способ 2 =======================================================================================================
        for (int i = 0; i < sortArr.size() - 1; i++) {
            for (int j = 1; j < sortArr.size() - i; j++) {
                if (sortArr.get(j) < sortArr.get(j-1)) {
                    int temp = sortArr.get(j);
                    sortArr.set(j, sortArr.get(j-1));
                    sortArr.set(j-1, temp);
                }
            }
        }
        Способ 3 =======================================================================================================
        for (int i = 0; i < sortArr.size() - 1; i++) {
            for (int j = 0; j < sortArr.size() - 1 - i; j++) {
                if (sortArr.get(j) > sortArr.get(j+1)) {
                    int temp = sortArr.get(j);
                    sortArr.set(j, sortArr.get(j+1));
                    sortArr.set(j+1, temp);
                }
            }
        }
        */
        return sortArr;
    }
    // Напишите метод для нахождения второго наименьшего числа в ArrayList<Integer>.
    public int findSecondMinNumber(ArrayList<Integer> list) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min1) {
                min2 = min1;
                min1 = list.get(i);
            } else if (list.get(i) < min2) {
                min2 = list.get(i);
            }
        }
        return min2;
    }
    // Напишите метод, который объединяет два ArrayList<Integer> в один, удаляя дубликаты элементов.
    public ArrayList<Integer> removingDuplicates(ArrayList<Integer> list, ArrayList<Integer> list1) {
        ArrayList<Integer> combinedList = new ArrayList<>();
        combinedList.addAll(list);
        combinedList.addAll(list1);
        for (int i = 0; i < combinedList.size(); i++) {
            Integer currentElement = combinedList.get(i);
            for (int j = i+1; j < combinedList.size(); j++) {
                if (currentElement.equals(combinedList.get(j))) {
                    combinedList.remove(j);
                    j--;
                }
            }
        }
        return combinedList;
    }


}
