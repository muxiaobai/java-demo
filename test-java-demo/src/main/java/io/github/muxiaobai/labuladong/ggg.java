package io.github.muxiaobai.labuladong;


import java.util.Arrays;

/**
 * 滑动窗口
 * 卖股票 利益最大
 * 有费率，相当，买入的高了费率，或者卖出的低了费率
 **/
public class ggg {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(slidingWindow(new int[]{7, 2, 5, 8, 6, 9}));
        System.out.println(slidingWindowN(new int[]{7, 2, 5, 8, 6, 9}));
        System.out.println(slidingWindowK(new int[]{7, 2, 5, 8, 6, 9}));

        long end = System.currentTimeMillis();
        System.out.println("data:" + (end - start));
    }

    /**
     * 7, 2, 5, 8, 6, 9
     * 无票 0  0  3  6  4  7
     * 有票-7 -2 -2 -2 -2 -2
     * 最小价格  最大差价
     * 只能买一次 买2 卖9，，中间经过状态 买2  卖5/卖8/卖9
     *
     * @param prices
     * @return int
     * @author Zhang Pengfei
     * @date 2020/11/8 12:04
     */
    static int slidingWindow(int[] prices) {
        if (prices==null ||prices.length==0){return  0;}
        //卖出状态利润  sell   reset -----> 无票
        int a = 0;
        //持有状态利润  buy reset  ---> 有票
        int b = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                a = 0;
                b = -prices[i];
                System.out.println("价格prices:"+prices[i]+",无票状态利润0:"+a+",有票状态利润1:"+b);
                continue;
            }
            // 没有动 ，如果卖票 就要看持有时期钱再加上卖出的价格
            a = Math.max(a, b + prices[i]);
            // 没有动 ，当前能卖的时候，利润会和卖价比较，不能用利润来减，因为只能交易一次
            b = Math.max(b, 0 - prices[i]);
            System.out.println("价格prices:"+prices[i]+",无票状态利润0:"+a+",有票状态利润1:"+b);

        }
        return a;
    }

    /**
     * 7, 2, 5, 8, 6, 9
     * 无票 0  0  3  6  6  9
     * 有票-7 -2 -2 -2  0  0
     * 票钱+ 有票状态下的利润 就是无票时候的利润
     * 最小价格  最大差价，记录利润
     * 可以买多次
     *
     * @param prices
     * @return int
     * @author Zhang Pengfei
     * @date 2020/11/8 12:04
     */
    static int slidingWindowN(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //卖出状态利润  sell   reset -----> 无票
        int a = 0;
        //持有状态利润  buy reset  ---> 有票
        int b = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                a = 0;
                b = -prices[i];
                System.out.println("价格prices:"+prices[i]+",无票状态利润0:"+a+",有票状态利润1:"+b);
                continue;
            }
            //把之前的利润记一下
            int temp = a;
            // 没有动 ，如果卖票 就要看持有时期钱再加上卖出的价格
            a = Math.max(a, b + prices[i]);
            // 没有动  ，或者 买了票，上面只能一次交易的，这次可以用利润买，
            b = Math.max(b, temp - prices[i]);
            System.out.println("价格prices:"+prices[i]+",无票状态利润0:"+a+",有票状态利润1:"+b);
        }
        return a;
    }

    /**
     * 只能交易k次
     *
     * @param prices
     * @return int k
     * @author Zhang Pengfei
     * @date 2020/11/8 15:11
     */
    static int slidingWindowK(int[] prices) {
        int n = prices.length;
        int max_k = 2;

        //如果价格有4个，那么最多可以交易2次
        if (max_k > n / 2) {
            return 0;
        }

        int[][][] dp = new int[n][max_k + 1][2];
        //i 每天价格 k 有k次交易，0/1  有票/无票
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) { /*处理 base case */
                    dp[0][max_k][0] = 0;
                    dp[0][max_k][1] = -prices[i];
                    System.out.println("第k次交易:"+k+"价格prices:"+prices[i]+",无票状态利润0:"+dp[i][k][0]+",有票状态利润1:"+dp[i][k][1]);
                    continue;
                }
                //这里应该是状态循环  0/1   0无票状态   1有票状态
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                System.out.println("第k次交易:"+k+",价格prices:"+prices[i]+",无票状态利润0:"+dp[i][k][0]+",有票状态利润1:"+dp[i][k][1]);
            }
        }
        // 穷举了 n × max_k × 2 个状态，正确。
        return dp[n - 1][max_k][0];
    }
//    /* 滑动窗口算法框架 */
//    void slidingWindow(string s, string t) {
//        unordered_map<char, int> need, window;
//        for (char c : t) need[c]++;
//
//        int left = 0, right = 0;
//        int valid = 0;
//        while (right < s.size()) {
//            // c 是将移入窗口的字符
//            char c = s[right];
//            // 右移窗口
//            right++;
//            // 进行窗口内数据的一系列更新
//        ...
//
//            /*** debug 输出的位置 ***/
//            printf("window: [%d, %d)\n", left, right);
//            /********************/
//
//            // 判断左侧窗口是否要收缩
//            while (window needs shrink) {
//                // d 是将移出窗口的字符
//                char d = s[left];
//                // 左移窗口
//                left++;
//                // 进行窗口内数据的一系列更新
//            ...
//            }
//        }
}

