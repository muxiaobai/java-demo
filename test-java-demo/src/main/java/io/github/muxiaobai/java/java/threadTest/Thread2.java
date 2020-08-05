package io.github.muxiaobai.java.java.threadTest;

/**
 * 线程不安全
 *
 * @author zhang
 * @Date 2016年7月23日 上午11:24:34
 * @doing
 */
public class Thread2 {
    public void m4t1() {
        synchronized (this) {
            int i = 10;
            while (i-- > 0) {

                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }

    public void m4t2() {
        int i = 10;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) {
        final Thread2 myt2 = new Thread2();
        Thread t1 = new Thread(() -> {
            myt2.m4t1();
        }, "t1");
        Thread t2 = new Thread(() -> {
            myt2.m4t2();
        }, "t2");
        t1.start();
        t2.start();
    }
}