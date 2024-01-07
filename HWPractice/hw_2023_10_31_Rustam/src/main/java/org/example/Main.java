package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       
    }
    
    //Напишите метод на Java для поиска общих элементов между двумя массивами целых чисел:
    public static List<Integer> getCommonElements(int[] arr1, int[] arr2){
        if (arr1.length == 0 || arr2.length == 0) throw new RuntimeException("Передан пустой массив");
        List<Integer> arrResult = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i; j < arr2.length; j++) {
                if (arr1[i]==arr2[j]) arrResult.add(arr1[i]);
            }
        }
        return arrResult;
    } 
    
    //удалениe повторяющихся элементов из массива
    public static List<Integer> removeDouble(int[] arr){
        if  (arr.length == 0) throw new RuntimeException("Передан пустой массив");
        List<Integer> arrResult = new ArrayList<>();
        boolean isDouble;
        for (int i = 0; i < arr.length; i++) {
            isDouble = false;
            for (int j = 0; j < arrResult.size(); j++) {
                if (arrResult.get(j)==arr[i]) {
                    isDouble=true;
                    break;
                }
            }
            if (!isDouble) arrResult.add(arr[i]);
        }
        return  arrResult;
    }

    //поиск второго по величине элемента в массиве
    public static int getTwoMax (int[] arr){
        if  (arr.length == 0) throw new RuntimeException("Передан пустой массив");
        int max = arr[0];
        int result=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max) max = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>result && arr[i]<max) result = arr[i];
        }
        return result;
    }

    //поиск второго наименьшего элемента в массиве
    public static int getTwoMin (int[] arr){
        if  (arr.length == 0) throw new RuntimeException("Передан пустой массив");
        int min = arr[0];
        int result=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<min) min = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<result && arr[i]>min) result = arr[i];
        }
        return result;
    }
}