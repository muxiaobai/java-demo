package io.github.muxiaobai.labuladong;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 吃橘子
 **/
public class sad {

    public static void main(String[] args) {
        System.out.println(minDays(56));
    }

    public static int minDays(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n % 6 == 0) {
            int x = 2 * (n / 3);
            int y = n / 2;
            int z = 1;
            return 1 + minDays(n - Math.max(Math.max(x, y), z));
        }
        if (n % 3 == 0) {
            int x = 2 * (n / 3);
            int z = 1;
            return 1 + minDays(n - Math.max(x, z));
        }
        if (n % 3 == 0) {
            int y = n / 2;
            int z = 1;
            return 1 + minDays(n - Math.max(y, z));
        }
        int z = 1;
        return 1 + minDays(n - z);
    }
}

