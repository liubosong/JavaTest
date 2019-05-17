package volatileDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-13 08:03
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(7, () -> {
            System.out.println("Going");
        });
        for (int i = 1; i <= 7; i++) {
            final int finalI = i;
            new Thread(() -> {
                System.out.println("The\t" + finalI);
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
