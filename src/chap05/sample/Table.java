package chap05.sample;

/**
 * Created by Joe on 2017/10/13.
 */
public class Table {
    private final String[] buffer;
    private int tail; //下次Put的位置
    private int head; //下次take的位置
    private int count; //buffer中含有蛋糕的个数

    public Table(int count) {
        this.buffer = new String[count];
        this.count = 0;
        this.tail = 0;
        this.head = 0;
    }

    //放置蛋糕
    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        //如果已经存放的蛋糕个数大于buff的长度，则说明还有
        while (count >= buffer.length) {
            wait();
        }

        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }

    //拿取蛋糕
    public synchronized String get() throws InterruptedException {
        while (count <= 0) {
            wait();
        }


        //获取当前位置的蛋糕
        String cake = buffer[head];

        //然后 后挪
        count--;
        head = (head + 1) % buffer.length;

        System.out.println(Thread.currentThread().getName() + " takes " + buffer[head] + " counts = " + count);
        //唤醒其他线程
        notifyAll();
        return cake;
    }
}
