package singleton;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-11 17:39
 **/
public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
