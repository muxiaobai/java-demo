package io.github.muxiaobai.algorithm.StatisticalLearning.DataMining_EM;

/**
 * EM期望最大化算法场景调用类
 * @author lyq
 *
 */
public class Client {
    public static void main(String[] args){
//        String filePath = "E:\\CourseExercises\\java\\ProjectTest\\src\\io.github.muxiaobai.algorithm\\StatisticalLearning\\DataMining_EM\\input.txt";
        String filePath = Client.class.getClassLoader().getResource("").getPath() + "\\io\\github\\muxiaobai" +
                "\\algorithm\\StatisticalLearning\\DataMining_EM\\input.txt";
//
        EMTool tool = new EMTool(filePath);
        tool.readDataFile();
        tool.exceptMaxStep();
    }
}
