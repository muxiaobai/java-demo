# java 基础深入研究

## java java基础

## jvm 参数展示
 ### heap
 ### stack 有多少栈帧大小

## objectsize jol展示对象大小

### Object 大小 Array[] 大小

- (两种计算Java对象大小的方法)[https://blog.csdn.net/antony9118/article/details/54317637]
- (计算Java对象内存大小)[https://www.cnblogs.com/E-star/p/10222250.html]
- (java如何获取一个对象的大小)[https://www.cnblogs.com/Kidezyq/p/8030098.html]

`jps -l` 查pid
`jmap -histo pid| grep ''| sort -nrk 2 | head -20`

验证线上对象的大小
```
             对象个数   对象总大小   对象名称
 num     #instances         #bytes  class name
Total       2388961      117489272
   1:        183849       25630384  [I
   2:        243630       18343336  [C
   3:        275254        8808128  java.util.HashMap$Node
   4:         69481        6626360  [Ljava.util.HashMap$Node;
   5:        211357        5072568  java.lang.String
   6:        169498        4081344  [Lcom.hankcs.hanlp.corpus.tag.Nature;
   7:        169497        4067928  com.hankcs.hanlp.dictionary.CoreDictionary$Attribute
   8:         65450        4016832  [Ljava.lang.Object;
   9:         39345        3462360  java.lang.reflect.Method
  10:          9229        3267984  [B
  11:         61250        2940000  java.util.HashMap
  12:         91340        2922880  java.util.concurrent.ConcurrentHashMap$Node
  13:         21040        2333976  java.lang.Class
  14:           919        1552064  [J
  15:         35250        1410000  java.util.TreeMap$Entry
  16:         33116        1324640  java.util.LinkedHashMap$Entry
  17:         48196        1156704  java.util.ArrayList
  18:         22768        1092864  java.util.TreeMap
  19:           754         960368  [Ljava.util.concurrent.ConcurrentHashMap$Node;
```


对象缩写类型	对象真实类型
- B 	byte
- C 	char
- D 	double
- F 	float
- I 	int
- J 	long
- Z 	boolean
- [ 	数组，如[I表示int[]
- [L+类名 	其他对象
- [B byte[]
- [C char[]
- [J long[]
- [I int[] 
- [Ljava.lang.Object;   Object[]

拿第五行，String来看一下:5072568/211357 = 24  一个String对象本身大小24字节 24bytes

## jit 即时编译

mvn  exec:java

运行加参数：

-server 
-XX:+UnlockDiagnosticVMOptions
-XX:+TraceClassLoading
-XX:+LogCompilation
-XX:LogFile=mylogfile.log
-XX:+PrintAssembly
-XX:+TraceClassLoading



https://github.com/AdoptOpenJDK/jitwatch.git



