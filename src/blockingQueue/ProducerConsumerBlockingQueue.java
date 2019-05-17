package blockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-14 09:56
 **/
public class ProducerConsumerBlockingQueue {
    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    public void increament() {
        lock.lock();
        try {
            while (number != 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void decreament() {
        lock.lock();
        try {
            while (number == 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
