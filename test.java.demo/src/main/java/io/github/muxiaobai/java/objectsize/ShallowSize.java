package io.github.muxiaobai.java.objectsize;

public class ShallowSize {
    private static class ObjectC {
        ObjectD[] array = new ObjectD[2];
        //array有没有设置值两种情况
        public ObjectC(){
            array[0] = new ObjectD();
            array[1] = new ObjectD();
        }
    }

    private static class ObjectD {
        int value;
    }

    public static void main(String[] args) throws IllegalAccessException {
        final ShallowTool shallowTool = new ShallowTool();
        arr(shallowTool);
        string(shallowTool);

    }
    private static  void  arr(ShallowTool shallowTool){
        try {
            ObjectInfo res = shallowTool.introspect(new ObjectC());
            System.out.println( res.getDeepSize() );
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    /**
     https://blog.csdn.net/antony9118/article/details/54317637

     我们可以手工计算一下ObjectC obj = new ObjectC()的大小：

     ObjectC的Shallow size = 8(_mark) + 4(oop指针) + 4(ObjectD[]引用) = 16

     new ObjectD[2]数组的长度 = 8(_mark) + 4(oop指针) + 4(数组长度占4个字节) + 4(ObjectD[0]引用) + 4(ObjectD[1]引用) = 24

     由于ObjectD[]数组没有指向具体的对象大小，所以我们手工计算的结果是16 + 24 = 40


*****************************************************************************
     public ObjectC(){
         array[0] = new ObjectD();
         array[1] = new ObjectD();
     }

     我们可以手工计算一下ObjectC obj = new ObjectC()的大小：
     ObjectC的Shallow size = 8(_mark) + 4(oop指针) + 4(ObjectD[]引用) = 16
     new ObjectD[2]数组的长度 = 8(_mark) + 4(oop指针) + 4(数组长度占4个字节) + 4(ObjectD[0]引用) + 4(ObjectD[1]引用) = 24
     ObjectD对象长度 = 8(_mark) + 4(oop指针) + 4(value) = 16
     所以ObjectC实际占用的空间 = 16 + 24 + 2 * 16 = 72

     **/
    private static  void string(ShallowTool shallowTool){
        ObjectInfo res = null;
        try {
            res = shallowTool.introspect(new JOLPeople());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println( res.getDeepSize() );
    }
}