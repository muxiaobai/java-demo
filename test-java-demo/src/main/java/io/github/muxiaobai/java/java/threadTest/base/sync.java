package io.github.muxiaobai.java.java.threadTest.base;

public class sync{
        public void f() {
            Object hollis = new Object();
            synchronized(hollis) {
                System.out.println(hollis);
            }
        }
    public synchronized void doSth1(){
        System.out.println("test Synchronized method" );
    }
    public void doSth(){
        synchronized (sync.class){
            System.out.println("test Synchronized" );
        }
    }

    public static void main(String[] args) {
            
        sync sync = new sync();
        sync.f();
        sync.f();
        sync.doSth();
    }
}
