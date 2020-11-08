package io.github.muxiaobai.labuladong;


import java.util.LinkedList;
import java.util.List;

/**
 * DFS  回溯  深度优先 depth
 */
public class ccc {
    static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        res.clear();
        LinkedList linkedList = new LinkedList();
//        int[] num = {1, 2, 3, 4, 5};
        int[] num = {1};
        back(num, linkedList);
        System.out.println(res);
    }

    static void back(int[] num, LinkedList linkedList) {
        if(num ==null){
            return;
        }
        if (linkedList.size() == num.length) {
            res.add(new LinkedList(linkedList));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            // 排除不合法的选择
            if (linkedList.contains(num[i])) {
                continue;
            }
            // 做选择
            linkedList.add(num[i]);
            // 进入下一层决策树
            back(num, linkedList);
            // 取消选择
            linkedList.removeLast();
        }
    }
}
