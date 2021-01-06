package io.github.muxiaobai.labuladong;


import java.util.*;

/**
 * 吃橘子 aaa
 * 同  斐波那契
 * 状态机问题
 * <p>
 * <p>
 * 吃掉一个橘子。
 * 如果剩余橘子数 n 能被 2 整除，那么你可以吃掉 n/2 个橘子。
 * 如果剩余橘子数 n 能被 3 整除，那么你可以吃掉 2*(n/3) 个橘子。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-days-to-eat-n-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class aaa2 {

    public static void main(String[] args) {
        int n = 1000;
        long a = System.currentTimeMillis();
        System.out.println(minDays(n));
        long b = System.currentTimeMillis();
        System.out.println(minDays0(n));
        long c = System.currentTimeMillis();
        System.out.println(minDays1(n));
        long d = System.currentTimeMillis();
        System.out.println(minDays2(n));
        long e = System.currentTimeMillis();
        System.out.println("minDays:" + (b - a) + ",minDays0:" + (c - b) + ",minDays1:" + (d - c) + ",minDays2:" + (e - d));
    }

    /**
     * @param n
     * @return
     */
    public static int minDays(int n) {
        if (n <= 1) {
            return n;
        } else {
            return Math.min(n % 2 + 1 + minDays(n / 2), n % 3 + 1 + minDays(n / 3));
        }
    }

    /**
     *  java  -XX:+PrintFlagsFinal -version | findstr Stack
     * @param n
     * @return
     */
    public static int minDays0(int n) {
        if (n <= 1) {
            return n;
        } else {
            int l = minDays0(n - 1) + 1;
            if (n % 6 == 0) {
                return Math.min(minDays0(n / 3) + 1, Math.min(l, minDays0(n / 2) + 1));
            }
            if (n % 2 == 0) {
                return Math.min(l, minDays0(n / 2) + 1);
            }
            if (n % 3 == 0) {
                return Math.min(l, minDays0(n / 3) + 1);
            }
            return l;
        }
    }

    static Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public static int minDays1(int n) {
        if (n <= 1) {
            memo.put(n, n);
            return n;
        } else {
            int l1;
            if (!memo.containsKey(n - 1)) {
                memo.put(n - 1, minDays1(n - 1));
            }
            l1 = memo.get(n - 1) + 1;

            if (n % 6 == 0) {
                int l2;
                if (!memo.containsKey(n / 2)) {
                    memo.put(n - 1, minDays1(n / 2));
                }
                l2 = memo.get(n / 2) + 1;
                int l3;
                if (!memo.containsKey(n / 3)) {
                    memo.put(n - 1, minDays1(n / 3));
                }
                l3 = memo.get(n / 3) + 1;
                return Math.min(l3, Math.min(l1, l2));
            }
            if (n % 2 == 0) {
                int l2;
                if (!memo.containsKey(n / 2)) {
                    memo.put(n - 1, minDays1(n / 2));
                }
                l2 = memo.get(n / 2) + 1;
                return Math.min(l1, l2);
            }
            if (n % 3 == 0) {
                int l3;
                if (!memo.containsKey(n / 3)) {
                    memo.put(n - 1, minDays1(n / 3));
                }
                l3 = memo.get(n / 3) + 1;
                return Math.min(l1, l3);
            }
            return l1;
        }
    }

    static Map<Integer, Integer> memo2 = new HashMap<Integer, Integer>();

    public static int minDays2(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo2.containsKey(n)) {
            return memo2.get(n);
        }
        memo2.put(n, Math.min(n % 2 + 1 + minDays2(n / 2), n % 3 + 1 + minDays2(n / 3)));
        return memo2.get(n);

    }
}

