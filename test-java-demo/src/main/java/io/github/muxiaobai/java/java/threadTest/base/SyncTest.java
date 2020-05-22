package io.github.muxiaobai.java.java.threadTest.base;

import java.util.concurrent.atomic.AtomicInteger;


public class SyncTest {
    private AtomicInteger j =new AtomicInteger();
    private volatile int i=0;
    // 同步方法
    public synchronized void incer(){
        i++;

    }
    // 同步代码块
    public  void decr(){
        synchronized (this) {
            i--;
        }
    }

    public static void main(String[] args) {
        Integer j = 0;
        System.out.println("j=" + (j--));
    }
}