package lessAlg_2023_11_29.queue;

public class CustomArrayQueue {
    private int[] data;
    private int tail;
    private int head;
    private int count;

    public CustomArrayQueue(int capacity) {
        data = new int[capacity];
        count = 0;
        head = -1;
        tail = -1;
    }

    public void enqueue(int element){ // O(1)
        if (count >= data.length) throw new RuntimeException("Queue is full");
        if (++tail == data.length) tail = 0;
        data[tail] = element;
        if (head == -1) head++;
        count++;
    }

    public int dequeue(){ // O(1)
        if (count == 0) throw new RuntimeException("Queue is empty");
        int result = data[head];
        if (++head == data.length) head = 0;
        if (--count == 0) {
            head = -1;
            tail = -1;
        }
        return result;
    }

    public int search(int element){ // TODO
        if (count == 0) {
            return -1; // Очередь пуста, элементов нет
        }
        for (int i = count - 1; i >= 0; i--) {
            if (data[i] == element) {
                return count - i;
            }
        }
        return -1; // Элемент не найден в очереди
    }

}
