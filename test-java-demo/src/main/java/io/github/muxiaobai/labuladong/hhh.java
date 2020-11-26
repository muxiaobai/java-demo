package io.github.muxiaobai.labuladong;


import java.util.*;

/**
 * 二叉树
 * <p>
 * 遍历
 **/
public class hhh {

    public static void main(String[] args) {
        TreeNode root = ddd.returnTree();
        System.out.println(findDuplicateSubtrees(root));
        System.out.println(count(root));
        System.out.println(traverseb(root));
        System.out.println(traversem(root));
        System.out.println(traverse(root));
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
     *
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

    /**
     * 一棵树 有多少个节点
     *
     * @param root
     * @return
     */
    public static int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = count(root.left);
        int right = count(root.right);
        //结果 后序遍历
        int result = left + right + 1;
        return result;
    }


    /**
     * 先序遍历
     *
     * @param root
     * @return
     */
    public static String traverseb(TreeNode root) {
        // 对于空节点，可以用一个特殊字符表示
        if (root == null) {
            return "#";
        }
        // 将左右子树序列化成字符串
        String left = traverseb(root.left);
        String right = traverseb(root.right);
        /* 先序遍历代码位置 */
        // 左右子树加上自己，就是以自己为根的二叉树序列化结果
        String subTree = root.val + "," + left + "," + right;
        return subTree;
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public static String traversem(TreeNode root) {
        // 对于空节点，可以用一个特殊字符表示
        if (root == null) {
            return "#";
        }
        // 将左右子树序列化成字符串
        String left = traversem(root.left);
        String right = traversem(root.right);
        /* 中序遍历代码位置 */
        // 左右子树加上自己，就是以自己为根的二叉树序列化结果
        String subTree = left + "," + root.val + "," + right;
        return subTree;
    }

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public static String traverse(TreeNode root) {
        // 对于空节点，可以用一个特殊字符表示
        if (root == null) {
            return "#";
        }
        // 将左右子树序列化成字符串
        String left = traverse(root.left);
        String right = traverse(root.right);
        /* 后序遍历代码位置 */
        // 左右子树加上自己，就是以自己为根的二叉树序列化结果
        String subTree = left + "," + right + "," + root.val;
        return subTree;
    }
}

