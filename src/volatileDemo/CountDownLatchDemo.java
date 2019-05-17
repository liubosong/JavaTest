package volatileDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-12 23:41
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) {
        Thread.currentThread().setName("秦国");
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "国\t被灭");
                countDownLatch.countDown();
            }, CountryEnum.foreachCountryEnum(i).getRetMessage()).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t统一");
    }
}
