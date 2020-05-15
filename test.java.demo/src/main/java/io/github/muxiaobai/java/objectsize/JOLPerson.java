package io.github.muxiaobai.java.objectsize;


public class JOLPerson {
    boolean married = false;
    long birthday = 128902093242L;
    char tag = 'c';
    int[] i = new int[2];
    double sallary = 1200.00d;
    String string = new String();
    Object object = new Object();
    Object[] objects = new Object[10];

    private static class ObjectC {
        ObjectD[] array = new ObjectD[2];
    }

    private static class ObjectD {
        int value;
    }
}
