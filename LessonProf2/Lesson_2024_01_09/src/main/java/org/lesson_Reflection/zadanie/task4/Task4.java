package org.lesson_Reflection.zadanie.task4;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Создайте экземпляр ArrayList с помощью рефлексии. Добавьте в список несколько
// элементов. Склонируйте список с помощью рефлексии.
public class Task4 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<ArrayList> listClass = ArrayList.class;
        List list = listClass.newInstance();
        list.add(13);
        list.add("Food");
        list.add(true);
        System.out.println(list);
        Class[] params = {Collection.class};
        List list2 = listClass.getConstructor(params).newInstance(list);
        System.out.println(list2);
        System.out.println(list2 == list);
        System.out.println(list2.equals(list));

        List list3 = new ArrayList<>(list);
        System.out.println(list3);
        System.out.println(list3 == list);
        System.out.println(list3.equals(list));
    }
}
