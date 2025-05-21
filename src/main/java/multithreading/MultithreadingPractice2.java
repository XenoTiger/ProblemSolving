package multithreading;

import java.util.LinkedList;

class Buffer {

    private final LinkedList<Integer> linkedList;

    private final int maxSize;

    public Buffer(int maxSize) {
        this.linkedList = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public synchronized void produce(int val) throws InterruptedException {
        while (linkedList.size() == maxSize) {
            wait();
        }
        linkedList.add(val);
        notify();
    }

    public synchronized int consume() throws InterruptedException {
        while (linkedList.isEmpty()) {
            wait();
        }
        int val = linkedList.removeFirst();
        notify();
        return val;
    }
}

class Producer1 implements Runnable {

    private final Buffer buffer;

    public Producer1(Buffer buffer) {
        this.buffer = buffer;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                buffer.produce(i);
                System.out.println("Produced: " + i);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }
}

class Consumer1 implements Runnable {

    private final Buffer buffer;

    public Consumer1(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                int val = buffer.consume();
                System.out.println("Consumed: " + val);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }
}

public class MultithreadingPractice2 {


    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);
         Thread producerThread = new Thread(new Producer1(buffer));
         Thread consumerThread = new Thread(new Consumer1(buffer));

         producerThread.start();
         consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished.");
    }
}
