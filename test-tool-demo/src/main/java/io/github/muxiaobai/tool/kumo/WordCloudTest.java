package io.github.muxiaobai.tool.kumo;


import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;
import com.kennycason.kumo.palette.ColorPalette;
import org.apache.commons.io.IOUtils;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static cn.hutool.core.io.FileUtil.getInputStream;
import static cn.hutool.core.io.FileUtil.getOutputStream;

public class WordCloudTest {
    public static void main(String[] args) throws IOException {
//        test1();
        test2();
    }

    static void test1() throws IOException {
        final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(600);
        frequencyAnalyzer.setMinWordLength(2);
        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());

        final List<WordFrequency> wordFrequencies = frequencyAnalyzer
                .load(getInputStream("wordcloud/chinese_language.txt"));
        final Dimension dimension = new Dimension(600, 600);
        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        wordCloud.setPadding(2);

        java.awt.Font font = new java.awt.Font("STSong-Light", 2, 16);
        wordCloud.setKumoFont(new KumoFont(font));

        wordCloud.setBackground(new CircleBackground(300));
        wordCloud.setColorPalette(new ColorPalette(new Color(0xD5CFFA), new Color(0xBBB1FA), new Color(0x9A8CF5),
                new Color(0x806EF5)));
        wordCloud.setFontScalar(new SqrtFontScalar(12, 45));
        wordCloud.build(wordFrequencies);

        OutputStream outputStream = getOutputStream("wordcloud/chinese_language_circle1.png");

        wordCloud.writeToStream("png", outputStream);

//        wordCloud.writeToFile("output/chinese_language_circle.png");
    }

    static List<WordFrequency> load() throws IOException {
        List<String> data = IOUtils.readLines(getInputStream("wordcloud/vina.txt"));
        final List<WordFrequency> wordFrequencies = new ArrayList<>();
//        final Map<String, Integer> cloud = new HashMap<>();
        data.stream().forEach(d -> wordFrequencies.add(new WordFrequency(d.split(",")[0],
                Integer.parseInt(d.split(",")[1]))));
//        cloud.forEach((key, value) -> wordFrequencies.add(new WordFrequency(key, value)));
        return wordFrequencies;
    }

    static void test2() throws IOException {
        //创建一个词语解析器,类似于分词
        FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(600);
        frequencyAnalyzer.setMinWordLength(2);
        //这边要注意,引用了中文的解析器
        frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());

        //拿到文档里面分出的词,和词频,建立一个集合存储起来
        List<WordFrequency> wordFrequencies = load();
        frequencyAnalyzer.load(getInputStream("wordcloud/vina.txt"));


        Dimension dimension = new Dimension(600, 600);

        //设置图片相关的属性,这边是大小和形状,更多的形状属性,可以从CollisionMode源码里面查找
        WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        wordCloud.setPadding(2);

        //这边要注意意思,是设置中文字体的,如果不设置,得到的将会是乱码,
        //这是官方给出的代码没有写的,我这边拓展写一下,字体,大小可以设置
        //具体可以参照Font源码
        java.awt.Font font = new java.awt.Font("STSong-Light", 2, 16);
        wordCloud.setKumoFont(new KumoFont(font));

        wordCloud.setBackgroundColor(new Color(0, 0, 0));
        //因为我这边是生成一个圆形,这边设置圆的半径
        wordCloud.setBackground(new CircleBackground(300));
        //设置颜色
        //设置词云显示的三种颜色，越靠前设置表示词频越高的词语的颜色
//        wordCloud.setColorPalette(new LinearGradientColorPalette(Color.RED, Color.BLUE, Color.GREEN, 30, 30));
        wordCloud.setColorPalette(new ColorPalette(new Color(0xD5CFFA), new Color(0xBBB1FA), new Color(0x9A8CF5),
                new Color(0x806EF5)));

        //设置背景图层为圆形
        wordCloud.setBackground(new CircleBackground(300));

        wordCloud.setFontScalar(new SqrtFontScalar(12, 45));
        //将文字写入图片
        wordCloud.build(wordFrequencies);
        //生成图片
        OutputStream outputStream = getOutputStream("wordcloud/chinese_language_circle2.png");

        wordCloud.writeToStream("png", outputStream);
//        wordCloud.writeToFile("wordcloud/chinese_language_circle.png");

    }
}
