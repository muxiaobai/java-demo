package io.github.muxiaobai.labuladong;


import java.util.*;

/**
 * 开锁问题
 * 0000     ------->5623
 * 有雷：3453，,4634
 **/
public class eee {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(BFS(new String[]{"3421", "2345"}, "2132"));
        long end = System.currentTimeMillis();
        System.out.println("date:" + (end - start));
    }

    static String plus(String s, int i) {
        char[] a = s.toCharArray();
        if (a[i] == '9') {
            a[i] = '0';
        } else {
            a[i] = (char) (a[i] + 1);
        }
        return String.valueOf(a);
    }

    static String minus(String s, int i) {
        char[] a = s.toCharArray();
        if (a[i] == '0') {
            a[i] = '9';
        } else {
            a[i] = (char) (a[i] - 1);
        }
        return String.valueOf(a);
    }

    static int BFS(String[] deads, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        set.add("0000");
        queue.offer("0000");
        int depth = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String ppp = queue.poll();
                Boolean flag = false;
                for (int k = 0; k < deads.length; k++) {
                    if (deads[k].equals(ppp)) {
                        flag = true;
                    }
                }
                if (flag) {
                    continue;
                }
                if (target.equals(ppp)) {
                    return depth;
                }
                System.out.println(ppp);
                for (int j = 0; j < ppp.length(); j++) {
                    String up = plus(ppp, j);
                    String minus = minus(ppp, j);
                    if (!set.contains(up)) {
                        queue.offer(up);
                        set.add(up);
                    }
                    if (!set.contains(minus)) {
                        queue.offer(minus);
                        set.add(minus);
                    }
                }
            }
            depth++;
        }
        return -1;

    }
}

