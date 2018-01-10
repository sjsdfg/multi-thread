package chap07.sample;

/**
 * Created by Joe on 2017/12/29.
 * 向Host发送字符显示请求的类
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host host = new Host();
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("main END");
    }
}
