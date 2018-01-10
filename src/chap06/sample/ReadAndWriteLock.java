package chap06.sample;

/**
 * Created by Joe on 2017/10/22.
 */
public class ReadAndWriteLock {
    private int readingReaders = 0; //实际正在读取的线程
    private int waitingWriters = 0; //正在等待写入的线程个数
    private int writingWriters = 0; //实际正在写入的线程个数
    private boolean preferWriting = true; //如果写入优先则为true

    public synchronized void readLock() throws InterruptedException {
        //如果有线程正在写入内容
        //写入优先，而且还有线程正在写入内容
        while (writingWriters > 0 || (preferWriting && waitingWriters > 0)) {
            wait();
        }

        readingReaders++;
    }

    public synchronized void readUnlock() {
        readingReaders--;
        preferWriting = true;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;

        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            waitingWriters--;
        }

        writingWriters++;
    }

    public synchronized void writeUnlock() {
        writingWriters--;
        preferWriting = false;
        notifyAll();
    }
}
