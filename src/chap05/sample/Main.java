package chap05.sample;

/**
 * Created by Joe on 2017/10/13.
 */
public class Main {
    public static void main(String[] args) {
        Table table = new Table(3);

        new MakerThread("MakerThread-1", table, 31415).start();
        new MakerThread("MakerThread-2", table, 4645).start();
        new MakerThread("MakerThread-3", table, 66654).start();

        new EaterThread("EaterThread-1", table, 897997).start();
        new EaterThread("EaterThread-3", table, 786).start();
        new EaterThread("EaterThread-2", table, 46456).start();

    }
}
