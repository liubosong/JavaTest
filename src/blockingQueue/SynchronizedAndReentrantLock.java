package blockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-14 11:05
 **/
public class SynchronizedAndReentrantLock {
    private int number = 5;
    Lock lock = new ReentrantLock();
    Condition conditionFive = lock.newCondition();
    Condition conditionTen = lock.newCondition();
    Condition conditionFifteen = lock.newCondition();


    public void printFive() {
        lock.lock();
        try {
            while (number != 5) {
                conditionFive.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.print(i + "\t");
            }
            System.out.println();
            number = 10;
            conditionTen.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printTen() {
        lock.lock();
        try {
            while (number != 10) {
                conditionTen.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.print(i + "\t");
            }
            System.out.println();
            number = 15;
            conditionFifteen.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printFifteen() {
        lock.lock();
        try {
            while (number != 15) {
                conditionFifteen.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.print(i + "\t");
            }
            System.out.println();
            number = 5;
            conditionFive.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
