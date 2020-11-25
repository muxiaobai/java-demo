package io.github.muxiaobai.labuladong;


/**
 * 斐波那契
 * 记录表
 * 自顶向下
 * 自下而上
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 509. 斐波那契数 https://leetcode-cn.com/problems/fibonacci-number/
 */
public class aaa {
    public static void main(String[] args) {
        int x = 45;
        aaa aaa = new aaa();
        // 普通斐波那契
        aaa.demofib(x);
        // 备忘录
        aaa.demofib2(x);
        // 记录表
        aaa.demofib3(x);
        //状态压缩
        aaa.demofib4(x);
    }

    void demofib(int x) {
        aaa aaa = new aaa();
        long start = System.currentTimeMillis();
        System.out.println(aaa.fib(x));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    int fib(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }
        return fib(x - 1) + fib(x - 2);
    }

    void demofib2(int x) {
        aaa aaa = new aaa();
        long start = System.currentTimeMillis();
        System.out.println(aaa.fib2(x));
        long end = System.currentTimeMillis();
        System.out.println("fib2:" + (end - start));
    }

    int fib2(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }
        /// 空间换时间
        int[] ccc = new int[x];
        return helper(ccc, x);
    }

    private int helper(int[] ccc, int x) {
        if (x == 1 || x == 2) {
            return 1;
        }
        if (ccc[x - 1] != 0) {
            return ccc[x - 1];
        }
        ccc[x - 1] = helper(ccc, x - 1) + helper(ccc, x - 2);
//        System.out.println(Arrays.toString(ccc));
        return ccc[x - 1];
    }

    void demofib3(int x) {
        aaa aaa = new aaa();
        long start = System.currentTimeMillis();
        System.out.println(aaa.fib3(x));
        long end = System.currentTimeMillis();
        System.out.println("fib3:" + (end - start));
    }

    int fib3(int x) {
        int[] ccc = new int[x];
        ccc[0] = 1;
        ccc[1] = 1;
        for (int i = 2; i < x; i++) {
            ccc[i] = ccc[i - 1] + ccc[i - 2];
        }
        return ccc[x - 1];

    }


    void demofib4(int x) {
        aaa aaa = new aaa();
        long start = System.currentTimeMillis();
        System.out.println(aaa.fib4(x));
        long end = System.currentTimeMillis();
        System.out.println("fib4:" + (end - start));
    }
    int fib4(int x) {
        if(x==0){return 0;}
        if (x == 1 || x == 2) {
            return 1;
        }
        int prev = 1;
        int curr = 1;
        for (int i = 2; i < x; i++) {
            int sum = curr + prev;
            prev = curr;
            curr = sum;
        }
        return curr;

    }
}
