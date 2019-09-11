package ru.ttv.interviewprepare.lesson3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Teplykh Timofey  11.09.2019
 */
public class CounterLockThread extends Thread {

    private Counter counter;

    private Lock lock;

    public CounterLockThread(Counter counter, Lock lock) {
        this.counter = counter;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            try {
                if(lock.tryLock(10, TimeUnit.SECONDS)){
                    counter.add();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
