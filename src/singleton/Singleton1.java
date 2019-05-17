package singleton;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-11 17:01
 **/
public class Singleton1 {
    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getINSTANCE() {
        return INSTANCE;
    }
}
