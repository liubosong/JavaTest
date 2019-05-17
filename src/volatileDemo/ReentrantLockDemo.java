package volatileDemo;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-12 18:56
 **/
public class ReentrantLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendSMS();
        }, "t1").start();

        new Thread(() -> {
            phone.sendSMS();
        }, "t2").start();
    }

}

class Phone {
    public synchronized void sendSMS() {
        System.out.println(Thread.currentThread().getId() + "\t" + "invoked sendSMS");
        sendmail();
    }

    public synchronized void sendmail() {
        System.out.println(Thread.currentThread().getId() + "\t #####invoked sendEmail");
    }
}
