package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SearchTree tree = new SearchTree();
        tree.add("C", 10);
        tree.add("A", 20);
        tree.add("B", 30);
        tree.add("D", 40);
        tree.add("G", 90);

        // Если добавлять ключи последовательно, несбалансированное дерево поиска выродится в связный список
        // A -> B -> C -> D -> E

        System.out.println(tree.get("A"));
        System.out.println(tree.get("B"));
        System.out.println(tree.get("C"));
        System.out.println(tree.get("D"));
        System.out.println(tree.get("G"));
        System.out.println(tree.get("X"));

        System.out.println(tree.getAllKeys());

        String[] sorted = tree.sortWithTree(new String[]{"Hello", "World", "C", "D", "A"});
        System.out.println(Arrays.toString(sorted));

        System.out.println("Max key = " + tree.getMaxKey());

        System.out.println("searchByValueBFS: " + tree.searchByValueBFS(90));
        System.out.println("searchByValueDFS: " + tree.searchByValueDFS(90));
        System.out.println("Высота дерева: " + tree.getHeight());
    }
}