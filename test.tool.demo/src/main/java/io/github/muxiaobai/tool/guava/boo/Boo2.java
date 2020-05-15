package io.github.muxiaobai.tool.guava.boo;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import org.apache.commons.lang3.RandomUtils;


public class Boo2 {

    /** 预计插入的数量 */
    private static final int SIZE = 1000000;

    /**
     * 允许的错误率，错误率越低，所需内存空间就越大
     * fpp 范围：0.0 < fpp < 1
     */
    private static final double FPP = 0.001;
    private static BloomFilter<Integer> idBloomFilter = BloomFilter.create((Funnel<Integer>) (integer, primitiveSink) -> primitiveSink.putInt(integer), SIZE, FPP);


    /**
     * 模拟初始化数据
     * 在实际生产中应该是把数据库中的数据插入布隆过滤器
     */
    private static void initData() {
        // 实际插入预估数据量的十倍
        for (Integer i = 0; i <= SIZE * 10; i++) {
            // 遗憾的是布隆过滤器没有 remove 方法
            idBloomFilter.put(i);
        }
    }

    static {
        initData();
    }


    public static void main(String[] args) {
        Integer fppCount = 0;
        Integer count = 100;

        for (int i = 0; i < count; i++) {
            Integer num = RandomUtils.nextInt(0, SIZE * 15);

            boolean result = idBloomFilter.mightContain(num);

            System.out.println("i:"+i+".num:"+num + "-----" + result);

            // 初始化的数据是 0 ~ SIZE，若 num > SIZE 则代表不存在过滤器中
            if ((num > SIZE * 10 && result) || (num < SIZE * 10 && !result)) {
                fppCount++;
            }
        }
        System.out.println("错误率:" + ((float)fppCount / count));
    }
}