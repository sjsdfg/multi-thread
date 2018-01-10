package chap05.exchanger;

import sun.awt.windows.ThemeReader;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * Created by Joe on 2017/10/21.
 * 填充字符，直到缓冲区被填满
 * 使用exchange方法将填满的缓冲区传递给ConsumerThread
 * 传递缓冲区之后，作为交换，接受空的缓冲区
 */
public class ProducerThread extends Thread {
    private final Exchanger<char[]> exchanger;
    private char[] buffer = null;
    private char index = 0;
    private final Random random;

    public ProducerThread(Exchanger<char[]> exchanger, char[] buffer, long seed) {
        super("ProducerThread");
        this.exchanger = exchanger;
        random = new Random(seed);
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = nextChar();
                    System.out.println(Thread.currentThread().getName() + ":->" + buffer[i]);
                }

                System.out.println(Thread.currentThread().getName() + ": Before exchange");
                buffer = exchanger.exchange(buffer);
                System.out.println(Thread.currentThread().getName() + ": After exchange");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar() throws InterruptedException {
        char c = (char) ('A' + index % 26);
        index++;
        Thread.sleep(random.nextInt(1000));
        return c;
    }

}
