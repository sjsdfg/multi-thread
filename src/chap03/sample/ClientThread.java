package chap03.sample;

import java.util.Random;

/**
 * Created by Joe on 2017/9/12.
 * 用于发送请求
 */
public class ClientThread extends Thread {
    private final Random random;
    private final RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue, String name, long seed) {
        super(name);
        this.requestQueue = requestQueue;
        random = new Random(seed);
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = new Request("No." + i);
            System.out.println(Thread.currentThread().getName() + " requests " + request);
            requestQueue.putRequest(request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (Exception e) {

            }
        }

    }
}
