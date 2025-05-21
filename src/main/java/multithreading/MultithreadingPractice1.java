package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {

    private BlockingQueue<Integer> buffer;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.buffer = blockingQueue;
    }

    @Override
    public void run() {
        int value = 1;
        while (value < 10) {
            try {
                buffer.put(value);
                System.out.println("Produced: " + value);
                value++;
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}

class Consumer implements Runnable {

    private BlockingQueue<Integer> buffer;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.buffer = blockingQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                int value = buffer.take();
                System.out.println("Consumed: " + value);
                Thread.sleep(800);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class MultithreadingPractice1 {

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
        Thread producerThread = new Thread(new Producer(blockingQueue));
        Thread consumerThread = new Thread(new Consumer(blockingQueue));
        producerThread.start();
        consumerThread.start();
    }
}
