package io.github.muxiaobai.java.objectsize;

import org.openjdk.jol.info.ClassLayout;

public class DoubleArraySize {
    private int[] i = new int[2];
    private int[] j = new int[2];
    private long[] k = new long[2];

    public static void main(String[] args) {
        print(ClassLayout.parseInstance(new DoubleArraySize()).toPrintable());
        print(ClassLayout.parseInstance(DoubleArraySize.class).toPrintable());
        print(ClassLayout.parseClass(DoubleArraySize.class).toPrintable());

    }

    static void print(String message) {
        System.out.println(message);
        System.out.println("-------------------------");
    }
}
