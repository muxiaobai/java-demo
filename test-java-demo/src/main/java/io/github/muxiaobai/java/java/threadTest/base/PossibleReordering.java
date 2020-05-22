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
/**
很容易想到这段代码的运行结果可能为(1,0)、(0,1)或(1,1)，因为线程one可以在线程two开始之前就执行完了，也有可能反之，甚至有可能二者的指令是同时或交替执行的。

然而，这段代码的执行结果也可能是(0,0). 因为，在实际运行时，代码指令可能并不是严格按照代码语句顺序执行的。
得到(0,0)结果的语句执行过程，如下图所示。值得注意的是，a=1和x=b这两个语句的赋值操作的顺序被颠倒了，或者说，发生了指令“重排序”(reordering)。

 **/
    }