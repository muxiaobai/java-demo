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
/**
 E:\tools\Java\jdk1.8.0_171\bin\java.exe -Dvisualvm.id=1128905792434003 "-javaagent:E:\Program Files\JetBrains\IntelliJ IDEA 2019.1.2\lib\idea_rt.jar=55803:E:\Program Files\JetBrains\IntelliJ IDEA 2019.1.2\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Administrator\AppData\Local\Temp\classpath2004274150.jar io.github.muxiaobai.java.objectsize.DoubleArraySize
 io.github.muxiaobai.java.objectsize.DoubleArraySize object internals:
 OFFSET  SIZE     TYPE DESCRIPTION                               VALUE
 0     4          (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
 4     4          (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
 8     4          (object header)                           05 c1 00 f8 (00000101 11000001 00000000 11111000) (-134168315)
 12     4    int[] DoubleArraySize.i                         [0, 0]
 16     4    int[] DoubleArraySize.j                         [0, 0]
 20     4   long[] DoubleArraySize.k                         [0, 0]
 Instance size: 24 bytes
 Space losses: 0 bytes internal + 0 bytes external = 0 bytes total

 -------------------------
 java.lang.Class object internals:
 OFFSET  SIZE                                              TYPE DESCRIPTION                               VALUE
 0     4                                                   (object header)                           01 5a 24 31 (00000001 01011010 00100100 00110001) (824465921)
 4     4                                                   (object header)                           7f 00 00 00 (01111111 00000000 00000000 00000000) (127)
 8     4                                                   (object header)                           df 03 00 f8 (11011111 00000011 00000000 11111000) (-134216737)
 12     4                     java.lang.reflect.Constructor Class.cachedConstructor                   null
 16     4                                   java.lang.Class Class.newInstanceCallerCache              null
 20     4                                  java.lang.String Class.name                                (object)
 24     4                                                   (alignment/padding gap)
 28     4                       java.lang.ref.SoftReference Class.reflectionData                      (object)
 32     4   sun.reflect.generics.repository.ClassRepository Class.genericInfo                         null
 36     4                                java.lang.Object[] Class.enumConstants                       null
 40     4                                     java.util.Map Class.enumConstantDirectory               null
 44     4                    java.lang.Class.AnnotationData Class.annotationData                      (object)
 48     4             sun.reflect.annotation.AnnotationType Class.annotationType                      null
 52     4                java.lang.ClassValue.ClassValueMap Class.classValueMap                       null
 56    32                                                   (alignment/padding gap)
 88     4                                               int Class.classRedefinedCount                 0
 92   412                                                   (loss due to the next object alignment)
 Instance size: 504 bytes
 Space losses: 36 bytes internal + 412 bytes external = 448 bytes total

 -------------------------
 io.github.muxiaobai.java.objectsize.DoubleArraySize object internals:
 OFFSET  SIZE     TYPE DESCRIPTION                               VALUE
 0    12          (object header)                           N/A
 12     4    int[] DoubleArraySize.i                         N/A
 16     4    int[] DoubleArraySize.j                         N/A
 20     4   long[] DoubleArraySize.k                         N/A
 Instance size: 24 bytes
 Space losses: 0 bytes internal + 0 bytes external = 0 bytes total

 -------------------------

 Process finished with exit code 0

  **/