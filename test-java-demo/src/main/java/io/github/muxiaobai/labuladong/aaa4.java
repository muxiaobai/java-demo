package io.github.muxiaobai.labuladong;


import java.util.Arrays;

/**
 * 凑硬币  有几种凑法
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个
 * <p>
 *
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * https://leetcode-cn.com/problems/coin-change-2/
 *
 */
public class aaa4 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10};
        int x = 13;
        aaa4 aaa4 = new aaa4();
        aaa4.democoin(coins, x);
    }

    /**
     * 有多少种凑法
     *
     * 13 = 10 +2+1
     * 13 = 10 +1+1+1
     * 13 = 5+5 +2+1
     * 13 = 5 +2+2+1 +2+1
     * 13 = 5 +2+2+1 +1+1+1
     * 13 = 5 +2+1+1+1 +2+1   重复
     * 13 = 5 +2+1+1+1  +1+1+1
     * 13 = 5 +1+1+1+1+1 +1+1+1
     * 13 = 2+2+1 +2+2+1 +2+1
     * ...
     * ...
     * ...
     *
     * 每一步的前一步都可以求得
     *
     * @param coins coins 硬币
     * @param x     x 总钱数
     */
    void democoin(int[] coins, int x) {
        long start = System.currentTimeMillis();
        System.out.println(aaa4.coin(coins, x));
        long end = System.currentTimeMillis();
        System.out.println("coin:" + (end - start));
    }

    static int coin(int[] coins, int amount) {
        int[] ccc = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i-coins[j]>=0) {
                    ccc[i] = Math.max(ccc[i] + 1, ccc[i - coins[j]]);
                }
            }
        }
        System.out.println(Arrays.toString(ccc));
        return ccc[amount];
    }

}
