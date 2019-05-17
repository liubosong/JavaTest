package blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-14 12:10
 **/
public class BlockingQueueDemo {
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    public BlockingQueueDemo(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProductor() throws InterruptedException {
        String data = null;
        boolean retValue = true;
        while (flag) {
            data = atomicInteger.getAndIncrement() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "插入" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "插入" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "停止生产");
    }

    public void myConsumer() throws InterruptedException {
        String result = null;
        while (flag) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (result == null || result.equalsIgnoreCase("")) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "获取" + "失败");
                return;
            } else {
                System.out.println(Thread.currentThread().getName() + "获取" + result + "成功");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "停止生产");
    }

    public void stop() {
        this.flag = false;
    }
}
