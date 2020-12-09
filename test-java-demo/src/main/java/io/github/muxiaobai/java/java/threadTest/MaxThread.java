package io.github.muxiaobai.java.java.threadTest;

/**
 * 最大线程
 *  设置虚拟机参数   -Xms2m -Xmx2m
 *  1M   1557
 *  2M
 * @author zhang
 * @Date 2016年7月23日 上午11:24:34
 * @doing
 */
public class MaxThread {

    public static Object o = new Object();
    private static int count=0;
    public static void main(String[] args) {
        for (;;){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (o){
                        count+=1;
                        System.out.println(count);
                    }
                    for (;;){
                        try {
                            Thread.sleep(1000);
                        }catch (Exception e){
                            System.out.println(e);
                        }
                    }
                }
            }).start();
        }
    }
}