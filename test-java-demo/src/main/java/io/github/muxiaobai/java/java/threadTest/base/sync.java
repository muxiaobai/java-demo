package io.github.muxiaobai.java.java.threadTest.base;

import org.openjdk.jol.info.ClassLayout;

import java.io.IOException;

public class sync{
    private  static  sync classSync = new sync();
    public void f() {
        Object hollis = new Object();
        synchronized(hollis) {
            System.out.println("无效的 synchronized，每一次进来都是 new 的对象");
            System.out.println(hollis);
            System.out.println(ClassLayout.parseInstance(this).toPrintable());
        }
    }
    public void doSth(){
        synchronized (classSync){
            System.out.println("test Synchronized 锁的是 private classSync对象 因此classSync会标记，this不会被标记" );
            System.out.println(ClassLayout.parseInstance(classSync).toPrintable());
            System.out.println(ClassLayout.parseInstance(this).toPrintable());

        }
        synchronized (sync.class){
            System.out.println("test Synchronized 锁的是 class对象 因此this不会标记" );
            System.out.println(ClassLayout.parseInstance(this).toPrintable());
            System.out.println(ClassLayout.parseInstance(sync.this).toPrintable());
        }

        synchronized (this){
            System.out.println("test Synchronized 锁的是调用的对象 因此this会标记，指向 main 的sync" );
            System.out.println(ClassLayout.parseInstance(this).toPrintable());
        }
    }
    public synchronized void doSth1(){
        System.out.println("test Synchronized method，sync调用这个方法，方法上的，会锁this对象 ，也就是main方法中 new的sync" );
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
    }
    /**
     *  mvn exec: java
     * -server
     * -XX:+UnlockDiagnosticVMOptions
     * -XX:+TraceClassLoading
     * -XX:+LogCompilation
     * -XX:LogFile=mylogfile.log
     * -XX:+PrintAssembly
     * -XX:+TraceClassLoading
     *
     * 会被JIT：
     * 1、被多次调用的方法。
     * 2、被多次执行的循环体。
     * 那么一段代码需要执行多少次才会触发JIT优化呢？通常这个值由-XX:CompileThreshold参数进行设置：
     * 1、使用client编译器时，默认为1500；
     * 2、使用server编译器时，默认为10000；
     * -XX:CompileThreshold=10 运行10次就JIT
     *
     *  *-XX:-TieredCompilation
     level 0 - interpreter
     level 1 - C1 with full optimization (no profiling)
     level 2 - C1 with invocation and backedge counters
     level 3 - C1 with full profiling (level 2 + MDO)
     level 4 - C2

     *     intx Tier2CompileThreshold                     = 0                                   {product}
     *      intx Tier3CompileThreshold                     = 2000                                {product}
     *      intx Tier4CompileThreshold                     = 15000                               {product}
     *      bool TieredCompilation                         = true

     * -XX:-DoEscapeAnalysis   关闭逃逸分析  栈上的对象不会被
     *
     * 当触发某方法或某代码块的优化时，先将其放入编译队列，然后由编译线程进行编译，
     * 编译之后的代码放在CodeCache中，CodeCache的大小也是有限的，
     * 通过-XX:-BackgroundCompilation 参数可以关闭异步编译
     *
     * @author  Zhang Pengfei
     * @date 2020/6/1/001 15:20
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        sync sync = new sync();
        sync.f();
        sync.f();
        sync.doSth();
        sync.doSth1();
        for (int i = 0; i < 10000; i++) {
            sync.f();
            sync.doSth();
        }

        System.out.println(ClassLayout.parseInstance(sync).toPrintable());
//        try {
//            System.in.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
