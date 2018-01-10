package chap04.sample;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 用于表示当前数据
 * Created by Joe on 2017/9/27.
 */
public class Data {
    private final String fileName; //保存的文件名称
    private String content; //数据内容
    private boolean changed; //修改后的内容如果没有修改，则为true

    public Data(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        this.changed = true;
    }

    //修改数据内容
    public synchronized void change(String newContent) {
        content = newContent;
        this.changed = true;
    }

    //若数据内容修改过，则保存到文件中
    public synchronized void save() throws IOException {
        if (!changed) {
            return;
        }
        doSave();
        this.changed = false;
    }

    //将数据内容存到文件中
    void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        Writer writer = new FileWriter(fileName);
        writer.write(content);
        writer.close();
    }
}
