package io.github.muxiaobai.labuladong;


/**
 * 滑动窗口
 * 卖股票 利益最大
 **/
public class ggg {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(slidingWindow(new int[]{7, 1, 5, 3, 6, 4}));
        long end = System.currentTimeMillis();
        System.out.println("search:" + (end - start));
    }

    static int slidingWindow(int[] prices) {
        if (prices==null ||prices.length==0){return  0;}
        int left = 0;
        int right = 0;
        int a = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            Math.max(a, prices[i]);
        }
        return Math.max(0,1);
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

