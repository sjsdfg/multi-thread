package chap03.sample;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Joe on 2017/9/12.
 * 请求队列
 */
public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<>();

    public synchronized Request getRequest() {
        while (queue.peek() == null) {
            try {
                wait();
            } catch (Exception e) {

            }
        }

        return queue.remove();
    }

    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }
}
