package io.github.muxiaobai.java.RPC.HelloWorld;

/** 
 * 
 * @author zhang
 * @date  2016年9月9日 下午9:00:16
 *
 */

public class EchoServiceImpl implements EchoService {

	@Override
	public String echo(String ping) {
		return ping!=null?ping+"--->I am ok!":"I am ok.";
	}

}
