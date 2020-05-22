package io.github.muxiaobai.java.objectsize;

import org.openjdk.jol.info.ClassLayout;

public class StaticSize {
    //static 不占用new Object 对象大小
    private static Integer si=1;
    private Integer i = 2;
    public static void main(String[] args) {
        print(ClassLayout.parseInstance(new StaticSize()).toPrintable());
        print(ClassLayout.parseInstance(StaticSize.class).toPrintable());

    }

    static void print(String message) {
        System.out.println(message);
        System.out.println("-------------------------");
    }
}
