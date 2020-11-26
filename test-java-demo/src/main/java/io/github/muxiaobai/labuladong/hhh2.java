package io.github.muxiaobai.labuladong;


import java.util.*;

/**
 * 二叉树
 * <p>
 * 遍历
 **/
public class hhh2 {

    public static void main(String[] args) {
        TreeNode root = ddd.returnTree();
        System.out.println(findDuplicateSubtrees(root));
        System.out.println(invertTree(root));
        flatten(root);
        System.out.println(maxPathSum(root));
    }

    /**
     * 翻转二叉树
     * 226
     * https://leetcode-cn.com/problems/invert-binary-tree/
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 114. 二叉树展开为链表
     * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
     *
     * @param root
     */
    public static void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        System.out.println(list);
        int size = list.size();
        //修改 list第一个节点的right
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    /**
     * 先序遍历 list
     *
     * @param root
     * @param list
     */
    public static void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

    /**
     * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
     * <p>
     * 两棵树重复是指它们具有相同的结构以及相同的结点值。
     * 652
     * https://leetcode-cn.com/problems/find-duplicate-subtrees/
     *
     * @param root
     * @return
     */
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map.clear();
        list.clear();
        demo(root);
        return list;
    }

    /**
     * 记录所有子树 和频数
     */
    static Map<String, Integer> map = new HashMap<>();
    /**
     * 记录重复子树
     */
    static List<TreeNode> list = new LinkedList<>();

    /**
     * 遍历
     *
     * @param root
     * @return
     */
    public static String demo(TreeNode root) {
        // 对于空节点，可以用一个特殊字符表示
        if (root == null) {
            return "#";
        }
        // 将左右子树序列化成字符串
        String left = demo(root.left);
        String right = demo(root.right);
        /* 先序遍历代码位置 */
        // 左右子树加上自己，就是以自己为根的二叉树序列化结果
        String subTree = root.val + "," + left + "," + right;
        int freq = map.getOrDefault(subTree, 0);

        //把该存的数据存一下，
        if (freq == 1) {
            list.add(root);
        }
        map.put(subTree, freq + 1);
        return subTree;
    }

    public static int res = Integer.MIN_VALUE;

    /**
     * 124. 二叉树中的最大路径和
     * <p>
     * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
     *
     * @param root
     * @return
     */
    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxPathSum(root.left));
        int right = Math.max(0, maxPathSum(root.right));
        // 这里 left , right 是否要加入
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;

    }
}

