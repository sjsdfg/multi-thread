package chap05.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by Joe on 2017/10/21.
 */
public class Main {
    public static void main(String[] args) {
        Exchanger<char[]> exchanger = new Exchanger<>();
        char[] buffer1 = new char[10];
        char[] buffer2 = new char[10];

        new ProducerThread(exchanger, buffer1, 123).start();
        new ConsumerThread(exchanger, buffer2, 465).start();
    }
}
