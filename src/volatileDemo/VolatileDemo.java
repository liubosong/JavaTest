package volatileDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-12 07:22
 **/
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        System.out.println(Thread.currentThread().getName() + "\t" + myData.number);
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + myData.number);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.setNumber();
            System.out.println(Thread.currentThread().getName() + "\t" + myData.number);
        }, "AAA").start();
        while (myData.number == 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "\t" + myData.number);
        AtomicInteger atomicInteger = new AtomicInteger(11);
        atomicInteger.getAndAdd(5);
        System.out.println(atomicInteger);
    }
}


class MyData {
    int number = 0;

    public void setNumber() {
        this.number = 60;
    }
}