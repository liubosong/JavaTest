package volatileDemo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-12 12:54
 **/
public class Singleton {
    public static void main(String[] args) {
        AtomicReference<Integer> atomicReference = new AtomicReference<>(1);
        AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(1, 001);
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + atomicReference.get());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicReference.compareAndSet(1, 2019);
            System.out.println(Thread.currentThread().getName() + "\t" + atomicReference.get());
        }, "t1").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + atomicReference.get());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicReference.compareAndSet(1, 2);
            System.out.println(atomicReference.compareAndSet(1, 5));
            System.out.println(Thread.currentThread().getName() + "\t" + atomicReference.get());
        }, "t2").start();

        new Thread(() -> {
            stampedReference.compareAndSet(1, 1024, 001, 002);
            System.out.println(Thread.currentThread().getName() + "\t" + stampedReference.getReference() + "\t" + stampedReference.getStamp());
        }, "thread1").start();

    }

    private static volatile Singleton instance = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
