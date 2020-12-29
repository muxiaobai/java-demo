package io.github.muxiaobai.java.java.stringTest;

import java.util.Random;

/** 
 * 
 * @author zhang
 * @date  2016年9月17日 上午8:08:15
 *
 */

public class FuoZu {
	    public static void main(String ... args) {
	        System.out.println(randomString(-229985452)+' '+randomString(-147909649));
	    }

	    public static String randomString(int seed) {
	        Random rand = new Random(seed);
	        StringBuilder sb = new StringBuilder();
	        while(true) {
	            int n = rand.nextInt(27);
	            if (n == 0) break;
	            sb.append((char) ('`' + n));
	        }
	        return sb.toString();
	    }
}

	

