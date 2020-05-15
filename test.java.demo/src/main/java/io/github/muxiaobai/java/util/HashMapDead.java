package io.github.muxiaobai.java.util;

import java.util.HashMap;
import java.util.UUID;


public class HashMapDead {
    //    6.1.1为什么要使用ConcurrentHashMap在并发编程中使用HashMap可能导致程序死循环。而使用线程安全的HashTable效率又非常低下，基于以上两个原因，
//    便有了ConcurrentHashMap的登场机会。（1）线程不安全的HashMap在多线程环境下
//    ，使用HashMap进行put操作会引起死循环，导致CPU利用率接近100%，所以在并发情况下不能使用HashMap。例如，执行以下代码会引起死循环。
    public static void main(String[] args) throws Exception {
        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();

    }
}
