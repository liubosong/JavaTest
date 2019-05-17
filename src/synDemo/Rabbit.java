package synDemo;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-30 10:14
 **/
public class Rabbit implements Runnable {
    private String good;
    private String money;

    @Override
    public void run() {
        synchronized (good) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(good);
            synchronized (money) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(money);
            }
        }
    }

    public Rabbit(String good, String money) {
        this.good = good;
        this.money = money;
    }
}
