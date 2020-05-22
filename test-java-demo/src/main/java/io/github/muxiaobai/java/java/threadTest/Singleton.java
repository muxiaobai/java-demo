package io.github.muxiaobai.java.java.threadTest;


public class Singleton {
    private static volatile   Singleton singleton= null;
    private int i = 8;
    private Singleton(){
    }
    /**
     *  单例返回  DCL  //Double Check Lock
     * @author  Zhang Pengfei
     * @date 2020/5/21/021 20:49
     * @param
     * @return io.github.muxiaobai.java.java.threadTest.Singleton
     */
    public static Singleton  getInstance(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
/*
1        new 分配空间 i=0;
2        invokespecial 赋值，基本成员变量  i = 8;
3        astore 添加指向

   2 ，3 指令重排序 singleton 不等于null ，但是i=0；所以添加volatile
*/
singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println("hashcode"+Singleton.getInstance().hashCode());
            }).start();
        }
    }
}
