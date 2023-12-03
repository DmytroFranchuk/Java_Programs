package lessAlg_2023_11_29.stack;

import lessAlg_2023_11_29.stack.CustomArrayStack;

public class SpecialStack {
    private CustomArrayStack data;
    private CustomArrayStack minStack;

    public SpecialStack(int capacity) {
        data = new CustomArrayStack(capacity);
        minStack = new CustomArrayStack(capacity);
    }

    public int getMin() {
        return minStack.peek();
    }

    public void push(int element) {
        if (isEmpty() || element <= getMin()) {
            minStack.push(element);
        }
        data.push(element);
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int result = data.pop();
        if (result == getMin()) {
            minStack.pop();
        }
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return data.peek();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }

    public int search(int element) { // TODO
        return -1;
    }
}
