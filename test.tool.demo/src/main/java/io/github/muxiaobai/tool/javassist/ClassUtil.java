package io.github.muxiaobai.tool.javassist;
import javassist.*;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.StringMemberValue;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassUtil {

    public static void main(String[] args) {
        Map map = new HashMap();
        generateClazz("name",map,true);
    }
    private static Pattern LinePattern = Pattern.compile("_(\\w)");
    public static Pattern PointPattern = Pattern.compile(".([a-z|A-Z])");

    /** 其它转驼峰 _下划线 ，.点 */
    public static String patternToHump(Pattern pattern,String str) {
        str = str.toLowerCase();
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
    /**
     *  生成Class类文件
     * @author  Zhang Pengfei
     * @date 2020/1/20/020 17:21
     * @param name clazz文件名
     * @param maps 字段和字段类型
     * @param  everyNewFlag
     * @return java.lang.Class
     */
    public static Class generateClazz(String name, Map<String,String> maps,Boolean everyNewFlag) {
        String className  =patternToHump(LinePattern,name);
        Class javaClazz = null;
        String packageClassName = "test.tool.demo.vo." + className;
        //是否每次都是用new Class
        if(!everyNewFlag){
            try {
                javaClazz = Class.forName("test.tool.demo.vo."+className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if(javaClazz!=null){
            return  javaClazz;
        }
        try {
            ClassPool pool = ClassPool.getDefault();
            pool.appendClassPath(new LoaderClassPath(pool.getClassLoader()));
            CtClass clazz = pool.makeClass(packageClassName);
            clazz.stopPruning(true);
            if(clazz.isFrozen()){
                clazz.defrost();
            }
            //为ctClass设置一个父类
            clazz.setSuperclass(pool.get("java.lang.Object"));

            ClassFile ccFile = clazz.getClassFile();
            ConstPool constPool = ccFile.getConstPool();

            // 添加类注解

                AnnotationsAttribute bodyAttr = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
                Annotation bodyAnnot = new Annotation("org.springframework.data.elasticsearch.annotations.Document", constPool);
                bodyAnnot.addMemberValue("indexName", new StringMemberValue(index, constPool));
                bodyAnnot.addMemberValue("type", new StringMemberValue(index, constPool));
                bodyAttr.addAnnotation(bodyAnnot);
                ccFile.addAttribute(bodyAttr);

            CtConstructor constructor = new CtConstructor(new CtClass[]{}, clazz);
            //制造构造函数
            //为构造函数设置函数体
            StringBuffer buffer = new StringBuffer();
            buffer.append("{ }");
            constructor.setBody(buffer.toString());

            //将构造函数添加到新类中
            clazz.addConstructor(constructor);

            //添加字段
            addFields(pool,clazz,maps);
//            javaClazz = clazz.toClass(new MyClassLoader());ClassLoader.getSystemClassLoader()
            javaClazz = clazz.toClass();
            //用完就把pool 中的CtClass删除掉
            clazz.detach();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  javaClazz;
    }
    /**
     *  添加字段
     * @author  Zhang Pengfei
     * @date 2020/1/20/020 17:22
     * @param pool	 classpool
     * @param clazz	 clazz文件
     * @param maps	 对应的字段和类型
     * @return void
     */
    private  static  void  addFields(ClassPool pool,CtClass clazz,Map<String,String> maps)throws  Exception{
        Iterator<Map.Entry<String,String>> iterator =maps.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,String> entry = (Map.Entry) iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            CtField ctFieldOne = new CtField(pool.get(value), key, clazz);
            ctFieldOne.setModifiers(Modifier.PRIVATE);
//            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
            if(FieldType.DATE.getJavaClazz()==value) {
                ClassFile ccFile = clazz.getClassFile();
                ConstPool constPool = ccFile.getConstPool();
                // 日期添加属性注解
                AnnotationsAttribute fieldAttr = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
                Annotation fieldAnnot = new Annotation("com.fasterxml.jackson.annotation.JsonFormat", constPool);
                fieldAnnot.addMemberValue("pattern", new StringMemberValue("yyyy-MM-dd HH:mm:ss", constPool));
                fieldAnnot.addMemberValue("timezone", new StringMemberValue("GMT+8", constPool));
                fieldAttr.addAnnotation(fieldAnnot);
                ctFieldOne.getFieldInfo().addAttribute(fieldAttr);
            }

            clazz.addField(ctFieldOne);
            clazz.addMethod(CtNewMethod.getter("get" + key.substring(0,1).toUpperCase().concat(key.substring(1)), ctFieldOne));
            clazz.addMethod(CtNewMethod.setter("set" + key.substring(0,1).toUpperCase().concat(key.substring(1)), ctFieldOne));
        }
    }

}