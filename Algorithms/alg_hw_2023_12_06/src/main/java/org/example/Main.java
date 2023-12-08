package org.example;

public class Main {
    public static void main(String[] args) {
        CustomLinkedStack stack = new CustomLinkedStack();
        stack.push("Elem_1");
        stack.push("Elem_2");
        stack.push("Elem_3");
        stack.push("Elem_4");
        stack.push("Elem_5");
        System.out.println("Содержимое стека: " + stack);
        System.out.println("Позиция в стеке от вершины: " + stack.search("Elem_1"));
        System.out.println("Элементов в стеке: " + stack.size());
        System.out.println("Есть элементы в стеке: " + stack.isEmpty());
        System.out.println("Забрать из стека: " + stack.pop());
        System.out.println("На вершине стека находиться: " + stack.peek());
        System.out.println("Забрать из стека: " + stack.pop());
        System.out.println("Забрать из стека: " + stack.pop());
        System.out.println("Элементов в стеке: " + stack.size());
        System.out.println("Забрать из стека: " + stack.pop());
        System.out.println("На вершине стека находиться: " + stack.peek());
        System.out.println("Забрать из стека: " + stack.pop());
        System.out.println("На вершине стека находиться: " + stack.peek());
        System.out.println("Забрать из стека: " + stack.pop());
        System.out.println("Содержимое стека: " + stack);
        System.out.println("Элементов в стеке: " + stack.size());
        System.out.println("Есть элементы в стеке: " + stack.isEmpty());
        System.out.println("Позиция в стеке от вершины: " + stack.search("Elem_1"));
    }
}