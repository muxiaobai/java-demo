package io.github.muxiaobai.labuladong;


import java.util.Arrays;

/**
 * 凑硬币
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * https://leetcode-cn.com/problems/coin-change/
 */
public class aaa3 {
    public static void main(String[] args) {
        int[] coins = {5, 10};
        int x = 13;
        aaa3 aaa3 = new aaa3();
//        aaa3.democoin(coins, x);
        // 备忘录
//        aaa3.democoin2(coins, x);
        //自下而上
        aaa3.democoin3(coins, x);
    }

    /**
     *
     * 搜索回溯 [超出时间限制]
     * @param coins coins 硬币
     * @param x     x 总钱数
     */
    void democoin(int[] coins, int x) {
        long start = System.currentTimeMillis();
        System.out.println(aaa3.coin(coins, x));
        long end = System.currentTimeMillis();
        System.out.println("coin:" + (end - start));
    }

    static int coin(int[] coins, int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 0) {
            return -1;
        }
        int k = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int y = coin(coins, x - coins[i]);
            if (y == -1) {
                continue;
            }
            k = Math.min(k, y + 1);
        }
        if (k != Integer.MAX_VALUE) {
            return k;
        }
        return coin(coins, x);
    }

    /**
     * 每一个 比如 要获取 10 那最小的9，，次数 +1  因为有 1，或者 最小的 8 次数 +1 因为有2  或者 最小的5 ，次数 +1 因为有5
     *
     * @param coins coins 硬币
     * @param x     x 总钱数
     */
    void democoin2(int[] coins, int x) {
        long start = System.currentTimeMillis();
        System.out.println(aaa3.coin2(coins, x));
        long end = System.currentTimeMillis();
        System.out.println("coin2:" + (end - start));
    }

    static int coin2(int[] coins, int x) {
        /// 空间换时间
        int[] ccc = new int[x + 1];
        int y = helpercoin2(ccc, coins, x);
        System.out.println(Arrays.toString(ccc));
        return y;
    }

    private static int helpercoin2(int[] ccc, int[] coins, int x) {
        if (x == 0) {
            ccc[x] = 0;
            return 0;
        }
        if (x < 0) {
            return -1;
        }
        int k = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            //剩余的钱 x-coins[i] 找最小
            int y = helpercoin2(ccc, coins, x - coins[i]);
            if (x - coins[i] < 0) {
                continue;
            }
            k = Math.min(k, y + 1);
        }
        if (k != Integer.MAX_VALUE) {
            ccc[x - 1] = k;
        }
        return ccc[x - 1];
    }


    /**
     * 每一个 比如 要获取 10 那最小的9，，次数 +1  因为有 1，或者 最小的 8 次数 +1 因为有2  或者 最小的5 ，次数 +1 因为有5
     *
     * @param coins coins 硬币
     * @param x     x 总钱数
     */
    void democoin3(int[] coins, int x) {
        long start = System.currentTimeMillis();
        System.out.println(aaa3.coin3(coins, x));
        long end = System.currentTimeMillis();
        System.out.println("coin3:" + (end - start));
    }

    /**
     * 从下往上找
     * <p>
     * [0, 1, 1, 2, 2, 1, 2, 2, 3, 3, 1, 2]
     *
     * @param coins coins 硬币
     * @param x     x 总钱数
     * @return
     */
    static int coin3(int[] coins, int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 0) {
            return -1;
        }
        /// 空间换时间
        int[] ccc = new int[x + 1];
        Arrays.fill(ccc, x + 1);
        ccc[0] = 0;
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < coins.length; j++) {
                //没有进入这里，求min的话说明最后没有匹配到
                if (i - coins[j] >= 0) {
                    ccc[i] = Math.min(ccc[i - coins[j]] + 1, ccc[i]);
                }
            }
        }
        int y = ccc[x] > x ? -1 : ccc[x];
        System.out.println(Arrays.toString(ccc));
        return y;
    }
}
