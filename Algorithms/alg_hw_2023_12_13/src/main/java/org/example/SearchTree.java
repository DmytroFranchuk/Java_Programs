package org.example;

import java.util.*;

public class SearchTree {

    private Node root;

    private static class Node {
        String key;
        Integer value;
        //        List<Node> children;
        Node left;
        Node right;

        public Node(String key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    // ===========================================================================
    public Integer get(String key) { // O(log n) if tree is balanced, O(n) if tree is not balanced
        Node current = root;
        while (current != null) {
            int result = key.compareTo(current.key);
            if (result == 0) return current.value;
            else if (result < 0) current = current.left;
            else current = current.right;
        }
        return null;
    }
    // ===========================================================================
    public void add(String key, Integer value) {
        root = add(root, key, value);
    }
    // ===========================================================================
    private Node add(Node current, String key, Integer value) { // O(log n) if tree is balanced, O(n) if tree is not balanced
        if (current == null) {
            current = new Node(key, value);
        } else {
            int result = key.compareTo(current.key);
            if (result == 0) current.value = value;
            else if (result < 0) current.left = add(current.left, key, value);
            else current.right = add(current.right, key, value);
        }
        return current;
    }
    // ===========================================================================
    public Iterable<String> getAllKeys() { // O(n)
        Queue<String> queue = new LinkedList<>();
        inorder(queue, root);
        return queue;
    }
    // ===========================================================================
    private void inorder(Queue<String> queue, Node current) {
        if (current.left != null) inorder(queue, current.left);
        queue.add(current.key);
        if (current.right != null) inorder(queue, current.right);
    }
    // ===========================================================================
    // O(n log(n)) time complexity
    // O(n) space complexity
    public String[] sortWithTree(String[] data) {
        SearchTree tree = new SearchTree(); // O(1)
        for (String s : data) { // O(n log(n))
            tree.add(s, 0); // O(log n)
        }
        Iterable<String> keys = tree.getAllKeys(); // O(n)
        String[] sortedData = new String[data.length];
        int i = 0;
        for (String s : keys) { // O(n)
            sortedData[i++] = s;
        }
        return sortedData;
    }
    // ===========================================================================
    public String getMaxKey() { // O(log n) if tree is balanced, O(n) if tree is not balanced
        Node current = root;
        while (current != null) {
            if (current.right == null) return current.key;
            current = current.right;
        }
        return null;
    }
    // ===========================================================================
    public String searchByValueBFS(Integer value) { // O(n)
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node current;
        while (!queue.isEmpty()) {
            current = queue.remove();
            if (current.value.equals(value)) return current.key;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return null;
    }
    // ===========================================================================
    public String searchByValueDFS(Integer value) { // O(n) TODO
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            if (currentNode.value.equals(value)) {
                return currentNode.key;
            }
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
        return null;
    }
    // ===========================================================================
    public int getHeight() {
        if (root == null) {
            return 0;
        }
        Stack<Node> stack = new Stack<>();
        Map<Node, Integer> heightMap = new HashMap<>();
        int maxHeight = 0;
        stack.push(root);
        heightMap.put(root, 1);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            int currentHeight = heightMap.get(currentNode);
            if (currentNode.right != null) {
                stack.push(currentNode.right);
                heightMap.put(currentNode.right, currentHeight + 1);
                maxHeight = Math.max(maxHeight, currentHeight + 1);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
                heightMap.put(currentNode.left, currentHeight + 1);
                maxHeight = Math.max(maxHeight, currentHeight + 1);
            }
        }
        return maxHeight;
    }
    // ===========================================================================
}
