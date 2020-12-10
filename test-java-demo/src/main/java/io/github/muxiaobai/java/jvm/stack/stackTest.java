package io.github.muxiaobai.java.jvm.stack;

/**
 * -X
 * -XX:+PrintFlagsFinal | findstr  Print
 * -XX:+PrintCommandLineFlags
 */
public class stackTest {
    public static void main(String[] args) {
        stackTest test = new stackTest();
        try {
            test.stack();
            // -Xss3m
        }catch (Throwable e){
            System.out.println(test.i);
        }
        //-XX:+HeapDumpOnOutOfMemoryError -verbosegc -Xms5m -Xmx5m
    }
    void stack(){
        i++;
        stack();
    }
    private int i =0;
}
