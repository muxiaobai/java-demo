package io.github.muxiaobai.labuladong;


/**
 * 二分查找
 * 无重复
 * 有重复  左侧 右侧
 **/
public class fff {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(search(new int[]{-1, 0, 9, 9, 9, 12}, 9));
        System.out.println(searchLeft(new int[]{9, 9, 9, 9, 9, 9}, 10));
        System.out.println(searchRight(new int[]{9, 9, 9, 9, 9, 9}, 8));
        long end = System.currentTimeMillis();
        System.out.println("search:" + (end - start));
    }

    static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 相等的话，右边向左边缩进
     * @param nums
     * @param target
     * @return
     */
    static int searchLeft(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left >= nums.length) {
            return -1;
        }
        return left;
    }

    /**
     * 相同的，左边向右边移
     * @param nums
     * @param target
     * @return
     */
    static int searchRight(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (right < 0) {
            return -1;
        }
        return right;
    }
}

