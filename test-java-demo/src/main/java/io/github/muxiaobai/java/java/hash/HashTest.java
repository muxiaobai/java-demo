package io.github.muxiaobai.java.java.hash;

/** 
 * 
 * @author zhang
 * @date  2016年7月21日 下午4:57:38
 *
 */

public class HashTest {
	public static void main(String[] args) {
		//Object native
		//String
		String str="abc";
		//a.hash=(31*0+97); a的ASCII为97
		//ab.hash=((31*0+97)*1+98);
		//abc.hash=(((31*0+97)*1+98)*2+99)
		System.out.println(str.hashCode());
	}

	
}
