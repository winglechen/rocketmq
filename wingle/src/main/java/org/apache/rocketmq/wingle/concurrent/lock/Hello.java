package org.apache.rocketmq.wingle.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * org.apache.rocketmq.wingle.concurrent.lock
 *
 * @author Wingle
 * @create 2018/12/16 7:53 PM
 **/
public class Hello {
    int a=0;
    ReentrantLock lock = new ReentrantLock();

    public void write() {
        lock.lock();
        try {
            a++;
        } finally {
            lock.unlock();
        }
    }

    public void read() {

    }

    public static void main(String[] args) {

    }
}
