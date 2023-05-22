public class ArrayManager {
    private int[] array = new int[10];
    private int size = 0;

    // Вставка элемента в конец массива
    public void insert(int value) {
        if (size >= 10) {
            System.out.println("Массив заполнен, вставка невозможна");
            return;
        }
        array[size] = value;
        size++;
    }

    // Удаление элемента из массива
    public void delete(int value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Элемент не найден, удаление невозможно");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    // Сортировка массива методом пузырька
    public void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Поиск элемента в массиве
    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // Вывод массива в строку
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
