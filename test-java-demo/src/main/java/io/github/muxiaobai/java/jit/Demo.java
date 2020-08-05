package io.github.muxiaobai.java.jit;


import java.util.ArrayList;

/**
 * -Djava.compiler=NONE  不编译
 * 第二次比第一此运行快
     first forEach:47
     second forEach:2
     first for:5
     second for :10
 但是for 不会

 参数：
 * # 输出jvm载入类的相关信息
 -verbose:class

 # 输出native方法调用的相关情况
 -verbose:jni

 # 输出每次GC的相关情况
 -verbose:gc

 # 当一个方法被编译时打印相关信息
 -XX:+PrintCompilation

 -verbose:class -verbose:jni -verbose:gc -XX:+PrintCompilation
 * */
public class Demo {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(Math.random() * 100);
        }
        System.out.println("first forEach:" + getForEachTime(list));
        System.out.println("second forEach:" + getForEachTime(list));
        System.out.println("first for:" + getForTime(list));
        System.out.println("second for :" + getForTime(list));
    }

    private static Long getForEachTime(ArrayList<Object> list) {
        Long start = System.currentTimeMillis();
        list.forEach(ob -> {

        });
        Long end = System.currentTimeMillis();
        return end - start;
    }
    private static Long getForTime(ArrayList<Object> list) {
        Long start = System.currentTimeMillis();
       for (Object o:list){}
        Long end = System.currentTimeMillis();
        return end - start;
    }

}
