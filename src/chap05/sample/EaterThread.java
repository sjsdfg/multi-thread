package chap05.sample;

import sun.awt.windows.ThemeReader;

import java.util.Random;

/**
 * Created by Joe on 2017/10/13.
 */
public class EaterThread extends Thread {
    private final Random random;
    private final Table table;

    public EaterThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String cake = table.get();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
