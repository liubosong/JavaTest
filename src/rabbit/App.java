package rabbit;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-29 18:46
 **/
public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Call pig = new Call("pig", 500);
        Call dog = new Call("dog", 1000);
        Future<Integer> pigFutere = pool.submit(pig);
        Future<Integer> dogFuture = pool.submit(dog);
        Thread.sleep(2000);
        pig.setFlag(false);
        dog.setFlag(false);
        Integer num1 = pigFutere.get();
        Integer num2 = dogFuture.get();
        System.out.println(pig.getStep());
        System.out.println(num1);
        System.out.println(dog.getStep());
        System.out.println(num2);
        pool.shutdownNow();
    }

    public static void fun() {
        Rabbit rabbit = new Rabbit();
        Pig pig = new Pig();
        Thread thread = new Thread(rabbit);
        Thread thread1 = new Thread(pig);
    }
}
