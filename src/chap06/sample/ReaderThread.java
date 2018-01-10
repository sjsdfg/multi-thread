package chap06.sample;

/**
 * Created by Joe on 2017/10/22.
 */
public class ReaderThread extends Thread {
    private final Data data;

    public ReaderThread(Data data) {
        this.data = data;
    }

    public void run() {
        try {
            while (true) {
                char[] readBuf = data.read();

                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readBuf));
            }
        } catch (InterruptedException e) {

        }
    }
}
