package io.github.muxiaobai.labuladong;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 凑硬币
 */
public class bbb {
    public static void main(String[] args) {
        int[] coins = {1, 4, 5, 2, 6, 8};
        int x = 10;
        bbb bbb = new bbb();
        bbb.democoin(coins, x);
        // 备忘录
        bbb.democoin2(coins,x);
    }

    void democoin(int[] coins, int x) {
        bbb bbb = new bbb();
        long start = System.currentTimeMillis();
        List list =new ArrayList();
        System.out.println(bbb.coin(coins, x));
        long end = System.currentTimeMillis();
        System.out.println("coin:" + (end - start));
    }

    int coin(int[] coins, int x) {
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

    void democoin2(int[] coins, int x) {
        bbb bbb = new bbb();
        long start = System.currentTimeMillis();
        List list =new ArrayList();
        System.out.println(bbb.coin2(coins, x));
        long end = System.currentTimeMillis();
        System.out.println("coin2:" + (end - start));
    }

    int coin2(int[] coins, int x) {
        /// 空间换时间
        int[] ccc = new int[x+1];
        System.out.println(Arrays.toString(ccc));
        return helper(ccc,coins, x);

    }

    private int helper(int[] ccc,int[] coins, int x) {
        if (x == 0) {
            ccc[x] = 0;
            return 0;
        }
        if (x < 0) {
            return -1;
        }
        int k = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int y = helper(ccc,coins, x - coins[i]);
            if (x - coins[i] < 0) {
                continue;
            }
            k = Math.min(k, y + 1);
        }
        if (k != Integer.MAX_VALUE) {
            ccc[x-1] = k;
        }
        return ccc[x - 1];
    }



}
