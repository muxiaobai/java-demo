package io.github.muxiaobai.java.java.threadTest;

import java.util.concurrent.*;

/**
 * 等待，所有的线程在1，await等待，直到 最后一个await到0 一起出发
 * 发令枪
 */
public class CyclicBarrierDemo {

    /*并发设置为1000*/
    private static final int nums = 1000;

    private static  CyclicBarrier cyclicBarrier = new CyclicBarrier(nums + 1);

    public static void main(String[] args) {

        Long start = System.currentTimeMillis();
        for (int i = 0; i < nums; i++) {
            new Thread(() -> {
                try {
                    System.out.println("1,run:" + Thread.currentThread().getName());

                    cyclicBarrier.await();
                    /// 都在这里等着，所有的执行完了再开始执行
                    System.out.println("2,run:" + Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
