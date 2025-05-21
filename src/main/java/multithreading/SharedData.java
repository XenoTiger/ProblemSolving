package multithreading;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedData {

    private int value = 0;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void write(int val) {
        lock.writeLock().lock();
        try {
            value = val;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int read() {
        lock.readLock().lock();
        try {
            return value;
        } finally {
            lock.readLock().unlock();
        }
    }


}
