package chap04.sample;

import java.io.IOException;
import java.util.Random;

/**
 * Created by Joe on 2017/9/28.
 */
public class ChangerThread extends Thread {
    private final Data data;
    private final Random random = new Random();

    public ChangerThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                data.change("No." + i);
                Thread.sleep(random.nextInt(500));
                data.save();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
