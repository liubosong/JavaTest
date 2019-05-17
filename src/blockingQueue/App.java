package blockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-14 10:03
 **/
public class App {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = Executors.newFixedThreadPool(5);
    }
}
