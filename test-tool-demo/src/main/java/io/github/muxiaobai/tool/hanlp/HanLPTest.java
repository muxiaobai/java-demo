package io.github.muxiaobai.tool.hanlp;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLSentence;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLWord;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.Viterbi.ViterbiSegment;

import java.util.Date;

/**
 */
public class HanLPTest {
    public static void nature() {
        CoNLLSentence sentence = HanLP.parseDependency("徐先生还具体帮助他确定了把画雄鹰、松鼠和麻雀作为主攻目标。");
        System.out.println(sentence);
        // 可以方便地遍历它
        for (CoNLLWord word : sentence) {
            System.out.printf("%s --(%s)--> %s\n", word.LEMMA, word.DEPREL, word.HEAD.LEMMA);
        }
        // 也可以直接拿到数组，任意顺序或逆序遍历
        CoNLLWord[] wordArray = sentence.getWordArray();
        for (int i = wordArray.length - 1; i >= 0; i--) {
            CoNLLWord word = wordArray[i];
            System.out.printf("%s --(%s)--> %s\n", word.LEMMA, word.DEPREL, word.HEAD.LEMMA);
        }
        // 还可以直接遍历子树，从某棵子树的某个节点一路遍历到虚根
        CoNLLWord head = wordArray[12];
        while ((head = head.HEAD) != null) {
            if (head == CoNLLWord.ROOT) System.out.println(head.LEMMA);
            else System.out.printf("%s --(%s)--> ", head.LEMMA, head.DEPREL);
        }
    }

    public static void main(String[] args) {
        word();
    }

    public static void WordRed() {
        String x = "西安某家<span>家装</span>公司可以进行暗装空调器的安装，支持百叶窗风格设计";
        String y = "西安支持家装的公司";
        StringBuilder stringBuilder = new StringBuilder();
        String xx = x.replace("<span>", "").replace("</span>", "");
        char[] xxx = xx.toCharArray();
        for (int j = 0; j < xxx.length; j++) {
            if (y.contains(String.valueOf(xxx[j]))) {
                stringBuilder.append("<span>").append(xxx[j]).append("</span>");
            } else {
                stringBuilder.append(xxx[j]);
            }
        }
        System.out.println(stringBuilder);

    }

    public static void word() {
        HanLP.Config.enableDebug();
        Segment segment = HanLP.newSegment();
//        ViterbiSegment viterbiSegment = new ViterbiSegment("E:/tools/elk/elasticsearch-7.16
//        .2-windows-x86_64/elasticsearch-7.16.2/config/analysis-hanlp/data/dictionary/custom/CustomDictionary.txt",
//        true);
       Segment viterbiSegment = new ViterbiSegment("E:\\tools\\sougou\\建筑词汇大全.txt", true);
        viterbiSegment.enableIndexMode(true);
        viterbiSegment.enablePartOfSpeechTagging(true);
        CustomDictionary.insert("独联体概况（下）");
        //        CustomDictionary.insert("校园", "n 820");
//        CustomDictionary.insert("校园内", "nz 106");
//        CustomDictionary.insert("校园卡", "nz 1");
//        CustomDictionary.insert("校园网", "n 6");
//        CustomDictionary.insert("校园行", "nz 1");
//        CustomDictionary.insert("校园", "n 820");
        segment.enableIndexMode(true);
        segment.enablePartOfSpeechTagging(true);
        System.out.println(viterbiSegment.seg("西安某家家装公司可以进行暗装空调器的安装，支持百叶窗风格设计"));
        System.out.println(segment.seg("西安某家家装公司可以进行暗装空调器的安装，支持百叶窗风格设计"));
        System.out.println(segment.seg("《独联体概况（下）》：扎根中国传统沃土 放眼丝路多元文明"));
    }

    public static void xxx() {

//        Segment segment = HanLP.newSegment();
//        CustomDictionary.insert("校园", "n 820");
//        CustomDictionary.insert("校园内", "nz 106");
//        CustomDictionary.insert("校园卡", "nz 1");
//        CustomDictionary.insert("校园网", "n 6");
//        CustomDictionary.insert("校园行", "nz 1");
//        CustomDictionary.insert("校园", "n 820");

//        this.enablePorterStemming = settings.get("enable_porter_stemming", "false").equals("true");
//        this.enableIndexMode = settings.get("enable_index_mode", "false").equals("true");
//        this.enableNumberQuantifierRecognize = settings.get("enable_number_quantifier_recognize", "false").equals
//        ("true");
//        this.enableCustomDictionary = settings.get("enable_custom_dictionary", "true").equals("true");
//        this.enableTranslatedNameRecognize = settings.get("enable_translated_name_recognize", "true").equals("true");
//        this.enableJapaneseNameRecognize = settings.get("enable_japanese_name_recognize", "false").equals("true");
//        this.enableOrganizationRecognize = settings.get("enable_organization_recognize", "false").equals("true");
//        this.enablePlaceRecognize = settings.get("enable_place_recognize", "false").equals("true");
//        this.enableNameRecognize = settings.get("enable_name_recognize", "true").equals("true");
//        this.enableTraditionalChineseMode = settings.get("enable_traditional_chinese_mode", "false").equals("true");
//        this.enableStopDictionary = settings.get("enable_stop_dictionary", "false").equals("true");
//        this.enablePartOfSpeechTagging = settings.get("enable_part_of_speech_tagging", "false").equals("true");
//        this.enableRemoteDict = settings.get("enable_remote_dict", "true").equals("true");
//        this.enableNormalization = settings.get("enable_normalization", "false").equals("true");
//        this.enableOffset = settings.get("enable_offset", "true").equals("true");
//        this.enableCustomConfig = settings.get("enable_custom_config", "false").equals("true");

//         .field("enable_custom_config", "true")
//                .field("enable_index_mode", "false")
//                .field("enable_stop_dictionary", "true")
//                .field("enable_organization_recognize", "false")
//                .field("enable_name_recognize", "true")
//                .field("enable_number_quantifier_recognize", "false")
//                .field("enable_place_recognize", "true")
//                .field("enable_traditional_chinese_mode", "true")

//        segment.enableNumberQuantifierRecognize(false);
//        segment.enableCustomDictionary(true);
//        segment.enableTranslatedNameRecognize(true);
//        segment.enableJapaneseNameRecognize(false);
//        segment.enableOrganizationRecognize(false);
//        segment.enablePlaceRecognize(false);
//        segment.enableNameRecognize(true);

//        segment.enableOffset(true);
//        System.out.println(segment.seg("装进手机里的“校园卡”——厦门大学数字校园卡使用说明"));
//        System.out.println("=================================");
    }
}
