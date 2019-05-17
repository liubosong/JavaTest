package blockingQueue;

import java.util.concurrent.*;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-14 16:14
 **/
public class MyThreadPoolExecutor {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        try {
            for (int i = 1; i <= 11; i++) {
                poolExecutor.execute(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                });
            }
        } finally {
            poolExecutor.shutdown();
        }
    }

}
