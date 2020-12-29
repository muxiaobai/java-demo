/**
 * Project Name:ProjectTest
 * File Name:HeapDump.java
 * Package Name:io.github.muxiaobai.java.java.memoryTest
 * Date:2017年11月22日下午3:16:20
 * Copyright (c) 2017, All Rights Reserved.
 *
*/

package io.github.muxiaobai.java.java.memoryTest;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:HeapDump
 * Function: TODO ADD FUNCTION.
 * Reason:	 TODO ADD REASON.
 * @date    2017年11月22日 下午3:16:20
 * @author   Mu Xiaobai
 * @version  1.8
 * @since    JDK 1.8
 */
public class HeapDump {
        public static void main(String[] args) {  
            List<User> persons = new ArrayList<User> ();  
            while( 1>0){  
                persons.add( new User("liuhai","male",25));  
            }  
        }  
}
class User {  
    private String name;  
    private String sex;  
    private int age;  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public String getSex() {  
        return sex;  
    }  
    public void setSex(String sex) {  
        this.sex = sex;  
    }  
    public int getAge() {  
        return age;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  
    public User( String name,String sex,int age){  
        this.name=name;  
        this.sex=sex;  
        this.age=age;  
    }  
}  

