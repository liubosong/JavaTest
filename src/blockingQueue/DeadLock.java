package blockingQueue;

import java.util.concurrent.TimeUnit;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-14 17:25
 **/
public class DeadLock implements Runnable {
    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread(() -> {
            deadLock.money();
        }).start();

        new Thread(() -> {
            deadLock.goods();
        }).start();

    }

    private String money = "Money";
    private String goods = "Goods";

    @Override
    public void run() {

    }

    public void money() {
        synchronized (money) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(money);
            goods();
        }
    }

    public synchronized void goods() {
        synchronized (goods) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(goods);
            money();
        }
    }
}
