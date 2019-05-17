package rabbit;

import java.util.concurrent.Callable;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-29 18:40
 **/
public class Rabbit extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Rabbit跑了" + i + "步！🐰");
        }
    }
}

class Tortoise extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("乌龟跑了" + i + "步！🐢");
        }
    }
}

class Pig implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("🐷");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Ticket implements Runnable {
    private int num = 50;

    @Override
    public void run() {
        while (true) {
            if (num == 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "Get it" + "还剩余" + (num--) + "张票");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Call implements Callable<Integer> {
    private String name;
    private long time;
    private boolean flag = true;
    private int step = 0;

    @Override
    public synchronized Integer call() throws Exception {
        while (flag) {
            step++;
            Thread.sleep(time);
        }
        return step;
    }

    public Call() {
    }

    public Call(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}