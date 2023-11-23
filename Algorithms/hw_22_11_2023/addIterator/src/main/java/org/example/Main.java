package org.example;

public class Main {
    public static void main(String[] args) {
        CustomDynamicArray dynamicArray = new CustomDynamicArray();
        for (int i = 0; i < 5; i++) {
            dynamicArray.add(i + 10);
        }
        while (dynamicArray.hasNext()) {
            System.out.println(dynamicArray.next() + 10);
        }
        System.out.println(dynamicArray);
    }
}