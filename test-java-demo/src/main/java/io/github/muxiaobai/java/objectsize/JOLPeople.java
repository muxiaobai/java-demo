package io.github.muxiaobai.java.objectsize;


import org.openjdk.jol.info.ClassLayout;

public class JOLPeople {
    int age = 20;
    String name = "Xiaoming";
    public static void main(String[] args) {
        print(ClassLayout.parseInstance(new JOLPeople()).toPrintable());

        print(ClassLayout.parseInstance(new String("Xiaoming")).toPrintable());
        char[] chars = new char[8];
        chars[0] = 'X';
        chars[1] = 'i';
        chars[2] = 'a';
        chars[3] = 'o';
        chars[4] = 'm';
        chars[5] = 'i';
        chars[6] = 'n';
        chars[7] = 'g';

        print(ClassLayout.parseInstance(chars).toPrintable());
    }

    static void print(String message) {
        System.out.println(message);
        System.out.println("-------------------------");
    }
}


/***************************************************************************/
/**
JOLPeople 本身
 -------------------------
 io.github.muxiaobai.java.objectsize.JOLPeople object internals:
 OFFSET  SIZE               TYPE DESCRIPTION                               VALUE
 0     4                    (object header)                           05 00 00 00 (00000101 00000000 00000000 00000000) (5)
 4     4                    (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
 8     4                    (object header)                           af f3 00 f8 (10101111 11110011 00000000 11111000) (-134155345)
 12     4                int JOLPeople.age                             20
 16     4   java.lang.String JOLPeople.name                            (object)
 20     4                    (loss due to the next object alignment)
 Instance size: 24 bytes
 Space losses: 0 bytes internal + 4 bytes external = 4 bytes total

 -------------------------
 -------------------------
 _mark +oop  + 4(age的value)+ 4(name引用)
 8     + 4   +  4            +4          + 4(lose) =  24

 String 是一个char[] 数组 和hash 两个属性

 The value is used for character storage.
private final char value[];

 Cache the hash code for the string
private int hash; // Default to 0

String

 -------------------------
 java.lang.String object internals:
 OFFSET  SIZE     TYPE DESCRIPTION                               VALUE
 0     4          (object header)                           05 00 00 00 (00000101 00000000 00000000 00000000) (5)
 4     4          (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
 8     4          (object header)                           da 02 00 f8 (11011010 00000010 00000000 11111000) (-134216998)
 12     4   char[] String.value                              []
 16     4      int String.hash                               0
 20     4          (loss due to the next object alignment)
 Instance size: 24 bytes
 Space losses: 0 bytes internal + 4 bytes external = 4 bytes total

 -------------------------
 _mark +oop  + 引用(char[])+ hash
 8     + 4   +  4            4 + lose =  24



 char[]数组


 -------------------------
 [C object internals:
 OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
 0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
 4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
 8     4        (object header)                           41 00 00 f8 (01000001 00000000 00000000 11111000) (-134217663)
 12     4        (object header)                           08 00 00 00 (00001000 00000000 00000000 00000000) (8)
 16    16   char [C.<elements>                             N/A
 Instance size: 32 bytes
 Space losses: 0 bytes internal + 0 bytes external = 0 bytes total

 -------------------------

 _mark +oop + 数组长度 + 实际数据
 8     + 4   +  4     + 8(arrLength) * 2(char) =  32


 我们可以手工计算一下JOLPeople obj = new JOLPeople()的大小：
 JOLPeople的Shallow size = 8(_mark) + 4(oop指针) +  4(age的value)+ 4(name引用) + 4(lose) = 24
 String对象的长度 = 8(_mark) + 4(oop指针) + 4(char[8]引用) +4(hash) +4(lose) =  24
 char[]对象长度 =  8(_mark) + 4(oop指针) +  4(数组长度占4个字节) + 8*2(value) = 32
 所以JOLPeople实际占用的空间 = 24 + 24 + 32 = 80



**/