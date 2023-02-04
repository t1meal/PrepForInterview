package ru.gb.lesson_3.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncCounter {
    private int counter;
    Lock lock;

    public SyncCounter() {
        this.lock = new ReentrantLock();
    }

    public synchronized void inc() {
        lock.lock();
        try {
            counter++;
            System.out.println(counter);
        } finally {
            lock.unlock();
        }
    }

    public synchronized void dec() {
        lock.lock();
        try {
            counter--;
            System.out.println(counter);
        } finally {
            lock.unlock();
        }
    }

    public int get() {
        lock.lock();
        try {
            return counter;
        } finally {
            lock.unlock();
        }
    }
}
