package io.github.muxiaobai.java.java.threadTest.base;


/**
 * 测试指令重排序
 *
 * @author Zhang Pengfei
 * @date 2020/5/22/022 9:22
 */
public class PossibleReordering {
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
        Thread one = new Thread(() -> {
            a = 1;
            x = b;
        });

        Thread other = new Thread(() -> {
            b = 1;
            y = a;
        });
        one.start();
        other.start();
        one.join();
        other.join();
        String result = "第" + i + "次 (" + x + "," + y + "）";
        if(x == 0 && y == 0) {
            System.err.println(result);
            break;
        } else {
            System.out.println(result);
        }
        }
    }

    }