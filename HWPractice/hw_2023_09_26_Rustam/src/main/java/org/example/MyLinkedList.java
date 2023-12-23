package org.example;

public class MyLinkedList<T> {
    private Node<T> head;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
