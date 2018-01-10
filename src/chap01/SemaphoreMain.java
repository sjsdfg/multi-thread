package chap01;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by Joe on 2017/9/9.
 */
public class SemaphoreMain {
    public static void main(String[] args) {
        //设置三个资源
        BoundedResource resource = new BoundedResource(3);

        //10个线程使用资源
        for (int i = 0; i < 10; i++) {
            new ResourceThread(resource).start();
        }
    }
}

class Log {
    public static void println(String string) {
        System.out.println(Thread.currentThread().getName() + ":" + string);
    }
}

class BoundedResource {
    private final Semaphore semaphore;
    private final int permits;
    private final static Random random = new Random(314159);

    //构造函数
    public BoundedResource(int permits) {
        this.permits = permits;
        this.semaphore = new Semaphore(permits);
    }

    //使用资源
    public void use() throws InterruptedException {
        semaphore.acquire();
        try {
            doUse();
        } finally {
            semaphore.release();
        }
    }

    //实际使用资源
    protected void doUse() throws InterruptedException {
        Log.println("Begin: used = " + (permits - semaphore.availablePermits()));
        Thread.sleep(random.nextInt(500));
        Log.println("End: used = " + (permits - semaphore.availablePermits()));
    }
}

//使用资源的线程
class ResourceThread extends Thread {
    private final static Random random = new Random(26535);
    private final BoundedResource resource;

    public ResourceThread(BoundedResource resource) {
        this.resource = resource;
    }

    public void run() {
        try {
            while (true) {
                resource.use();
                Thread.sleep(random.nextInt(500));
            }
        } catch (InterruptedException e) {

        }
    }
}
