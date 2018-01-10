package chap06.sample;

import java.util.Random;

/**
 * Created by Joe on 2017/10/22.
 */
public class WriterThread extends Thread {
    private static final Random random = new Random();
    private final Data data;
    private final String filler;
    private int index = 0;

    public WriterThread(Data data, String filler) {
        this.data = data;
        this.filler = filler;
    }

    public void run() {
        try {
            while (true) {
                char c = nextChar();
                data.write(c);
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public char nextChar() {
        char c = filler.charAt(index);
        index++;

        index = index % filler.length();

        return c;
    }
}
