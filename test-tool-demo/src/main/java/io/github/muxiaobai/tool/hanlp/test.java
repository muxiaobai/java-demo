package io.github.muxiaobai.tool.hanlp;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;

import java.util.List;

/**
 * @author Zhang Pengfei
 * @version V1.0
 * @PROJECT_NAME java-demo
 * @Package io.github.muxiaobai.tool.hanlp
 * @date 2020/8/3/003 10:51
 * @短语提取，
 * @Copyright © 2000-2019 Xi'an Webber Software. All Rights Reserved.
 */
public class test {
    /**
     * 短语提取
     *
     * @param
     * @return
     * @author Zhang Pengfei
     * @date 2020/1/20/020 14:57
     */
    public static void extractPhrase() {
        String text = "算法工程师\n" +
                "算法（Algorithm）是一系列解决问题的清晰指令，也就是说，能够对一定规范的输入，在有限时间内获得所要求的输出。" +
                "如果一个算法有缺陷，或不适合于某个问题，执行这个算法将不会解决这个问题。不同的算法可能用不同的时间、" +
                "空间或效率来完成同样的任务。一个算法的优劣可以用空间复杂度与时间复杂度来衡量。算法工程师就是利用算法处理事物的人。\n" +
                "\n" +
                "1职位简介\n" +
                "算法工程师是一个非常高端的职位；\n" +
                "专业要求：计算机、电子、通信、数学等相关专业；\n" +
                "学历要求：本科及其以上的学历，大多数是硕士学历及其以上；\n" +
                "语言要求：英语要求是熟练，基本上能阅读国外专业书刊；\n" +
                "必须掌握计算机相关知识，熟练使用仿真工具MATLAB等，必须会一门编程语言。\n" +
                "\n" +
                "2研究方向\n" +
                "视频算法工程师、图像处理算法工程师、音频算法工程师 通信基带算法工程师\n" +
                "\n" +
                "3目前国内外状况\n" +
                "目前国内从事算法研究的工程师不少，但是高级算法工程师却很少，是一个非常紧缺的专业工程师。" +
                "算法工程师根据研究领域来分主要有音频/视频算法处理、图像技术方面的二维信息算法处理和通信物理层、" +
                "雷达信号处理、生物医学信号处理等领域的一维信息算法处理。\n" +
                "在计算机音视频和图形图像技术等二维信息算法处理方面目前比较先进的视频处理算法：机器视觉成为此类算法研究的核心；" +
                "另外还有2D转3D算法(2D-to-3D conversion)，去隔行算法(de-interlacing)，运动估计运动补偿算法" +
                "(Motion estimation/Motion Compensation)，去噪算法(Noise Reduction)，缩放算法(scaling)，" +
                "锐化处理算法(Sharpness)，超分辨率算法(Super Resolution),手势识别(gesture recognition),人脸识别(face recognition)。\n" +
                "在通信物理层等一维信息领域目前常用的算法：无线领域的RRM、RTT，传送领域的调制解调、信道均衡、信号检测、网络优化、信号分解等。\n" +
                "另外数据挖掘、互联网搜索算法也成为当今的热门方向。\n" +
                "算法工程师逐渐往人工智能方向发展。";
//        text="信物理层等一维信息领域目前常用的算法：无线领域的RRM、RTT，传送;";
        System.out.println(HanLP.extractKeyword(text, 5));
        System.out.println(HanLP.extractPhrase(text, 5));
    }
    public static void test1() {
//        System.out.println(new File("").getAbsolutePath());
//        System.out.println(new File(HanLP.Config.CoreDictionaryTransformMatrixDictionaryPath).exists());
        HanLP.Config.enableDebug(true);
//
        String[] testCase = new String[]{
                "签约仪式前，秦光荣、李纪恒、仇和等一同会见了参加签约的企业家。",
                "王国强、高峰、汪洋、张朝阳光着头、韩寒、小四",
                "张浩和胡健康复员回家了",
                "王总和小丽结婚了",
                "编剧邵钧林和稽道青说",
                "这里有关天培的有关事迹",
                "龚学平等领导,邓颖超生前",
        };
        HanLP.extractKeyword(testCase[0],10);
        Segment segment = HanLP.newSegment().enableNameRecognize(true);
        for (String sentence : testCase)
        {
            List<Term> termList = segment.seg(sentence);
            System.out.println(termList);
        }
//        String[] testCase = new String[]{
//                "武胜县新学乡政府大楼门前锣鼓喧天",
//                "蓝翔给宁夏固原市彭阳县红河镇黑牛沟村捐赠了挖掘机",
//        };
//        Segment segment = HanLP.newSegment().enablePlaceRecognize(true);
//        for (String sentence : testCase)
//        {
//            List<Term> termList = segment.seg(sentence);
//            System.out.println(termList);
//        }
//        HanLP.Config.enableDebug();
//        System.out.println(HanLP.convertToSimplifiedChinese("「以後等妳當上皇后，就能買士多啤梨慶祝了」"));
//        System.out.println(HanLP.convertToSimplifiedChinese("「以後等妳當上皇后，就能買草莓慶祝了」"));
//        System.out.println(HanLP.convertToTraditionalChinese("“以后等你当上皇后，就能买草莓庆祝了”"));
//        Suggester suggester = new Suggester();
//        String[] titleArray =
//                (
//                        "威廉王子发表演说 呼吁保护野生动物\n" +
//                                "《时代》年度人物最终入围名单出炉 普京马云入选\n" +
//                                "“黑格比”横扫菲：菲吸取“海燕”经验及早疏散\n" +
//                                "日本保密法将正式生效 日媒指其损害国民知情权\n" +
//                                "英报告说空气污染带来“公共健康危机”"
//                ).split("\\n");
//        for (String title : titleArray)
//        {
//            suggester.addSentence(title);
//        }
//        System.out.println(suggester.suggest("发言", 1));       // 语义
//        System.out.println(suggester.suggest("危机公共", 1));   // 字符
//        System.out.println(suggester.suggest("mayun", 1));      // 拼音
    }
    public static void main(String[] args) {
        extractPhrase();
    }
}
