package io.github.muxiaobai.java.java.construtorTest;

/**
 * @author muxiaobai
 * @date 2020/1/6/006 17:49
 * null 对象可以调用静态方法，实际上是class对象调用的test1()
 */
public class NullTest {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        NullTest nullTest = null;

        // hello
        nullTest.test1("hello");
    }

    private static void test1(String text) {
        System.out.println(text);
    }
}