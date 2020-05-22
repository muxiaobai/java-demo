package io.github.muxiaobai.java.objectsize;

import io.github.muxiaobai.java.objectsize.JOLPeople;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;


public class JOLSize {
    public static void main(String[] args) {
//        print("size:"+inst.getObjectSize(people));
//        print(String.valueOf(SizeTool.getObjectSize(people)));
//        //计算指定对象及其引用树上的所有对象的综合大小，单位字节
//        print(String.valueOf(RamUsageEstimator.sizeOfObject(new Object())));
//        //计算指定对象本身在堆空间的大小，单位字节
//        print(String.valueOf(RamUsageEstimator.shallowSizeOf(people)));
        JOLSize demo = new JOLSize();
        //查看对象外部信息
        print(GraphLayout.parseInstance(demo).toPrintable());
        //查看对象内部信息
        print(ClassLayout.parseInstance(demo).toPrintable());
        //获取对象总大小
        print("size : " + GraphLayout.parseInstance(demo).totalSize());

        print(ClassLayout.parseClass(Object.class).toPrintable());
        print(ClassLayout.parseInstance(new Object()).toPrintable());
        print(ClassLayout.parseInstance(Object.class).toPrintable());

        print(ClassLayout.parseInstance(new char[8]).toPrintable());
        print(ClassLayout.parseInstance(new String()).toPrintable());

        print(ClassLayout.parseInstance(new int[2]).toPrintable());
        print(ClassLayout.parseInstance(new Integer(1)).toPrintable());
        print(ClassLayout.parseInstance(new String[5]).toPrintable());
        print(ClassLayout.parseInstance(new Object[5]).toPrintable());
        print(ClassLayout.parseInstance(new HashMap()).toPrintable());
        print(ClassLayout.parseInstance(new ConcurrentHashMap<>()).toPrintable());
        System.gc();
    }

    static void print(String message) {
        System.out.println(message);
        System.out.println("-------------------------");
    }
}
