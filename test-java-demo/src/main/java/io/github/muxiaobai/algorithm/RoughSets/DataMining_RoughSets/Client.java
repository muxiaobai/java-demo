package io.github.muxiaobai.algorithm.RoughSets.DataMining_RoughSets;

/**
 * 粗糙集约简算法
 * @author lyq
 *
 */
public class Client {
    public static void main(String[] args){
        String filePath = Client.class.getClassLoader().getResource("").getPath() + "\\io\\github\\muxiaobai" +
                "\\algorithm\\RoughSets\\DataMining_RoughSets\\input.txt";

        RoughSetsTool tool = new RoughSetsTool(filePath);
        tool.findingReduct();
    }
}
