package io.github.muxiaobai.java.jit;


public class jitTest {
    public volatile long sum = 0;

    public int add(int a, int b) {
        int temp = a + b;
        sum += temp;
        return temp;
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
     * @author  Zhang Pengfei
     * @date 2020/6/1/001 15:20
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        jitTest test = new jitTest();

        int sum = 0;

        for (int i = 0; i < 1000000; i++) {
            sum = test.add(sum, 1);
        }

        System.out.println("Sum:" + sum);
        System.out.println("Test.sum:" + test.sum);
    }
}
