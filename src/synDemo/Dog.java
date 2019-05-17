package synDemo;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-30 10:22
 **/
public class Dog implements Runnable {
    private String good;
    private String money;

    @Override
    public void run() {
        synchronized (money) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(money);
            synchronized (good) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(good);
            }
        }
    }

    public Dog(String good, String money) {
        this.good = good;
        this.money = money;
    }
}
