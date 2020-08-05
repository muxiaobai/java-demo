package io.github.muxiaobai.java.java.threadTest;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

//-XX:-PrintGCDetails -Xloggc:./gc.log
// -XX:+HeapDumpOnOutOfMemoryError
// -Xms16m -Xmx16m -XX:MaxGCPauseMillis=250 -Djava.awt.headless=true
public class ThreadLocalDemo {
    public volatile int a = 1;
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    public static void main(String[] args) {
        threadLocal.set(1);
        System.out.println(Thread.currentThread().getName() + ",ThreadLocalDemo :" + threadLocal.get());
        Thread thread = new Thread(new demoThread());
        thread.start();
        //下一次被回收 缓存
        Map map = new HashMap<String, SoftReference<String>>();
        map.put("s", "s");
        Thread thread1 = new Thread(() -> {
            System.out.println(1);
        });
    }
}

class demoThread implements Runnable {
    @Override
    public void run() {
        Integer i = ThreadLocalDemo.threadLocal.get();
        Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + ",ThreadLocalDemo :" + i);
    }
}
