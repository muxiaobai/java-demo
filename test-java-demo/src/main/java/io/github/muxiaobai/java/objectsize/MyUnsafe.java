package io.github.muxiaobai.java.objectsize;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class MyUnsafe {
    private  int i=1;
    private String s="a";
    public static void main(String[] args) {
            Unsafe unsafe = null;
        try {
            Field singleoneInstanceField = Unsafe.class.getDeclaredField("theUnsafe");
            singleoneInstanceField.setAccessible(true);
            unsafe = (Unsafe)singleoneInstanceField.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Field[] fields = MyUnsafe.class.getDeclaredFields();
        for(Field f: fields){
            System.out.println(f.getName() + " offset: " +unsafe.objectFieldOffset(f));
        }
    }

}
