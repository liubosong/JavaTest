package singleton;

import java.util.concurrent.*;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-11 17:29
 **/
public class TestSingleton {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Singleton1 singleton1 = Singleton1.getINSTANCE();
        Singleton2 singleton2 = Singleton2.INSTANCE;
        Callable<Singleton4> c = new Callable<Singleton4>() {
            @Override
            public Singleton4 call() throws Exception {
                return Singleton4.getInstance();
            }
        };
        ExecutorService eS = Executors.newFixedThreadPool(2);
        Future<Singleton4> f1 = eS.submit(c);
        Future<Singleton4> f2 = eS.submit(c);
        Singleton4 s1 = f1.get();
        Singleton4 s2 = f2.get();
        System.out.println(s1 == s2);
        eS.shutdown();
    }
}
