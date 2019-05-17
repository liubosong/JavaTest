package synDemo;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-30 10:25
 **/
public class App {
    public static void main(String[] args) {
        String good = "good";
        String money = "money";
        Rabbit rabbit = new Rabbit(good, money);
        Dog dog = new Dog(good, money);
        Thread thread1 = new Thread(rabbit);
        Thread thread2 = new Thread(dog);
        thread1.start();
        thread2.start();
    }
}
