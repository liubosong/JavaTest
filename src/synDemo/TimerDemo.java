package synDemo;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-30 11:02
 **/
public class TimerDemo {
    public static void main(String[] args) {
        //noinspection AlibabaAvoidUseTimer
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Fuck you...");
            }
        }, new Date(System.currentTimeMillis() + 1000), 1000);
    }
}
