package program;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-30 11:28
 **/
public class Movie {
    private String pic;
    private boolean flag = true;

    public synchronized void product(String pic) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.pic = pic;
        System.out.println("生产了" + this.pic);
        this.notifyAll();
        flag = false;
    }

    public synchronized void consumer() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("播放" + this.pic);
        this.notifyAll();
        flag = true;
    }
}
