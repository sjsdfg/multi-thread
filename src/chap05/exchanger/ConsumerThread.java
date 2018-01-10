package chap05.exchanger;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * Created by Joe on 2017/10/21.
 */
public class ConsumerThread extends Thread {
    private final Exchanger<char[]> exchanger;
    private char[] buffer = null;
    private final Random random;

    public ConsumerThread(Exchanger<char[]> exchanger, char[] buffer, long seed) {
        super("ConsumerThread");
        this.exchanger = exchanger;
        this.buffer = buffer;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + ": Before exchange");
                buffer = exchanger.exchange(buffer);
                System.out.println(Thread.currentThread().getName() + ": After exchange");

                //从缓存区中取出字符
                for (int i = 0; i < buffer.length; i++) {
                    System.out.println(Thread.currentThread().getName() + ":-> " + buffer[i]);
                    Thread.sleep(random.nextInt(1000));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
