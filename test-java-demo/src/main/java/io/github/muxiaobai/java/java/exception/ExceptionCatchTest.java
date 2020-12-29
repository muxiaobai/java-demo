package io.github.muxiaobai.java.java.exception;

import java.io.File;
import java.io.InputStream;

/**
 * 
 * @author zhang
 * @date 2016年7月20日 下午1:59:25
 *
 */

public class ExceptionCatchTest {
	public static void main(String[] args)  {
		ExceptionCatchTest exceptionTest=new ExceptionCatchTest();
			System.out.println(exceptionTest.value());
	}
	public Integer value() {
		Integer ret = 0;
		try {
			//ret=1/0;
			return ret;
		}catch (Exception e) {
			ret = 3;
			System.out.println("catch:"+ret);
			return ret;
		} finally {
			ret = 2;
			System.out.println("finally:"+ret);
		}
	}
}
