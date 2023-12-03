package lessAlg_2023_11_29.queue;

import lessAlg_2023_11_29.queue.CustomArrayQueue;

public class TestQueue {
    public static void main(String[] args) {
//        Deque
//        Queue

        CustomArrayQueue queue = new CustomArrayQueue(10);

        // Test 1
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        // Test 2
        queue.enqueue(6);
        queue.enqueue(7);
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());

        // Test 3
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
        queue.enqueue(11);
        queue.enqueue(12);
        queue.enqueue(13);
        queue.enqueue(14);
        queue.enqueue(15);

        System.out.println(queue.search(14));
    }
}
