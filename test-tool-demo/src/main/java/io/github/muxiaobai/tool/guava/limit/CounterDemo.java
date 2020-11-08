package io.github.muxiaobai.tool.guava.limit;


public class CounterDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                if (grant()) {
                    System.out.println("ok");
                } else {
                    System.out.println("fail");
                }
            }).start();
        }
    }

    public static long timeStamp = System.currentTimeMillis();
    public static long limitCount = 100;

    private static boolean grant() {
        long now = System.currentTimeMillis();
        if (now < timeStamp) {
            return true;
        }
        return false;
    }

}
