package io.github.muxiaobai.java.java.threadTest.base;

public class volatileTest {
    public static volatile boolean stop = false ;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            int i=0;
            while (!stop){
                i++;
            }
            System.out.println(i);
        });
        thread.start();
        System.out.println("begin start thread");
        Thread.sleep(1000);
        stop = true;
    }
}