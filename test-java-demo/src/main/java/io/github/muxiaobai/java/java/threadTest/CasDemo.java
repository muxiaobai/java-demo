package io.github.muxiaobai.java.java.threadTest;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;


public class CasDemo {
    public static void main(String[] args) throws InterruptedException {
        CasDemo demo = new CasDemo();
        //CAS 问题： CompareAndSweap
        //循环开销
        //对象原子性 对象
        AtomicReference atomicReference = new AtomicReference<>(demo);
        //ABA问题 加版本号是1的时候变为2 才能更新成功
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(demo, 1);
        atomicStampedReference.compareAndSet(demo, demo, 1, 2);
}

}
