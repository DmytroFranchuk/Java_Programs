package lessAlg_2023_11_29.stack;

public class CustomArrayStack {
    private int[] data;
    private int count;

    public CustomArrayStack(int capacity) {
        data = new int[capacity];
        this.count = 0;
    }

    public int getMin(){
        int min = Integer.MIN_VALUE;
        int[] dop = new int[data.length];
        for (int i = 0; i < dop.length; i++) {
            dop[i] = pop();

        }
        return -2;
    }

    public void push(int element) {
        if (count >= data.length) throw new RuntimeException("Stack is full");
        data[count++] = element;
    }

    public int pop() {
        if (count == 0) throw new RuntimeException("Stack is empty");
        int result = data[--count];
        data[count] = 0;
        return result;
    }

    public int peek() {
        if (count == 0) throw new RuntimeException("Stack is empty");
        return data[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public int search(int element) { // TODO
        return -1;
    }

}
