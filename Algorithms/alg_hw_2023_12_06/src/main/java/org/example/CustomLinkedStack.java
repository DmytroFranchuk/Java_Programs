package org.example;

public class CustomLinkedStack {
    private final static class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.format("Node: %ndata = [%s], next = [%s]", data, next);
        }
    }

    private Node top = null;
    private int size = 0;

    public void push(String element) {
        Node newNode = new Node(element);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }

    public String pop() {
        if (top == null) return null;
        String result = top.data;
        top = top.next;
        size--;
        return result;
    }

    public String peek() {
        if (top == null) return null;
        return top.data;
    }

    public boolean isEmpty() {
        return top != null;
    }

    public int size() {
        return size;
    }

    // (Определяет, существует ли объект в стеке.
    // Если элемент найден, возвращает позицию элемента с вершины стека.
    // В противном случае он возвращает -1) --- O(n)
    public int search(String element) {
        Node current = top;
        int position = 1;
        while (current != null) {
            if (current.data.equals(element)) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1;
    }

    @Override
    public String toString() {
        return String.format("Stack: %s", top);
    }
}
