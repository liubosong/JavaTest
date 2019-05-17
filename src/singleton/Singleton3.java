package singleton;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-11 17:33
 **/
public class Singleton3 {
    private static final Singleton3 INSTANCE;

    static {
        INSTANCE = new Singleton3();
    }

    private Singleton3() {

    }
}
