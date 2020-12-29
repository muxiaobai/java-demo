package io.github.muxiaobai.java.RPC.HelloWorld;

/** 
 * 
 * @author zhang
 * @date  2016年9月9日 下午9:17:33
 *
 */

public class RPCServer {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
				    System.out.println("server listener at port : " + 8080);
					RPCExporter.exporter("localhost", 8080);
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		}).start();
	}
}
