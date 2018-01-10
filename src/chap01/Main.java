package chap01;

/**
 * Created by Joe on 2017/9/6.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Gate");

        Gate gate = new Gate();

        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chirs", "Canada").start();
    }
}
