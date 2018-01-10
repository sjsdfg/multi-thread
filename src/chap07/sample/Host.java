package chap07.sample;

/**
 * Created by Joe on 2017/12/29.
 * 针对请求创造线程
 */
public class Host {
    private final Helper helper = new Helper();

    public void request(final int count, final char c) {
        System.out.println("        request(" + count + "," + c + ") BEGIN");
        Thread thread = new Thread(() -> helper.handle(count, c));
        thread.start();
        System.out.println("        request(" + count + "," + c + ") END");
    }


}
