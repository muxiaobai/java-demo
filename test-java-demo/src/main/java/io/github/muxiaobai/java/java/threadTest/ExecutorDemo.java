package io.github.muxiaobai.java.java.threadTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 全部出发，最终停止的时候再统计，终点，所有的线程都跑到终点结束
 */
public class ExecutorDemo {

    /*并发设置为1000*/
    private static final int nums = 10000;
    private static CountDownLatch countDownLatch = new CountDownLatch(nums);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Long start = System.currentTimeMillis();
        for (int i = 0; i < nums; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "开始执行");
                    Thread.sleep((long) (Math.random() * 100));
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完成");
                    /// latch 数减1
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        try {
            System.out.println("主线程" + Thread.currentThread().getName() + "等待子线程执行完成...");
            countDownLatch.await();//阻塞当前线程，直到计数器的值为0
            System.out.println("主线程" + Thread.currentThread().getName() + "开始执行...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));
    }
}
