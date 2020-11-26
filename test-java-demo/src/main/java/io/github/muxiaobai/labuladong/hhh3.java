package io.github.muxiaobai.labuladong;


/**
 * 构造二叉树
 **/
public class hhh3 {

    public static void main(String[] args) {
        int[] data = {3, 2, 1, 6, 0, 5};
        /**
         *           6
         *       3      5
         *     n  2    0 n
         *    nn n 1
         */
        System.out.println(constructMaximumBinaryTree(data));
        int[] pre = {3, 9, 20, 15, 7};
        int[] mid = {9, 3, 15, 20, 7};
        int[] post = {9, 15, 7, 20, 3};
        /**
         *     3
         *  9    20
         *     15  7
         *
         *
         */
        System.out.println(buildTree(pre, mid));
        System.out.println(buildTree2(mid, post));
        System.out.println();
    }

    /**
     * 数组中构造最大二叉树
     * <p>
     * <p>
     * 654
     * https://leetcode-cn.com/problems/maximum-binary-tree/
     *
     * @param nums
     * @return
     */
    static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    static TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = constructMaximumBinaryTree(nums, left, maxIndex - 1);
        node.right = constructMaximumBinaryTree(nums, maxIndex + 1, right);
        return node;
    }

    /**
     * . 从前序与中序遍历序列构造二叉树
     * 105
     * <p>
     * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     *
     * @param preorder
     * @param inorder
     * @return
     */
    static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, inorder.length - 1, 0, inorder.length - 1);
    }

    static TreeNode buildTree(int[] preorder, int[] inorder, int prestart, int preend, int instart, int inend) {
        if (prestart > preend) {
            return null;
        }
        int index = -1;
        for (int j = instart; j <= inend; j++) {
            if (inorder[j] == preorder[prestart]) {
                index = j;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        root.left = buildTree(preorder, inorder, prestart + 1, prestart + (index - instart), instart, index - 1);
        root.right = buildTree(preorder, inorder, prestart + (index - instart) + 1, preend, index + 1, inend);
        return root;
    }

    /**
     * . 从后序与中序遍历序列构造二叉树
     * 106
     * <p>
     * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
     *
     * @param inorder
     * @param postorder
     * @return
     */
    static TreeNode buildTree2(int[] inorder, int[] postorder) {
        return buildTree2(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    static TreeNode buildTree2(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend) {
        if (poststart > postend) {
            return null;
        }
        int index = -1;
        for (int j = instart; j <= inend; j++) {
            if (inorder[j] == postorder[postend]) {
                index = j;
                break;
            }
        }
        TreeNode root = new TreeNode(postorder[postend]);
        root.left = buildTree2(inorder, postorder, instart, index - 1, poststart, poststart + (index - instart) - 1);
        root.right = buildTree2(inorder, postorder, index + 1, inend, poststart + (index - instart), postend - 1);
        return root;
    }
}

