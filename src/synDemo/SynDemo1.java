package synDemo;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-30 09:07
 **/

/**
 * 单例模式 一个类只有一个对象，懒汉模式 但线程下可以，
 * 多线程下 不一定了
 * 构造器私有化
 * 声明一个私有的静态变量
 */
public class SynDemo1 {
}


class Jvm {
    private static Jvm instance;

    public static Jvm getInstance() {
        if (null == instance) {
            synchronized (Jvm.class) {
                if (null == instance) {
                    instance = new Jvm();
                }
            }
        }
        return instance;
    }

    private Jvm() {
    }
}