package io.github.muxiaobai.labuladong;

/**
 * @Package io.github.muxiaobai.labuladong
 * @date 2020/12/2/002 17:06
 * @BST 二叉搜索树（Binary Search Tree）
 * BST 的中序遍历结果是有序的（升序）。
 *
 * 二叉搜索树的 增删改查 和 验证是否是二叉搜索树
 */
public class hhh4 {
    public static void main(String[] args) {
        System.out.println(hhh.traversem(ddd.returnSearchTree()));
        System.out.println(hhh.traversem(hhh4.searchBST(ddd.returnSearchTree(), 2)));

        System.out.println(hhh.traversem(hhh4.insertIntoBST(ddd.returnSearchTree(), 2)));

        System.out.println(hhh4.isValidBST(ddd.returnTree()));
        System.out.println(hhh4.isValidBST(ddd.returnSearchTree()));
    }

    /**
     * 查找
     * 广度优先 因为二叉搜索树中序有顺序
     * 700. 二叉搜索树中的搜索
     * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
     *
     * @param root
     * @param val
     * @return
     */
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root.val > val) {
            if (root.left == null) {
                return null;
            }
            return searchBST(root.left, val);
        } else if (root.val < val) {
            if (root.right == null) {
                return null;
            }
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }

    /**
     * 插入701. 二叉搜索树中的插入操作
     * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
     * 随意返回一个二叉树
     *
     * @param root
     * @param val
     * @return
     */
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        return root;
    }

    /**
     * 插入
     * 返回必须是二叉搜索树
     *
     * @param root
     * @param val
     * @return
     */
    public static TreeNode insertIntoBST1(TreeNode root, int val) {
        return root;

    }

    /**
     * 判断是否是二擦搜索树
     * BST
     * 98. 验证二叉搜索树
     * https://leetcode-cn.com/problems/validate-binary-search-tree/
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * 我的叶子结点 左侧，必须小于我，右侧必须大于我
     *
     * @param root
     * @param min  右侧必须大于min
     * @param max  左侧必须小于max
     * @return
     */
    public static boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        // 左侧
        if (max != null && (root.left.val > root.val || root.left.val > max.val)) {
            return false;
        }
        //右侧
        if (min != null && (root.right.val > root.val || root.val > max.val)) {
            return false;
        }
        //我的左侧必须小于root,我的右侧必须大于root
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
