package other;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Joe on 2017/10/11.
 * 启动四个线程，向4个文件A,B,C,D里写入数据，每个线程只能写入一个值
 * 线程1：只能写入1
 * 线程2：只能写入2
 * 线程3：只能写入3
 * 线程4: 只能写入4
 *
 * 4个文件：A,B,C,D
 * 程序运行起来，4个文件的写入结果如下
 * A:12341234
 * b:23412341
 * C:34123412
 * D:41234123
 */
public class Main {
    public static void main(String[] args) throws Exception {
        final int N = 4;
        final CyclicBarrier barrier = new CyclicBarrier(N);
        final StringBuilder[] buffers = new StringBuilder[N];
        Thread[] threads = new Thread[N];

        for (int i = 0; i < N; i++) {
            buffers[i] = new StringBuilder();
            final int id = i;
            threads[i] = new Thread(() -> {
                try {
                    for (int x = id; ; x = (x + N - 1) % N) {
                        barrier.await();
                        buffers[x].append(id + 1);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            threads[i].start();
        }

        ////////////////////////////////////////////////////////

        Thread.sleep(200);
        for (StringBuilder buffer : buffers) {
            System.out.println(buffer);
        }
        System.exit(0);

    }
}
