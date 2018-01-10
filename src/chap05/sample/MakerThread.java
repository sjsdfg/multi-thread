package chap05.sample;

import java.util.Random;

/**
 * Created by Joe on 2017/10/13.
 */
public class MakerThread extends Thread {
    private final Random random;
    private final Table table;

    private static int id = 0; //蛋糕的流水号，所有的makerThread共用

    MakerThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000));
                String cake = "[Cake No." + nextId() + " by " + this.getName() + "]";
                table.put(cake);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}
