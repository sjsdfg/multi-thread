package chap04.sample;

import java.io.IOException;

/**
 * Created by Joe on 2017/9/28.
 */
public class SaverThread extends Thread {
    private final Data data;

    public SaverThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    public void run() {
        try {
            while (true) {
                data.save(); //要求保存数据
                Thread.sleep(1000); //休眠线程
            }
        } catch (IOException | InterruptedException e) {
            //JDK 7特性，使用管道符`|`用于同时捕获多个异常
            e.printStackTrace();
        }
    }
}
