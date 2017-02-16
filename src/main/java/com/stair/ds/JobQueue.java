package com.stair.ds;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Class for holding the submitted floor data.
It is a circular Queue which support push and pop feature guarded by lock.
 */
public class JobQueue {

    private static final JobQueue INSTANCE = new JobQueue(100);
    private final Object[] array;
    private final int size;
    private int getPtr = 0;
    private int putPtr = 0;
    private int count = 0;

    private final Lock lock = new ReentrantLock();
    private final Condition getCondition = lock.newCondition();
    private final Condition putCondition = lock.newCondition();



    private JobQueue(int size){
        this.size = size;
        array = new Object[size];
    }

    private static JobQueue getInstance(){
        return INSTANCE;
    }

    public boolean push(Object obj) throws InterruptedException {
        lock.lock();
        try {
            while (count == size)
                putCondition.await();
            array[putPtr] = obj;
            if(++putPtr == size)
                putPtr = 0;
            count ++;
            getCondition.signalAll();
        }finally {
            lock.unlock();
        }

        return true;
    }

    public Object pop() throws InterruptedException {
        lock.lock();
        Object result = null;
        try {
            while (count == 0)
                getCondition.await();
            result = array[getPtr];
            if(++ getPtr == size)
                getPtr = 0;
            count --;
            putCondition.signalAll();
        }finally {
            lock.unlock();
        }
        return result;
    }


}
