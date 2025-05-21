package stackAndQueues;

class Queue {

    private int[] queue;
    private int front, rear, capacity, size;

    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear++;
        queue[rear] = data;
        size++;
        System.out.println("Enqueued :" + data);

    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int val = queue[front];
        for (int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }
        rear--;
        size--;
        System.out.println("Dequeued: " + val);
        return val;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int val = queue[front];
        System.out.println("peek: " + val);
        return val;
    }
}

public class QueueUsingArray {

    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.dequeue();
        queue.peek();
    }
}
