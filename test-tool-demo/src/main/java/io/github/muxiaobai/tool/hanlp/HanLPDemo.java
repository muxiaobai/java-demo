package io.github.muxiaobai.tool.hanlp;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;
import com.hankcs.hanlp.dictionary.BaseSearcher;
import com.hankcs.hanlp.dictionary.CoreDictionary;
import com.hankcs.hanlp.dictionary.CoreSynonymDictionary;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.hankcs.hanlp.dictionary.py.Pinyin;
import com.hankcs.hanlp.dictionary.stopword.StopWordDictionary;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.suggest.Suggester;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class HanLPDemo {
//            https://www.hankcs.com/nlp/hanlp.html
        public static void main(String[] args) throws Exception {
            HanLP.Config.enableDebug();
//            String text = "中国是世界上的经济大国，社会主义强国！";
//            List<Term> keyWords = HanLP.segment(text);
//            System.out.println(keyWords.toString());
//            HanLPDemo.Suggester();
//            HanLPDemo.keyWord();
            HanLPDemo.pinyin();
//            HanLPDemo.DemoWordDistance();
//            HanLPDemo.extractPhrase();
//            HanLPDemo.extractSummary();
//            System.out.println(HanLP.convertToPinyinFirstCharString("测试", "", true));
//            System.out.println(HanLP.convertToPinyinString("测试", "", true));
//
//            System.out.println(HanLP.convertToSimplifiedChinese("國家"));
//            System.out.println(HanLP.convertToTraditionalChinese("国家"));
//            segment();
//            deee();
        }
        public static void deee(){
            String text = "近日，为认真贯彻落实习近平总书记关于“不忘初心、牢记使命”的相关重要讲话和重要指示批示精神，根据自治区党委、政府及集团公司有关部署，中国移动西藏公司正式启动“不忘初心 牢记使命”主题教育活动，同时下发《中国移动通信集团西藏有限公司党委关于开展“不忘初心、牢记使命”主题教育的实施方案》，全面认真领会习近平新时代中国特色社会主义精神，扎实推动主题教育深入开展，有效提升党员领导干部的党性修养。自6月21日活动启动以来，中国移动西藏公司党委已开展2次集中学习研讨活动，并邀请西藏自治区党校的史云峰教授开展“习近平新时代中国特色社会主义思想”的专题辅导。史云峰教授从习近平时代的历史定位、正确认识国家领袖在历史中的地位、共产主义与中华民族伟大复兴、现代化的中国方案和新党政体制与核心价值构建五个方面，对习近平新时代中国特色社会主义思想进行了一次全方位深入的解读，让中国移动西藏公司各级党员领导干部再一次深刻领会了习近平新时代中国特色社会主义思想的深刻内涵，从思想和认识上接受了一次深刻的洗礼。在中国移动西藏公司党委开展的“不忘初心 牢记使命”主题教育第一次集中学习研讨会上，公司党委书记周敏同志带领学习习近平总书记在“不忘初心牢记使命”启动会上的讲话精神和集团公司杨杰书记在中国移动“不忘初心、牢记使命”主题教育动员部署会上的讲话精神。周敏强调，公司党委和机关党委各支部要认真领会“不忘初心、牢记使命”主题教育的重大意义；要准确把握 “不忘初心、牢记使命”主题教育的目标要求；公司党委、机关党委各支部作为第一阶段开展的单位，要按照公司部署安排扎实推动主题教育取得实效，公司党委委员要加强自学，深刻领会，强化指导和监督，各支部书记要结合公司整体部署安排，在支部内开展好主题教育的各项工作。中国移动西藏公司纪委书记赵艳琦在个人学习心得交流时提出，公司纪委将积极参与到主题教育各阶段、各环节，对未落实的人和事将严肃追究责任，确保中央和集团各项决策部署在我公司落地生根，确保主题教育取得实效，切实为公司营造干事创业敢担当、清正廉洁作表率的良好的政治生态。赵艳琦指出，本次主题教育工作开展周期为三个月，公司上下全体干部员工要认真贯彻执行实施方案具体内容和安排，确保本次主题教育工作取得实效。（李瑞伟）";
            try {
                StopWordDictionary stopWordDictionary = new StopWordDictionary("E:\\workspace\\idea\\app-goverment\\app-search\\src\\main\\resources\\word\\stop_words.txt");
                HanLP.Config.CoreStopWordDictionaryPath = "E:\\workspace\\idea\\app-goverment\\app-search\\src\\main\\resources\\word\\stop_words.txt" ;
            } catch (IOException e) {
                e.printStackTrace();
            }
            IndexTokenizer.segment(text);
            List<Term> termList = HanLP.segment(text);
            System.out.println(termList);
        }
     public static   void segment(){
            String text = "中国科学院计算技术研究所的宗成庆教授正在教授自然语言处理课程";
            List<Term> termList = NLPTokenizer.segment(text);
            System.out.println(termList);
            System.out.println(HanLP.segment(text));

      }
    public static void customDict() {
        // 动态增加
        CustomDictionary.add("攻城狮");
        // 强行插入
        CustomDictionary.insert("白富美", "nz 1024");
        // 删除词语（注释掉试试）
//        CustomDictionary.remove("攻城狮");
        System.out.println(CustomDictionary.add("单身狗", "nz 1024 n 1"));
        System.out.println(CustomDictionary.get("单身狗"));

        String text = "攻城狮逆袭单身狗，迎娶白富美，走上人生巅峰";  // 怎么可能噗哈哈！

        // DoubleArrayTrie分词
        final char[] charArray = text.toCharArray();
        CustomDictionary.parseText(charArray, new AhoCorasickDoubleArrayTrie.IHit<CoreDictionary.Attribute>() {
            @Override
            public void hit(int begin, int end, CoreDictionary.Attribute value) {
                System.out.printf("[%d:%d]=%s %s\n", begin, end, new String(charArray, begin, end - begin), value);
            }
        });
        // 首字哈希之后二分的trie树分词
        BaseSearcher searcher = CustomDictionary.getSearcher(text);
        Map.Entry entry;
        while ((entry = searcher.next()) != null) {
            System.out.println(entry);
        }

        // 标准分词
        System.out.println(HanLP.segment(text));

        // Note:动态增删不会影响词典文件
        // 目前CustomDictionary使用DAT储存词典文件中的词语，用BinTrie储存动态加入的词语，前者性能高，后者性能低
        // 之所以保留动态增删功能，一方面是历史遗留特性，另一方面是调试用；未来可能会去掉动态增删特性。
    }
    /**
     *  简介提取
     * @author  Zhang Pengfei
     * @date 2020/1/20/020 14:57
     * @param
     * @return
     */
    public static  void extractSummary(){
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
        List<String> phraseList = HanLP.extractSummary(text, 5);
        System.out.println(phraseList);
    }
    /**
     *  短语提取
     * @author  Zhang Pengfei
     * @date 2020/1/20/020 14:57
     * @param
     * @return
     */
    public static  void extractPhrase(){
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
        text="信物理层等一维信息领域目前常用的算法：无线领域的RRM、RTT，传送;";
        List<String> phraseList = HanLP.extractPhrase(text, 5);
        System.out.println(phraseList);
    }
    /**
     * 语义距离
     * @author hankcs
     */
    public  static  void DemoWordDistance(){
            String[] wordArray = new String[]
                    {
                            "香蕉",
                            "苹果",
                            "白菜",
                            "水果",
                            "蔬菜",
                            "自行车",
                            "公交车",
                            "飞机",
                            "买",
                            "卖",
                            "购入",
                            "新年",
                            "春节",
                            "丢失",
                            "补办",
                            "办理",
                            "送给",
                            "寻找",
                            "孩子",
                            "教室",
                            "教师",
                            "会计",
                    };
            for (String a : wordArray)
            {
                for (String b : wordArray)
                {
                    System.out.println(a + "\t" + b + "\t之间的距离是\t" + CoreSynonymDictionary.distance(a, b));
                }
            }
    }
    public static void Suggester()
    {
        Suggester suggester = new Suggester();
        String[] titleArray =
                (
                        "威廉王子发表演说 呼吁保护野生动物\n" +
                                "《时代》年度人物最终入围名单出炉 普京马云入选\n" +
                                "“黑格比”横扫菲：菲吸取“海燕”经验及早疏散\n" +
                                "日本保密法将正式生效 日媒指其损害国民知情权\n" +
                                "英报告说空气污染带来“公共健康危机”"
                ).split("\\n");
        for (String title : titleArray)
        {
            suggester.addSentence(title);
        }
        System.out.println(suggester.suggest("发言", 1));       // 语义
        System.out.println(suggester.suggest("危机公共", 1));   // 字符
        System.out.println(suggester.suggest("mayun", 1));      // 拼音
    }
    public static  void keyWord(){
        String content = "程序员(英文Programmer)是从事程序开发、维护的专业人员。一般将程序员分为程序设计人员和程序编码人员，但两者的界限并不非常清楚，特别是在中国。软件从业人员分为初级程序员、高级程序员、系统分析员和项目经理四大类。";
        List<String> keywordList = HanLP.extractPhrase(content,5);//.extractKeyword(content, 5);
        System.out.println(keywordList);
    }
    public static void pinyin()
    {
        String text = "重载不是重任";
        List<Pinyin> pinyinList = HanLP.convertToPinyinList(text);
        System.out.print("原文,");
        for (char c : text.toCharArray())
        {
            System.out.printf("%c,", c);
        }
        System.out.println();
        System.out.print("拼音（数字音调）,");
        for (Pinyin pinyin : pinyinList)
        {
            System.out.printf("%s,", pinyin);
        }
        System.out.println();
        System.out.print("拼音（符号音调）,");
        for (Pinyin pinyin : pinyinList)
        {
            System.out.printf("%s,", pinyin.getPinyinWithToneMark());
        }
        System.out.println();
        System.out.print("拼音（无音调）,");
        for (Pinyin pinyin : pinyinList)
        {
            System.out.printf("%s,", pinyin.getPinyinWithoutTone());
        }
        System.out.println();
        System.out.print("声调,");
        for (Pinyin pinyin : pinyinList)
        {
            System.out.printf("%s,", pinyin.getTone());
        }
        System.out.println();
        System.out.print("声母,");
        for (Pinyin pinyin : pinyinList)
        {
            System.out.printf("%s,", pinyin.getShengmu());
        }
        System.out.println();
        System.out.print("韵母,");
        for (Pinyin pinyin : pinyinList)
        {
            System.out.printf("%s,", pinyin.getYunmu());
        }
        System.out.println();
        System.out.print("输入法头,");
        for (Pinyin pinyin : pinyinList)
        {
            System.out.printf("%s,", pinyin.getHead());
        }
        System.out.println();
    }
}
