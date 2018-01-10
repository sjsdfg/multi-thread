package chap03.sample;

import java.util.Random;

/**
 * Created by Joe on 2017/9/12.
 */
public class ServerThread extends Thread {
    private final RequestQueue requestQueue;
    private final Random random;

    public ServerThread(RequestQueue requestQueue, String name, long seed) {
        super(name);

        this.requestQueue = requestQueue;
        this.random = new Random(seed);
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = requestQueue.getRequest();
            System.out.println(Thread.currentThread().getName() + " hands " + request);
            try {
                sleep(random.nextInt(1000));
            } catch (Exception e) {

            }
        }
    }
}
