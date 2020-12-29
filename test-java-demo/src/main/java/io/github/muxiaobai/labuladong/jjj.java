package io.github.muxiaobai.labuladong;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * nSum  和问题
 **/
public class jjj {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 10)));
//        System.out.println(Arrays.toString(twoSum2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 10)));
//        System.out.println(Arrays.toString(twoSum3(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 10)));
//        iii.printf(twoSum4(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 10));
//        iii.printf(twoSum5(new int[]{1,1, 2, 3, 4, 5, 6, 7, 8, 9}, 10));

//        iii.printf(twoSum5(new int[]{-1,-1, -2, -3, -4, -5, -6, -7, -8, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9},0,-1));
//        System.out.println(threeSum(new int[]{-1,-1, -2, -3, -4, -5, -6, -7, -8, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
//        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
//        System.out.println(fourSum(new int[]{-1, -1, -2, -3, -4, -5, -6, -7, -8, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 0));


        System.out.println(nSum(new int[]{-1, -1, -2, -3, -4, -5, -6, -7, -8, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 4,0));


    }

    /**
     * 1  两数和
     *
     * @param nums
     * @return int[]
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 1  两数和
     *
     * @param nums 1
     * @param target 1
     * @return int[] ws
     */
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }

        return null;
    }

    /**
     * 1  两数和
     *
     * @param nums 1
     * @param target 1
     * @return int[]
     */
    public static int[] twoSum3(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else if (sum == target) {
                return new int[]{left, right};
            }
        }

        return null;
    }

    /**
     * 1  两数和
     * 返回所有满足条件的数字
     *
     * @param nums 1
     * @param target 1
     * @return int[][]
     */
    public static int[][] twoSum4(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                merged.add(new int[]{target - nums[i], nums[i]});
            }
            hashMap.put(nums[i], i);
        }
        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * 1  两数和
     * 收尾指针
     * 左右横跳
     * @param nums 1
     * @param  start 1
     * @param target 1
     * @return List<List<Integer>>
     */
    public static List<List<Integer>> twoSum5(int[] nums, int start, int target) {
        Arrays.sort(nums);
        List<List<Integer>> merged = new ArrayList<>();
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            int a = nums[left], b = nums[right];
            if (sum < target) {
                while (left < right && nums[left] == a) {
                    left++;
                }
            } else if (sum > target) {
                while (left < right && nums[right] == b) {
                    right--;
                }
            } else if (sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                merged.add(list);
                while (left < right && nums[left] == a) {
                    left++;
                }
                while (left < right && nums[right] == b) {
                    right--;
                }
            }
        }
        return merged;
    }

    /**
     * 15 三数和
     * a+ b+ c =0
     *
     * @param nums 1
     * @return List<List<Integer>>
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target = 0;

        List<List<Integer>> merged = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> ttt = twoSum5(nums, i + 1, target - nums[i]);
            for (int j = 0; j < ttt.size(); j++) {
                List<Integer> list = ttt.get(j);
                list.add(nums[i]);
                merged.add(list);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return merged;

    }

    /**
     * 15 三数和
     * a+ b+ c =0
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums, int left, int target) {
        Arrays.sort(nums);
        List<List<Integer>> merged = new ArrayList<List<Integer>>();
        for (int i = left; i < nums.length; i++) {
            List<List<Integer>> ttt = twoSum5(nums, i + 1, target - nums[i]);
            for (int j = 0; j < ttt.size(); j++) {
                List<Integer> list =ttt.get(j);
                list.add(nums[i]);
                merged.add(list);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return merged;

    }

    /**
     * 18 四数和
     * a+ b+ c +d =target
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> merged = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> ttt = threeSum2(nums, i + 1, target - nums[i]);
            for (int j = 0; j < ttt.size(); j++) {
                List<Integer> list = ttt.get(j);
                list.add(nums[i]);
                merged.add(list);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return merged;
    }

    /**
     * 推广 nSum
     *
     * @param nums 数组
     * @param n 几位数之和
     * @param target 和为多少
     * @return
     */

    public static List<List<Integer>> nSum(int[] nums, int n, int target) {
        Arrays.sort(nums);
        return nSum2(nums, n, 0, target);
    }

    /**
     * nSum n数和
     *
     * 2 为第一个
     * 之后的递归 回到aaa.java 的问题
     * @param nums 数组
     * @param n  几位数之和
     * @param start 从多少开始算
     * @param target 和为多少
     * @return List
     */
    public static List<List<Integer>> nSum2(int[] nums, int n, int start, int target) {
        List<List<Integer>> merged = new ArrayList<List<Integer>>();
        if (n < 2 || nums.length < n) {
            return merged;
        }
        if (n == 2) {
            int left = start;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                int a = nums[left], b = nums[right];
                if (sum < target) {
                    while (left < right && nums[left] == a) {
                        left++;
                    }
                } else if (sum > target) {
                    while (left < right && nums[right] == b) {
                        right--;
                    }
                } else if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    merged.add(list);
                    while (left < right && nums[left] == a) {
                        left++;
                    }
                    while (left < right && nums[right] == b) {
                        right--;
                    }
                }
            }
            return merged;
        } else {
            for (int i = 0; i < nums.length; i++) {
                List<List<Integer>> ttt = nSum2(nums, n - 1, i + 1, target - nums[i]);
                for (int j = 0; j < ttt.size(); j++) {
                    List<Integer> list = ttt.get(j);
                    list.add(nums[i]);
                    merged.add(list);
                }
                // 跳过第一个数字重复的情况，否则会出现重复结果
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return merged;
    }
}

