package io.github.muxiaobai.java.java.construtorTest;

/**
 * 
 * @author zhang
 * @date 2016年7月22日 下午4:06:24
 *
 */

public class ConstrutorTest {
	static{
		System.out.println("construtortest");
	}
	public static void main(String[] args) {
		new Man();
	}
}
class Person{
	private int age;
	private String name;
	static{
		System.out.println("static");
	}
	public Person() {
		System.out.println("person");
		System.out.println("age:"+age);
		System.out.println("name:"+name);
	}
	public void say(){
	}
}
class Man extends Person{
	public Man() {
		System.out.println("man");
	}
}