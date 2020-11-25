package io.github.muxiaobai.labuladong;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 区间问题
 * 1288  56  986
 **/
public class iii {

    public static void main(String[] args) {
//        System.out.println(removeCoveredIntervals(new int[][]{{1, 4}, {3, 6}, {2, 8},{3,5},{6,7}}));
//        printf(merge(new int[][]{{1, 4}, {3, 4}, {9, 23}, {8, 8}, {2, 8}}));
//        printf(merge(new int[][]{{2, 3}, {5, 5}, {2, 2}, {3, 4}, {4,4},{3, 4}}));
        printf(intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12},
                {15, 24}, {25, 26}}));

//        System.out.println(countRangeSum(new int[]{1, 43, 62, 83,56,7},1,1));

    }

    /**
     * 返回 没有被覆盖的区间个数
     * 1288
     *
     * @param intervals
     * @return
     */

    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> {
            if (x[0] == y[0]) {
                return y[1] - x[1];
            } else {
                return x[0] - y[0];
            }
        });
        printf(intervals);
        int left = intervals[0][0];
        int right = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            // 下一个区间在内部
            if (left <= intervals[i][0] && intervals[i][1] <= right) {
                count++;
                continue;
            }
            // 存在重合区间
            if (left <= intervals[i][0] && intervals[i][0] <= right && right < intervals[i][1]) {
                right = intervals[i][1];
                continue;
            }
            // 无关
            if (left <= intervals[i][0] && right <= intervals[i][0]) {
                left = intervals[i][0];
                right = intervals[i][1];
                continue;
            }

        }
        return intervals.length - count;
    }

    public static void printf(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            int[] interval  =intervals[i];
            System.out.print("[ ");
            for (int j = 0; j < interval.length; j++) {
                System.out.print(intervals[i][j] + ", " );
            }
            System.out.println("]");
        }
    }

    /**
     * 返回合并区间
     * 56
     *
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> {
            if (x[0] == y[0]) {
                return y[1] - x[1];
            } else {
                return x[0] - y[0];
            }
        });
//        printf(intervals);
        List<int[]> merged = new ArrayList<int[]>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < intervals.length; i++) {

            // 下一个区间在内部
            if (left <= intervals[i][0] && intervals[i][1] <= right) {
            }
            // 存在重合区间
            if (left <= intervals[i][0] && intervals[i][0] <= right && right < intervals[i][1]) {
                right = intervals[i][1];
            }
            // 无关
            if (right < intervals[i][0]) {
                //第一个区间不动
                if (i != 0) {
                    merged.add(new int[]{left, right});
                }
                left = intervals[i][0];
                right = intervals[i][1];
            }
            // 添加最后的一个区间
            if (i == intervals.length - 1) {
                merged.add(new int[]{left, right});
            }

        }
        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * 986  区间求并集
     * -------  -------   ---------     ----------
     * --   ---       -  -----    -----------
     * --   --        -   --      -     -----
     * 求区间并集
     * @param A
     * @param B
     * @return
     */
    public static int[][] intervalIntersection(int[][] A, int[][] B) {
//        Arrays.sort(A, (x, y) -> {
//            if (x[0] == y[0]) {
//                return y[1] - x[1];
//            } else {
//                return x[0] - y[0];
//            }
//        });
//        Arrays.sort(B, (x, y) -> {
//            if (x[0] == y[0]) {
//                return y[1] - x[1];
//            } else {
//                return x[0] - y[0];
//            }
//        });
        List<int[]> merged = new ArrayList<int[]>();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            // 两个区间比较  左侧取最大，右侧取最小，
            // 根据右侧大小，进行位置移动

            //两个区间存在交集 相互比大小
            if (A[i][1] >= B[j][0] && B[j][1] >= A[i][0]) {
                // 取开始区间的最大值，取结束区间的最小值
                merged.add(new int[]{Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])});
            }
            // 更新位置  B大 需要调大A的位置
            if (A[i][1] <= B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * 327
     *
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public static int countRangeSum(int[] nums, int lower, int upper) {
        return 0;
    }
}

