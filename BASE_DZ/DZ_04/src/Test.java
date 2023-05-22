public class Test {
    public static void main(String[] args) {
        ArrayManager arrayManager = new ArrayManager();
        arrayManager.insert(5);
        arrayManager.insert(98);
        arrayManager.insert(7);
        arrayManager.insert(1);
        arrayManager.insert(9);
        arrayManager.insert(29);
        arrayManager.insert(56);
        arrayManager.insert(23);
        arrayManager.insert(73);
        arrayManager.insert(41);

        System.out.println("Массив до сортировки: " + arrayManager.toString());

        arrayManager.bubbleSort();

        System.out.println("Массив после сортировки: " + arrayManager.toString());

        int index = arrayManager.find(7);
        if (index == -1) {
            System.out.println("Элемент не найден");
        } else {
            System.out.println("Элемент найден на позиции: " + index);
        }

        arrayManager.delete(3);

        System.out.println("Массив после удаления элемента: " + arrayManager.toString());

    }
}
